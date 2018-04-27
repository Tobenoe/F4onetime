package com.example.zs.onetime.activity;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.zs.onetime.MainActivity;
import com.example.zs.onetime.R;
import com.example.zs.onetime.base.BaseActivity;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;



import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;



public class ShipinxiangqingActivity extends BaseActivity{


    private JCVideoPlayer mMvPlayer;

    @Override
    protected int getLayout() {
        return R.layout.activity_shipinxiangqing;
    }

    @Override
    protected void initView() {
        mMvPlayer = (JCVideoPlayer) findViewById(R.id.mvPlayer);





    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String urls = intent.getStringExtra("url");
        Toast.makeText(this,""+urls,Toast.LENGTH_SHORT).show();


        mMvPlayer.setUp(urls,"");
        mMvPlayer.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);




    }






}
