package com.gxg.demojiuxi6.mydemo6.video;

/**
 * Created by jiuxi on 17/6/30.
 */

public class VideoListClickEvent {
    public int position;
    public VideoBean.ResponseBean.DatasBean item;

    public VideoListClickEvent(int position, VideoBean.ResponseBean.DatasBean item) {
        this.position = position;
        this.item = item;
    }
}
