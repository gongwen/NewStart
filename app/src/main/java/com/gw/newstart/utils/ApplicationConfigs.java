package com.gw.newstart.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.gw.newstart.MainApplication;
import com.mcxiaoke.packer.helper.PackerNg;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by GongWen on 17/5/23.
 */

public class ApplicationConfigs {
    private static MainApplication sInstance = MainApplication.getInstance();
    public static boolean DEBUGGABLE = true;

    public static void init() {
        registerActivityLifecycleCallbacks();
        final String market = PackerNg.getMarket(sInstance, "默认打包渠道");
        if (DEBUGGABLE) {
            Logger.init("debug").methodCount(3).hideThreadInfo().logLevel(LogLevel.FULL);
        } else {
            Logger.init().logLevel(LogLevel.NONE);
        }
    }

    private static void registerActivityLifecycleCallbacks() {
        sInstance.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                ActivityManager.getInstance().setCurrentActivity(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
