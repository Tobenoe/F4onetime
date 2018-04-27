package com.example.zs.onetime.presenter;

import com.example.zs.onetime.moudel.GetDataM;
import com.example.zs.onetime.view.LoginVinterface;

/**
 * Created by work on 2018/4/27.
 */

public class LoginP implements LoginPinterface{

   private GetDataM getDataM;
   private LoginVinterface loginVinterface;

    public LoginP(LoginVinterface loginVinterface) {
        this.getDataM = new GetDataM();
        this.loginVinterface = loginVinterface;
    }


    public void getLogin(String mobile,String password){

        getDataM.getLogin(mobile,password,this);


    }
    @Override
    public void OnLogin(Object o) {

        loginVinterface.OnLogin(o);
    }

    @Override
    public void onDestroy() {

        if(loginVinterface!= null){

            loginVinterface = null;
        }

    }
}
