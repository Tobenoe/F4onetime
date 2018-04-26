package com.example.zs.onetime.presenter;





import com.example.zs.onetime.moudel.GetDataM;

import com.example.zs.onetime.view.BannerVinterface;

/**
 * Created by work on 2018/4/25.
 */


public class BannerP extends BasePresenter<BannerPinterface> implements BannerPinterface {
    private GetDataM getDataM;
    private BannerVinterface bannerVinterface;

    public void getBanner() {

        getDataM.getBanner(this);

    }

    public BannerP(BannerVinterface bannerVinterface) {
        this.getDataM = new GetDataM();

        this.bannerVinterface = bannerVinterface;
    }

    @Override
    public void OnBanner(Object o) {


        bannerVinterface.OnBanner(o);
    }

    @Override
    public void onDestroy() {


    }
}




