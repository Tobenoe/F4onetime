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

/**
 * Created by work on 2018/4/25.
 */

public class RecommendFhot extends BaseFragment implements BannerVinterface {
    private View view;
    private XBanner mHotBanner;
    private XRecyclerView mHotRecylerView;
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

        bannerP = new BannerP(getActivity());
        bannerP.getBanner();

    }
    
    @Override
    public void OnBanner(Object o) {

        

    }

        BannerBen bannerBen = (BannerBen) o;







    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bannerP.onDestroy();

    }
}
