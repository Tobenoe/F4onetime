package com.example.zs.onetime.presenter;

import com.example.zs.onetime.moudel.ShipinModel;
import com.example.zs.onetime.view.ShipinView;

/**
 * Created by zs on 2018/4/26.
 */

public class ShipinPresenter implements IShipinp {
    private ShipinView shipinView;
    private ShipinModel shipinModel;
    public ShipinPresenter(ShipinView shipinView) {
        this.shipinView = shipinView;
        shipinModel=new ShipinModel();
    }

    @Override
    public void onYes(Object o) {
        if (shipinView==null){
            return;
        }
        shipinView.onYes(o);

    }

    @Override
    public void onNo(String e) {

        if (shipinView==null){
            return;
        }
        shipinView.onNo(e);
    }

    @Override
    public void getData(String uid, String source, String appVersion) {
        shipinModel.getData(uid,source,appVersion,this);

    }
}
