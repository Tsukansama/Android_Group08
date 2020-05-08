package com.example.cainiaoguo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cainiaoguo.R;

public class sfzActivity extends Activity {

    private Button msfzbc;
    private Button msfz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfz);
        initView();
        initListener();


    }

    private void initView() {
        msfzbc = (Button) this.findViewById(R.id.btn_sfzbc);
        msfz = (Button) this.findViewById(R.id.btn_sfz);
    }

    private void initListener() {
        msfzbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sfzActivity.this, bccgActivity.class);
                startActivity(intent);
            }
        });

        msfz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sfzActivity.this, sfz2Activity.class);
                startActivity(intent);
            }
        });
    }
}
