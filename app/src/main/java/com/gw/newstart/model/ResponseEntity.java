package com.gw.newstart.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GongWen on 17/5/26.
 */

public class ResponseEntity<T> {
    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("body")
    private T body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public boolean isSuccess() {
        return code == 200;
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", body=" + body +
                '}';
    }
}
