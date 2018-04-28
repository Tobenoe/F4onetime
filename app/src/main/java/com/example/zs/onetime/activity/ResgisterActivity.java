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
import com.example.zs.onetime.bean.RegiterBean;
import com.example.zs.onetime.presenter.RegisterP;
import com.example.zs.onetime.view.RegisterVinterface;

public class ResgisterActivity extends BaseActivity implements View.OnClickListener, RegisterVinterface {


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
    private RegisterP registerP;

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
        registerP = new RegisterP(this);


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
                Toast.makeText(ResgisterActivity.this, "点击了注册", Toast.LENGTH_SHORT).show();
                String mobile = mRegisterName.getText().toString();
                String password = mRegisterPass.getText().toString();
                registerP.getRegister(mobile, password);
                Log.i("TAG", mobile + "--" + password);
                break;
            case R.id.resgister_yk:
                Toast.makeText(ResgisterActivity.this, "点击了游客", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    //注册返回
    @Override
    public void OnRegister(Object o) {

        RegiterBean regiterBean = (RegiterBean) o;
        String msg = regiterBean.getMsg();
        String code = regiterBean.getCode();

        if (code.equals("0")) {

            Toast.makeText(ResgisterActivity.this, msg, Toast.LENGTH_SHORT).show();
            finish();
        } else {

            Toast.makeText(ResgisterActivity.this, msg, Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注册解耦
        registerP.onDestroy();

    }
}
