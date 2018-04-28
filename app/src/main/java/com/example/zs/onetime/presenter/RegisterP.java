package com.example.zs.onetime.presenter;

import com.example.zs.onetime.moudel.GetDataM;
import com.example.zs.onetime.view.RegisterVinterface;

/**
 * Created by work on 2018/4/27.
 */

public class RegisterP implements RegisterPinterface {

     private GetDataM getDataM;
     private RegisterVinterface registerVinterface;

    public RegisterP(RegisterVinterface registerVinterface) {
        this.getDataM = new GetDataM();
        this.registerVinterface = registerVinterface;
    }

     public void getRegister(String mobile,String password){

        getDataM.getRegister(mobile,password,this);

     }

    @Override
    public void OnRegister(Object o) {

         registerVinterface.OnRegister(o);

    }


    @Override
    public void onDestroy() {

         if(registerVinterface!= null){

             registerVinterface = null;

         }


    }
}
