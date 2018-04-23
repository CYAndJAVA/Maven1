drop table tb_employ;
drop sequence tb_em_id;
drop table tb_salory;
drop sequence tb_sa_id;



create table tb_employ(
id number(10) primary key,
emnumber varchar2(255) UNIQUE,
name varchar2(255),
gender number(10),
zhicheng number(10),
worktime DATE,
phone varchar2(255)
);
create sequence tb_em_id;

create table tb_salory(
sid number(10) primary key,
salarytime DATE,
basicsalary number(10,2),
sells number(10,2),
taotal number(10,2),
emid number(10)
);
create sequence tb_sa_id;


