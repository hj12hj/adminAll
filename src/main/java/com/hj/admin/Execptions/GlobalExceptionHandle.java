package com.hj.admin.Execptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//全局异常处理

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class)
    public void Handle(Exception e, HttpServletResponse response) throws IOException {

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("msg");
        response.flushBuffer();
    }
}
