package com.example.zs.onetime.utils;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2018/4/9.
 */

public class RetrofitUtils {

    private static RetrofitUtils RETROFIT_UTILS = null;

    private RetrofitUtils() {}
    //单例设计模式，  单例模式只会创建一个对象 考虑到内存问题  单例设计模式比较好

    public static RetrofitUtils getInData() {
        if (RETROFIT_UTILS == null){
            synchronized (RetrofitUtils.class){
                if (RETROFIT_UTILS == null){
                    RETROFIT_UTILS = new RetrofitUtils();
                }
            }
        }
        return RETROFIT_UTILS;
    }

    public <T> T getRetrofit(String path,Class<T> cla){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("TAG",message);
            }
        });

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(path)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        T t = retrofit.create(cla);

        return t;
    }
}
