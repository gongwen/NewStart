package com.gw.newstart.utils;

import com.gw.newstart.MainApplication;
import com.gw.newstart.R;

/**
 * Created by GongWen on 17/5/31.
 */

public class StringUtils {
    private static MainApplication context = MainApplication.getInstance();

    public static String getNetErrorTip() {
        return context.getString(R.string.net_error_tip);
    }
}
