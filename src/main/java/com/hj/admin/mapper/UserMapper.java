package com.hj.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hj.admin.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    IPage<User> selectPageVo(Page<?> page,@Param("id") Integer id);

    User findUser(@Param("name") String name,@Param("passWord") String passWord);


}