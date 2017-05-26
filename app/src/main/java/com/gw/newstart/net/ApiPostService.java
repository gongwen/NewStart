package com.gw.newstart.net;

import com.gw.newstart.model.ResponseEntity;
import com.gw.newstart.model.UserEntity;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by GongWen on 17/5/25.
 */

public interface ApiPostService {
    @FormUrlEncoded
    @POST("/login")
    Observable<ResponseEntity<UserEntity>> getGankList(@Field("username") String username, @Field("password") String password);
}
