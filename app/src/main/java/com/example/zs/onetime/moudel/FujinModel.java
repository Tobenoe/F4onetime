package com.example.zs.onetime.moudel;

import android.util.Log;

import com.example.zs.onetime.api.Api;
import com.example.zs.onetime.api.ApiService;
import com.example.zs.onetime.bean.FujinBean;
import com.example.zs.onetime.bean.ShipinBean;
import com.example.zs.onetime.presenter.IFujinP;
import com.example.zs.onetime.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by zs on 2018/4/27.
 */

public class FujinModel {

    public void getData(String page , String latitude, String longitude, String token, String source, String appVersion, final IFujinP iFujinP) {
        ApiService retrofit = RetrofitUtils.getInData().getRetrofit(Api.ONTETIME, ApiService.class);
        Flowable<FujinBean> flowable = retrofit.getFujin(page,latitude,longitude, token,source, appVersion);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<FujinBean>() {
                    @Override
                    public void onNext(FujinBean fujinBean) {

                        Log.d("TAG",fujinBean.getMsg());
                        iFujinP.onYes(fujinBean);

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
