package com.example.zs.onetime.moudel;

import android.util.Log;

import com.example.zs.onetime.api.Api;
import com.example.zs.onetime.api.ApiService;
import com.example.zs.onetime.bean.DZBean;
import com.example.zs.onetime.presenter.IDZPresenter;
import com.example.zs.onetime.utils.RetrofitUtils;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 杜晓彤 on 2018/4/26.
 */

public class DZModel implements IDZModel {
    private static final String TAG = "DZModel-----";

    private IDZPresenter idzPresenter;

    public DZModel(IDZPresenter idzPresenter) {
        this.idzPresenter = idzPresenter;
    }

    //请求数据的方法
    @Override
    public void getDZData(Map<String, String> map) {
        Log.i("AAA","model");
        //使用Retrofit请求网络
        RetrofitUtils retrofitUtils = RetrofitUtils.getInData();
        ApiService apiService = retrofitUtils.getRetrofit(Api.ONTETIME, ApiService.class);
        apiService.getDZList(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultObserver<DZBean>() {
                    @Override
                    public void onNext(DZBean value) {
//                        //调用P层获取数据的方法
                       idzPresenter.getDZDataList(value.getData());
                        Log.e("AAA",value.getData().size()+"==111");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: 异常--------------"+e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: 完成------------");
                    }
                });


    }
}
