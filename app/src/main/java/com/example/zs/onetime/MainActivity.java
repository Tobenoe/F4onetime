package com.example.zs.onetime;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zs.onetime.activity.FabuActivity;
import com.example.zs.onetime.activity.LoginActivity;
import com.example.zs.onetime.activity.SettingActivity;
import com.example.zs.onetime.base.BaseActivity;
import com.example.zs.onetime.bean.SildeBean;
import com.example.zs.onetime.fragments.CrossdFreagment;
import com.example.zs.onetime.fragments.RecommendFreagment;
import com.example.zs.onetime.fragments.VideoFreagment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements View.OnClickListener {


    private List<Fragment> fragmentList;
    private BottomTabBar mBottomTabBar;
    private SimpleDraweeView mPlaceHolderImageDraweeView;
    /**
     * title
     */
    private TextView mTabTitle;
    private DrawerLayout mMyDrawerLayout;
    private ListView mSildeList;
    private List<SildeBean> list;
    private SimpleDraweeView mSildeTouxiang;
<<<<<<< HEAD
    private SimpleDraweeView mFabu;
=======
    /**
     * name
     */
    private TextView mSildeName;
>>>>>>> b4a85800e05db7a24349d50148d20b7049fdbeef
    private ImageView mWj;
    private ImageView mSz;

    @Override
    protected int getLayout() {

        return R.layout.activity_main;

    }

    @Override
    protected void initView() {


        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        mPlaceHolderImageDraweeView = (SimpleDraweeView) findViewById(R.id.placeHolderImageDraweeView);
        mTabTitle = (TextView) findViewById(R.id.tab_title);
        mMyDrawerLayout = (DrawerLayout) findViewById(R.id.my_drawerLayout);
        mSildeList = (ListView) findViewById(R.id.silde_list);
        mSildeTouxiang = (SimpleDraweeView) findViewById(R.id.silde_touxiang);
        mSildeTouxiang.setOnClickListener(this);
<<<<<<< HEAD
        mFabu = (SimpleDraweeView) findViewById(R.id.fabu);
        mFabu.setOnClickListener(this);
        mWj = (ImageView) findViewById(R.id.wj);
        mSz = (ImageView) findViewById(R.id.sz);
        mMyDrawerLayout.setOnClickListener(this);
=======
        mSildeName = (TextView) findViewById(R.id.silde_name);
        mWj = (ImageView) findViewById(R.id.wj);
        mWj.setOnClickListener(this);
        mSz = (ImageView) findViewById(R.id.sz);
        mSz.setOnClickListener(this);
>>>>>>> b4a85800e05db7a24349d50148d20b7049fdbeef
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

        mPlaceHolderImageDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "点击了头像", Toast.LENGTH_SHORT).show();
                mMyDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mSildeName.setText(name);
        List<SildeBean> list = new ArrayList<>();
        list.add(new SildeBean("我的关注", R.drawable.left_xin, R.mipmap.jiantou));
        list.add(new SildeBean("我的收藏", R.drawable.left_shoucang, R.mipmap.jiantou));
        list.add(new SildeBean("搜索好友", R.mipmap.left_search, R.mipmap.jiantou));
        list.add(new SildeBean("消息通知", R.mipmap.left_xiaoxi, R.mipmap.jiantou));
        SlideAdapter slideAdapter = new SlideAdapter(this, list);
        mSildeList.setAdapter(slideAdapter);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.silde_touxiang:
                //去登录页面
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);


                break;
<<<<<<< HEAD
            case R.id.fabu:
                Intent intent1 = new Intent(this, FabuActivity.class);
                startActivity(intent1);

                break;
            case R.id.my_drawerLayout:
=======
            case R.id.wj:




                break;
            case R.id.sz:

                Intent intent1 = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent1);

>>>>>>> b4a85800e05db7a24349d50148d20b7049fdbeef
                break;
        }
    }



<<<<<<< HEAD
=======

>>>>>>> b4a85800e05db7a24349d50148d20b7049fdbeef
    class SlideAdapter extends BaseAdapter {

        private Context context;
        private List<SildeBean> list;

        public SlideAdapter(Context context, List<SildeBean> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = LayoutInflater.from(context).inflate(R.layout.silde_item, viewGroup, false);
            ImageView silde_item_left = view.findViewById(R.id.silde_item_left);
            TextView silde_item_text = view.findViewById(R.id.silde_item_text);
            ImageView silde_item_right = view.findViewById(R.id.silde_item_right);

            silde_item_left.setImageResource(list.get(i).getLeftImg());
            silde_item_text.setText(list.get(i).getText());
            silde_item_right.setImageResource(list.get(i).getRight());

            return view;


        }
    }

}
