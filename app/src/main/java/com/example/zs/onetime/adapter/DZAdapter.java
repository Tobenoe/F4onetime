package com.example.zs.onetime.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zs.onetime.R;
import com.example.zs.onetime.bean.DZBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.List;

/**
 * Created by 杜晓彤 on 2018/4/26.
 */

public class DZAdapter extends RecyclerView.Adapter<DZAdapter.MyViewHolder> {
    private List<DZBean.DataBean> list;
    private Context context;
    public DZAdapter(List<DZBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.dz_list_layout,null);

        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        //賦值
        holder.dz_name.setText(list.get(position).getUser().getNickname()+"");
        holder.dz_time.setText(list.get(position).getCreateTime());
        holder.dz_content.setText(list.get(position).getContent());
        Log.d("TAG", "onBindViewHolder:=============================== ");
        String imgUrls = (String) list.get(position).getImgUrls();
        Log.d("TAG", "onBindViewHolder: "+imgUrls);


        if( imgUrls != null){

            Log.d("TAG", "onBindViewHolder:---------------- ");
            String[] split = imgUrls.split("\\|");
            Glide.with(context)
                    .load(split[0])
                    .into(holder.dz_img);

        }

        //关注的点击事件
        holder.guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"无此用户",Toast.LENGTH_SHORT).show();
            }
        });

        //加号点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.crosstalk_floating.collapse();
            }
        });

        //屏蔽
        holder.pinbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"你点击了屏蔽",Toast.LENGTH_SHORT).show();
            }
        });
        //链接
        holder.lianjie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"你点击了链接",Toast.LENGTH_SHORT).show();
            }
        });
        //
        holder.jubao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"你点击了举报",Toast.LENGTH_SHORT).show();
            }
        });

        //给整个条目布局添加点击事件
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

        return list!=null?list.size():0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView dz_img;
        private final TextView dz_name;
        private final TextView dz_time;
        private final TextView dz_content;
        private FloatingActionButton pinbi;
        private FloatingActionButton lianjie;
        private FloatingActionButton jubao;
        private Button guanzhu;
        private final FloatingActionsMenu crosstalk_floating;


        public MyViewHolder(View itemView) {
            super(itemView);
            dz_img = itemView.findViewById(R.id.dz_img);
            dz_name = itemView.findViewById(R.id.dz_name);
            dz_time = itemView.findViewById(R.id.dz_time);
            dz_content = itemView.findViewById(R.id.dz_content);
            crosstalk_floating = itemView.findViewById(R.id.crosstalk_floating);


            //图片id
            pinbi = itemView.findViewById(R.id.pinbi);
            lianjie = itemView.findViewById(R.id.lianjie);
            jubao = itemView.findViewById(R.id.jubao);

            guanzhu = itemView.findViewById(R.id.guanzhu);

        }
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
}
