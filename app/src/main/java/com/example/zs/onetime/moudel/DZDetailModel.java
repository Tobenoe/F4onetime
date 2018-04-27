package com.example.zs.onetime.moudel;

import android.util.Log;

import com.example.zs.onetime.api.Api;
import com.example.zs.onetime.api.ApiService;
import com.example.zs.onetime.bean.DZDetailBean;
import com.example.zs.onetime.presenter.IDZDetailPresenter;
import com.example.zs.onetime.utils.RetrofitUtils;

import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 杜晓彤 on 2018/4/27.
 */

public class DZDetailModel implements IDZDetailModel {
    private static final String TAG = "DZDetailModel-----------";

    private IDZDetailPresenter idzDetailPresenter;

    public DZDetailModel(IDZDetailPresenter idzDetailPresenter) {
        this.idzDetailPresenter = idzDetailPresenter;
    }

    @Override
    public void getDetailData(Map<String, String> map) {
        //使用retrofit请求网络
        RetrofitUtils retrofitUtils = RetrofitUtils.getInData();
        ApiService apiService = retrofitUtils.getRetrofit(Api.ONTETIME, ApiService.class);
        apiService.getDetailList(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultObserver<DZDetailBean>() {
                    @Override
                    public void onNext(DZDetailBean value) {
                        Log.d("TAG", "onNext: "+value.getMsg());
                        //调用p层获取详情的方法
                        idzDetailPresenter.getDZDetailListData((List<DZDetailBean.DataBean>) value.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "onError: 异常---------"+e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TAG", "onComplete:完成----------- ");
                    }
                });
    }
}
