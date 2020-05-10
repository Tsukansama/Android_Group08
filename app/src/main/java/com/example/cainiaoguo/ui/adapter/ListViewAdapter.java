package com.example.cainiaoguo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.beans.ItemBean;
import com.example.cainiaoguo.domain.HistoryOrders;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.InnerHoledr> {
    private List<HistoryOrders.DataBean> mData = new ArrayList<>();
    private OnItemClickListener mItemClickListener = null;

    @NonNull
    @Override
    public ListViewAdapter.InnerHoledr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview,parent,false);
        return new InnerHoledr(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewAdapter.InnerHoledr holder, int position) {
        TextView mStatus = holder.itemView.findViewById(R.id.list_view_title);
        TextView realTimeAddr = holder.itemView.findViewById(R.id.list_view_title1);
        HistoryOrders.DataBean dataBean = mData.get(position);
        if(dataBean.getSign_for().equals("Y")){
            mStatus.setText("已签收");
        }else{
            mStatus.setText("未签收");
        }
        realTimeAddr.setText(dataBean.getReal_time_address());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemClickListener != null){
                    mItemClickListener.onItemClick(dataBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(HistoryOrders historyOrders) {
        mData.clear();
        mData.addAll(historyOrders.getData());
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(HistoryOrders.DataBean item);
    }

    public class InnerHoledr extends RecyclerView.ViewHolder {
        public InnerHoledr(@NonNull View itemView) {
            super(itemView);
        }
    }


//    public ListViewAdapter(List<ItemBean> data) {
//        this.mData = data;
//    }
//
//    @Override
//    public InnerHoledr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        //传入的界面
//        View view = View.inflate(parent.getContext(), R.layout.listview, null);
//        return new InnerHoledr(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull InnerHoledr holder, int position) {
//        holder.setData(mData.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        if (mData != null) {
//            return mData.size();
//        }
//        return 0;
//    }
//
//    public class InnerHoledr extends RecyclerView.ViewHolder {
//        private ImageView micon;
//        private TextView mtitle;
//
//        public InnerHoledr(@NonNull View itemView) {
//            super(itemView);
//            micon = (ImageView) itemView.findViewById(R.id.list_view_icon);
//            mtitle = (TextView) itemView.findViewById(R.id.list_view_title);
//        }
//
//        public void setData(ItemBean itemBean) {
//
//            micon.setImageResource(itemBean.icon);
//            mtitle.setText(itemBean.title);
//
//        }
//    }
}
