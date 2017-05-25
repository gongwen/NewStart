package com.gw.newstart.net;

import com.gw.newstart.model.ResultEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by GongWen on 17/5/25.
 */

public interface ApiService {
    @GET("/api/data/Android/10/1")
    Observable<ResultEntity> getGankList();
}
