package com.example.zs.onetime.presenter;

import com.example.zs.onetime.bean.DZDetailBean;
import com.example.zs.onetime.moudel.DZDetailModel;
import com.example.zs.onetime.view.IDetailView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 杜晓彤 on 2018/4/27.
 */

public class DZDetailPresenter implements IDZDetailPresenter {

    private IDetailView iDetailView;
    @Override
    public void showDeatilToView(DZDetailModel dzDetailModel, IDetailView iDetailView) {
        this.iDetailView=iDetailView;
        //创建Map集合
        Map<String,String> map=new HashMap<>() ;
        map.put("jid","2208");
        map.put("source","android");
        map.put("appVersion","101");
        //调用M层请求数据的方法
        dzDetailModel.getDetailData(map);
    }

    //调用V层展示段子详情的方法
    @Override
    public void getDZDetailListData(Object o) {
        iDetailView.showDzDetailData(o);
    }
}
