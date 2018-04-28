package com.example.zs.onetime.presenter;

import com.example.zs.onetime.bean.DZDetailBean;
import com.example.zs.onetime.moudel.DZDetailModel;
import com.example.zs.onetime.view.IDetailView;

import java.util.List;

/**
 * Created by 杜晓彤 on 2018/4/27.
 */

public interface IDZDetailPresenter {

    void showDeatilToView(DZDetailModel dzDetailModel, IDetailView iDetailView);

    //获取段子详情的方法
    void getDZDetailListData(Object o);
}



