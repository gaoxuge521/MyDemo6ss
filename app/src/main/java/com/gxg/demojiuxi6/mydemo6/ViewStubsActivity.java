package com.gxg.demojiuxi6.mydemo6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gxg.demojiuxi6.mydemo6.utils.AppUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewStubsActivity extends AppCompatActivity {

    @Bind(R.id.vs)
    ViewStub vs;
    @Bind(R.id.tv)
    TextView tv;

    private RelativeLayout rl_try_agian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stubs);
        ButterKnife.bind(this);


        vs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewStubsActivity.this, "点击了", Toast.LENGTH_LONG).show();
                rl_try_agian.setVisibility(View.GONE);
            }
        });

        if (AppUtil.isConnNet()) {

        } else {
            View inflate = vs.inflate();
            rl_try_agian = (RelativeLayout) inflate;

            rl_try_agian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ViewStubsActivity.this, "点击了", Toast.LENGTH_LONG).show();
                    rl_try_agian.setVisibility(View.GONE);
                }
            });
        }
    }


    @OnClick(R.id.tv)
    public void onViewClicked() {
        Toast.makeText(ViewStubsActivity.this, "点击了222", Toast.LENGTH_LONG).show();
        vs.setVisibility(View.VISIBLE);
    }
}
