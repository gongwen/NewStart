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

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
