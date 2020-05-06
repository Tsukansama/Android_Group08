package com.example.cainiaoguo.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.base.BaseFragment;
import com.example.cainiaoguo.ui.activity.MainActivity;
import com.example.cainiaoguo.ui.activity.MyInfo;
import com.example.cainiaoguo.utils.LogUtils;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.OnClick;

public class MineFragment extends BaseFragment {

    @BindView(R.id.nickName)
    public TextView tNickName;
    @BindView(R.id.signin)
    public Button btn_signin;
    @BindView(R.id.notification)
    public Button btn1;
    @BindView(R.id.editInfo)
    public Button btn2;
    @BindView(R.id.feedback)
    public Button btn3;
    @BindView(R.id.id)
    public Button btn4;

    @BindDrawable(R.drawable.signin)
    public Drawable signin;
    @BindDrawable(R.drawable.notification)
    public Drawable notification;
    @BindDrawable(R.drawable.info)
    public Drawable info;
    @BindDrawable(R.drawable.feedback)
    public Drawable feedback;
    @BindDrawable(R.drawable.id)
    public Drawable idCard;
    @BindDrawable(R.drawable.youjiantou)
    public Drawable youjiantou;






    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_mine;
    }


    protected void initView(View rootView) {
        SharedPreferences sp = getContext().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String username = sp.getString("username","");

        tNickName.setText(username);

        signin.setBounds(0,0,35,35);
        youjiantou.setBounds(0,0,50,50);
        notification.setBounds(0,0,60,60);
        info.setBounds(0,0,60,60);
        feedback.setBounds(0,0,60,60);
        idCard.setBounds(0,0,60,60);

        btn_signin.setCompoundDrawables(signin,null,null,null);
        btn1.setCompoundDrawables(notification, null, youjiantou,null);
        btn2.setCompoundDrawables(info, null, youjiantou,null);
        btn3.setCompoundDrawables(feedback, null, youjiantou,null);
        btn4.setCompoundDrawables(idCard, null, youjiantou,null);

    }

    @OnClick(R.id.editInfo)
    public void toMyInfo(){
        Intent intent = new Intent(getActivity(), MyInfo.class);
        startActivity(intent);
        LogUtils.i(MainActivity.class,"跳转到Myinfo");
    }

}
