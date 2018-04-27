package com.example.zs.onetime.api;

import com.example.zs.onetime.bean.BannerBen;
import com.example.zs.onetime.bean.DZBean;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by work on 2018/4/25.
 */

public interface ApiService {


    @POST("getAd")
    Flowable<BannerBen> getBeanner();


    //段子列表
    @FormUrlEncoded
    @POST("getJokes")
    Observable<DZBean> getDZList(@FieldMap Map<String,String> map);










}
