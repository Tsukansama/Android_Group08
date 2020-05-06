package com.example.cainiaoguo.ui.fragment;

import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.OnClick;
import android.content.Intent;
import com.example.cainiaoguo.R;
import com.example.cainiaoguo.base.BaseFragment;
import com.example.cainiaoguo.ui.activity.MyInfo;
import com.example.cainiaoguo.ui.activity.SearchActivity;
import com.example.cainiaoguo.ui.activity.SearchFailActivity;
import com.example.cainiaoguo.ui.activity.SendSucceedActivity;


public class MailFragment extends BaseFragment {

    @BindView(R.id.next)
    public Button btn_next;

    @Override
    protected int getRootViewResId() { return R.layout.fragment_mail;}

    @OnClick(R.id.next)
    public void toSendSucceedActivity(View rootView) {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchFailActivity.class);

                startActivity(intent);
            }
        });

    }




}
