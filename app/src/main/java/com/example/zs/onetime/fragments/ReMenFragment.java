package com.example.zs.onetime.fragments;

import android.content.Intent;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zs.onetime.R;
import com.example.zs.onetime.activity.ShipinxiangqingActivity;
import com.example.zs.onetime.adapter.ShipinRemenAdapter;
import com.example.zs.onetime.base.BaseFragment;
import com.example.zs.onetime.bean.ShipinBean;
import com.example.zs.onetime.presenter.ShipinPresenter;
import com.example.zs.onetime.view.ShipinView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by zs on 2018/4/26.
 */

public class ReMenFragment extends BaseFragment implements ShipinView{
    private XRecyclerView mXrv;
    private ShipinPresenter shipinPresenter;
    private String i="1";
    private ShipinRemenAdapter shipinRemenAdapter;
    private List<ShipinBean.DataBean> data;

    @Override
    protected int getLayout() {
        return R.layout.remen;
    }

    @Override
    protected void initView(View view) {
        mXrv = view.findViewById(R.id.xrv);
        shipinRemenAdapter = new ShipinRemenAdapter(getContext());
    }

    @Override
    protected void initData() {
        shipinPresenter = new ShipinPresenter(this);
        shipinPresenter.getData("10239","android",i);

        shipinRemenAdapter.setOnItemClickListener(new ShipinRemenAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                String videoUrl = data.get(position).getVideoUrl();
                int uid = data.get(position).getUid();


                Intent intent = new Intent(getActivity(), ShipinxiangqingActivity.class);
                intent.putExtra("url",videoUrl);
                intent.putExtra("yhuid",uid);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onYes(Object o) {
        ShipinBean o1 = (ShipinBean) o;
        data = o1.getData();

        if (data!=null) {


            shipinRemenAdapter.setData(data);
            mXrv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

            mXrv.setAdapter(shipinRemenAdapter);
        }else{
            return;
        }

    }

    @Override
    public void onNo(String e) {

    }



}
