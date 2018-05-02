package com.example.zs.onetime.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zs.onetime.R;
import com.example.zs.onetime.adapter.PinlunAdapter;
import com.example.zs.onetime.base.BaseActivity;
import com.example.zs.onetime.bean.DZDetailBean;
import com.example.zs.onetime.bean.PinlunBean;
import com.example.zs.onetime.moudel.DZDetailModel;
import com.example.zs.onetime.moudel.PinlunModel;
import com.example.zs.onetime.presenter.DZDetailPresenter;
import com.example.zs.onetime.presenter.PinlunPresenter;
import com.example.zs.onetime.view.IDetailView;
import com.example.zs.onetime.view.IPinlunView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 杜晓彤 on 2018/4/27.
 */

public class DzDetailActivity extends BaseActivity implements IDetailView,IPinlunView{

    private TextView detail_name;
    private TextView detail_time;
    private TextView detail_content;
    private int jid;
    private ImageView fanhui;
    private RecyclerView jokedetail_recycler;
    private EditText et_pinlun;
    private TextView fasong;
    private List<String> list;
    private String s;
    private ImageView fenxiang;

    @Override
    protected int getLayout() {
        return R.layout.activity_dzdetail;
    }

    //控件方法
    @Override
    protected void initView() {
        detail_name = findViewById(R.id.detail_name);
        detail_time = findViewById(R.id.detail_time);
        detail_content = findViewById(R.id.detail_content);
        fanhui = findViewById(R.id.fanhui);
        jokedetail_recycler = findViewById(R.id.jokedetail_recycler);
        et_pinlun = findViewById(R.id.et_pinlun);//评论内容
        fasong = findViewById(R.id.fasong);//发送

        fenxiang = findViewById(R.id.rawfenxiang);//分享
    }

    //逻辑操作
    @Override
    protected void initData() {

        //返回按钮
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                return;
            }
        });

        jokedetail_recycler.setLayoutManager(new LinearLayoutManager(this));
        //发送评论
        fasong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = et_pinlun.getText().toString();
                if (s.trim().equals("")){
                    Toast.makeText(DzDetailActivity.this,"评论内容不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    PinlunPresenter pinlunPresenter = new PinlunPresenter();
                    pinlunPresenter.showPinToView(s,new PinlunModel(pinlunPresenter),DzDetailActivity.this);
                    list = new ArrayList<>();
                    list.add(s);

                    et_pinlun.setText("");//清空
                }
            }
        });

        Intent intent = getIntent();
        jid = intent.getIntExtra("jid", 2209);

        //调用p层
        DZDetailPresenter dzDetailPresenter=new DZDetailPresenter();
        dzDetailPresenter.showDeatilToView(new DZDetailModel(dzDetailPresenter),DzDetailActivity.this);
    }


    //展示详情
    @Override
    public void showDzDetailData(Object o) {
        DZDetailBean o1 = (DZDetailBean) o;
        DZDetailBean.DataBean data = o1.getData();
        if(data==null){
            return;
        }

        detail_time.setText(data.getCreateTime());
        detail_name.setText(data.getUser().getNickname()+"");
        detail_content.setText(data.getContent());

    }

    //展示评论
    @Override
    public void showpinlun(Object o) {

        PinlunBean o1 = (PinlunBean) o;
        String code = o1.getCode();


        if(code.equals("0")){
            Toast.makeText(DzDetailActivity.this,"评论成功",Toast.LENGTH_SHORT).show();
            //创建适配器
            PinlunAdapter pinlunAdapter=new PinlunAdapter(list,DzDetailActivity.this);
            jokedetail_recycler.setAdapter(pinlunAdapter);

        }else{
            Toast.makeText(DzDetailActivity.this,"评论失败",Toast.LENGTH_SHORT).show();
        }

    }
}
