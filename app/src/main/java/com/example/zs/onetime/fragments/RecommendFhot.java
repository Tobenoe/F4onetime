package com.example.zs.onetime.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zs.onetime.R;
import com.example.zs.onetime.base.BaseFragment;
import com.example.zs.onetime.bean.BannerBen;
import com.example.zs.onetime.presenter.BannerP;
import com.example.zs.onetime.view.BannerVinterface;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by work on 2018/4/25.
 * 推荐正式版
 */

public class RecommendFhot extends BaseFragment implements BannerVinterface {
    private View view;
    private XBanner mHotBanner;
    private XRecyclerView mHotRecylerView;
//    private BannerP bannerP;
    private List<String>list_path;
    private BannerP bannerP;

    @Override
    protected int getLayout() {
        return R.layout.hot_layout;
    }

    @Override
    protected void initView(View view) {

        mHotBanner = (XBanner) view.findViewById(R.id.hot_banner);
        mHotRecylerView = (XRecyclerView) view.findViewById(R.id.hot_recylerView);

    }

    @Override
    protected void initData() {

//        bannerP = new BannerP(this);
//        bannerP.getBanner();

        bannerP = new BannerP(this);
        bannerP.getBanner();
        list_path = new ArrayList<>();





    }

    @Override
    public void OnBanner(Object o) {

        BannerBen bannerBen = (BannerBen) o;
        Log.i("TAG", bannerBen.getCode() + "base");
        List<BannerBen.DataBean> data = bannerBen.getData();
        for(int i = 0 ;i < data.size() ; i++){
            String icon = data.get(i).getIcon();
            list_path.add(icon);

        }



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bannerP.onDestroy();

    }
}
