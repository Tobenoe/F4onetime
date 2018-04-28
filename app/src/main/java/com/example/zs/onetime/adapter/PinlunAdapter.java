package com.example.zs.onetime.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zs.onetime.R;
import com.example.zs.onetime.bean.PinlunBean;

import java.util.List;

/**
 * Created by 杜晓彤 on 2018/4/27.
 */

public class PinlunAdapter extends RecyclerView.Adapter<PinlunAdapter.MyViewHolder> {

    private List<String> list;
    private Context context;

    public PinlunAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.pinlun_item_layout, null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.getRe_pinlun().setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView re_pinlun;

        public TextView getRe_pinlun() {
            return re_pinlun;
        }

        public MyViewHolder(View itemView) {
            super(itemView);


            re_pinlun = itemView.findViewById(R.id.re_pinlun);

        }
    }
}
