<<<<<<< HEAD
package com.edu.reservas.config;

import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer { // ✅ agregar esta interfaz

    @Bean
    public FilterRegistrationBean<Filter> rateLimiterFilter(com.edu.reservas.filter.RateLimiter rateLimiter) {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(rateLimiter);
        registrationBean.addUrlPatterns("/api/reservas");
        return registrationBean;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3002") // ✅ cambialo a tu puerto actual
                .allowedMethods("*");
    }
}
=======
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
>>>>>>> ea833c195e8072fb6038c54333ff5336eb37ee03
