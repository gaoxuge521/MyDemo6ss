package com.gxg.demojiuxi6.mydemo6.video;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gxg.demojiuxi6.mydemo6.R;
import com.gxg.demojiuxi6.mydemo6.http.utils.RxBus;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by gaoxuge on 17/6/30.
 */

public class VideoListActivity extends FragmentActivity {
    @Bind(R.id.iv_title_left)
    ImageView ivTitleLeft;
    @Bind(R.id.tv_title_center)
    TextView tvTitleCenter;
    @Bind(R.id.iv_title_right)
    ImageView ivTitleRight;
    @Bind(R.id.layout_content)
    FrameLayout layoutContent;
    @Bind(R.id.titleLayout)
    RelativeLayout titleLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videolist);
        ButterKnife.bind(this);

        VideoListFragment fragment = new VideoListFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.layout_content, fragment).commit();


        ivTitleLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //监听屏幕方向变化，显示或隐藏底部Tab导航栏，方便全屏播放
        RxBus.getDefault().toObserverable(VideoOrientationChangeEvent.class)
                .subscribe(new Action1<VideoOrientationChangeEvent>() {
                    @Override
                    public void call(VideoOrientationChangeEvent event) {
                        if (event.newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
                            titleLayout.setVisibility(View.VISIBLE);
                        }

                        if (event.newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                            titleLayout.setVisibility(View.GONE);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        RxBus.getDefault().post(new VideoOrientationChangeEvent(newConfig));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onBackPressed() {

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            return;
        }
        super.onBackPressed();
    }
}
