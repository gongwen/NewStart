package com.gw.newstart.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.gw.newstart.MainApplication;

/**
 * Created by GongWen on 17/5/25.
 */

public class AppUtils {
    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivityMgr = (ConnectivityManager) MainApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityMgr.getActiveNetworkInfo();
        /// if no network is available networkInfo will be null
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }
}
