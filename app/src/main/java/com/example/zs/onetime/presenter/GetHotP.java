package com.example.zs.onetime.presenter;

import com.example.zs.onetime.moudel.GetDataM;
import com.example.zs.onetime.view.GetHotVinterface;

/**
 * Created by work on 2018/4/26.
 * 推荐的数据
 *
 */

public class GetHotP implements GetHotPinterface {

      private GetDataM getDataM;
      private GetHotVinterface getHotVinterface;

    public GetHotP(GetHotVinterface getHotVinterface) {
        this.getDataM = new GetDataM();
        this.getHotVinterface = getHotVinterface;
    }

     public void getHot(String uid, String type,String version){


        getDataM.getHot(uid,type,version,this);

     }


    @Override
    public void OnHot(Object o) {

          getHotVinterface.OnHot(o);

    }

    @Override
    public void onDestroy() {
         if(getHotVinterface != null){
             getHotVinterface  = null;
         }


    }
}
