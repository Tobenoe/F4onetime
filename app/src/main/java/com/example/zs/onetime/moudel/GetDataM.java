package com.example.zs.onetime.moudel;

import android.util.Log;

import com.example.zs.onetime.api.Api;
import com.example.zs.onetime.api.ApiService;
import com.example.zs.onetime.bean.BannerBen;
import com.example.zs.onetime.bean.HotBean;
import com.example.zs.onetime.bean.LoginBean;
import com.example.zs.onetime.bean.RegiterBean;
import com.example.zs.onetime.presenter.BannerPinterface;
import com.example.zs.onetime.presenter.GetHotPinterface;
import com.example.zs.onetime.presenter.LoginPinterface;
import com.example.zs.onetime.presenter.PresmanPinterface;
import com.example.zs.onetime.presenter.RegisterPinterface;
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

    //轮播
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

    //推荐
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

    //注册
    public void getRegister(String mobile, String password, final RegisterPinterface registerPinterface) {


        ApiService apiService = RetrofitUtils.getInData().getRetrofit(Api.REGISTER, ApiService.class);
        Flowable<RegiterBean> flowable = apiService.getRegister(mobile, password);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DefaultSubscriber<RegiterBean>() {
            @Override
            public void onNext(RegiterBean regiterBean) {

                registerPinterface.OnRegister(regiterBean);

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });


    }

    //登录
    public void getLogin(String mobile, String password, final LoginPinterface loginPinterface){

        ApiService apiService = RetrofitUtils.getInData().getRetrofit(Api.LOGIN, ApiService.class);
        Flowable<LoginBean> flowable = apiService.getLogin(mobile, password);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DefaultSubscriber<LoginBean>() {
            @Override
            public void onNext(LoginBean loginBean) {

                loginPinterface.OnLogin(loginBean);

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });


    }


    public void getPreman(String uid, String toyken, final PresmanPinterface presmanPinterface){

        ApiService apiService = RetrofitUtils.getInData().getRetrofit(Api.LOGIN, ApiService.class);
        Flowable<LoginBean> flowable = apiService.getPresman(uid,toyken);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DefaultSubscriber<LoginBean>() {
            @Override
            public void onNext(LoginBean loginBean) {

                presmanPinterface.OnPresman(loginBean);


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
