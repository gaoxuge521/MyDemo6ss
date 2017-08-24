package com.gxg.demojiuxi6.mydemo6;

import android.app.Application;
import android.content.Context;

/**
 * Created by jiuxi on 17/6/21.
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        sContext = this;

    }

    private static Context sContext;

    public static Context getContext() {

        return sContext;
    }
}
