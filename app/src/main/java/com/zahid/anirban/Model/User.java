package com.zahid.anirban.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Zahid on 06-Jun-17.
 */

public class User {


    @SerializedName("username")
    private String userName;
    @SerializedName("password")
    private String password;
    @SerializedName("orgcode")
    private String orgCode;

    public User(){}

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
}
