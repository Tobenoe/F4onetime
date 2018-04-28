package com.example.zs.onetime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
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

import com.example.zs.onetime.activity.IssuevideoActivity;
import com.example.zs.onetime.activity.LoginActivity;
import com.example.zs.onetime.activity.SettingActivity;
import com.example.zs.onetime.base.BaseActivity;
import com.example.zs.onetime.bean.LoginBean;
import com.example.zs.onetime.bean.SildeBean;
import com.example.zs.onetime.fragments.CrossdFreagment;
import com.example.zs.onetime.fragments.RecommendFreagment;
import com.example.zs.onetime.fragments.VideoFreagment;
import com.example.zs.onetime.presenter.PresmanP;
import com.example.zs.onetime.view.PresmanVinterface;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements View.OnClickListener, PresmanVinterface {


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
    /**
     * name
     */
    private TextView mSildeName;
    private ImageView mWj;
    private ImageView mSz;
    private PresmanP presmanP;
    private SharedPreferences sharedPreferences;
    private String uid;
    private SimpleDraweeView mFabu;

    @Override
    protected int getLayout() {

        return R.layout.activity_main;

    }

    @Override
    protected void initView() {
        //存储uid
        sharedPreferences = getSharedPreferences("userdata", Activity.MODE_PRIVATE);

        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        mPlaceHolderImageDraweeView = (SimpleDraweeView) findViewById(R.id.placeHolderImageDraweeView);
        mTabTitle = (TextView) findViewById(R.id.tab_title);
        mMyDrawerLayout = (DrawerLayout) findViewById(R.id.my_drawerLayout);
        mSildeList = (ListView) findViewById(R.id.silde_list);
        mSildeTouxiang = (SimpleDraweeView) findViewById(R.id.silde_touxiang);
        mSildeTouxiang.setOnClickListener(this);
        mSildeName = (TextView) findViewById(R.id.silde_name);
        mWj = (ImageView) findViewById(R.id.wj);
        mWj.setOnClickListener(this);
        mSz = (ImageView) findViewById(R.id.sz);
        mSz.setOnClickListener(this);
        mPlaceHolderImageDraweeView.setOnClickListener(this);
        mFabu = (SimpleDraweeView) findViewById(R.id.fabu);
        mFabu.setOnClickListener(this);
    }

    @Override
    protected void initData() {


        setmain();

        setsilde();
        presmanP = new PresmanP(this);
        uid = sharedPreferences.getString("uid", "0");
        String token = sharedPreferences.getString("token", "0");
        Log.i("TAG", "uid" + uid);
        if (!uid.equals("0")) {

            presmanP.getPresman(uid, token);

        } else {

            Toast.makeText(MainActivity.this, "暂未登陆", Toast.LENGTH_SHORT).show();


        }


    }

    private void setmain() {


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

    private void setsilde() {

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
            case R.id.wj:


                break;
            case R.id.sz:

                Intent intent1 = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent1);

                break;
            case R.id.placeHolderImageDraweeView:

                mMyDrawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.fabu:


                Toast.makeText(MainActivity.this,"点击了发布",Toast.LENGTH_SHORT).show();

                Intent intent2 = new Intent(MainActivity.this, IssuevideoActivity.class);
                startActivity(intent2);
                break;
        }
    }

    //获取个人信息
    @Override
    public void OnPresman(Object o) {

        LoginBean loginBean = (LoginBean) o;
        String msg = loginBean.getMsg();
        if (!uid.equals("0")) {

            Log.i("TAG", msg);
            //用户名
            String username = loginBean.getData().getUsername();
            mSildeName.setText(username);
            //用户头像
            Uri uri = Uri.parse("https://img-blog.csdn.net/20141210011257140?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTHVvc2hlbmd5YW5n/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast");
            mPlaceHolderImageDraweeView.setImageURI(uri);
            mSildeTouxiang.setImageURI(uri);

        } else {

            mSildeName.setText("暂未登陆");

        }


    }



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
