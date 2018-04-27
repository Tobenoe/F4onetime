package com.example.zs.onetime.presenter;

import com.example.zs.onetime.bean.DZBean;
import com.example.zs.onetime.moudel.DZModel;
import com.example.zs.onetime.view.IDZView;

import java.util.List;

/**
 * Created by 杜晓彤 on 2018/4/26.
 */

public interface IDZPresenter {

    //关联M和V
    void showDataToView(DZModel dzModel, IDZView idzView);

    //获取段子数据
    void getDZDataList(List<DZBean.DataBean> bean);
}
