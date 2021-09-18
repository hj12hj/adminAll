package com.hj.admin.filter;

import com.hj.admin.Execptions.NoTokenException;
import com.hj.admin.base.BaseFilter;
import com.hj.admin.jwt.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "firstFilter", urlPatterns = "/*")
@Component
public class GlobalFilter extends BaseFilter {

    @Autowired
    JwtToken jwtToken;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String token = httpServletRequest.getHeader("token");

        if (httpServletRequest.getRequestURI().equals("/user/login")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (token == null) {
            this.handleExceptions(new NoTokenException(), httpServletResponse);
            return;
        }

        try {
            String s = jwtToken.parseJwt(token);
            httpServletRequest.setAttribute("id", s);
        } catch (Exception e) {
            this.handleExceptions(new NoTokenException(),httpServletResponse);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }


}
