package com.hj.admin.base;



import com.hj.admin.jwt.JwtToken;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

  public Long getUser(HttpServletRequest request){

       String token = request.getHeader("token");

       JwtToken jwtToken =new JwtToken();
       String s = jwtToken.parseJwt(token);
       return Long.parseLong(s);


   }

}
