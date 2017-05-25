package com.gw.newstart.utils;

import com.gw.newstart.MainApplication;

import java.io.File;

/**
 * Created by GongWen on 17/5/25.
 */

public class FileUtils {
    public static File getCacheDir(String uniqueName) {
        File cacheDir = StorageUtils.getCacheDirectory(MainApplication.getInstance());
        return new File(cacheDir, uniqueName);
    }
}
