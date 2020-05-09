package com.example.cainiaoguo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.ui.fragment.MineFragment;

public class bccgActivity extends Activity {

    private Button mbccg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bccg);
        initView();
        initListener();


    }

    private void initView() {
        mbccg = (Button) this.findViewById(R.id.btn_bccg);

    }

    private void initListener() {
        mbccg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bccgActivity.this.finish();
            }
        });
    }
}
