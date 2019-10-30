package com.example.misdaqia.View.register;

public class RegisterResponse {

    /**
     * status : true
     * msg : Account Created Successfully
     */

    private boolean status;
    private String msg;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
