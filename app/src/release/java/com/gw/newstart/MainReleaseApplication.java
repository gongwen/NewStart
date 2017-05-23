package com.gw.newstart;

import android.app.Application;
import android.widget.Toast;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by GongWen on 17/5/22.
 */

public class MainReleaseApplication extends MainApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init().logLevel(LogLevel.NONE);
        Toast.makeText(this, "Release", Toast.LENGTH_SHORT).show();
    }
}
