-- 部门表
use core;
drop table if exists dept;

create table dept
(
    id           bigint primary key not null comment '主键',
    dept_name    varchar(30)      not null comment '部门名称',
    dept_manager long             not null comment '部门主管',


    version      int              not null comment '版本',
    create_by    int null comment '创建人',
    update_by    int null comment '更新人',
    create_time  datetime         not null comment '创建时间',
    update_time  datetime         not null comment '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;