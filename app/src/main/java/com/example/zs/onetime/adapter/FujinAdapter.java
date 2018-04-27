package com.example.zs.onetime.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zs.onetime.R;
import com.example.zs.onetime.bean.FujinBean;
import com.example.zs.onetime.bean.ShipinBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zs on 2018/4/27.
 */

public class FujinAdapter  extends RecyclerView.Adapter<FujinAdapter.ViewHodler>{
    private List<FujinBean.DataBean> data;
    private Context context;
    private List<Integer> heightList;
    public FujinAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<FujinBean.DataBean> data) {
        this.data = data;
        heightList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            int height = new Random().nextInt(350) + 100;//[100,450)的随机数
            heightList.add(height);
        }
        notifyDataSetChanged();
    }
    //条目点击监听
    private ShipinRemenAdapter.OnItemClickListener onItemClickListener;
    //条目点击事件
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    //条目点击事件
    public void setOnItemClickListener(ShipinRemenAdapter.OnItemClickListener onItemClickListener) {

        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.fujinitem,parent,false);
        ViewHodler hodler=new ViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(final ViewHodler holder, int position) {
        ViewGroup.LayoutParams params = holder.img.getLayoutParams();
        params.height=heightList.get(position);
        Glide.with(context)
                .load(data.get(position).getUser().getIcon())
                .into(holder.img);
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

    class ViewHodler extends RecyclerView.ViewHolder {

        private final ImageView img;

        public ViewHodler(View itemView) {
        super(itemView);
            img = itemView.findViewById(R.id.imgfj);
    }
}
}
