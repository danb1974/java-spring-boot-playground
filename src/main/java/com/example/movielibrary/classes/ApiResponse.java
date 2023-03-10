package com.example.movielibrary.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse {
    private boolean success;

    private String msg;

    private Object data;

    public ApiResponse() {
        success = false;
        msg = "";
        data = new Object();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    @JsonIgnore
    public ResponseEntity<ApiResponse> getResponseEntity() {
        return new ResponseEntity<>(this, HttpStatus.OK);
    }
}
