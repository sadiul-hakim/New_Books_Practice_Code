package com.spring_security_in_action.interceptors;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;

import java.io.IOException;

public class RequestInterceptor implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String token = req.getHeader("Token");
        if(token == null || token.isBlank() || token.isEmpty()){
            res.setStatus(HttpStatus.BAD_REQUEST.value());
            return;
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
