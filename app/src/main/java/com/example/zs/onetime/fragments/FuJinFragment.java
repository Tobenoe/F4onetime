package com.example.zs.onetime.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zs.onetime.R;
import com.example.zs.onetime.activity.ShipinxiangqingActivity;
import com.example.zs.onetime.adapter.FujinAdapter;
import com.example.zs.onetime.adapter.ShipinRemenAdapter;
import com.example.zs.onetime.base.BaseFragment;
import com.example.zs.onetime.bean.FujinBean;
import com.example.zs.onetime.presenter.FujinPresenter;
import com.example.zs.onetime.view.FujinView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by zs on 2018/4/26.
 */

public class FuJinFragment extends BaseFragment implements FujinView {
    private View view;
    private XRecyclerView mXrvv;
    private List<FujinBean.DataBean> data;
    private FujinAdapter fujinAdapter;
    private FujinPresenter fujinPresenter;

    @Override
    protected int getLayout() {
        return R.layout.fujin;
    }

    @Override
    protected void initView(View view) {

        mXrvv = (XRecyclerView) view.findViewById(R.id.fujinrv);
    }

    @Override
    protected void initData() {
        fujinPresenter = new FujinPresenter(this);
        fujinPresenter.getData("1","1","1","1","android","1");



    }

    @Override
    public void onYes(Object o) {

        FujinBean o1 = (FujinBean) o;
        data = o1.getData();

        fujinAdapter = new FujinAdapter(getContext());


        fujinAdapter.setData(data);
        mXrvv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        mXrvv.setAdapter(fujinAdapter);

        fujinAdapter.setOnItemClickListener(new ShipinRemenAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), ShipinxiangqingActivity.class);
                intent.putExtra("url",data.get(position).getVideoUrl());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onNo(String e) {


    }



}
