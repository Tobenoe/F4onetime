package com.example.zs.onetime.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zs.onetime.R;
import com.example.zs.onetime.base.BaseActivity;

public class IssuevideoActivity extends BaseActivity implements View.OnClickListener {


    /**
     * cancel
     */
    private TextView mIssueCancel;
    private ImageView mIssueVideo;
    private ImageView mIssueDuanzi;

    @Override
    protected int getLayout() {

        return R.layout.activity_myvideo;
    }

    @Override
    protected void initView() {

        mIssueCancel = (TextView) findViewById(R.id.issue_cancel);
        mIssueCancel.setOnClickListener(this);
        mIssueVideo = (ImageView) findViewById(R.id.issue_video);
        mIssueVideo.setOnClickListener(this);
        mIssueDuanzi = (ImageView) findViewById(R.id.issue_duanzi);
        mIssueDuanzi.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.issue_cancel:
                //取消

                break;
            case R.id.issue_video:
                //视频


                break;
            case R.id.issue_duanzi:
                //段子



                break;
        }
    }
}
