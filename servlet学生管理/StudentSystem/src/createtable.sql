drop table tb_user;
drop table tb_student;

drop sequence tb_userid_seq;
create sequence tb_userid_seq;
drop sequence tb_stuid_seq;
create sequence tb_stuid_seq;

create table tb_user(
id number(10) primary key,
username varchar2(255) unique not null,
password varchar2(255) not null,
power number(10)
);
create table tb_student(
id number(10) primary key,
sno varchar2(255) unique,
suname varchar2(255),
birthday DATE,
gender number(10)
);