package com.hj.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hj.admin.base.Result;
import com.hj.admin.jwt.JwtToken;
import com.hj.admin.mapper.UserMapper;
import com.hj.admin.pojo.User;
import com.hj.admin.pojo.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl  implements UserService  {

    @Resource
    private UserMapper userMapper;

    @Autowired
    JwtToken jwtToken;


    @Override
    public Result selectPageVo(UserQuery userQuery) {
        Page<User> userPage = new Page<>(userQuery.getCurrent(),userQuery.getSize());
        IPage<User> userIPage = userMapper.selectPageVo(userPage, userQuery.getId());
        Result result = this.Page2Result(userIPage);
        result.setStatus(0);
        return  result;
    }

    @Override
    public Result login(UserQuery userQuery) {

        User user = userMapper.findUser(userQuery.getName(), userQuery.getPassWord());
        String jwt="";
        if (null!=user){
            Map<String,String> map =new HashMap<>();
            map.put(user.getId().toString(),user.getName());
            jwt  = jwtToken.createJwt(user.getId().toString(), map);
        }

        Result result =new Result();
        result.setToken(jwt);
        result.setStatus(0);
        result.setMsg("登录成功!");

        return result;
    }
}
