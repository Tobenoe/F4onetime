package com.example.zs.onetime.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.zs.onetime.R;
import com.example.zs.onetime.base.BaseActivity;

public class FabuActivity extends BaseActivity implements View.OnClickListener {


    private ImageView mFabushipin;
    private ImageView mFabuduanzi;

    @Override
    protected int getLayout() {
        return R.layout.activity_fabu;
    }

    @Override
    protected void initView() {

        mFabushipin = (ImageView) findViewById(R.id.fabushipin);
        mFabushipin.setOnClickListener(this);
        mFabuduanzi = (ImageView) findViewById(R.id.fabuduanzi);
        mFabuduanzi.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fabushipin:


                break;
            case R.id.fabuduanzi:


                break;
        }
    }
}
