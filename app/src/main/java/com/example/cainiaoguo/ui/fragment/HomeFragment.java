package com.example.cainiaoguo.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.api.API;
import com.example.cainiaoguo.base.BaseFragment;
import com.example.cainiaoguo.beans.Datas;
import com.example.cainiaoguo.beans.ItemBean;
import com.example.cainiaoguo.domain.Order;
import com.example.cainiaoguo.ui.activity.LoginBeforeActivity;
import com.example.cainiaoguo.ui.activity.SearchActivity;
import com.example.cainiaoguo.ui.activity.SearchFailActivity;
import com.example.cainiaoguo.ui.adapter.ListViewAdapter;
import com.example.cainiaoguo.ui.adapter.LooperPagerAdapter;
import com.example.cainiaoguo.utils.LogUtils;
import com.example.cainiaoguo.utils.RetrofitManager;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends BaseFragment {

    private LooperPagerAdapter mLooperPagerAdapter;
    private static List<Integer> sPics = new ArrayList<>();
    private Order mOrder;

    @BindView(R.id.looper_pager)
    public ViewPager mloopPager;
    private List<ItemBean> mData;
    @BindView(R.id.recycler_view)
    public RecyclerView mlist;
    @BindView(R.id.HomeFragment_search)
    public EditText editText2;
    @BindView(R.id.HomeFragment_ButtonSearch)
    public Button btnA;

    static {
        sPics.add(R.mipmap.lunbo1);
        sPics.add(R.mipmap.lunbo2);
    }

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home;
    }

    @OnClick(R.id.HomeFragment_ButtonSearch)
    public void HomeSearch(View rootView) {
        String order_id = editText2.getText().toString();
        LogUtils.i(HomeFragment.class,"order_id-->"+order_id);
        Retrofit retrofit = RetrofitManager.getRetrofit();
        API api = retrofit.create(API.class);
        Call<Order> task = api.getOrder(order_id);

        task.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                int code = response.code();
                if(code == HttpURLConnection.HTTP_OK){
                    Order order = response.body();
                    if(order.isFlag()){
                        LogUtils.i(LoginBeforeActivity.class,"order_id--->"+order.getData().getOrder_id());

                        Intent intent = new Intent(getActivity(),SearchActivity.class);
                        intent.putExtra("order_id",order_id);
                        startActivity(intent);
                    }else{
                        Intent intent2 = new Intent(getActivity(), SearchFailActivity.class);
                        startActivity(intent2);
                        LogUtils.i(LoginBeforeActivity.class,"无此订单！");
                    }
                }
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                LogUtils.i(LoginBeforeActivity.class,t.toString());
            }
        });
//        btnA.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }

    /*  @Override
  /*  protected void HomeSearch(View rootView) {
          btn_Homesearch.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(getActivity(), SearchActivity.class);
                 // String accountb = editText2.getText().toString();
                  //intent.putExtra("Name", accountb);
                  startActivity(intent);
              }
          });
      }
  */
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
