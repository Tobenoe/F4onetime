package com.example.zs.onetime.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zs.onetime.R;
import com.example.zs.onetime.base.BaseActivity;

public class ResgisterActivity extends BaseActivity implements View.OnClickListener {


    private ImageView mRegisterBack;
    /**
     * 已有账号？
     */
    private TextView mRegisterLogin;
    /**
     * 请输入手机号
     */
    private EditText mRegisterName;
    /**
     * 输入大小写和数字，密码不能超过8位
     */
    private EditText mRegisterPass;
    /**
     * 注册
     */
    private Button mBtnResgister;
    /**
     * 游客登录
     */
    private TextView mResgisterYk;

    @Override
    protected int getLayout() {
        return R.layout.activity_resgister;
    }

    @Override
    protected void initView() {

        mRegisterBack = (ImageView) findViewById(R.id.register_back);
        mRegisterBack.setOnClickListener(this);
        mRegisterLogin = (TextView) findViewById(R.id.register_login);
        mRegisterLogin.setOnClickListener(this);
        mRegisterName = (EditText) findViewById(R.id.register_name);
        mRegisterPass = (EditText) findViewById(R.id.register_pass);
        mBtnResgister = (Button) findViewById(R.id.btn_resgister);
        mBtnResgister.setOnClickListener(this);
        mResgisterYk = (TextView) findViewById(R.id.resgister_yk);
        mResgisterYk.setOnClickListener(this);
    }

    @Override
    protected void initData() {



    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.register_back:
                finish();

                break;
            case R.id.register_login:

                Intent intent = new Intent(ResgisterActivity.this, OtherLoginActivity.class);
                startActivity(intent);
                finish();

                break;
            case R.id.btn_resgister:
                Toast.makeText(ResgisterActivity.this,"点击了注册",Toast.LENGTH_SHORT).show();

                break;
            case R.id.resgister_yk:

                Toast.makeText(ResgisterActivity.this,"点击了游客",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
