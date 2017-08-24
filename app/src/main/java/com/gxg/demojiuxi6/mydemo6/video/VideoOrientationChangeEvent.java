package com.gxg.demojiuxi6.mydemo6.video;

import android.content.res.Configuration;

/**
 * Created by jiuxi on 17/6/30.
 */

public class VideoOrientationChangeEvent {

    public Configuration newConfig;

    public VideoOrientationChangeEvent(Configuration newConfig) {
        this.newConfig = newConfig;
    }
}
