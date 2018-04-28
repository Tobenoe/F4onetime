package com.example.zs.onetime.presenter;

import com.example.zs.onetime.moudel.PinlunModel;
import com.example.zs.onetime.view.IPinlunView;

/**
 * Created by 杜晓彤 on 2018/4/27.
 */

public interface IPinlunPresenter {

    //关联
    void showPinToView(String s,PinlunModel pinlunModel, IPinlunView iPinlunView);
    //获取数据
    void getPinlunListData(Object o);
}
