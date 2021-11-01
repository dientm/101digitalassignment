package com.digital.assignment.coreservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.digital.assignment.coreservice.dto.AuthRequest;
import com.digital.assignment.coreservice.dto.AuthResponse;
import com.digital.assignment.coreservice.utils.JwtUtil;

import dto.UserDto;

@Service
public class AuthService {

    private final RestTemplate restTemplate;

    private final JwtUtil jwt;

    @Autowired
    public AuthService(RestTemplate restTemplate, JwtUtil jwt) {
        this.restTemplate = restTemplate;
        this.jwt = jwt;
    }

    public AuthResponse register(AuthRequest authRequest) {
        authRequest.setPassword(BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt()));
        UserDto userDto = restTemplate.postForObject("http://user-service/users", authRequest, UserDto.class);

        String accessToken = jwt.generate(userDto, "ACCESS");
        String refreshToken = jwt.generate(userDto, "REFRESH");

        return new AuthResponse(accessToken, refreshToken);
    }

}
