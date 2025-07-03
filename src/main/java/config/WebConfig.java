package com.edu.reservas.config;


import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<Filter> rateLimiterFilter(com.edu.reservas.filter.RateLimiter rateLimiter) {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(rateLimiter);
        registrationBean.addUrlPatterns("/api/reservas");
        return registrationBean;
    }
}
