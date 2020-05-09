package com.example.cainiaoguo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.cainiaoguo.R;
import com.example.cainiaoguo.utils.RetrofitManager;
import com.example.cainiaoguo.api.API;
import com.example.cainiaoguo.domain.ResultInfo;
import com.example.cainiaoguo.utils.LogUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {

    private EditText registName;
    private EditText registPasswd;
    private EditText registPhoNum;
    private EditText registIdentify;
    private EditText registAddress;
    private EditText registAge;
    private RadioButton registB;
    private RadioButton registG;
    Button btnToRegisterSucceedActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();

    }

    private void initView() {
        registName = findViewById(R.id.register_user);
        registPasswd = findViewById(R.id.register_phoneNumber);
        registPhoNum = findViewById(R.id.register_phoneNumber);
        registIdentify = findViewById(R.id.register_identify);
        registAddress = findViewById(R.id.register_address);
        registAge = findViewById(R.id.register_age);
        registB = findViewById(R.id.sexB);
        registG = findViewById(R.id.seXG);
        btnToRegisterSucceedActivity = findViewById(R.id.button_DoRegister);
    }

    public void regist(View view){
        String username = registName.getText().toString();
        String passwd = registPasswd.getText().toString();
        String phoneNum = registPhoNum.getText().toString();
        String identify = registIdentify.getText().toString();
        String address = registAddress.getText().toString();
        String age = registAge.getText().toString();


        LogUtils.i(RegisterActivity.class,"username-->"+username+"\npasswd-->"+passwd+
                "\nphoneNum-->"+phoneNum+"\nidentify-->"+identify+"\naddress-->"+address+"\nage-->"+age);
        Retrofit retrofit = RetrofitManager.getRetrofit();
        API api = retrofit.create(API.class);
        Call<ResultInfo> task = api.userRegist(username,passwd,address,"1",age,identify,phoneNum);
        task.enqueue(new Callback<ResultInfo>() {
            @Override
            public void onResponse(Call<ResultInfo> call, Response<ResultInfo> response) {
                int code = response.code();
                if(code == HttpURLConnection.HTTP_OK){
                    ResultInfo resultInfo = response.body();
                    if(resultInfo.isFlag()){
                        Intent intent = new Intent(getApplicationContext(),RegisterSucceedActivity.class);
                        startActivity(intent);

//                        Toast.makeText(getApplicationContext(),"注册成功!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"注册失败!请检查是否有空值",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResultInfo> call, Throwable t) {
                LogUtils.i(RegisterActivity.class,t.toString());
            }
        });
    }

}
