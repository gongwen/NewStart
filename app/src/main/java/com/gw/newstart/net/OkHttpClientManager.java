package com.gw.newstart.net;

import com.gw.newstart.net.interceptor.CacheInterceptor;
import com.gw.newstart.utils.ApplicationConfigs;
import com.gw.newstart.utils.FileUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by GongWen on 17/5/25.
 */

public class OkHttpClientManager {
    private final static OkHttpClientManager mOkHttpClientManager = new OkHttpClientManager();
    private final long cacheMaxSize = 1024 * 1024 * 50;
    private final long connectTimeout = 15;
    private final long readTimeout = 25;
    private final long writeTimeout = 25;

    private OkHttpClient mOkHttpClient;
    private final File cacheFile = FileUtils.getCacheDir("HttpCache");
    private final Cache cache = new Cache(cacheFile, cacheMaxSize);//缓存文件

    private OkHttpClientManager() {
    }

    public static OkHttpClientManager getInstance() {
        return mOkHttpClientManager;
    }

    public OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (ApplicationConfigs.DEBUGGABLE) {
                //log信息拦截器
                HttpLoggingInterceptor mHttpLoggingInterceptor = new HttpLoggingInterceptor();
                mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(mHttpLoggingInterceptor);
            }
            builder
                    .cache(cache).addInterceptor(new CacheInterceptor())
                    //.addInterceptor(new GlobalParametersInterceptor())
                    //.addInterceptor(new HeaderInterceptor())
                    .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                    .readTimeout(readTimeout, TimeUnit.SECONDS)
                    .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true);
            mOkHttpClient = builder.build();
        }
        return mOkHttpClient;
    }
}
