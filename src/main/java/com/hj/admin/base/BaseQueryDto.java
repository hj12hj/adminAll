package com.hj.admin.base;

import lombok.Data;

// 查询 基类
@Data
public class BaseQueryDto {
    long current;
    long size;

   public BaseQueryDto(){
       current = 1;
       size =10;
   }

}
