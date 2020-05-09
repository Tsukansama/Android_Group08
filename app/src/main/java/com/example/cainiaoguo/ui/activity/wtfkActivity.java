package com.example.cainiaoguo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.ui.fragment.MineFragment;

public class wtfkActivity extends Activity {

    private Button mwtfktj;
    private Button backToMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wtfk);
        initView();
        initListener();


    }

    private void initView(){
        mwtfktj = (Button) this.findViewById(R.id.btn_wtfktj);
        backToMine = findViewById(R.id.btn_home2);

    }

    private void initListener() {
        mwtfktj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), fkcgActivity.class);
                startActivity(intent);
            }
        });

        backToMine.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                wtfkActivity.this.finish();
            }
        });
    }

}
