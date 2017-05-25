package com.gw.newstart.net.interceptor;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by GongWen on 17/5/25.
 */

public class GlobalParametersInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        /*String method = originalRequest.method();
        Headers headers = originalRequest.headers();*/
        HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                // Provide your custom parameter here
                .addQueryParameter("os", "android")
                .build();
        Request request = originalRequest.newBuilder().url(modifiedUrl).build();
        return chain.proceed(request);
    }
}
