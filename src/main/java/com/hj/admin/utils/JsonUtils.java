package com.hj.admin.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtils {

   private static ObjectMapper mapper = new ObjectMapper();

   //json  转 对象
    public static <T> T jsonToObj(String json,Class<T> tClass) throws JsonProcessingException {
     return    mapper.readValue(json,tClass);
    }

    //对象  转 json
    public  static <T> String  objToJson(T t) throws JsonProcessingException {
        return mapper.writeValueAsString(t);
    }

}
