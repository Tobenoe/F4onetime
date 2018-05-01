package com.example.zs.onetime.fragments;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zs.onetime.R;
import com.example.zs.onetime.activity.DzDetailActivity;
import com.example.zs.onetime.adapter.DZAdapter;
import com.example.zs.onetime.adapter.ShipinRemenAdapter;
import com.example.zs.onetime.api.Api;
import com.example.zs.onetime.api.ApiService;
import com.example.zs.onetime.base.BaseFragment;
import com.example.zs.onetime.bean.DZBean;
import com.example.zs.onetime.moudel.DZModel;
import com.example.zs.onetime.presenter.DZPresenter;
import com.example.zs.onetime.utils.RetrofitUtils;
import com.example.zs.onetime.view.IDZView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * 段子
 */

public class CrossdFreagment extends BaseFragment implements IDZView {
    private View view;
    private XRecyclerView mXrecyclerview;
    private List<DZBean.DataBean> list;
    private List<DZBean.DataBean> data;//把获取到的数据放在集合里
    private int page = 1;//页数
    private int con=0;//判断con是否等于0，等于0就执行适配器，不等于就刷新界面
    private DZAdapter dzAdapter;

    @Override
    protected int getLayout() {
        return R.layout.cross_layout;
    }

    @Override
    protected void initView(View view) {
        //初始化Xrecyclerview
        mXrecyclerview = (XRecyclerView) view.findViewById(R.id.xrecyclerview);
        //设置布局管理器模式
        mXrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        //设置
        mXrecyclerview.setPullRefreshEnabled(true);
        mXrecyclerview.setLoadingMoreEnabled(true);

        data=new ArrayList<>();
    }

    @Override
    protected void initData() {
        //调用P层的接口
        DZPresenter dzPresenter = new DZPresenter();
        dzPresenter.showDataToView(new DZModel(dzPresenter), this);

        //给xrecyclerview设置监听
        mXrecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            //刷新
            @Override
            public void onRefresh() {
                page = 1;
                Toast.makeText(getActivity(), "刷新", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        list.clear();//清楚数据
                        dzAdapter.notifyDataSetChanged();
                        mXrecyclerview.refreshComplete();
                    }
                },2000);
            }
            //加载
            @Override
            public void onLoadMore() {
                page++;//上拉加载添加数据
                Toast.makeText(getActivity(), "加载更多", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        con=1;//con不等于0就执行上拉加载

                        mXrecyclerview.loadMoreComplete();
                    }
                },2000);
            }
        });
    }
    //展示段子列表的方法
    @Override
    public void showDZList(final List<DZBean.DataBean> list) {
        this.list = list;
        Log.d("TAG", "showDZList: 数据---------" + list);

        //设置适配器
        dzAdapter = new DZAdapter(list, getActivity());
        mXrecyclerview.setAdapter(dzAdapter);

        dzAdapter.setOnItemClickListener(new DZAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //跳转到段子详情页面
                Intent intent=new Intent(getActivity(), DzDetailActivity.class);
                intent.putExtra("jid",list.get(0).getJid());
                startActivity(intent);
            }
        });

    }
}
