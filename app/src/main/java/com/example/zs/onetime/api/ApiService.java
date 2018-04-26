package com.example.zs.onetime.api;

import com.example.zs.onetime.bean.BannerBen;

import io.reactivex.Flowable;
import retrofit2.http.POST;

/**
 * Created by work on 2018/4/25.
 */

public interface ApiService {


    @POST("getAd")
    Flowable<BannerBen> getBeanner();











}
