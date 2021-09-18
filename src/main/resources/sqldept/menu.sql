-- 菜单表
use core;

drop table if exists menu;


create table menu
(
    id          bigint primary key not null comment '主键',
    router      varchar(60)      not null comment '路由',
    icon        varchar(30)      not null comment '图标',


    version     int              not null comment '版本',
    create_by   int null comment '创建人',
    update_by   int null comment '更新人',
    create_time datetime         not null comment '创建时间',
    update_time datetime         not null comment '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;