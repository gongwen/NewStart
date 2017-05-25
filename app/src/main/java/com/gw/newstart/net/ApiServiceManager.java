package com.gw.newstart.net;

import com.gw.newstart.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GongWen on 17/5/25.
 */

public class ApiServiceManager {
    private final static ApiServiceManager mApiServiceManager = new ApiServiceManager();

    private static ApiService mApiService;

    private ApiServiceManager() {
    }

    public static ApiServiceManager getInstance() {
        return mApiServiceManager;
    }

    public ApiService getApiService() {
        if (mApiService == null) {
            Retrofit mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constant.HOST)
                    .client(OkHttpClientManager.getInstance().getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return mRetrofit.create(ApiService.class);
        }
        return mApiService;
    }
}
