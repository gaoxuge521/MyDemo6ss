package com.gxg.demojiuxi6.mydemo6.video;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.anthony.imageloader.ImageLoader;
import com.anthony.imageloader.ImageLoaderUtil;
import com.anthony.videolistplayer.VideoPlayView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.gxg.demojiuxi6.mydemo6.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class VideoOneActivity extends AppCompatActivity {

    @Bind(R.id.fm_video)
    FrameLayout fmVideo;
    @Bind(R.id.iv_video)
    ImageView ivVideo;
    @Bind(R.id.ic_play)
    ImageView icPlay;
    @Bind(R.id.layout_thumbnail)
    RelativeLayout layoutThumbnail;
    private VideoPlayView mVideoPlayView;
    private Gson gson;
    private VideoBean videoBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_one);
        ButterKnife.bind(this);
        mVideoPlayView = new VideoPlayView(this);
        gson = new Gson();
        String videoStr = StreamUtils.get(this, R.raw.video_list_data);
        videoBean = gson.fromJson(videoStr, VideoBean.class);

        Log.e("sss", "onCreate: "+ videoBean.getResponse().getDatas().get(1).getImage().get(0) );
        Glide.with(this).load(videoBean.getResponse().getDatas().get(1).getImage().get(0)).into(ivVideo);

        addListener();

    }

    private void addListener() {
        mVideoPlayView.setCompletionListener(new VideoPlayView.CompletionListener() {
            @Override
            public void completion(IMediaPlayer mp) {
                if (mVideoPlayView != null) {
                    mVideoPlayView.stop();
                    fmVideo.removeAllViews();
                    layoutThumbnail.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (mVideoPlayView == null) {
            mVideoPlayView = new VideoPlayView(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mVideoPlayView != null) {
            mVideoPlayView.stop();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mVideoPlayView != null) {
            mVideoPlayView.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        mVideoPlayView.stop();
        mVideoPlayView.release();
        mVideoPlayView.onDestroy();
        mVideoPlayView = null;
    }

    @OnClick({R.id.iv_video, R.id.ic_play})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_video:
                break;
            case R.id.ic_play:
                layoutThumbnail.setVisibility(View.GONE);
                fmVideo.addView(mVideoPlayView);
                Log.e("sss", "onViewClicked: "+videoBean.getResponse().getDatas().get(1).getRelVideo().size()+"    "+videoBean.getResponse().getDatas().get(1).getRelVideo().get(0).getDURL() );
                mVideoPlayView.start(videoBean.getResponse().getDatas().get(1).getRelVideo().get(0).getDURL());
                break;
        }
    }
}
