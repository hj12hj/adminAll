package com.hj.admin.base;

import lombok.Data;

import java.util.List;

@Data
public class Result   {

    Integer status;
    String msg;
    long current;
    long size;
    long total;
    String token;
    List<?> Data;


}
