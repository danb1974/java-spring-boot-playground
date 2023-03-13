package com.example.movielibrary.controller;

import com.example.movielibrary.classes.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ApiController {
    @GetMapping(value = "/api/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse test() {
        ApiResponse apiResponse = new ApiResponse();

        try {
            HashMap<String, Object> data = new HashMap<>();
            data.put("string", "Happy");
            data.put("integer", 13);
            data.put("float", 3.1415926);
            data.put("boolean", true);
            apiResponse.setData(data, "Hello!");
        } catch (Exception e) {
            apiResponse.setSuccess(false, e.getMessage());
        }

        return apiResponse;
    }
}
