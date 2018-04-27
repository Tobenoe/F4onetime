package com.example.zs.onetime.presenter;

/**
 * Created by zs on 2018/4/27.
 */

public interface IFujinP {
    void onYes(Object o);
    void onNo(String e);
    void getData(String page,String latitude,String longitude,String token,String source,String appVersion);
}
