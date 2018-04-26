package com.example.zs.onetime.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.zs.onetime.R;
import com.example.zs.onetime.adapter.TabLayoutAdapter;
import com.example.zs.onetime.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by work on 2018/4/25.
 */

public class VideoFreagment extends BaseFragment{
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> fragments;
    private List<String> titles;
    @Override
    protected int getLayout() {
        return R.layout.video_layout;
    }

    @Override
    protected void initView(View view) {
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab);

        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    protected void initData() {

        fragments = new ArrayList<Fragment>();

        ReMenFragment reMenFragment = new ReMenFragment();

        fragments.add(reMenFragment);

        FuJinFragment fuJinFragment = new FuJinFragment();

        fragments.add(fuJinFragment);


        titles = new ArrayList<String>();
        titles.add("热门");
        titles.add("附近");

        mAdapter = new TabLayoutAdapter(getActivity().getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

    }
}
