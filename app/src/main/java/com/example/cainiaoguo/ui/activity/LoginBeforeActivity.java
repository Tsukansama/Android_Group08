package com.example.cainiaoguo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.ui.adapter.LooperPagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class LoginBeforeActivity extends AppCompatActivity {
    private LooperPagerAdapter mLooperPagerAdapter;
    private static List<Integer> sPics = new ArrayList<>();
    private ViewPager mloopPager;

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
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginBeforeActivity.this, SearchActivity.class);
                EditText editText1 = (EditText) findViewById(R.id.Search);
                String account = editText1.getText().toString();
                intent.putExtra("Name", account);
                startActivity(intent);
            }
        });
    }


    private void initView() {
        mloopPager = (ViewPager) this.findViewById(R.id.looper_pager);
        mLooperPagerAdapter = new LooperPagerAdapter();
        mLooperPagerAdapter.setData(sPics);
        mloopPager.setAdapter(mLooperPagerAdapter);
    }
}
