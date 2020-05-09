package com.example.cainiaoguo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cainiaoguo.R;

public class Notification extends AppCompatActivity {

    private Button backToMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        initView();
        initListener();
    }

    private void initView() {
        backToMine = findViewById(R.id.btn_back_to_mine);
    }

    private void initListener() {
        backToMine.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Notification.this.finish();
            }
        });
    }

}
