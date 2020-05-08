package com.example.cainiaoguo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cainiaoguo.R;

public class sfz2Activity extends Activity {

    private Button mqd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfz2);
        initView();
        initListener();


    }

    private void initView() {
        mqd = (Button) this.findViewById(R.id.btn_qd);
    }

    private void initListener() {

        mqd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sfz2Activity.this,sfzActivity.class);
                startActivity(intent);
            }
        });

    }
}
