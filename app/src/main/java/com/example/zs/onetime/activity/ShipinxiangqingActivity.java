package com.example.zs.onetime.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zs.onetime.R;
import com.example.zs.onetime.base.BaseActivity;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class ShipinxiangqingActivity extends BaseActivity implements View.OnClickListener {


    private JCVideoPlayer mMvPlayer;
    private ImageView mFanhui;
    private ImageView mLeftxin;
    private ImageView mRawxin;
    private ImageView mRawfenxiang;
    private boolean ischeck = false;
    private boolean isflag = false;
    private ImageView mTouxiang;

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
        mTouxiang = (ImageView) findViewById(R.id.touxiang);
        mTouxiang.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String urls = intent.getStringExtra("url");

        Glide.with(this)
                .load(R.drawable.touxiang)
                .bitmapTransform(new RoundedCornersTransformation(this,100,5))
                .into(mTouxiang);

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


                if (ischeck == false) {
                    mLeftxin.setImageResource(R.drawable.left_xin);

                    ischeck = true;
                } else {
                    mLeftxin.setImageResource(R.drawable.raw_querenxin);

                    ischeck = false;
                }

                break;
            case R.id.rawxin:
                if (isflag == false) {
                    mRawxin.setImageResource(R.drawable.raw_xin);
                    isflag = true;
                } else {
                    mRawxin.setImageResource(R.drawable.raw_xinsui);
                    isflag = false;
                }
                break;
            case R.id.rawfenxiang:

                Toast.makeText(ShipinxiangqingActivity.this, "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.touxiang:
                Toast.makeText(ShipinxiangqingActivity.this, "头像", Toast.LENGTH_SHORT).show();

                break;
        }
    }


}
