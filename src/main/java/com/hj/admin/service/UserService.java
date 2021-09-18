package com.hj.admin.service;


import com.hj.admin.base.BaseService;
import com.hj.admin.base.Result;
import com.hj.admin.pojo.UserQuery;

public interface UserService extends BaseService {



  Result selectPageVo(UserQuery userQuery);

  Result login(UserQuery userQuery);

}
