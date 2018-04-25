package com.example.zs.onetime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.zs.onetime.base.BaseActivity;
import com.example.zs.onetime.fragments.CrossdFreagment;
import com.example.zs.onetime.fragments.RecommendFreagment;
import com.example.zs.onetime.fragments.VideoFreagment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private ViewPager mMainViewPager;
    private RadioButton mMainRadioGroupRadio1;
    private RadioButton mMainRadioGroupRadio2;
    private RadioButton mMainRadioGroupRadio3;
    private RadioGroup mMainRadioGroup;
    private List<Fragment> fragmentList;

    @Override
    protected int getLayout() {

        return R.layout.activity_main;

    }

    @Override
    protected void initView() {


        mMainViewPager = (ViewPager) findViewById(R.id.main_viewPager);
        mMainRadioGroupRadio1 = (RadioButton) findViewById(R.id.main_radioGroup_radio1);
        mMainRadioGroupRadio2 = (RadioButton) findViewById(R.id.main_radioGroup_radio2);
        mMainRadioGroupRadio3 = (RadioButton) findViewById(R.id.main_radioGroup_radio3);
        mMainRadioGroup = (RadioGroup) findViewById(R.id.main_radioGroup);
    }

    @Override
    protected void initData() {

        fragmentList = new ArrayList<>();
        fragmentList.add(new RecommendFreagment());
        fragmentList.add(new CrossdFreagment());
        fragmentList.add(new VideoFreagment());

        mMainViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList != null ? fragmentList.size() : 0;
            }
        });

        mMainViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {

                    case 0:
                        mMainRadioGroup.check(R.id.main_radioGroup_radio1);
                        break;
                    case 1:
                        mMainRadioGroup.check(R.id.main_radioGroup_radio2);
                        break;
                    case 2:
                        mMainRadioGroup.check(R.id.main_radioGroup_radio3);
                        break;


                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mMainRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {

                    case R.id.main_radioGroup_radio1:
                        mMainViewPager.setCurrentItem(0);
                        break;
                    case R.id.main_radioGroup_radio2:
                        mMainViewPager.setCurrentItem(1);
                        break;
                    case R.id.main_radioGroup_radio3:
                        mMainViewPager.setCurrentItem(2);
                        break;

                }

            }
        });


    }


}
