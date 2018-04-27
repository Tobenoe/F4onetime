package com.example.zs.onetime.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.zs.onetime.R;
import com.example.zs.onetime.bean.HotBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by work on 2018/4/26.
 */

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.hotMyViewHodler> {
    //属性动画
    private ObjectAnimator animator;
    private ObjectAnimator fanimator;
    private ObjectAnimator animator1;
    private ObjectAnimator fanimator1;
    private ObjectAnimator animator2;
    private ObjectAnimator fanimator2;
    private ObjectAnimator animator3;
    private ObjectAnimator fanimator3;

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
    public void onBindViewHolder(final hotMyViewHodler holder, final int position) {


        Uri uri = Uri.parse(data.get(position).getUser().getIcon());
        holder.hot_item_img.setImageURI(uri);
        holder.hot_item_name.setText(data.get(position).getUser().getNickname());
        holder.hot_item_time.setText(data.get(position).getCreateTime());
        String videoUrl = data.get(position).getVideoUrl();
        holder.videoplayer.setUp(videoUrl, data.get(position).getWorkDesc() + "");
        int size = data.get(position).getComments().size();
        if (size != 0) {

            holder.hot_item_plr.setText(data.get(position).getComments().get(0).getNickname()+":");
            holder.hot_item_plcotext.setText(data.get(position).getComments().get(0).getContent());

        }


        holder.hot_item_amin_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //-----伸出时的动画
                animator = ObjectAnimator.ofFloat(holder.hot_item_amin_, "rotation", 0f, 180f);
                animator1 = ObjectAnimator.ofFloat(holder.hot_item_amin_1, "translationX", 0f, -80f);
                animator2 = ObjectAnimator.ofFloat(holder.hot_item_amin_2, "translationX", 0f, -160f);
                animator3 = ObjectAnimator.ofFloat(holder.hot_item_amin_3, "translationX", 0f, -240f);


                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {

                        holder.hot_item_amin_jian.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

                AnimatorSet animSet = new AnimatorSet();//动画集合
                animSet.play(animator).with(animator1).with(animator2).with(animator3);
                animSet.setDuration(500);
                animSet.start();


            }
        });

        holder.hot_item_amin_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //----缩回时的动画
                fanimator = ObjectAnimator.ofFloat(holder.hot_item_amin_, "rotation", 0f, -180f);
                fanimator1 = ObjectAnimator.ofFloat(holder.hot_item_amin_1, "translationX", -80f, 0f);
                fanimator2 = ObjectAnimator.ofFloat(holder.hot_item_amin_2, "translationX", -160f, 0f);
                fanimator3 = ObjectAnimator.ofFloat(holder.hot_item_amin_3, "translationX", -240f, 0f);

                AnimatorSet animSet1 = new AnimatorSet();//动画集合
                animSet1.play(fanimator).with(fanimator1).with(fanimator2).with(fanimator3);
                animSet1.setDuration(500);
                animSet1.start();

                fanimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        holder.hot_item_amin_jian.setVisibility(View.GONE);
                        //改变图片
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });


            }
        });


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
        private final ImageView hot_item_amin_1;
        private final ImageView hot_item_amin_2;
        private final ImageView hot_item_amin_3;
        private final ImageView hot_item_amin_jian;


        private final JCVideoPlayer videoplayer;


        private final TextView hot_item_plr;
        private final TextView hot_item_plcotext;


        public hotMyViewHodler(View itemView) {
            super(itemView);

            hot_item_img = itemView.findViewById(R.id.hot_item_img);
            hot_item_name = itemView.findViewById(R.id.hot_item_name);
            hot_item_time = itemView.findViewById(R.id.hot_item_time);
            hot_item_amin_ = itemView.findViewById(R.id.hot_item_amin_);
            hot_item_amin_1 = itemView.findViewById(R.id.hot_item_amin_1);
            hot_item_amin_2 = itemView.findViewById(R.id.hot_item_amin_2);
            hot_item_amin_3 = itemView.findViewById(R.id.hot_item_amin_3);
            hot_item_amin_jian = itemView.findViewById(R.id.hot_item_amin_jian);
            //评论
            hot_item_plr = itemView.findViewById(R.id.hot_item_plr);
            hot_item_plcotext = itemView.findViewById(R.id.hot_item_plcotext);


            videoplayer = itemView.findViewById(R.id.mvPlayer);


        }
    }


}
