package com.example.zs.onetime.presenter;

import com.example.zs.onetime.bean.PinlunBean;
import com.example.zs.onetime.moudel.PinlunModel;
import com.example.zs.onetime.view.IPinlunView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杜晓彤 on 2018/4/27.
 */

public class PinlunPresenter implements IPinlunPresenter {
    private static final String TAG = "PinlunPresenter--------------";

    private IPinlunView iPinlunView;

    @Override
    public void showPinToView(String s,PinlunModel pinlunModel,IPinlunView iPinlunView) {
        this.iPinlunView=iPinlunView;


        Map<String,String> map=new HashMap<>();
        map.put("uid","10962");
        map.put("jid","2208");
        map.put("source","android");
        map.put("token","49DD065C4180DD646BA27B10BE842CBF");
        map.put("appVersion","101");
        map.put("content",s);

        //调用M层请求数据
        pinlunModel.getPinlunData(map);
    }

    @Override
    public void getPinlunListData(Object o) {
        //调用V展示
        iPinlunView.showpinlun(o);
    }
}
