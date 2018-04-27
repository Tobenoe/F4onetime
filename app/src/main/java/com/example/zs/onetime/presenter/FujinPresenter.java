package com.example.zs.onetime.presenter;

import com.example.zs.onetime.moudel.FujinModel;
import com.example.zs.onetime.view.FujinView;

/**
 * Created by zs on 2018/4/27.
 */

public class FujinPresenter implements IFujinP {
    private FujinView fujinView;
    private FujinModel fujinModel;


    public FujinPresenter(FujinView fujinView) {
        this.fujinView = fujinView;
        fujinModel=new FujinModel();
    }

    @Override
    public void onYes(Object o) {
        if (fujinView==null){
            return;
        }
        fujinView.onYes(o);

    }

    @Override
    public void onNo(String e) {
        if (fujinView==null){
            return;
        }
        fujinView.onNo(e);

    }

    @Override
    public void getData(String page, String latitude, String longitude, String token, String source, String appVersion) {
        fujinModel.getData(page,latitude,longitude,token,source,appVersion,this);
    }



}
