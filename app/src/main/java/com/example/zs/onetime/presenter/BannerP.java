package com.example.zs.onetime.presenter;


import com.example.zs.onetime.moudel.BannerM;

import com.example.zs.onetime.base.BasePresenter;


import com.example.zs.onetime.moudel.GetDataM;

import com.example.zs.onetime.view.BannerVinterface;

/**
 * Created by work on 2018/4/25.
 */



public class BannerP implements BannerPinterface {

    private GetDataM getDataM;
    private BannerVinterface bannerVinterface;






        

    @Override
    public void onDestroy() {

        if (bannerVinterface != null) {

            bannerVinterface = null;

        }


    }


