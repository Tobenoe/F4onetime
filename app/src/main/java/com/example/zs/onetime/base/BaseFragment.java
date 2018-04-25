package com.example.zs.onetime.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zs.onetime.R;

/**
 * Created by work on 2018/4/25.
 */

public abstract class BaseFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayout(), container, false);
        initView(view);
        initData();
        return view;
    }


    protected abstract int getLayout();

    protected abstract void initView(View view);

    protected abstract void initData();


}
