package com.example.cainiaoguo.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.api.API;
import com.example.cainiaoguo.domain.Order;
import com.example.cainiaoguo.utils.LogUtils;
import com.example.cainiaoguo.utils.RetrofitManager;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class PackageInfoActivity extends AppCompatActivity {

    private TextView mPackName;
    private TextView mPackPrice;
    private TextView mPackNum;
    private TextView mPackDisAddr;
    private TextView mPackRealAddr;
    private TextView mSenderAddr;
    private TextView mPackStatus;
    private Button mBack;
    private String mOrder_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_info);

        initView();
        initListener();
        initData();

    }


    private void initView() {
        mPackName = findViewById(R.id.package_name);
        mPackNum = findViewById(R.id.package_num);
        mPackRealAddr = findViewById(R.id.pac_info_now_addr);
        mPackDisAddr = findViewById(R.id.pac_info_rec_addr);
        mSenderAddr = findViewById(R.id.pac_info_snd_addr);
        mPackPrice = findViewById(R.id.package_price);
        mPackStatus = findViewById(R.id.pac_info_sign_condition);
        mBack = findViewById(R.id.btn_back_to_package_list);
    }


    private void initListener() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageInfoActivity.this.finish();
            }
        });
    }

    private void initData() {
        Intent intent = getIntent();
        mOrder_id = intent.getStringExtra("order_id");

        Retrofit retrofit = RetrofitManager.getRetrofit();
        API api = retrofit.create(API.class);
        Call<Order> task = api.getOrder(mOrder_id);
        task.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                int code = response.code();
                if(code == HttpURLConnection.HTTP_OK){
                    Order order = response.body();
                    if(order.isFlag()){
                        setData(order);
                    }else{
                        LogUtils.i(PackageInfoActivity.class,"请求失败，请稍后重试");
                    }
                }
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                LogUtils.i(PackageInfoActivity.class,"错误信息-->"+t.toString());
            }
        });


    }

    private void setData(Order order) {
        mPackNum.setText(mOrder_id);
        mPackRealAddr.setText(order.getData().getReal_time_address());
        mPackDisAddr.setText(order.getData().getReceiver_address());
        mSenderAddr.setText(order.getData().getSender_address());
        if(order.getData().getSign_for().equals("Y")){
            mPackStatus.setText("已签收");
        }else{
            mPackStatus.setText("未签收");
        }
    }


}