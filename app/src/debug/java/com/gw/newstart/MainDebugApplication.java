package com.gw.newstart;

import android.widget.Toast;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by GongWen on 17/5/22.
 */

public class MainDebugApplication extends MainApplication {
    @Override
    public void onCreate() {
        Logger.init("debug").methodCount(3).hideThreadInfo().logLevel(LogLevel.FULL);
        super.onCreate();
        Toast.makeText(this, "DEBUG", Toast.LENGTH_SHORT).show();
    }
}
