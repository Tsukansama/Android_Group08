package com.example.cainiaoguo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.RetrofitManager;
import com.example.cainiaoguo.api.API;
import com.example.cainiaoguo.domain.User;
import com.example.cainiaoguo.utils.LogUtils;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private EditText mEditUser;
    private EditText mEditPsw;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

    }

    private void initView() {
        mEditUser = findViewById(R.id.editText_use);
        mEditPsw = findViewById(R.id.editText_password);
    }

    public void login(View view){

        String username = mEditUser.getText().toString();
        LogUtils.i(LoginActivity.class,"username -->"+username);
        String passwd = mEditPsw.getText().toString();

//        LogUtils.i(LoginActivity.class,username);
//        LogUtils.i(LoginActivity.class,password);

        Retrofit retrofit = RetrofitManager.getRetrofit();
        API api = retrofit.create(API.class);
        Call<User> task = api.userLogin(username,passwd);
        task.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int code = response.code();
                LogUtils.i(LoginActivity.class,"code-->"+code);
                if(code == HttpURLConnection.HTTP_OK){
                    User user = response.body();

                    LogUtils.i(LoginActivity.class,"username-->"+user.getData().getAddress());
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                    LogUtils.i(LoginActivity.class,"登录失败");
            }
        });








    }
}
