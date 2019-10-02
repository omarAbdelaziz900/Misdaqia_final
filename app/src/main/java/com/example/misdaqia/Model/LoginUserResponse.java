package com.example.misdaqia.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginUserResponse {

    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("status")
    private String status;
    @SerializedName("error")
    private String error;
    @SerializedName("data")
    private String data;

    public String getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}







