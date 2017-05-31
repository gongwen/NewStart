package com.gw.newstart.net;

import com.gw.newstart.net.interceptor.GlobalParametersInterceptor;
import com.gw.newstart.net.interceptor.HttpLoggingInterceptor;
import com.gw.newstart.utils.Constant;
import com.gw.newstart.utils.FileUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

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
            //https://github.com/square/okhttp/wiki/Interceptors
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder
                    //.addInterceptor(new HeaderInterceptor())
                    .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                    .readTimeout(readTimeout, TimeUnit.SECONDS)
                    .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                    .addInterceptor(new GlobalParametersInterceptor())
                    //.cache(cache).addInterceptor(new CacheInterceptor())
                    .retryOnConnectionFailure(true);
            if (Constant.DEBUGGABLE) {
                //log信息拦截器
                HttpLoggingInterceptor mHttpLoggingInterceptor = new HttpLoggingInterceptor();
                mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.ME);
                builder.addNetworkInterceptor(mHttpLoggingInterceptor);
            }
            mOkHttpClient = builder.build();
        }
        return mOkHttpClient;
    }
}
