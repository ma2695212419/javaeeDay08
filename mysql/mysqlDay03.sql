create schema tcbd1016 default character set utf8;
use tcbd1016;
create table emp(
 id int(11) auto_increment,
 account varchar(50),
 password varchar(50),
 nickname varchar(20),
 primary key(id)
 );
 insert into emp 
 (account,password,nickname) 
 values 
 ("user1","123456","user1"),
 ("user2","123456","user2");
 alter table emp add unique(account);
 select * from emp;
 insert into emp  (account,password,nickname)  values  ("user1","123456","user1");
 
 insert into emp  (account,password,nickname) 
 select "user1","123456","user1" from dual
 where not exists 
 (select id from emp where account = "user1");
 
 insert into emp  (account,password,nickname) 
 select "user3","123456","user3" from dual
 where not exists 
 (select id from emp where account = "user3");
 
 update emp set id = 3 where account = 'user3';
 
 insert into emp  (account,password,nickname) 
 select "user4","123456","user4" from dual
 where not exists 
 (select id from emp where account = "user4");
 
 insert into emp  (account,password,nickname) 
 select "user5","123456","user5" from dual
 where not exists 
 (select id from emp where account = "user5");
 
 create view test_view as select id,nickname from emp;
 
 select * from test_view;
 
 update emp set nickname = 'user55' where id = 5;
 
 select * from test_view;
 
 update test_view set nickname = 'user5' where id = 5;
 
 create table atm (
 id int(11) auto_increment,
 nickname varchar(50) not null,
 money int(11) not null,
 primary key(id)
 );
 insert into atm (nickname,money) values ('孙敬轩',10000),('李朝蓬',10000);
 begin;
 update atm set money = (money - 100) where nickname = '孙敬轩';
 update atm set money = (money + 100) where nickname = '李朝蓬';
 commit;
 begin;
 update atm set money = (money - 100) where nickname = '孙敬轩';
 update atm set money = (money + 100) where nickname = '李朝蓬';
 savepoint zq01;
 update atm set money = (money - 100) where nickname = '孙敬轩';
 update atm set money = (money + 100) where nickname = '李朝蓬';
 savepoint zq02;
 update atm set money = (money - 100) where nickname = '孙敬轩';
 update atm set money = (money + 100) where nickname = '李朝蓬';
 savepoint zq03;
 
 rollback to zq02;
 rollback;