package com.example.cainiaoguo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.cainiaoguo.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegSucceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegSucceed = findViewById(R.id.button_DoRegister);
        btnRegSucceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(RegisterActivity.this, RegisterSucceedActivity.class);
                startActivity(intent);
            }
        });

    }
}
