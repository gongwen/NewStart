package com.gw.newstart;

import android.app.Application;

import com.gw.newstart.utils.ApplicationConfigs;

/**
 * Created by GongWen on 17/5/22.
 */

public class MainApplication extends Application {
    private static MainApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        ApplicationConfigs.init();
    }

    public static MainApplication getInstance() {
        return instance;
    }
}
