package com.example.cainiaoguo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.ui.fragment.MineFragment;

public class fkcgActivity extends Activity {

    private Button mxxfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fkcg);
        initView();
        initListener();


    }

    private void initView() {
        mxxfc = (Button) this.findViewById(R.id.btn_xxfk);
    }

    private void initListener() {
        mxxfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fkcgActivity.this, MineFragment.class);
                startActivity(intent);
            }
        });

    }
}
