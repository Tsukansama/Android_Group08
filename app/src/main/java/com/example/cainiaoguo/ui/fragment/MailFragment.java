package com.example.cainiaoguo.ui.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.api.API;
import com.example.cainiaoguo.base.BaseFragment;
import com.example.cainiaoguo.domain.MailResultInfo;
import com.example.cainiaoguo.domain.ResultInfo;
import com.example.cainiaoguo.ui.activity.MyInfo;
import com.example.cainiaoguo.ui.activity.SearchActivity;
import com.example.cainiaoguo.ui.activity.SearchFailActivity;
import com.example.cainiaoguo.ui.activity.SendSucceedActivity;
import com.example.cainiaoguo.utils.LogUtils;
import com.example.cainiaoguo.utils.RetrofitManager;

import java.net.HttpURLConnection;


public class MailFragment extends BaseFragment {

    @BindView(R.id.next)
    public Button btn_next;

//    @BindView(R.id.snd_address)
//    public EditText text_snd_addr;
//
//    @BindView(R.id.snd_phone_num)
//    public EditText text_snd_phone_num;
//
//    @BindView(R.id.rec_address)
//    public EditText text_rec_addr;
//
//    @BindView(R.id.rec_phone_num)
//    public EditText text_rec_phone_num;
    @BindView(R.id.snd_address)
    public EditText sendAddress;

    @BindView(R.id.snd_phone_num)
    public EditText sendPhoneNum;

    @BindView(R.id.rec_address)
    public EditText recAddress;

    @BindView(R.id.rec_phone_num)
    public EditText recPhoneNum;

    @BindView(R.id.rec_name)
    public EditText recName;

    @BindView(R.id.weight_content)
    public EditText weight;

    @BindView(R.id.type_content)
    public Spinner type;


    @Override
    protected int getRootViewResId() { return R.layout.fragment_mail;}

    @OnClick(R.id.next)
    public void toSendSucceedActivity(View rootView) {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getContext().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                String uid = sp.getString("uid","4");
                String username = sp.getString("username","xq");

                String sndAddress = sendAddress.getText().toString();
                String sndPhoNum = sendPhoneNum.getText().toString();
                String recvAddress = recAddress.getText().toString();
                String recvPhoNum = recPhoneNum.getText().toString();
                String recvName = recName.getText().toString();
                String zhongLiang =weight.getText().toString();
                int weight1 = Integer.parseInt(zhongLiang);
                String type_content = type.getSelectedItem().toString();
                LogUtils.i(MailFragment.class,"sendAddress-->"+sndAddress+"\nsendPhoNum-->"+sndPhoNum+"\nrecvAddress-->"
                        +recvAddress+"\nrecvPhoneNum-->"+recvPhoNum+"\nrecName-->"+recvName+"\nzhongliang-->"+zhongLiang+"\ntype_content-->"+type_content);

                Retrofit retrofit = RetrofitManager.getRetrofit();
                API api = retrofit.create(API.class);
                Call<ResultInfo> task = api.mailThings(uid,sndAddress,username,sndPhoNum,recvAddress,recvName,recvPhoNum,weight1,type_content);
                task.enqueue(new Callback<ResultInfo>() {
                    @Override
                    public void onResponse(Call<ResultInfo> call, Response<ResultInfo> response) {
                        int code = response.code();
                        if(code == HttpURLConnection.HTTP_OK){
                            ResultInfo resultInfo = response.body();
                            if(resultInfo.isFlag()){
                                Intent intent = new Intent(getContext(),SendSucceedActivity.class);
                                startActivity(intent);
                                LogUtils.i(MailFragment.class,"寄件成功");
                            }else{
                                LogUtils.i(MailFragment.class,"网络繁忙，请稍后重试");
                                Toast.makeText(getContext(),"网络繁忙，请稍后重试",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResultInfo> call, Throwable t) {
                        LogUtils.i(MailFragment.class,"错误信息-->"+t.toString());
                    }
                });




//                Intent intent = new Intent(getActivity(), SendSucceedActivity.class);
//
//                String t_snd_addr = text_snd_addr.getText().toString();
//                intent.putExtra("snd_addr", t_snd_addr);
//
//                String t_snd_phone_num = text_snd_phone_num.getText().toString();
//                intent.putExtra("snd_phone_num", t_snd_phone_num);
//
//                String t_rec_addr = text_rec_addr.getText().toString();
//                intent.putExtra("rec_addr", t_rec_addr);
//
//                String t_rec_phone_num = text_rec_phone_num.getText().toString();
//                intent.putExtra("rec_phone_num", t_rec_phone_num);
//
//                startActivity(intent);
            }
        });

    }




}
