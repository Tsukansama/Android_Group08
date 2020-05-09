package com.example.cainiaoguo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cainiaoguo.R;

public class SearchFailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_fail);

        initView();
    }

    private void initView() {
        Button btn_back = findViewById(R.id.button_back_search_fail);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFailActivity.this.finish();
            }
        });
    }
}
