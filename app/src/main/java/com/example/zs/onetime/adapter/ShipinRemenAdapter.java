package com.example.zs.onetime.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zs.onetime.R;
import com.example.zs.onetime.bean.ShipinBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zs on 2018/4/26.
 */

public class ShipinRemenAdapter extends RecyclerView.Adapter<ShipinRemenAdapter.ViewHolder>{

    private List<ShipinBean.DataBean> data;
    private Context context;
    private List<Integer> heightList;

    public ShipinRemenAdapter(Context context) {
        this.context = context;
    }
    //条目点击监听
    private OnItemClickListener onItemClickListener;
    //条目点击事件
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    //条目点击事件
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {

        this.onItemClickListener = onItemClickListener;
    }

    public void setData(List<ShipinBean.DataBean> data) {
        this.data = data;
        heightList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            int height = new Random().nextInt(350) + 100;//[100,450)的随机数
            heightList.add(height);
        }

        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.shipinitem,parent,false);

        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        ViewGroup.LayoutParams params = holder.img.getLayoutParams();
        params.height=heightList.get(position);
        Glide.with(context)
                .load(data.get(position).getUser().getIcon())
                .into(holder.img);
//        String cover = data.get(position).getCover();
//        String icon = data.get(position).getUser().getIcon();
//        if (cover.equals("")||cover==null){
//            Glide.with(context).load(icon).into(holder.img);
//        }else{
//            Glide.with(context).load(cover).into(holder.img);
//        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //条目的点击事件
                int index = holder.getLayoutPosition();
                onItemClickListener.onItemClick(view,index);

            }
        });



    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
}
