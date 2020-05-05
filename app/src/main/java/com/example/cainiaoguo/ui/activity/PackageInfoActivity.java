package com.example.cainiaoguo.ui.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cainiaoguo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PackageInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_info);

        ListView addrListView = (ListView) findViewById(R.id.time_list_view);

        List<Map<String, ?>> dataList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Map<String, String> map = new HashMap<>();

            map.put("addr", "北京市");

            dataList.add(map);//将列表的内容添加进listview中，但不一定都显示
        }

        String[] from = {"addr"};//自定义listview的item中需要显示的数据
        int[] to = {R.id.title};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, dataList, R.layout.item_time_line_listview, from, to);

        addrListView.setAdapter(simpleAdapter);
    }

}