package com.example.zs.onetime.presenter;

import com.example.zs.onetime.moudel.GetDataM;
import com.example.zs.onetime.view.PresmanVinterface;

/**
 * Created by work on 2018/4/28.
 */

public class PresmanP implements PresmanPinterface{

  private GetDataM getDataM;
   private PresmanVinterface presmanVinterface;

    public PresmanP(PresmanVinterface presmanVinterface) {
        this.getDataM = new GetDataM();
        this.presmanVinterface = presmanVinterface;
    }

    public void getPresman(String uid , String toyken){

        getDataM.getPreman(uid,toyken,this);

    }

    @Override
    public void OnPresman(Object o) {

        presmanVinterface.OnPresman(o);

    }

    @Override
    public void onDestroy() {
         if(presmanVinterface!= null){
             presmanVinterface = null;
         }

    }
}
