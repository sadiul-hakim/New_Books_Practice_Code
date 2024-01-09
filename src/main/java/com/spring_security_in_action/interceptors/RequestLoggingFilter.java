package com.spring_security_in_action.interceptors;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class RequestLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String token = req.getHeader("Token");
        if(!(token == null || token.isBlank() || token.isEmpty())){
            System.out.println(token);
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
