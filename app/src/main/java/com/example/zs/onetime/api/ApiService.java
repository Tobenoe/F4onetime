package com.example.zs.onetime.api;

import com.example.zs.onetime.bean.BannerBen;
import com.example.zs.onetime.bean.HotBean;

import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by work on 2018/4/25.
 */

public interface ApiService {


    @POST("getAd")
    Flowable<BannerBen> getBeanner();
   //获取推荐列表
    @POST("getVideos")
    Flowable<HotBean> getHot(@Query("uid") String uid ,@Query("type")String type,@Query("source") String android,@Query("appVersion") String version);



}
