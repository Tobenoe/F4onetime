package com.example.zs.onetime.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zs.onetime.R;
import com.example.zs.onetime.base.BaseActivity;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    /**
     * 退出登录
     */
    private Button mTuichu;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;

    @Override
    protected int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {


        mTuichu = (Button) findViewById(R.id.tuichu);
        mTuichu.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        sharedPreferences = getSharedPreferences("userdata", Activity.MODE_PRIVATE);
        edit = sharedPreferences.edit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tuichu:
                edit.clear();
                Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

                break;
        }
    }
}
