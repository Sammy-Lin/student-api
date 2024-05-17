create database student_demo;
use student_demo;

drop table if exists tb_student;
create table tb_student
(
    id           bigint auto_increment primary key comment '主键',
    name         varchar(64) not null comment '学生名称',
    gender       tinyint(1) comment '性别;1:男,0:女',
    class_id     bigint comment '班级ID',
    gmt_create   datetime comment '创建时间',
    gmt_modified datetime comment '修改时间'
);

drop table if exists tb_clazz;
create table tb_clazz
(
    id           bigint auto_increment primary key comment '主键',
    grade_no     smallint comment '年级',
    clazz_no     smallint comment '班级',
    gmt_create   datetime comment '创建时间',
    gmt_modified datetime comment '更新时间'
)