package com.example.zs.onetime.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zs.onetime.R;
import com.example.zs.onetime.adapter.HotAdapter;
import com.example.zs.onetime.base.BaseFragment;
import com.example.zs.onetime.bean.BannerBen;
import com.example.zs.onetime.bean.HotBean;
import com.example.zs.onetime.presenter.BannerP;
import com.example.zs.onetime.presenter.GetHotP;
import com.example.zs.onetime.view.BannerVinterface;
import com.example.zs.onetime.view.GetHotVinterface;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by work on 2018/4/25.
 * 推荐正式版
 */

public class RecommendFhot extends BaseFragment implements BannerVinterface, GetHotVinterface {
    private View view;
    private XRecyclerView mHotRecylerView;
    private List<String> list_path;
    private List<String> list_title;
    private BannerP bannerP;
    private Banner banner;
    private GetHotP getHotP;
    private String types = "";
    private HotAdapter hotAdapter;


    @Override
    protected int getLayout() {
        return R.layout.hot_layout;
    }

    @Override
    protected void initView(View view) {

        banner = view.findViewById(R.id.banner);
        mHotRecylerView = (XRecyclerView) view.findViewById(R.id.hot_recylerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mHotRecylerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    protected void initData() {

        list_path = new ArrayList<>();
        list_title = new ArrayList<>();

        bannerP = new BannerP(this);
        bannerP.getBanner();
        hotAdapter = new HotAdapter(getActivity());
        getHotP = new GetHotP(this);
        Bundle arguments = getArguments();
        String type = arguments.getString("type1");
        getHotP.getHot("0", "1", "101");


    }

    //推荐数据
    @Override
    public void OnHot(Object o) {

        HotBean hotBean = (HotBean) o;
        List<HotBean.DataBean> data = hotBean.getData();
        String msg = hotBean.getMsg();
        String createTime = data.get(0).getCreateTime();
        Log.i("TAG", createTime);

        hotAdapter.setData(data);
        mHotRecylerView.setAdapter(hotAdapter);


    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            Glide.with(context).load((String) path).into(imageView);

        }
    }

    //推荐轮播
    @Override
    public void OnBanner(Object o) {

        BannerBen bannerBen = (BannerBen) o;
        Log.i("TAG", bannerBen.getCode() + "base");
        List<BannerBen.DataBean> data = bannerBen.getData();
        for (int i = 0; i < data.size(); i++) {
            String icon = data.get(i).getIcon();
            list_path.add(icon);
            list_title.add(data.get(i).getTitle());
        }

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //必须最后调用的方法，启动轮播图。
                .start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bannerP.onDestroy();
        getHotP.onDestroy();

    }


}
