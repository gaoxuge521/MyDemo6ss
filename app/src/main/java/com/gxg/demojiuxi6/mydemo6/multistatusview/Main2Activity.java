package com.gxg.demojiuxi6.mydemo6.multistatusview;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gxg.demojiuxi6.mydemo6.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @Bind(R.id.rb1)
    RadioButton rb1;
    @Bind(R.id.rb2)
    RadioButton rb2;
    @Bind(R.id.rb3)
    RadioButton rb3;
    @Bind(R.id.rg)
    RadioGroup rg;
    @Bind(R.id.main)
    MultiStatusView main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        main.setOnRetryListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this,"点击",Toast.LENGTH_LONG).show();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        main.setVisibility(View.VISIBLE);
                        main.showError();
                        break;
                    case R.id.rb2:
                        main.setVisibility(View.VISIBLE);
                        main.showLoading();
                        break;
                    case R.id.rb3:
                        main.setVisibility(View.VISIBLE);
                        main.showEmpty();
                        break;
                    case R.id.rb4:
                        main.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }


}
