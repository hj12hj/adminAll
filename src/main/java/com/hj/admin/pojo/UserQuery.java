package com.hj.admin.pojo;

import com.hj.admin.base.BaseQueryDto;
import lombok.Data;

@Data
public class UserQuery extends BaseQueryDto {
    Integer id;
    String  name;
    String  passWord;
}
