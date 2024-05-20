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

INSERT INTO student_demo.tb_student (id, name, gender, gmt_create, gmt_modified, clazz_id) VALUES (4, 'Test2', true, '2024-05-14 17:56:38', '2024-05-14 17:56:38', null);
INSERT INTO student_demo.tb_student (id, name, gender, gmt_create, gmt_modified, clazz_id) VALUES (5, 'Test3', false, '2024-05-14 17:56:38', '2024-05-14 17:56:38', null);
INSERT INTO student_demo.tb_student (id, name, gender, gmt_create, gmt_modified, clazz_id) VALUES (6, 'Test4', true, '2024-05-14 17:56:38', '2024-05-14 17:56:38', null);
INSERT INTO student_demo.tb_student (id, name, gender, gmt_create, gmt_modified, clazz_id) VALUES (7, 'Test5', false, '2024-05-14 17:56:38', '2024-05-14 17:56:38', null);
INSERT INTO student_demo.tb_student (id, name, gender, gmt_create, gmt_modified, clazz_id) VALUES (8, 'Test6', true, '2024-05-14 17:56:38', '2024-05-14 17:56:38', null);
INSERT INTO student_demo.tb_student (id, name, gender, gmt_create, gmt_modified, clazz_id) VALUES (9, 'Test7', false, '2024-05-14 17:56:38', '2024-05-14 17:56:38', null);
INSERT INTO student_demo.tb_student (id, name, gender, gmt_create, gmt_modified, clazz_id) VALUES (13, 'Test11', false, '2024-05-16 15:42:42', '2024-05-16 15:42:42', null);
INSERT INTO student_demo.tb_student (id, name, gender, gmt_create, gmt_modified, clazz_id) VALUES (14, 'Test12', false, '2024-05-16 15:42:42', '2024-05-16 15:42:42', null);
INSERT INTO student_demo.tb_student (id, name, gender, gmt_create, gmt_modified, clazz_id) VALUES (15, 'Test13', true, '2024-05-16 15:42:42', '2024-05-16 15:42:42', null);
INSERT INTO student_demo.tb_student (id, name, gender, gmt_create, gmt_modified, clazz_id) VALUES (16, 'Test14', false, '2024-05-16 15:42:42', '2024-05-16 15:42:42', null);
INSERT INTO student_demo.tb_student (id, name, gender, gmt_create, gmt_modified, clazz_id) VALUES (17, 'Test15', true, '2024-05-16 15:42:42', '2024-05-16 15:42:42', null);



drop table if exists tb_clazz;
create table tb_clazz
(
    id           bigint auto_increment primary key comment '主键',
    grade_no     smallint comment '年级',
    clazz_no     smallint comment '班级',
    gmt_create   datetime comment '创建时间',
    gmt_modified datetime comment '更新时间'
)

    INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (2, 1, 21, '2024-05-15 09:56:07', '2024-05-16 14:24:55');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (3, 1, 3, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (4, 1, 4, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (5, 1, 5, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (6, 2, 1, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (7, 2, 2, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (8, 2, 3, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (9, 2, 4, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (10, 2, 5, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (11, 3, 1, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (12, 3, 2, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (13, 3, 3, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (14, 3, 4, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (15, 3, 5, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (16, 4, 1, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (17, 4, 2, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (18, 4, 3, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (19, 4, 4, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (20, 4, 5, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
INSERT INTO student_demo.tb_clazz (id, grade_no, clazz_no, gmt_create, gmt_modified) VALUES (21, 5, 1, '2024-05-15 09:56:07', '2024-05-15 09:56:07');
