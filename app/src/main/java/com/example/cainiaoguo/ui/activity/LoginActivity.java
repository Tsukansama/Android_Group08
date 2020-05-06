package com.example.cainiaoguo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.RetrofitManager;
import com.example.cainiaoguo.api.API;
import com.example.cainiaoguo.domain.User;
import com.example.cainiaoguo.ui.fragment.HomeFragment;
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
        initViewregister();
        initView();

    }

    private void initViewregister() {
        Button btn_register = findViewById(R.id.button_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mEditUser = findViewById(R.id.editText_use);
        mEditPsw = findViewById(R.id.editText_password);
        Button btn_login = findViewById(R.id.button_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editStruser;
                String editStrupsw;
                editStruser = mEditUser.getText().toString();
                editStrupsw = mEditPsw.getText().toString();
                String userA = "123";
                String userpswA = "123";
                if (editStruser.equals(userA) && editStrupsw.equals(userpswA)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    return;
                } else {
                    AlertDialog alertDialog1 = new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("这是标题")//标题
                            .setMessage("这是内容")//内容
                            .setIcon(R.mipmap.ic_launcher)//图标
                            .create();
                    alertDialog1.show();
                }


            }
        });
    }

//    public void login(View view) {
//
//        String username = mEditUser.getText().toString();
//        LogUtils.i(LoginActivity.class, "username -->" + username);
//        String passwd = mEditPsw.getText().toString();
//
////        LogUtils.i(LoginActivity.class,username);
////        LogUtils.i(LoginActivity.class,password);
//
//        Retrofit retrofit = RetrofitManager.getRetrofit();
//        API api = retrofit.create(API.class);
//        Call<User> task = api.userLogin(username, passwd);
//        task.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                int code = response.code();
//                LogUtils.i(LoginActivity.class, "code-->" + code);
//                if (code == HttpURLConnection.HTTP_OK) {
//                    User user = response.body();
//                    if(user != null){
//                        LogUtils.i(LoginActivity.class,"username-->"+user.getData().getAddress());
//                        /**
//                         * 将用户信息存储到本地
//                         */
//                        SharedPreferences sp = getApplicationContext().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editor = sp.edit();
//                        editor.putString("username",user.getData().getUsername());
//                        editor.putString("uid",user.getData().getUid());
//                        editor.putString("gender",user.getData().getGender());
//                        editor.putString("identify",user.getData().getIdentify());
//                        editor.putString("age",user.getData().getAge());
//                        editor.putString("user_phone",user.getData().getUser_phone());
//                        editor.putString("address",user.getData().getAddress());
//                        editor.commit();
//                        /**
//                         * 跳转至首页
//                         */
//                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
//                    }
//                    else {
//                        Toast.makeText(getApplicationContext(), "登陆失败", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                LogUtils.i(LoginActivity.class, "登录失败");
//            }
//        });
//    }
}
