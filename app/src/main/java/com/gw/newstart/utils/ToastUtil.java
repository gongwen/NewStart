package com.gw.newstart.utils;

import android.widget.Toast;

import com.gw.newstart.MainApplication;

public class ToastUtil {

    public static void showToastShort(String toastStr) {
        Toast.makeText(MainApplication.getInstance(), toastStr, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(String toastStr) {
        Toast.makeText(MainApplication.getInstance(), toastStr, Toast.LENGTH_LONG).show();
    }

}
