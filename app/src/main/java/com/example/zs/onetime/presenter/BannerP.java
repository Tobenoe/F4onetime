package com.example.zs.onetime.presenter;

<<<<<<< HEAD
import com.example.zs.onetime.moudel.BannerM;

import com.example.zs.onetime.base.BasePresenter;
=======
>>>>>>> df3833b2413aea0d663bfc4b3710eb2557c5a04c
import com.example.zs.onetime.moudel.GetDataM;

import com.example.zs.onetime.view.BannerVinterface;

/**
 * Created by work on 2018/4/25.
 */

<<<<<<< HEAD
=======
public class BannerP implements BannerPinterface {

    private GetDataM getDataM;
    private BannerVinterface bannerVinterface;
>>>>>>> df3833b2413aea0d663bfc4b3710eb2557c5a04c




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

        bannerVinterface.OnBanner(o);
        }

    @Override
    public void onDestroy() {

        if (bannerVinterface != null) {

            bannerVinterface = null;

        }


    }


