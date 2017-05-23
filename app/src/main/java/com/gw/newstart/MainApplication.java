package com.gw.newstart;

import android.app.Application;
import android.widget.Toast;

import com.mcxiaoke.packer.helper.PackerNg;
import com.orhanobut.logger.Logger;

/**
 * Created by GongWen on 17/5/22.
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        final String market = PackerNg.getMarket(this, "默认打包渠道");
        Logger.d(market);
    }
}
