package com.example.zs.onetime.moudel;

import android.util.Log;

import com.example.zs.onetime.api.Api;
import com.example.zs.onetime.api.ApiService;
import com.example.zs.onetime.bean.PinlunBean;
import com.example.zs.onetime.presenter.IPinlunPresenter;
import com.example.zs.onetime.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 杜晓彤 on 2018/4/27.
 */

public class PinlunModel implements IPinlunModel {

    private IPinlunPresenter iPinlunPresenter;

    public PinlunModel(IPinlunPresenter iPinlunPresenter) {
        this.iPinlunPresenter = iPinlunPresenter;
    }

    //请求数据
    @Override
    public void getPinlunData(Map<String, String> map) {
        //retrofit请求网络
        RetrofitUtils retrofitUtils = RetrofitUtils.getInData();
        ApiService apiService = retrofitUtils.getRetrofit(Api.ONTETIME, ApiService.class);
        apiService.getPinlun(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultObserver<PinlunBean>() {
                    @Override
                    public void onNext(PinlunBean value) {
                        Log.d("TAG", "onNext: "+value);

                        //调用p层获取数据的方法
                        iPinlunPresenter.getPinlunListData(value);
                        Log.d("TAG", "onNext: ---------pinlun"+value);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "onError: 评论请求异常---------"+e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TAG", "onComplete: 完成---------");
                    }
                });
    }
}
