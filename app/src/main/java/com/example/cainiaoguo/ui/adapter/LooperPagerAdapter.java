package com.example.cainiaoguo.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class LooperPagerAdapter extends PagerAdapter {
    private List<Integer> mPics = null;


    @Override
    public int getCount() {
        if (mPics != null) {
            return mPics.size();
        }
        return 0;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView=new ImageView(container.getContext());
        //imageView.setBackgroundColor(mColors.get(position));
        imageView.setImageResource(mPics.get(position));
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    public void setData(List<Integer> sColos) {
        this.mPics =sColos;
    }
}
