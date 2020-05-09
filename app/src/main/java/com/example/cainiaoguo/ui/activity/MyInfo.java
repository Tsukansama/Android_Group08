package com.example.cainiaoguo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.api.API;
import com.example.cainiaoguo.domain.ResultInfo;
import com.example.cainiaoguo.domain.User;
import com.example.cainiaoguo.utils.LogUtils;
import com.example.cainiaoguo.utils.RetrofitManager;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyInfo extends AppCompatActivity {

    private EditText input_name;
    private EditText input_age;
    private EditText input_addr;
    private EditText input_iden;
    private Spinner spinner;
    private String name;
    private int age = 0;
    private String gender;
    private String address;
    private String identify;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);



        initView();
        initData();

    }



    private void initView() {

        input_name = findViewById(R.id.input_name);
        input_age = findViewById(R.id.input_age);
        input_addr = findViewById(R.id.input_addr);
        input_iden = findViewById(R.id.input_identify);

        // 初始化控件
        spinner = findViewById(R.id.spinner_sex);
        // 建立数据源
        String[] sexItems = getResources().getStringArray(R.array.sex);
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, sexItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //绑定 Adapter到控件
        spinner .setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                String[] sexArray = getResources().getStringArray(R.array.sex);
                gender = sexArray[pos];
                //Toast.makeText(MyInfo.this, "你点击的是:"+languages[pos], Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }

    private void initData() {
        SharedPreferences sp = getApplicationContext().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        input_name.setText(sp.getString("username",""));
        input_age.setText(sp.getString("age",""));
        input_addr.setText(sp.getString("address",""));
        input_iden.setText(sp.getString("identify",""));
        uid = sp.getString("uid","4");
    }

    public void onSave(View view){

        name = input_name.getText().toString();
        age = Integer.parseInt(input_age.getText().toString());
        address = input_addr.getText().toString();
        identify = input_iden.getText().toString();

        if(name == null || age == 0 || address == null || gender == null){
            Toast.makeText(getApplicationContext(), "请不要漏填信息！", Toast.LENGTH_SHORT).show();
        }else{
            Retrofit retrofit = RetrofitManager.getRetrofit();
            API api = retrofit.create(API.class);
            String gender1=null;
            if(gender.equals("男")){
                gender1 = "m";
            }else{
                gender1 = "w";
            }
            Call<User> task = api.updateMyInfo(uid,name,address,gender1,age,identify);

            task.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    int code = response.code();
                    if(code == HttpURLConnection.HTTP_OK){
                       User user = response.body();
                       if(user.isFlag()){
                           SharedPreferences sp = getApplicationContext().getSharedPreferences("userinfo",Context.MODE_PRIVATE);
                           SharedPreferences.Editor editor = sp.edit();
                           editor.putString("username",user.getData().getUsername());
                           editor.putString("age",user.getData().getAge());
                           editor.putString("address",user.getData().getAddress());
                           editor.putString("identify",user.getData().getIdentify());
                           editor.commit();

                           Intent intent = new Intent(getApplicationContext(),bccgActivity.class);
                           startActivity(intent);

                       }else{
                           Toast.makeText(getApplicationContext(),user.getErrorMsg(),Toast.LENGTH_SHORT).show();
                       }
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
        }

        LogUtils.i(MyInfo.class, "onSave: "+"name:" + name + "---age:" + age + "---gender:" + gender + "---addr:" + address);
    }

}
