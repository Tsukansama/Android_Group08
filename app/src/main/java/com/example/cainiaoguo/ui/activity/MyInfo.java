package com.example.cainiaoguo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.utils.LogUtils;

public class MyInfo extends AppCompatActivity {

    private EditText input_name;
    private EditText input_age;
    private EditText input_addr;
    private Spinner spinner;
    private String name;
    private int age = 0;
    private String gender;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        input_name = findViewById(R.id.input_name);
        input_age = findViewById(R.id.input_age);
        input_addr = findViewById(R.id.input_addr);

        initView();


    }

    private void initView() {
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

    public void onSave(View view){

        name = input_name.getText().toString();
        age = Integer.parseInt(input_age.getText().toString());
        address = input_addr.getText().toString();

        if(name == null || age == 0 || address == null || gender == null){
            Toast.makeText(this, "请不要漏填信息！", Toast.LENGTH_SHORT).show();
            return;
        }

        LogUtils.i(MyInfo.class, "onSave: "+"name:" + name + "---age:" + age + "---gender:" + gender + "---addr:" + address);
    }

}
