package com.digital.assignment.cloudgateway.config;


import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableList;

@Component
public class RouterValidator {

    public static final List<String> OPEN_API_ENDPOINTS = ImmutableList.of(
        "/auth/register",
        "/auth/login"
    );

    public Predicate<ServerHttpRequest> isSecured =
        request -> OPEN_API_ENDPOINTS
            .stream()
            .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
