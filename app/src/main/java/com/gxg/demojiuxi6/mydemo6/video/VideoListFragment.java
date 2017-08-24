package com.gxg.demojiuxi6.mydemo6.video;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.anthony.imageloader.ImageLoader;
import com.anthony.imageloader.ImageLoaderUtil;
import com.anthony.pullrefreshview.PullToRefreshView;
import com.anthony.rvhelper.divider.RecycleViewDivider;
import com.anthony.videolistplayer.VideoPlayView;
import com.anthony.videolistplayer.media.IjkVideoView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.google.gson.Gson;
import com.gxg.demojiuxi6.mydemo6.R;
import com.gxg.demojiuxi6.mydemo6.http.utils.RxBus;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * Created by gaoxuge on 17/6/30.
 */

public class VideoListFragment extends Fragment {
    @Bind(R.id.recycleView)
    RecyclerView mRecyclerView;
    @Bind(R.id.ptr)
    PullToRefreshView ptr;
    @Bind(R.id.layout_play_window_holder)
    FrameLayout mVideoPlayWindowHolder;
    @Bind(R.id.btn_close)
    ImageView mClosePlayWindowBtn;
    @Bind(R.id.layout_play_window)
    RelativeLayout mVideoPlayWindowLayout;
    @Bind(R.id.layout_play_full_holder)
    FrameLayout mVideoPlayFullHolder;
    private View view;
    private VideoPlayView mVideoPlayView;
    private LinearLayoutManager mLayoutManager;

    private static final int PLAY_MODE_IN_LIST = 0;
    private static final int PLAY_MODE_WINDOW = 1;
    private static final int PLAY_MODE_FULL_SCREEN = 2;
    private int mPlayMode = PLAY_MODE_IN_LIST;
    private int current_play_position = -1; //正在播放的item位置，如果为-1表明当前没有视频在播放
    private Gson gson;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_videolist, null);
        ButterKnife.bind(this, view);
        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //创建视频容器
        mVideoPlayView = new VideoPlayView(getActivity());

        gson = new Gson();
        initRecycleView();


        mVideoPlayWindowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //全屏播放
                dismissVideoPlayLayoutInWindow(PLAY_MODE_FULL_SCREEN);
                getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        });
