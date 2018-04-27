package com.example.zs.onetime.moudel;

import com.example.zs.onetime.api.Api;
import com.example.zs.onetime.api.ApiService;
import com.example.zs.onetime.bean.ShipinBean;
import com.example.zs.onetime.bean.YonghuBean;
import com.example.zs.onetime.presenter.IYonghuP;
import com.example.zs.onetime.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by zs on 2018/4/27.
 */

public class YonghuModel {

    public void getData(String uid, String source, String appVersion, final IYonghuP iYonghuP) {


        ApiService retrofit = RetrofitUtils.getInData().getRetrofit(Api.ONTETIME, ApiService.class);
        Flowable<YonghuBean> flowable = retrofit.getYonghu(uid, source, appVersion);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<YonghuBean>() {
                    @Override
                    public void onNext(YonghuBean yonghuBean) {
                        iYonghuP.onYes(yonghuBean);

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
