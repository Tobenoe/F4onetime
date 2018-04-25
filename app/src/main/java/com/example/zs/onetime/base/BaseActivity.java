package com.example.zs.onetime.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.zs.onetime.R;

/**
 * Created by work on 2018/4/25.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        initView();
        initData();


    }

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initData();
}
