package com.example.zs.onetime.moudel;

import com.example.zs.onetime.api.Api;
import com.example.zs.onetime.api.ApiService;
import com.example.zs.onetime.bean.ShipinBean;
import com.example.zs.onetime.presenter.IShipinp;
import com.example.zs.onetime.utils.RetrofitUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by zs on 2018/4/26.
 */

public class ShipinModel {
    public void getData(String uid, String source, String appVersion, final IShipinp iShipinp){

        ApiService retrofit = RetrofitUtils.getInData().getRetrofit(Api.ONTETIME, ApiService.class);
        Flowable<ShipinBean> flowable = retrofit.getShipin(uid, source, appVersion);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<ShipinBean>() {
                    @Override
                    public void onNext(ShipinBean shipinBean) {
                        iShipinp.onYes(shipinBean);

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    };
}
