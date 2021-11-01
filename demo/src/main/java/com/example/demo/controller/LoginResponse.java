package com.example.demo.controller;

import lombok.Data;

/**
 * @author dtran@fortna.com
 */
@Data
public class LoginResponse {

    private String accessToken;
    private String tokenType = "Bearer";

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }

}
