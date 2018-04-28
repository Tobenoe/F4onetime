package com.example.zs.onetime.presenter;

import com.example.zs.onetime.moudel.YonghuModel;
import com.example.zs.onetime.view.YonghuView;

/**
 * Created by zs on 2018/4/27.
 */

public class Yonghupresenter implements IYonghuP {
    private YonghuView yonghuView;
    private YonghuModel yonghuModel;
    public Yonghupresenter(YonghuView yonghuView) {
        this.yonghuView = yonghuView;
        yonghuModel=new YonghuModel();
    }

    @Override
    public void onYes(Object o) {
        if (yonghuView==null){
            return;
        }
        yonghuView.onYes(o);

    }

    @Override
    public void onNo(String e) {
        if (yonghuView==null){
            return;
        }
        yonghuView.onNo(e);

    }

    @Override
    public void getData(String uid, String source, String appVersion) {
        yonghuModel.getData(uid,source,appVersion,this);

    }
}
