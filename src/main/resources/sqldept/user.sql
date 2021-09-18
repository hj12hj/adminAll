-- 部门表
use core;
drop table if exists user;

create table user
(
    id          bigint primary key not null comment '主键',
    name        varchar(30)        not null comment '姓名',
    pass_word   varchar(30)        not null comment '密码',
    dept_id     bigint             not null comment '部门Id',
    menu_info   bigint             not null comment '菜单Id',
    phone       varchar(11)        not null comment '电话',
    job         varchar(30)        not null comment '职务',


    version     int                not null comment '版本',
    create_by   int                null comment '创建人',
    update_by   int                null comment '更新人',
    create_time datetime           not null comment '创建时间',
    update_time datetime           not null comment '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;