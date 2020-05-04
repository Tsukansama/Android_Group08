package com.example.cainiaoguo.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.base.BaseFragment;
import com.example.cainiaoguo.ui.fragment.HomeFragment;
import com.example.cainiaoguo.ui.fragment.MailFragment;
import com.example.cainiaoguo.ui.fragment.MineFragment;
import com.example.cainiaoguo.utils.LogUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_navigation_bar)
    public BottomNavigationView mNavigationView;
    private HomeFragment mHomeFragment;
    private MailFragment mMailFragment;
    private MineFragment mMineFragment;
    private FragmentManager mFM;
    public Unbinder mBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);
        initFragment();
        initListener();
        switchFragment(mHomeFragment);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mBind!=null){
            mBind.unbind();
        }
    }

    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mMailFragment = new MailFragment();
        mMineFragment = new MineFragment();
        mFM = getSupportFragmentManager();
    }

    private void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Log.d(TAG,"title-->"+ item.getTitle()+"id-->" + item.getItemId());
                if(item.getItemId() == R.id.home){
                    LogUtils.d(MainActivity.class,"切换到首页");
                    switchFragment(mHomeFragment);
                }else if(item.getItemId() == R.id.mail){
                    LogUtils.d(MainActivity.class,"切换到寄件");
                    switchFragment(mMailFragment);
                }else if(item.getItemId() == R.id.mine){
                    LogUtils.d(MainActivity.class,"切换到我的");
                    switchFragment(mMineFragment);
                }
                return true;
            }
        });
    }

    private void switchFragment(BaseFragment targetFragment) {
        FragmentTransaction fragmentTransaction = mFM.beginTransaction();
        fragmentTransaction.replace(R.id.main_page_container,targetFragment);
        fragmentTransaction.commit();
    }

    public void search(View view){

    }


}
