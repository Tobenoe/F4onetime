package com.example.zs.onetime.presenter;





import com.example.zs.onetime.moudel.GetDataM;

import com.example.zs.onetime.view.BannerVinterface;

/**
 * Created by work on 2018/4/25.
 */



public class BannerP implements BannerPinterface {

    private GetDataM getDataM;
    private BannerVinterface bannerVinterface;

    public BannerP(BannerVinterface bannerVinterface) {
        this.getDataM = new GetDataM();
        this.bannerVinterface = bannerVinterface;
    }

    public void getBanner(){

         getDataM.getBanner(this);


     }

    @Override
    public void OnBanner(Object o) {

        bannerVinterface.OnBanner(o);

    }

    @Override
    public void onDestroy() {

        if (bannerVinterface != null) {

            bannerVinterface = null;

        }


    }
}


