package com.hj.admin.controller;


import com.hj.admin.base.BaseController;
import com.hj.admin.base.Result;
import com.hj.admin.pojo.UserQuery;
import com.hj.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;


    @GetMapping("/findOne")
    public Result findOne(UserQuery userQuery, HttpServletRequest request){


        System.out.println(request.getAttribute("id"));
        return userService.selectPageVo(userQuery);
    }

    @GetMapping("/login")
    public Result login(UserQuery userQuery){
        return userService.login(userQuery);
    }


}
