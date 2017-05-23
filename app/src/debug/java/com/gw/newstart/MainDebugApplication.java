package com.gw.newstart;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by GongWen on 17/5/22.
 */

public class MainDebugApplication extends MainApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("debug").methodCount(3).hideThreadInfo().logLevel(LogLevel.FULL);
    }
}
