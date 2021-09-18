package com.hj.admin.base;

import com.hj.admin.Execptions.NoTokenException;
import com.hj.admin.utils.JsonUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseFilter implements Filter {

    public void handleExceptions(Exception e, HttpServletResponse response) throws IOException {
        if (e instanceof NoTokenException) {
            returnMsg("token 无效",response);
        }
    }

    //返回数据
    private void returnMsg(String msg, HttpServletResponse response) throws IOException {
        Result result = new Result();
        result.setMsg(msg);
        result.setStatus(-1);
        String s = JsonUtils.objToJson(result);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(s);
        response.flushBuffer();

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
