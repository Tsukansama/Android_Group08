package com.example.cainiaoguo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cainiaoguo.R;

public class RegisterSucceedActivity extends AppCompatActivity {

    Button btnToBeforeLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_succeed);

        btnToBeforeLogin = findViewById(R.id.btn_back_to_first_page);
        btnToBeforeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(RegisterSucceedActivity.this, LoginBeforeActivity.class);
                startActivity(intent);
            }
        });
    }
}
