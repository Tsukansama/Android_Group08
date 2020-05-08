package com.example.cainiaoguo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.api.API;
import com.example.cainiaoguo.domain.Order;
import com.example.cainiaoguo.ui.adapter.LooperPagerAdapter;
import com.example.cainiaoguo.utils.LogUtils;
import com.example.cainiaoguo.utils.RetrofitManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginBeforeActivity extends AppCompatActivity {
    private LooperPagerAdapter mLooperPagerAdapter;
    private static List<Integer> sPics = new ArrayList<>();
    private ViewPager mloopPager;
    private EditText mSearchMessage;

    static {
        sPics.add(R.mipmap.lunbo1);
        sPics.add(R.mipmap.lunbo2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_before);
        Button btn1 = findViewById(R.id.button_denglu);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginBeforeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        initView();
        Button btn_search = findViewById(R.id.button_search);
//        btn_search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginBeforeActivity.this, SearchActivity.class);
//
//                String account = mSearchMessage.getText().toString();
//                intent.putExtra("Name", account);
//                startActivity(intent);
//            }
//        });
    }


    private void initView() {
        mSearchMessage= (EditText) findViewById(R.id.Search);
        mloopPager = (ViewPager) this.findViewById(R.id.looper_pager);
        mLooperPagerAdapter = new LooperPagerAdapter();
        mLooperPagerAdapter.setData(sPics);
        mloopPager.setAdapter(mLooperPagerAdapter);
    }

    public void search_before(View view){
        String order_id = mSearchMessage.getText().toString();
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
                        LogUtils.i(LoginBeforeActivity.class,"order--->"+order.getData().getOrder_id());

                        Intent intent = new Intent(getApplicationContext(),SearchActivity.class);
                        intent.putExtra("order",order);
                        startActivity(intent);
                    }else{
                        LogUtils.i(LoginBeforeActivity.class,"无此订单！");
                    }
                }
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                LogUtils.i(LoginBeforeActivity.class,t.toString());
            }
        });
    }

}
