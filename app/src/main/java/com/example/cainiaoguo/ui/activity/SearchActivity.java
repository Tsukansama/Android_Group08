package com.example.cainiaoguo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.api.API;
import com.example.cainiaoguo.domain.Order;
import com.example.cainiaoguo.utils.LogUtils;
import com.example.cainiaoguo.utils.RetrofitManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchActivity extends AppCompatActivity {

    private TextView mPackInfo;

    private Order mOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initView();
        updateUI();
    }



    public void initView(){
//        mIntent = getIntent();
//        String account = mIntent.getStringExtra("Name");
//
        mPackInfo = findViewById(R.id.TextView_a_text1);
//
//        TextView textView = (TextView)findViewById(R.id.GetText);
//        textView.setText("内容为account-->"+account);
        Button btn_back = findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchActivity.this.finish();
            }
        });
    }

    private void updateUI() {
        Intent intent = getIntent();
        String order_id = intent.getStringExtra("order_id");
        LogUtils.i(SearchActivity.class,"order_id-->"+order_id);
        Retrofit retrofit = RetrofitManager.getRetrofit();
        API api = retrofit.create(API.class);
        Call<Order> task = api.getOrder(order_id);

        task.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                int code = response.code();
                if(code == HttpURLConnection.HTTP_OK){
                    mOrder = response.body();
                    if(mOrder.getData().getSign_for().equals("Y")){
                        mPackInfo.setText("订单已完成\n您的包裹已签收");
                    }else{
                        mPackInfo.setText("订单未完成\n您的订单未签收");
                    }

                }
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                LogUtils.i(SearchActivity.class,t.toString());
            }
        });

    }

}
