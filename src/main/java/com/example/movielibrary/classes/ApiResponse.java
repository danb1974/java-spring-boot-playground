package com.example.movielibrary.classes;

public class ApiResponse {
    private boolean success;

    private String msg;

    private Object data;

    public ApiResponse() {
        this.success = true;
        this.msg = "";
        this.data = new Object();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setSuccess(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setData(Object data, String msg) {
        this.data = data;
        this.msg = msg;
    }
}
