package com.example.zs.onetime.presenter;

import android.util.Log;

import com.example.zs.onetime.bean.DZBean;
import com.example.zs.onetime.moudel.DZModel;
import com.example.zs.onetime.view.IDZView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 杜晓彤 on 2018/4/26.
 */

public class DZPresenter implements IDZPresenter {
    private static final String TAG = "DZPresenter----------";

    private IDZView idzView;

    @Override
    public void showDataToView(DZModel dzModel, IDZView idzView) {
        this.idzView=idzView;
        //创建Map集合
        Map<String,String> map= new HashMap<>();
        map.put("page","1");
        map.put("token","49DD065C4180DD646BA27B10BE842CBF");
        map.put("source","android");
        map.put("appVersion","101");
        //调用M层请求数据的方法
        dzModel.getDZData(map);
        Log.i("AAA","persenter");
    }

    //获取段子列表的方法
    @Override
    public void getDZDataList(List<DZBean.DataBean> bean) {
        //调用V层展示的方法
        idzView.showDZList(bean);
    }
}