//
//
        //小屏关闭
        mClosePlayWindowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mVideoPlayView.isPlay()) {
                    dismissVideoPlayLayoutInWindow(PLAY_MODE_IN_LIST);
                    mVideoPlayView.stop();
                    mVideoPlayView.release();
                    current_play_position = -1;
                }
            }
        });


        //播放完成监听
        mVideoPlayView.setCompletionListener(new VideoPlayView.CompletionListener() {
            @Override
            public void completion(IMediaPlayer mp) {
                current_play_position = -1;

                //关闭播放视频layout
                FrameLayout frameLayout = (FrameLayout) mVideoPlayView.getParent();
                dismissVideoPlayLayout(frameLayout);
                //释放mVideoPlayView
                mVideoPlayView.release();
                mPlayMode = PLAY_MODE_IN_LIST;
            }
        });

        //增加RecyclerView中itemView的Attach和Detach监听
        //当item移回屏幕显示List播放，当item移出屏幕显示窗口播放
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.layout_thumbnail:
                        VideoBean.ResponseBean.DatasBean datasBean = mRecyclerAdapter.getData().get(position);
                        view.setVisibility(View.GONE);
                        RxBus.getDefault().post(new VideoListClickEvent(position, datasBean));
                        break;
                }
            }
        });

        ptr.setListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ptr.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptr.onFinishLoading();
                    }
                },1500);
            }

            @Override
            public void onLoadMore() {
                ptr.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptr.onFinishLoading();
                    }
                },1500);
            }
        });

        //滑动监听
        mRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {
                int index = mRecyclerView.getChildAdapterPosition(view);
                if (index == current_play_position && mVideoPlayView.VideoStatus() == IjkVideoView.STATE_PLAYING) {//&& mPlayMode != PLAY_MODE_FULL_SCREEN
                    dismissVideoPlayLayoutInWindow(PLAY_MODE_IN_LIST);

                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.layout_video_holder);
                    displayVideoPlayLayout(frameLayout);
                } else {
                    View layout_thumbnail = view.findViewById(R.id.layout_thumbnail);
                    if (layout_thumbnail != null) {
                        layout_thumbnail.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                int index = mRecyclerView.getChildAdapterPosition(view);
                if (index == current_play_position) {
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.layout_video_holder);
                    dismissVideoPlayLayout(frameLayout);

                    //小窗口播放
                    displayVideoPlayLayoutInWindow();
                }
            }
        });

        //监听item中layout_thumbnail的点击事件，开始播放视频
        RxBus.getDefault().toObserverable(VideoListClickEvent.class)
                .subscribe(new Action1<VideoListClickEvent>() {
                    @Override
                    public void call(VideoListClickEvent event) {
                        //点击一个item时，如果另外一个item中的视频正处于暂停状态，那么停止并释放mVideoPlayView
                        //否则将不会播放点击的视频而是继续播放暂停的视频
                        if (mVideoPlayView.VideoStatus() == IjkVideoView.STATE_PAUSED) {
                            mVideoPlayView.stop();
                            mVideoPlayView.release();
                        }

                        //点击一个item时，如果当正在小窗播放，那么清除小窗
                        if (mPlayMode == PLAY_MODE_WINDOW) {
                            dismissVideoPlayLayoutInWindow(PLAY_MODE_IN_LIST);
                        }

                        //点击一个item时，如果在正在播放另外一个item中的视频，那么先关闭正在播放的视频layout
                        if (current_play_position != event.position && current_play_position != -1) {
                            ViewGroup frameLayout = (ViewGroup) mVideoPlayView.getParent();
                            dismissVideoPlayLayout(frameLayout);
                        }

                        //将mVideoPlayView加入到layout_video_holder中，并开始播放
                        View itemView = mRecyclerView.findViewHolderForAdapterPosition(event.position).itemView;
                        FrameLayout frameLayout = (FrameLayout) itemView.findViewById(R.id.layout_video_holder);
                        frameLayout.removeAllViews();
                        frameLayout.addView(mVideoPlayView);
                        mVideoPlayView.start(event.item.getRelVideo().get(0).getDURL());

                        current_play_position = event.position;
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });


        RxBus.getDefault().toObserverable(VideoOrientationChangeEvent.class)
                .subscribe(new Action1<VideoOrientationChangeEvent>() {
                    @Override
                    public void call(VideoOrientationChangeEvent event) {
                        Configuration newConfig = event.newConfig;

                        if (mVideoPlayView != null) {
                            mVideoPlayView.onChanged(newConfig);
                            if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
                                mVideoPlayFullHolder.setVisibility(View.GONE);
                                mRecyclerView.setVisibility(View.VISIBLE);
                                mVideoPlayFullHolder.removeAllViews();

                                //全屏模式下自动播放完毕之后，需要刷新列表，避免出现item中图片空白的情况
                                if (current_play_position == -1) {
                                    mRecyclerView.getAdapter().notifyDataSetChanged();
                                }

                                if (current_play_position <= mLayoutManager.findLastVisibleItemPosition()
                                        && current_play_position >= mLayoutManager.findFirstVisibleItemPosition()) {
                                    View view = mRecyclerView.findViewHolderForAdapterPosition(current_play_position).itemView;
                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.layout_video_holder);
                                    displayVideoPlayLayout(frameLayout);
                                    mVideoPlayView.setShowContoller(true);
                                    mPlayMode = PLAY_MODE_IN_LIST;
                                } else {
                                    displayVideoPlayLayoutInWindow();
                                    mPlayMode = PLAY_MODE_WINDOW;
                                }
//                            videoItemView.setContorllerVisiable();
                            } else {
                                ViewGroup viewGroup = (ViewGroup) mVideoPlayView.getParent();
                                if (viewGroup != null)
                                    viewGroup.removeAllViews();
                                mVideoPlayFullHolder.addView(mVideoPlayView);
                                mRecyclerView.setVisibility(View.GONE);
                                mVideoPlayFullHolder.setVisibility(View.VISIBLE);
                            }
                        } else {
                            mRecyclerView.getAdapter().notifyDataSetChanged();
                            mRecyclerView.setVisibility(View.VISIBLE);
                            mVideoPlayFullHolder.setVisibility(View.GONE);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });

    }

    protected NewsVideoAdapter mRecyclerAdapter;
