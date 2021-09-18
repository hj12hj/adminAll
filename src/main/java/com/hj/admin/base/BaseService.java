package com.hj.admin.base;

import com.baomidou.mybatisplus.core.metadata.IPage;

public interface BaseService {
    default Result Page2Result(IPage page){
        Result result = new Result();
        result.setCurrent(page.getCurrent());
        result.setTotal(page.getTotal());
        result.setSize(page.getSize());
        result.setData(page.getRecords());
        return  result;
    }
}
