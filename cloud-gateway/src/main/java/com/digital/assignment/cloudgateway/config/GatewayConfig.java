package com.digital.assignment.cloudgateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.digital.assignment.cloudgateway.filter.JwtAuthenticationFilter;

@Configuration
public class GatewayConfig {

    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("user-service", r -> r.path("/users/**")
                .filters(f -> f.filter(filter))
                .uri("lb://user-service"))
            .route("shop-service", r -> r.path("/shops/**")
                .filters(f -> f.filter(filter))
                .uri("lb://shop-service"))
            .route("shop-service", r -> r.path("/products/**", "/queues/**")
                .filters(f -> f.filter(filter))
                .uri("lb://shop-service"))
            .route("order-service", r -> r.path("/orders/**")
                .filters(f -> f.filter(filter))
                .uri("lb://order-service"))
            .route("core-service", r -> r.path("/ordering/**")
                .filters(f -> f.filter(filter))
                .uri("lb://core-service"))
            .route("auth-service", r -> r.path("/auth/**")
                .filters(f -> f.filter(filter))
                .uri("lb://auth-service"))
            .build();
    }

}
