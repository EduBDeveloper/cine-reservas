<<<<<<< HEAD
package com.edu.reservas.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class RateLimiter implements Filter {

    private final StringRedisTemplate redisTemplate;
    private static final int MAX_REQUESTS = 10;
    private static final long TIME_WINDOW = 60;

    public RateLimiter(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;

        String clientIp = httpReq.getRemoteAddr();
        String key = "rate:" + clientIp;

        Long count = redisTemplate.opsForValue().increment(key);

        if (count == 1) {
            redisTemplate.expire(key, TIME_WINDOW, TimeUnit.SECONDS);
        }
        if (count != null && count > MAX_REQUESTS) {
            httpResp.setStatus(429);
            httpResp.getWriter().write("Demasiadas solicitudes. Intenta mas tarde.");
            return;
        }

        chain.doFilter(request, response);
    }
}
=======
package com.edu.reservas.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class RateLimiter implements Filter {

    private final StringRedisTemplate redisTemplate;
    private static final int MAX_REQUESTS = 10;
    private static final long TIME_WINDOW = 60; // segundos

    public RateLimiter(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;

        String clientIp = httpReq.getRemoteAddr(); // o usa Authorization/token si tenés login
        String key = "rate:" + clientIp;

        Long count = redisTemplate.opsForValue().increment(key);

        if (count == 1) {
            redisTemplate.expire(key, TIME_WINDOW, TimeUnit.SECONDS);
        }

        if (count != null && count > MAX_REQUESTS) {
            httpResp.setStatus(429);
            httpResp.getWriter().write("Demasiadas solicitudes. Intenta mas tarde.");
            return;
        }

        chain.doFilter(request, response);
    }
}
>>>>>>> ea833c195e8072fb6038c54333ff5336eb37ee03
