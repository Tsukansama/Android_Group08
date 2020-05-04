package com.example.cainiaoguo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.base.BaseFragment;
import com.example.cainiaoguo.beans.Datas;
import com.example.cainiaoguo.beans.ItemBean;
import com.example.cainiaoguo.ui.adapter.ListViewAdapter;
import com.example.cainiaoguo.ui.adapter.LooperPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment {
    private LooperPagerAdapter mLooperPagerAdapter;
    private static List<Integer> sPics = new ArrayList<>();
    @BindView(R.id.looper_pager)
    public ViewPager mloopPager;
    private List<ItemBean> mData;
    @BindView(R.id.recycler_view)
    public RecyclerView mlist;

    static {
        sPics.add(R.mipmap.lunbo1);
        sPics.add(R.mipmap.lunbo2);
    }

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViewloop(View rootView) {
        mLooperPagerAdapter = new LooperPagerAdapter();
        mLooperPagerAdapter.setData(sPics);
        mloopPager.setAdapter(mLooperPagerAdapter);
    }

    @Override
    protected void initData(View rootView) {
        //List<databata>-----adapeter-----setadapter------展示数据
        mData = new ArrayList<>();
        for (int i = 0; i < Datas.icons.length; i++) {
            ItemBean data = new ItemBean();
            data.icon = Datas.icons[i];
            data.title = "我是第" + i + "个条目";
            //添加到集合里
            mData.add(data);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        mlist.setLayoutManager(layoutManager);
        ListViewAdapter adapter = new ListViewAdapter(mData);
        mlist.setAdapter(adapter);
    }
}
