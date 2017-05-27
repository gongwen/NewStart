package com.gw.newstart.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GongWen on 17/5/25.
 */

public class UserEntity {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("os")
    private String os;

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
