package com.example.cainiaoguo.base;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment extends Fragment {

    private Unbinder mBind;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = loadRootView(inflater,container,savedInstanceState);

        mBind = ButterKnife.bind(this,rootView);

        initView(rootView);
        initData(rootView);
        initViewloop(rootView);
        HomeSearch(rootView);
        return rootView;

    }

    protected void initView(View rootView) {

    }

    protected void HomeSearch(View rootView) {

    }

    protected void initData(View rootView) {

    }

    protected void initViewloop(View rootView){

    }

    public void onDestroyView() {

        super.onDestroyView();
        if(mBind!=null){
            mBind.unbind();
        }
    }

    protected View loadRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        int resId = getRootViewResId();
        return inflater.inflate(resId,container,false);
    }

    protected abstract int getRootViewResId();

}
