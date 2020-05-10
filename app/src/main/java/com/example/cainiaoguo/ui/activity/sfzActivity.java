package com.example.cainiaoguo.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cainiaoguo.R;

public class sfzActivity extends Activity {

    private Button mBackToMine;
    private TextView mIdentify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfz);
        initView();
        initListener();
        initData();

    }



    private void initView() {
        mBackToMine = findViewById(R.id.btn_back);
        mIdentify = findViewById(R.id.text_identify);
    }

    private void initListener() {
        mBackToMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfzActivity.this.finish();
            }
        });
    }

    private void initData() {
        SharedPreferences sp = getApplicationContext().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String identify = sp.getString("identify","");
        mIdentify.setText("身份证     "+identify);
    }
}
