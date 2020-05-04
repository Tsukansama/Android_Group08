package com.example.cainiaoguo.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.beans.ItemBean;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.InnerHoledr> {
    private final List<ItemBean> mData;

    public ListViewAdapter(List<ItemBean> data) {
        this.mData = data;
    }

    @Override
    public InnerHoledr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //传入的界面
        View view = View.inflate(parent.getContext(), R.layout.listview, null);
        return new InnerHoledr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHoledr holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public class InnerHoledr extends RecyclerView.ViewHolder {
        private ImageView micon;
        private TextView mtitle;

        public InnerHoledr(@NonNull View itemView) {
            super(itemView);
            micon = (ImageView) itemView.findViewById(R.id.list_view_icon);
            mtitle = (TextView) itemView.findViewById(R.id.list_view_title);
        }

        public void setData(ItemBean itemBean) {

            micon.setImageResource(itemBean.icon);
            mtitle.setText(itemBean.title);

        }
    }
}
