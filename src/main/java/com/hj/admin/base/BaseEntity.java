package com.hj.admin.base;

import lombok.Data;

import java.time.LocalDate;

/*
*       Dto 基础类
**/
@Data
public class BaseEntity {

    /*
    *       版本 乐观锁
    **/

    Integer version;

    /*
    *       创建时间
    **/
    LocalDate createTime;

    /*
     *       更新时间
     **/
    LocalDate updateTime;

    /*
    *   创建人
    * */
    Integer  createBy;

    /*
    *   更新人
    * */
    Integer updateBy;

}
