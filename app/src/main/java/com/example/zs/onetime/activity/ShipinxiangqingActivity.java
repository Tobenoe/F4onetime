package com.example.zs.onetime.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zs.onetime.R;
import com.example.zs.onetime.base.BaseActivity;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


public class ShipinxiangqingActivity extends BaseActivity implements View.OnClickListener {


    private JCVideoPlayer mMvPlayer;
    private ImageView mFanhui;
    private ImageView mLeftxin;
    private ImageView mRawxin;
    private ImageView mRawfenxiang;

    @Override
    protected int getLayout() {
        return R.layout.activity_shipinxiangqing;
    }

    @Override
    protected void initView() {
        mMvPlayer = (JCVideoPlayer) findViewById(R.id.mvPlayer);


        mFanhui = (ImageView) findViewById(R.id.fanhui);
        mFanhui.setOnClickListener(this);
        mLeftxin = (ImageView) findViewById(R.id.leftxin);
        mLeftxin.setOnClickListener(this);
        mRawxin = (ImageView) findViewById(R.id.rawxin);
        mRawxin.setOnClickListener(this);
        mRawfenxiang = (ImageView) findViewById(R.id.rawfenxiang);
        mRawfenxiang.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String urls = intent.getStringExtra("url");


        mMvPlayer.setUp(urls, "沃尔特一------------");
        mMvPlayer.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                finish();
                break;
            case R.id.leftxin:
                break;
            case R.id.rawxin:
                break;
            case R.id.rawfenxiang:
                break;
        }
    }
}
