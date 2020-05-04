package com.example.cainiaoguo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.cainiaoguo.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginBeforeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_before);
        Button btn1=findViewById(R.id.button_denglu);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginBeforeActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
