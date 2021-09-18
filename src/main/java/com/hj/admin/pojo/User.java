package com.hj.admin.pojo;

import com.hj.admin.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 菜单id
     */
    private Integer menuInfo;

    /**
     * 电话
     */
    private String phone;

    /**
     * 职务
     */
    private String job;

    private static final long serialVersionUID = 1L;
}