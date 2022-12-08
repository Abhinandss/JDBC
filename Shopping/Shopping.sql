create database shop;
use shop;
create table agent(user_name varchar(20),password varchar(20));
insert into agent values('Rahul','Rahul@98');
insert into agent values('Arun','Arun@98');
insert into agent values('Sahul','Sahul@98');
insert into agent values('Jishnu','Jishnu@98');
insert into agent values('Vyshnav','Vyshnav@98');
create table admin(user_name varchar(20),password varchar(20));
insert into admin values('Justin','Justin@99');
insert into admin values('Abin','Abin@98');
create table grocery(prd_id int,prd_name varchar(20),qty int,price int);
insert into grocery values(001,'soap',30,20);
insert into grocery values(002,'oil',15,60);
insert into grocery values(003,'toothpaste',30,20);
insert into grocery values(004,'brush',30,20);
insert into grocery values(005,'biscut',30,10);
insert into grocery values(006,'blade',30,10);
select *from agent;
select *from admin;
select *from grocery;
SET SQL_SAFE_UPDATES=0;
update grocery set prd_id='3' where prd_name='toothpaste';
update grocery set prd_id='4' where prd_name='brush';
update grocery set prd_id='5' where prd_name='biscut';
update grocery set prd_id='6' where prd_name='blade';
update admin set user_name='Abin' where password='Leon@97';
select *from admin;
update admin set password='Abin@98' where user_name='Abin';
update grocery set prd_name='salt' where prd_id=3;
select *from admin;
select user_name,password,count(*) as cnt from admin group by user_name,password having count(*) > 1;
delete from admin where user_name="Abin" limit 1;






