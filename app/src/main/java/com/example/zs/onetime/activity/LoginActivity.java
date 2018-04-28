package com.example.zs.onetime.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zs.onetime.MainActivity;
import com.example.zs.onetime.R;
import com.example.zs.onetime.base.BaseActivity;
import com.example.zs.onetime.presenter.LoginP;
import com.example.zs.onetime.view.LoginVinterface;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mOtherBack;
    private ImageButton mQqLogin;
    private ImageButton mWxLogin;
    /**
     * 选择其他方式登录
     */
    private TextView mLoginOther;

    @Override
    protected int getLayout() {

        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        mOtherBack = (ImageView) findViewById(R.id.other_back);
        mOtherBack.setOnClickListener(this);
        mQqLogin = (ImageButton) findViewById(R.id.qq_login);
        mQqLogin.setOnClickListener(this);
        mWxLogin = (ImageButton) findViewById(R.id.wx_login);
        mWxLogin.setOnClickListener(this);
        mLoginOther = (TextView) findViewById(R.id.login_other);
        mLoginOther.setOnClickListener(this);
    }

    @Override
    protected void initData() {



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.other_back:
                //返回页面
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();

                break;
            case R.id.qq_login:


                break;
            case R.id.wx_login:


                break;
            case R.id.login_other:
                Intent intent = new Intent(LoginActivity.this, OtherLoginActivity.class);
                startActivity(intent);

                break;
        }
    }



}
