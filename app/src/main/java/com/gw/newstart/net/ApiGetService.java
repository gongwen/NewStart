package com.gw.newstart.net;

import com.gw.newstart.model.ResponseEntity;
import com.gw.newstart.model.UserEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by GongWen on 17/5/25.
 */

public interface ApiGetService {
    @GET("/login?username=用户名&password=密码")
    Observable<ResponseEntity<UserEntity>> getGankList();
}
