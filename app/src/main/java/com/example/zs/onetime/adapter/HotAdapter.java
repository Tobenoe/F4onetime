package com.example.zs.onetime.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.zs.onetime.R;
import com.example.zs.onetime.bean.HotBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by work on 2018/4/26.
 */

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.hotMyViewHodler> {
    private Context context;
    private List<HotBean.DataBean> data;

    public HotAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<HotBean.DataBean> data) {
        this.data = data;
    }


    @Override
    public hotMyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hot_item_layout, parent, false);
        hotMyViewHodler hodler = new hotMyViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(hotMyViewHodler holder, int position) {

        Uri uri = Uri.parse(data.get(position).getUser().getIcon());
        holder.hot_item_img.setImageURI(uri);
        holder.hot_item_name.setText(data.get(position).getUser().getNickname());
        holder.hot_item_time.setText(data.get(position).getCreateTime());
        String videoUrl = data.get(position).getVideoUrl();
        holder.videoplayer.setUp(videoUrl,data.get(position).getWorkDesc()+"");



    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    class hotMyViewHodler extends RecyclerView.ViewHolder {


        private final SimpleDraweeView hot_item_img;
        private final TextView hot_item_name;
        private final TextView hot_item_time;
        private final ImageView hot_item_amin_;
        private final JCVideoPlayer videoplayer;


        public hotMyViewHodler(View itemView) {
            super(itemView);

            hot_item_img = itemView.findViewById(R.id.hot_item_img);
            hot_item_name = itemView.findViewById(R.id.hot_item_name);
            hot_item_time = itemView.findViewById(R.id.hot_item_time);
            hot_item_amin_ = itemView.findViewById(R.id.hot_item_amin_);
            videoplayer = itemView.findViewById(R.id.mvPlayer);


        }
    }


}
