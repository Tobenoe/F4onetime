package com.example.zs.onetime.moudel;

import android.util.Log;

import com.example.zs.onetime.api.Api;
import com.example.zs.onetime.api.ApiService;
import com.example.zs.onetime.bean.BannerBen;
import com.example.zs.onetime.bean.HotBean;
import com.example.zs.onetime.presenter.BannerPinterface;
import com.example.zs.onetime.presenter.GetHotPinterface;
import com.example.zs.onetime.utils.RetrofitUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by work on 2018/4/25.
 */

public class GetDataM {


    public void getBanner(final BannerPinterface bannerPinterface) {

        ApiService apiService = RetrofitUtils.getInData().getRetrofit(Api.ADV, ApiService.class);
        Flowable<BannerBen> flowable = apiService.getBeanner();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<BannerBen>() {
                    @Override
                    public void onNext(BannerBen bannerBen) {

                        Log.i("TAG", bannerBen.getCode() + "----------------");
                        bannerPinterface.OnBanner(bannerBen);

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


    public void getHot(String uid, String type, String version, final GetHotPinterface getHotPinterface) {

        ApiService apiService = RetrofitUtils.getInData().getRetrofit(Api.VLIE, ApiService.class);
        Flowable<HotBean> flowable = apiService.getHot(uid, type, "android", version);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<HotBean>() {
                    @Override
                    public void onNext(HotBean hotBean) {
                        getHotPinterface.OnHot(hotBean);
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
