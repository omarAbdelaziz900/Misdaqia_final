package com.example.misdaqia.View.login;

public class LoginRequest {

    /**
     * email : ert@gmail.com
     * password : 147147
     */

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
