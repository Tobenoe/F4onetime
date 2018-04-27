package com.example.zs.onetime.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zs.onetime.R;
import com.example.zs.onetime.base.BaseActivity;

public class OtherLoginActivity extends BaseActivity implements View.OnClickListener {


    private ImageView mOtherLoginBack;
    /**
     * 注册账号
     */
    private TextView mOtherRegister;
    /**
     * 账号
     */
    private EditText mLoginName;
    /**
     * 密码
     */
    private EditText mLoginPass;
    /**
     * 登录
     */
    private Button mLoginLogines;
    /**
     * forget password
     */
    private TextView mForgetpassword;
    /**
     * 游客登录
     */
    private TextView mLoginYk;

    @Override
    protected int getLayout() {

        return R.layout.activity_other_login;
    }

    @Override
    protected void initView() {

        mOtherLoginBack = (ImageView) findViewById(R.id.other_login_back);
        mOtherRegister = (TextView) findViewById(R.id.other_register);
        mOtherLoginBack.setOnClickListener(this);
        mOtherRegister.setOnClickListener(this);
        mLoginName = (EditText) findViewById(R.id.login_name);
        mLoginPass = (EditText) findViewById(R.id.login_pass);
        mLoginLogines = (Button) findViewById(R.id.login_logines);
        mLoginLogines.setOnClickListener(this);
        mForgetpassword = (TextView) findViewById(R.id.forgetpassword);
        mForgetpassword.setOnClickListener(this);
        mLoginYk = (TextView) findViewById(R.id.login_yk);
        mLoginYk.setOnClickListener(this);
    }

    @Override
    protected void initData() {


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.other_login_back:
                finish();
                break;

            case R.id.other_register:

                Toast.makeText(OtherLoginActivity.this, "点击了注册", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OtherLoginActivity.this, ResgisterActivity.class);
                startActivity(intent);

                break;
            case R.id.login_logines:


                break;
            case R.id.forgetpassword:


                break;
            case R.id.login_yk:


                break;
        }
    }


}
