package com.hj.admin.Execptions;

import com.hj.admin.base.Result;
import com.hj.admin.utils.JsonUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//全局异常处理

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class)
    public void Handle(Exception e, HttpServletResponse response) throws IOException {
        Result result = new Result();
        result.setMsg(e.toString());
        result.setStatus(-1);
        String s = JsonUtils.objToJson(result);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(s);
        response.flushBuffer();
    }
}
