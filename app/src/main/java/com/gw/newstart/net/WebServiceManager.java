package com.gw.newstart.net;

import com.google.gson.Gson;
import com.gw.newstart.utils.Constant;

import java.util.concurrent.ConcurrentHashMap;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GongWen on 17/5/25.
 */

public class WebServiceManager {
    private final ConcurrentHashMap<Class, Object> mWebServiceMap = new ConcurrentHashMap<>();
    private final static WebServiceManager mApiServiceManager = new WebServiceManager();
    private Retrofit mRetrofit;

    private WebServiceManager() {
    }

    private Retrofit getRetrofit() {
        if (mRetrofit == null) {
            //Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constant.HOST)
                    .client(OkHttpClientManager.getInstance().getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    private <T> T getWebService(Class<T> clazz) {
        T mWebService = (T) mWebServiceMap.get(clazz);
        if (mWebService == null) {
            mWebService = getRetrofit().create(clazz);
            mWebServiceMap.put(clazz, mWebService);
        }
        return mWebService;
    }

    public static WebServiceManager getInstance() {
        return mApiServiceManager;
    }

    public ApiGetService getApiGetService() {
        return getWebService(ApiGetService.class);
    }

    public ApiPostService getApiPostService() {
        return getWebService(ApiPostService.class);
    }
}