//    private TopicWrapper mTopicWrapper;

    private void initRecycleView() {

        String videoStr = StreamUtils.get(getActivity(), R.raw.video_list_data);
        VideoBean videoBean = gson.fromJson(videoStr, VideoBean.class);
        mLayoutManager = new LinearLayoutManager(getActivity());

        mRecyclerView.setLayoutManager(mLayoutManager);
        if (getItemDecoration() != null) {
            mRecyclerView.addItemDecoration(getItemDecoration());
        }
        mRecyclerAdapter = new NewsVideoAdapter(getActivity(), videoBean.getResponse().getDatas());
        mRecyclerAdapter.setOnItemClickListener(null);

        mRecyclerView.setAdapter(mRecyclerAdapter);
    }


    protected RecyclerView.ItemDecoration getItemDecoration() {
        return new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL, 20,
                getResources().getColor(R.color.common_bg_dark));
    }
    /**
     * 显示视频播放View，隐藏缩略图
     *
     * @param videoPlayHolder 必须是prj_list_item_video.xml中的layout_video_holder(FrameLayout)
     */
    private void displayVideoPlayLayout(ViewGroup videoPlayHolder) {
        if (videoPlayHolder != null) {
            videoPlayHolder.removeAllViews();
            videoPlayHolder.addView(mVideoPlayView);
            View itemView = (View) videoPlayHolder.getParent();
            if (itemView != null) {
                itemView.findViewById(R.id.layout_thumbnail).setVisibility(View.GONE);
            }
        }
    }

    /**
     * 小窗口播放
     */
    private void displayVideoPlayLayoutInWindow() {
        if (mVideoPlayWindowLayout.getVisibility() == View.GONE && mVideoPlayView != null
                && mVideoPlayView.isPlay()) {
            mVideoPlayWindowLayout.setVisibility(View.VISIBLE);
            mVideoPlayWindowHolder.removeAllViews();
            mVideoPlayView.setShowContoller(false);
            mVideoPlayWindowHolder.addView(mVideoPlayView);
            mPlayMode = PLAY_MODE_WINDOW;
        }
    }
    /**
     * 隐藏视频播放View，显示缩略图
     *
     * @param videoPlayHolder 必须是prj_list_item_video.xml中的layout_video_holder(FrameLayout)
     */
    private void dismissVideoPlayLayout(ViewGroup videoPlayHolder) {
        if (videoPlayHolder != null) {
            videoPlayHolder.removeAllViews();
            View itemView = (View) videoPlayHolder.getParent();
            if (itemView != null) {
                itemView.findViewById(R.id.layout_thumbnail).setVisibility(View.VISIBLE);
            }
        }
    }
//
    private void dismissVideoPlayLayoutInWindow(int toMode) {
        if (mVideoPlayWindowLayout.getVisibility() == View.VISIBLE && mVideoPlayView != null
                && mVideoPlayView.isPlay()) {
            mVideoPlayWindowLayout.setVisibility(View.GONE);
            mVideoPlayWindowHolder.removeAllViews();
            mVideoPlayView.setShowContoller(true);
            mPlayMode = toMode;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mVideoPlayView == null) {
            mVideoPlayView = new VideoPlayView(getActivity());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mVideoPlayView != null) {
            mVideoPlayView.stop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        if (current_play_position != -1) {
            ViewGroup view = (ViewGroup) mVideoPlayView.getParent();
            if (view != null) {
                view.removeAllViews();
            }
        }

        mVideoPlayView.stop();
        mVideoPlayView.release();
        mVideoPlayView.onDestroy();
        mVideoPlayView = null;
    }

    public class NewsVideoAdapter extends BaseQuickAdapter<VideoBean.ResponseBean.DatasBean, BaseViewHolder> {
        public NewsVideoAdapter(Context context, List<VideoBean.ResponseBean.DatasBean> list) {
            super(R.layout.prj_list_item_video, list);
        }

        @Override
        protected void convert(BaseViewHolder holder, VideoBean.ResponseBean.DatasBean item) {
            holder.setText(R.id.tv_news_title, item.getMetaDataTitle());
            holder.setText(R.id.tv_news_summary, "未知来源");
            holder.setText(R.id.tv_news_date, item.getPubDate());

            if (item.getImage().get(0) != null && item.getImage().size() > 0) {
                ImageView news_img = holder.getView(R.id.iv_video);
                String url = item.getImage().get(0);
                ImageLoader.Builder builder = new ImageLoader.Builder();
                ImageLoader img = builder.url(url)
                        .imgView(news_img).strategy(ImageLoaderUtil.LOAD_STRATEGY_ONLY_WIFI).build();
                new ImageLoaderUtil().loadImage(mContext, img);
            }


            holder.addOnClickListener(R.id.layout_thumbnail);

        }

    }


}
