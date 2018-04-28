package com.example.zs.onetime.activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.zs.onetime.R;
import com.example.zs.onetime.base.BaseActivity;
import com.example.zs.onetime.bean.YonghuBean;
import com.example.zs.onetime.presenter.Yonghupresenter;
import com.example.zs.onetime.view.YonghuView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class YonghuzuopinActivity extends BaseActivity implements YonghuView {


    private int yhuid;
    private Yonghupresenter yonghupresenter;
    private XRecyclerView mYhxrv;
    private JCVideoPlayer mYhzPlayer;
    private String videoUrl;

    @Override
    protected int getLayout() {
        return R.layout.activity_yonghuzuopin;
    }

    @Override
    protected void initView() {
        yonghupresenter = new Yonghupresenter(this);



        mYhzPlayer = (JCVideoPlayer) findViewById(R.id.yhzPlayer);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        yhuid = intent.getIntExtra("yhuid", 0);
        yonghupresenter.getData(yhuid + "", "android", "1");
    }

    @Override
    public void onYes(Object o) {
        YonghuBean o1 = (YonghuBean) o;
        List<YonghuBean.DataBean> data = o1.getData();

        for (int i = 0; i < data.size(); i++) {
            videoUrl = data.get(i).getVideoUrl();
        }


        mYhzPlayer.setUp(videoUrl, "用户视频");
        mYhzPlayer.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);



    }

    @Override
    public void onNo(String e) {

    }



}
