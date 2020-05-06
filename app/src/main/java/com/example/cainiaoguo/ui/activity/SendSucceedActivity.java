package com.example.cainiaoguo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.cainiaoguo.R;
import com.example.cainiaoguo.ui.fragment.HomeFragment;

import android.view.View;
import android.widget.Button;

public class SendSucceedActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_succeed);

        btn = findViewById(R.id.btn_back_to_first_page);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SendSucceedActivity.this, HomeFragment.class);
                startActivity(intent);
            }
        });
    }
}
