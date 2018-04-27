package com.example.zs.onetime;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.TextView;

import com.example.zs.onetime.base.BaseActivity;
import com.example.zs.onetime.fragments.CrossdFreagment;
import com.example.zs.onetime.fragments.RecommendFreagment;
import com.example.zs.onetime.fragments.VideoFreagment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends BaseActivity {


    private List<Fragment> fragmentList;
    private BottomTabBar mBottomTabBar;
    private SimpleDraweeView mPlaceHolderImageDraweeView;
    /**
     * title
     */
    private TextView mTabTitle;

    @Override
    protected int getLayout() {

        return R.layout.activity_main;

    }

    @Override
    protected void initView() {


        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        mPlaceHolderImageDraweeView = (SimpleDraweeView) findViewById(R.id.placeHolderImageDraweeView);
        mTabTitle = (TextView) findViewById(R.id.tab_title);
    }

    @Override
    protected void initData() {

        fragmentList = new ArrayList<>();
        fragmentList.add(new RecommendFreagment());
        fragmentList.add(new CrossdFreagment());
        fragmentList.add(new VideoFreagment());

        mBottomTabBar.init(getSupportFragmentManager())
                .setImgSize(100, 100)
                .setFontSize(0)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("", R.drawable.tuijian2, R.drawable.tuijian1, RecommendFreagment.class)
                .addTabItem("", R.drawable.duanzi2, R.drawable.duanzi1, CrossdFreagment.class)
                .addTabItem("", R.drawable.shipin2, R.drawable.shipin1, VideoFreagment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        Log.i("TAG", position + "");
                        switch (position) {

                            case 0:

                                mTabTitle.setText("推荐");
                                break;

                            case 1:

                                mTabTitle.setText("段子");
                                break;

                            case 2:
                                mTabTitle.setText("视频");
                                break;

                        }


                    }
                });


    }


}
