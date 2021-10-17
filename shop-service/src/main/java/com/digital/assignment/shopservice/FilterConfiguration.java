/*
 * Copyright 2019, Verizon Media.
 * Licensed under the Apache License, Version 2.0
 * See LICENSE file in project root for terms.
 */

package com.digital.assignment.shopservice;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.access.servlet.TeeFilter;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<TeeFilter> requestResponseFilter() {

        final FilterRegistrationBean<TeeFilter> filterRegBean = new FilterRegistrationBean<>();
        TeeFilter filter = new TeeFilter();
        filterRegBean.setFilter(filter);
        filterRegBean.addUrlPatterns("/*");
        filterRegBean.setName("Elide Request Response Filter");
        filterRegBean.setAsyncSupported(Boolean.TRUE);
        return filterRegBean;
    }

}
