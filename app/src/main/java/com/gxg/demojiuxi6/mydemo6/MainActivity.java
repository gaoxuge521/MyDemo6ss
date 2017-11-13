package com.gxg.demojiuxi6.mydemo6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gxg.demojiuxi6.mydemo6.http.HttpDemoActivity;
import com.gxg.demojiuxi6.mydemo6.materialviewpager.MaterialViewPagerActivity;
import com.gxg.demojiuxi6.mydemo6.multistatusview.Main2Activity;
import com.gxg.demojiuxi6.mydemo6.updateapp.UpdataAppActivity;
import com.gxg.demojiuxi6.mydemo6.video.VideoListActivity;
import com.gxg.demojiuxi6.mydemo6.video.VideoOneActivity;
import com.gxg.demojiuxi6.mydemo6.zidingyiview.ZiDingYiViewActivity;
import com.gxg.demojiuxi6.mydemo6.zidingyiview.ZidingyiOneActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.button_viewstub)
    Button buttonViewstub;
    @Bind(R.id.button_viewstub2)
    Button buttonViewstub2;
    @Bind(R.id.button_viewstub3)
    Button buttonViewstub3;
    @Bind(R.id.button_video)
    Button buttonVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button_video_one,R.id.button_materialViewPager,R.id.button_zidingyi,R.id.button_update,R.id.button_viewstub, R.id.button_viewstub2, R.id.button_viewstub3,R.id.button_video})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_video_one:
                startActivity(new Intent(MainActivity.this, VideoOneActivity.class));
                break;
            case R.id.button_zidingyi:
                startActivity(new Intent(MainActivity.this, ZidingyiOneActivity.class));
                break;
            case R.id.button_update:
                startActivity(new Intent(MainActivity.this, UpdataAppActivity.class));
                break;
            case R.id.button_viewstub:
                startActivity(new Intent(MainActivity.this, ViewStubsActivity.class));
                break;
            case R.id.button_viewstub2:
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                break;
            case R.id.button_viewstub3:
                startActivity(new Intent(MainActivity.this, HttpDemoActivity.class));
                break;
            case R.id.button_video:
                startActivity(new Intent(MainActivity.this, VideoListActivity.class));
                break;
            case R.id.button_materialViewPager:
                startActivity(new Intent(MainActivity.this, MaterialViewPagerActivity.class));
                break;
        }
    }



}
