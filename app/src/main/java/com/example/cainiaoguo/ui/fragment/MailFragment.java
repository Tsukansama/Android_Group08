package com.example.cainiaoguo.ui.fragment;

import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.OnClick;
import android.content.Intent;
import android.widget.EditText;

import com.example.cainiaoguo.R;
import com.example.cainiaoguo.base.BaseFragment;
import com.example.cainiaoguo.ui.activity.MyInfo;
import com.example.cainiaoguo.ui.activity.SearchActivity;
import com.example.cainiaoguo.ui.activity.SearchFailActivity;
import com.example.cainiaoguo.ui.activity.SendSucceedActivity;


public class MailFragment extends BaseFragment {

    @BindView(R.id.next)
    public Button btn_next;

    @BindView(R.id.snd_addr)
    public EditText text_snd_addr;

    @BindView(R.id.snd_phone_num)
    public EditText text_snd_phone_num;

    @BindView(R.id.rec_addr)
    public EditText text_rec_addr;

    @BindView(R.id.rec_phone_num)
    public EditText text_rec_phone_num;


    @Override
    protected int getRootViewResId() { return R.layout.fragment_mail;}

    @OnClick(R.id.next)
    public void toSendSucceedActivity(View rootView) {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SendSucceedActivity.class);

                String t_snd_addr = text_snd_addr.getText().toString();
                intent.putExtra("snd_addr", t_snd_addr);

                String t_snd_phone_num = text_snd_phone_num.getText().toString();
                intent.putExtra("snd_phone_num", t_snd_phone_num);

                String t_rec_addr = text_rec_addr.getText().toString();
                intent.putExtra("rec_addr", t_rec_addr);

                String t_rec_phone_num = text_rec_phone_num.getText().toString();
                intent.putExtra("rec_phone_num", t_rec_phone_num);

                startActivity(intent);
            }
        });

    }




}
