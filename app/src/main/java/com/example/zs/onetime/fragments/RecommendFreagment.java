package com.example.zs.onetime.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zs.onetime.R;
import com.example.zs.onetime.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by work on 2018/4/25.
 */

public class RecommendFreagment extends BaseFragment {
    private View view;
    private TabLayout mRecomTabs;
    private ViewPager mRecomViewPager;
    private String[] items = {"热门", "关注"};
    private String[] type = {"1", "2"};
  //  private List<Fragment> fragments = new ArrayList<>();
    private List<RecommendFhot> fhotList = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.recommend_layout;
    }

    @Override
    protected void initView(View view) {

        mRecomTabs = (TabLayout) view.findViewById(R.id.recom_tabs);
        mRecomViewPager = (ViewPager) view.findViewById(R.id.recom_viewPager);


    }

    @Override
    protected void initData() {



        for (int i = 0; i < items.length; i++) {
            RecommendFhot recommendFhot = new RecommendFhot();
            Bundle bundle = new Bundle();
            bundle.putString("type",type[i]);
            recommendFhot.setArguments(bundle);
            fhotList.add(recommendFhot);
            mRecomTabs.addTab(mRecomTabs.newTab().setText(items[i]));

        }


        mRecomTabs.setupWithViewPager(mRecomViewPager);
        mRecomViewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fhotList.get(position);
            }
            @Override
            public int getCount() {
                return fhotList!= null ? fhotList.size() : 0;
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return items[position];
            }


        });


    }




}