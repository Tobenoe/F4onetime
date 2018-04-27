package com.example.zs.onetime.api;

import com.example.zs.onetime.bean.BannerBen;
import com.example.zs.onetime.bean.DZBean;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import com.example.zs.onetime.bean.FujinBean;
import com.example.zs.onetime.bean.HotBean;
import com.example.zs.onetime.bean.LoginBean;
import com.example.zs.onetime.bean.RegiterBean;
import com.example.zs.onetime.bean.ShipinBean;
import com.example.zs.onetime.bean.YonghuBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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

    @FormUrlEncoded
    @POST("getVideos")
    Flowable<ShipinBean> getShipin(@Field("uid") String uid, @Field("source") String source, @Field("appVersion") String appVersion);

    //段子列表
    @FormUrlEncoded
    @POST("getJokes")
    Observable<DZBean> getDZList(@FieldMap Map<String,String> map);


    //getNearVideos?page=1&latitude=1&longitude=1&token=1&source=android&appVersion=1
    @FormUrlEncoded
    @POST("getNearVideos")
    Flowable<FujinBean> getFujin(@Field("page") String page, @Field("latitude") String latitude, @Field("longitude") String longitude,@Field("token") String token,@Field("source") String source,@Field("appVersion") String appVersion);

<<<<<<< HEAD
    //注册
      @FormUrlEncoded
      @POST("register")
      Flowable<RegiterBean> getRegister(@Field("mobile") String mobile,@Field("password") String password);

      //登录
      @FormUrlEncoded
      @POST("login")
      Flowable<LoginBean> getLogin(@Field("mobile") String mobile, @Field("password") String password);
=======
 //https://www.zhaoapi.cn/quarter/getUserVideos?uid=14366&source=android&appVersion=1
       @FormUrlEncoded
       @POST("getUserVideos")
       Flowable<YonghuBean> getYonghu(@Field("uid") String uid,@Field("source") String source,@Field("appVersion") String appVersion);



>>>>>>> 0976058c02153fd2038fb107ce67c308610721b3

}
