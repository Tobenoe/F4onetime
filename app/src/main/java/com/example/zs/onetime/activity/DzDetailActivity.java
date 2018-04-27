package com.example.zs.onetime.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import com.example.zs.onetime.R;
import com.example.zs.onetime.base.BaseActivity;
import com.example.zs.onetime.bean.DZDetailBean;
import com.example.zs.onetime.moudel.DZDetailModel;
import com.example.zs.onetime.presenter.DZDetailPresenter;
import com.example.zs.onetime.view.IDetailView;

import java.util.List;

/**
 * Created by 杜晓彤 on 2018/4/27.
 */

public class DzDetailActivity extends BaseActivity implements IDetailView{

    private TextView detail_name;
    private TextView detail_time;
    private TextView detail_content;
    private int jid;

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
    }

    //逻辑操作
    @Override
    protected void initData() {

        Intent intent = getIntent();
        jid = intent.getIntExtra("jid", 2209);

        //调用p层
        DZDetailPresenter dzDetailPresenter=new DZDetailPresenter();
        dzDetailPresenter.showDeatilToView(new DZDetailModel(dzDetailPresenter),DzDetailActivity.this);
    }


    //展示详情
    @Override
    public void showDzDetailData(List<DZDetailBean.DataBean> list) {
        Log.d("TAG", "showDzDetailData: "+list);

    }
}
