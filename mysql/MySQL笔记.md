---
typora-root-url: MySQL笔记
typora-copy-images-to: MySQL笔记
---

# MySQL笔记

#### Day01

```
概述
数据库是一个长期存储在计算机内的、有组织的、有共享的、统一管理的数据集合.
在数据库中的数据我们可以用二维表格的形式理解,例如
表格中一列的标题我们称之为字段
表格中一行数据我们称之为一条记录
```

|  id  | account | password |  nickname  |                 uuid                 |
| :--: | :-----: | :------: | :--------: | :----------------------------------: |
|  1   |  root   |   roor   | 超级管理员 | 2e6342dd-c475-410f-9948-e4cc1948ef0f |
|  2   |  admin  |  admin   |   guanli   | e30e8060-9320-4b72-8722-10328348a272 |
|  3   | phoenix |  123456  |   李昊哲   | 3ddc2b0e-fdba-4f61-b0a8-2585ffdce940 |

```
数据库由3部分组成
数据库：用于存储数据
数据库管理系统：用户管理数据库的软件
数据库应用程序：为了提高数据库系统的管理能力使用的数据库管理的补充

```

![1562117348850](/1562117348850.png)

```

对数据库进行查询、修改操作的语言我们称之为SQL
结构化查询语言(Structured Query Language)简称SQL(发音：/ˈes kjuː ˈel/ "S-Q-L")，是一种特殊目的的编程语言，是一种数据库查询和程序设计语言，用于存取数据以及查询、更新和管理关系数据库系统；同时也是数据库脚本文件的扩展名。
标准：SQL-92、SQL-99、方言
常用关系型数据库
Oracle、MySQL、SQLServer、...
对象型数据库
PostgreSQL、...
常用的非关系数据库（在中国）
Redis、MongoDB、HBase、...
按照SQL-92标准SQL包含4部分
1、数据库定义语言(DDL)：create、drop、alter、...
2、数据库操作语言(DML)：insert、update、delete、...
3、数据库查询语言(DQL)：slecet
4、数据库控制语言(DCL)：commit、rollbasck、grant、revoke、...

```

```mysql
kgc@kgc-phoenix:~$ mysql -h localhost -uroot -p
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 2
Server version: 5.7.26 MySQL Community Server (GPL)

Copyright (c) 2000, 2019, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> 

```

```mysql
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
4 rows in set (0.00 sec)
mysql> create database 190703_01 default character set utf8;
Query OK, 1 row affected (0.00 sec)
mysql> create schema 190703_02 default character set utf8;
Query OK, 1 row affected (0.00 sec)
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| 190703_01          |
| 190703_02          |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
6 rows in set (0.00 sec)
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| 190703_01          |
| 190703_02          |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
6 rows in set (0.00 sec)
mysql> drop database 190703_01;
Query OK, 0 rows affected (0.01 sec)
mysql> drop schema 190703_02;
Query OK, 0 rows affected (0.00 sec)
mysql> create database mysqlDay01 default character set utf8;
Query OK, 1 row affected (0.00 sec)
mysql> use mysqlDay01;
Database changed
mysql> select database();
+------------+
| database() |
+------------+
| mysqlDay01 |
+------------+
1 row in set (0.00 sec)

mysql> show engines;

```

![1562118952118](/1562118952118.png)

```mysql
mysql> show create database mysqlDay01;
+------------+---------------------------------------------------------------------+
| Database   | Create Database                                                     |
+------------+---------------------------------------------------------------------+
| mysqlDay01 | CREATE DATABASE `mysqlDay01` /*!40100 DEFAULT CHARACTER SET utf8 */ |
+------------+---------------------------------------------------------------------+
1 row in set (0.00 sec)
mysql> show create database mysqlDay01\g
+------------+---------------------------------------------------------------------+
| Database   | Create Database                                                     |
+------------+---------------------------------------------------------------------+
| mysqlDay01 | CREATE DATABASE `mysqlDay01` /*!40100 DEFAULT CHARACTER SET utf8 */ |
+------------+---------------------------------------------------------------------+
1 row in set (0.00 sec)

mysql> show create database mysqlDay01\G
*************************** 1. row ***************************
       Database: mysqlDay01
Create Database: CREATE DATABASE `mysqlDay01` /*!40100 DEFAULT CHARACTER SET utf8 */
1 row in set (0.00 sec)

```

```
mysql常用数据类型
数值型、日期|时间、字符串
```

```mysql
mysql> CREATE TABLE tb_emp1
    -> (
    -> id      INT(11),
    -> name   VARCHAR(25),
    -> deptId  INT(11),
    -> salary  FLOAT
    -> );
Query OK, 0 rows affected (0.01 sec)
mysql> show tables;
+----------------------+
| Tables_in_mysqlDay01 |
+----------------------+
| tb_emp1              |
+----------------------+
1 row in set (0.00 sec)
mysql> drop table tb_emp1;
Query OK, 0 rows affected (0.02 sec)
mysql> create table `tb_emp01` (
    ->  `id` int(11) comment '员工编号',
    ->  `name` varchar(50) comment '员工性名',
    ->  `deptId` int(11) comment '部门编号',
    ->  `salary` double(5,2) comment '员工薪资'                                                 ->  );
mysql> system clear;
```

```mysql
默认约束使用关键字default
mysql> create table `tb_emp02` (
    ->  `id` int(11) comment '员工编号',
    ->  `name` varchar(50) comment '员工性名',
    ->  `deptId` int(11) default 2 comment '部门编号',
    ->  `salary` double(5,2) comment '员工薪资'                                                 
    ->   );
非空约束关键字not null
create table `tb_emp03` (
 `id` int(11) comment '员工编号',
 `name` varchar(50) not null comment '员工性名',
 `deptId` int(11) default 2 comment '部门编号',
 `salary` double(5,2) comment '员工薪资'                                                 
  );
唯一性约束关键字unique
mysql> create table `tb_emp04` (
    ->  `id` int(11) unique comment '员工编号',
    ->  `name` varchar(50) not null comment '员工性名',
    ->  `deptId` int(11) default 2 comment '部门编号',
    ->  `salary` double(5,2) comment '员工薪资'
    ->   );
非空约束 + 唯一性约束 = 主键约束
mysql> create table `tb_emp05` (
    ->  `id` int(11) not null unique comment '员工编号',
    ->  `name` varchar(50) not null comment '员工性名',
    ->  `deptId` int(11) default 2 comment '部门编号',
    ->  `salary` double(5,2) comment '员工薪资'
    ->   );
 主键约束关键字primary key
 写法一(不推荐)
 mysql> create table `tb_emp06` (
    ->  `id` int(11) primary key comment '员工编号',
    ->  `name` varchar(50) not null comment '员工性名',
    ->  `deptId` int(11) default 2 comment '部门编号',
    ->  `salary` double(5,2) comment '员工薪资'
    ->   );
 写法二(推荐)
 mysql> create table `tb_emp07` (
    ->  `id` int(11) comment '员工编号',
    ->  `name` varchar(50) not null comment '员工性名',
    ->  `deptId` int(11) default 2 comment '部门编号',
    ->  `salary` double(5,2) comment '员工薪资',
    ->  primary key(`id`)
    ->   );
  联合主键或称之为复合主键
  mysql> create table `emp_dept` (
    ->  `empId` int(11) comment '员工编号',
    ->  `deptId` int(11) comment '部门编号',
    ->  primary key(`empId`,`deptId`)
    ->  );
  主键自增长关键字auto_increment
  mysql> create table `tb_emp08` (
    ->  `id` int(11) auto_increment comment '员工编号',
    ->  `name` varchar(50) not null comment '员工性名',
    ->  `deptId` int(11) default 2 comment '部门编号',
    ->  `salary` double(5,2) comment '员工薪资',
    ->  primary key(`id`)
    ->  );
  外键必须存在主从表的关联字段
  应用场景一对多或者多对一的关系
  先建主表
  mysql> create table `dept` (
    ->  `id` int(11) auto_increment comment '部门编号',
    ->  `name` varchar(50) comment '部门名称',
    ->  primary key(`id`)
    ->  )；
  后建从表
  mysql> create table `emp` (
    ->  `id` int(11) auto_increment comment '员工编号',
    ->  `name` varchar(50) not null comment '员工性名',
    ->  `deptId` int(11) default 2 comment '部门编号',
    ->  `salary` double(5,2) comment '员工薪资',
    ->  primary key(`id`),
    ->  constraint `fk_emp_dept` foreign key(`deptId`) references `dept`(`id`)
    ->  );
  检查约束关键字check
```

```mysql
mysql> describe dept;
+-------+-------------+------+-----+---------+----------------+
| Field | Type        | Null | Key | Default | Extra          |
+-------+-------------+------+-----+---------+----------------+
| id    | int(11)     | NO   | PRI | NULL    | auto_increment |
| name  | varchar(50) | YES  |     | NULL    |                |
+-------+-------------+------+-----+---------+----------------+
2 rows in set (0.00 sec)
mysql> describe dept\G
*************************** 1. row ***************************
  Field: id
   Type: int(11)
   Null: NO
    Key: PRI
Default: NULL
  Extra: auto_increment
*************************** 2. row ***************************
  Field: name
   Type: varchar(50)
   Null: YES
    Key: 
Default: NULL
  Extra: 
2 rows in set (0.01 sec)
mysql> describe emp;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| id     | int(11)     | NO   | PRI | NULL    | auto_increment |
| name   | varchar(50) | NO   |     | NULL    |                |
| deptId | int(11)     | YES  | MUL | 2       |                |
| salary | double(5,2) | YES  |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)
mysql> describe tb_emp04;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| id     | int(11)     | YES  | UNI | NULL    |       |
| name   | varchar(50) | NO   |     | NULL    |       |
| deptId | int(11)     | YES  |     | 2       |       |
| salary | double(5,2) | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
4 rows in set (0.00 sec)
mysql> describe tb_emp05;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| id     | int(11)     | NO   | PRI | NULL    |       |
| name   | varchar(50) | NO   |     | NULL    |       |
| deptId | int(11)     | YES  |     | 2       |       |
| salary | double(5,2) | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
4 rows in set (0.00 sec)
mysql> show create table tb_emp05;
+----------+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Table    | Create Table                                                                                                                                                                                                                                                                                                     |
+----------+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| tb_emp05 | CREATE TABLE `tb_emp05` (
  `id` int(11) NOT NULL COMMENT '员工编号',
  `name` varchar(50) NOT NULL COMMENT '员工性名',
  `deptId` int(11) DEFAULT '2' COMMENT '部门编号',
  `salary` double(5,2) DEFAULT NULL COMMENT '员工薪资',
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8                 |
+----------+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)
mysql> show create table tb_emp06;
+----------+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Table    | Create Table                                                                                                                                                                                                                                                                                                 |
+----------+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| tb_emp06 | CREATE TABLE `tb_emp06` (
  `id` int(11) NOT NULL COMMENT '员工编号',
  `name` varchar(50) NOT NULL COMMENT '员工性名',
  `deptId` int(11) DEFAULT '2' COMMENT '部门编号',
  `salary` double(5,2) DEFAULT NULL COMMENT '员工薪资',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8                 |
+----------+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)


```

```mysql
mysql> create table `tb_emp11` (
    ->  `id` int(11)   comment '员工编号',
    ->  `name` varchar(50)  comment '员工性名',
    ->  `deptId` int(11)  comment '部门编号',
    ->  `salary` double(5,2) comment '员工薪资'
    ->   )engine=myisam default charset=utf8;
mysql> create table `tb_emp12` (
    ->  `id` int(11)   comment '员工编号',
    ->  `name` varchar(50)  comment '员工性名',
    ->  `deptId` int(11)  comment '部门编号',
    ->  `salary` double(5,2) comment '员工薪资'
    ->   )engine=myisam default charset=gbk;

```

```mysql
数据库备份
kgc@kgc-phoenix:~$ mysqldump -h localhost -uroot -p mysqlDay01 > /home/kgc/mysqlDay01.sql;
Enter password: 
数据库还原
kgc@kgc-phoenix:~$ mysql -h localhost -uroot -p
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 7
Server version: 5.7.26 MySQL Community Server (GPL)

Copyright (c) 2000, 2019, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
4 rows in set (0.00 sec)
mysql> create database mysqlDay01 default character set utf8;
Query OK, 1 row affected (0.00 sec)

mysql> use mysqlDay01;
Database changed
mysql> source /home/kgc/mysqlDay01.sql;
mysql> show tables;
+----------------------+
| Tables_in_mysqlDay01 |
+----------------------+
| dept                 |
| emp                  |
| emp_dept             |
| tb_emp01             |
| tb_emp02             |
| tb_emp04             |
| tb_emp05             |
| tb_emp06             |
| tb_emp07             |
| tb_emp08             |
| tb_emp11             |
| tb_emp12             |
+----------------------+
12 rows in set (0.00 sec)

```

Day02

```
01、查询所有
02、按字段查询
03、按条件查询
04、多条件查询
05、between and
06、in
07、排序
08、分组
09、聚合查询
10、 (当前页码号 - 1) * 每页记录数 = 数据库中每页的起始index
11、关联查询、复合查询
12、连接查询
13、子查询
```

#### Day03

```mysql
-- 修改表名 --
ALTER TABLE `emp` RENAME TO `employee`
-- 修改字段数据类型 --
ALTER TABLE `employee` MODIFY name CHAR(11)
-- 修改字段名 --
ALTER TABLE `employee` CHANGE name nickname CHAR(11)
-- 修改字段名的同时修改数类型 --
ALTER TABLE `employee` CHANGE name nickname CHAR(11)

-- 增加字段 --
ALTER TABLE `employee` ADD `uuid` VARCHAR(255) COMMENT '唯一标识符'
-- 删除字段 --
ALTER TABLE `employee` DROP `uuid`
-- 增加字段在表的第一个位置 --
ALTER TABLE `employee` ADD `uuid` VARCHAR(255) COMMENT '唯一标识符' FIRST
-- 增加字段在表的指定位置 --
ALTER TABLE `employee` ADD `uuid` VARCHAR(255) COMMENT '唯一标识符' AFTER `NAME`
-- 修改字段在表的指定位置 --
ALTER TABLE `employee` MODIFY `uuid` VARCHAR(255) COMMENT '唯一标识符' AFTER `did`
-- 增加字段唯一性约束 --
ALTER TABLE `employee`  ADD UNIQUE(`uuid`)
-- 删除字段唯一性约束 --
ALTER TABLE `employee`  DROP INDEX `uuid`

-- 插入数据 --
INSERT `dept` (`NAME`) VALUES ('开发部'),('运维部')

insert into `emp` 
 (`account`,`nickname`,`birthday`,`gender`,`uuid`)  
 select 'feijie','李梦菲','1999-08-08',0,'3ae01629-0795-4dda-9d9e-d6e6eba67a32'  
 from dual  
 WHERE NOT EXISTS   
 (  select `id` from `emp` WHERE  1 = 1  and `account` = 'feijie'  ) 

-- 更新数据 --
UPDATE `emp` SET `did` = 1 
 WHERE 1 = 1 
 AND `id` = 2
-- 删除数据 -- 
DELETE FROM `employee` 
 WHERE 1 = 1 
 AND `id` = 3
-- 查询数据 -
SELECT * FROM `emp`
```

#### Day04

```
MySQL 事务
MySQL 事务主要用于处理操作量大，复杂度高的数据。比如说，在人员管理系统中，你删除一个人员，你即需要删除人员的基本资料，也要删除和该人员相关的信息，如信箱，文章等等，这样，这些数据库操作语句就构成一个事务！

在 MySQL 中只有使用了 Innodb 数据库引擎的数据库或表才支持事务。
事务处理可以用来维护数据库的完整性，保证成批的 SQL 语句要么全部执行，要么全部不执行。
事务用来管理 insert,update,delete 语句
一般来说，事务是必须满足4个条件（ACID）：：原子性（Atomicity，或称不可分割性）、一致性（Consistency）、隔离性（Isolation，又称独立性）、持久性（Durability）。

原子性：一个事务（transaction）中的所有操作，要么全部完成，要么全部不完成，不会结束在中间某个环节。事务在执行过程中发生错误，会被回滚（Rollback）到事务开始前的状态，就像这个事务从来没有执行过一样。

一致性：在事务开始之前和事务结束以后，数据库的完整性没有被破坏。这表示写入的资料必须完全符合所有的预设规则，这包含资料的精确度、串联性以及后续数据库可以自发性地完成预定的工作。

隔离性：数据库允许多个并发事务同时对其数据进行读写和修改的能力，隔离性可以防止多个事务并发执行时由于交叉执行而导致数据的不一致。事务隔离分为不同级别，包括读未提交（Read uncommitted）、读提交（read committed）、可重复读（repeatable read）和串行化（Serializable）。

持久性：事务处理结束后，对数据的修改就是永久的，即便系统故障也不会丢失。

在 MySQL 命令行的默认设置下，事务都是自动提交的，即执行 SQL 语句后就会马上执行 COMMIT 操作。因此要显式地开启一个事务务须使用命令 BEGIN 或 START TRANSACTION，或者执行命令 SET AUTOCOMMIT=0，用来禁止使用当前会话的自动提交。

事务控制语句：
BEGIN 或 START TRANSACTION 显式地开启一个事务；

COMMIT 也可以使用 COMMIT WORK，不过二者是等价的。COMMIT 会提交事务，并使已对数据库进行的所有修改成为永久性的；

ROLLBACK 也可以使用 ROLLBACK WORK，不过二者是等价的。回滚会结束用户的事务，并撤销正在进行的所有未提交的修改；

SAVEPOINT identifier，SAVEPOINT 允许在事务中创建一个保存点，一个事务中可以有多个 SAVEPOINT；

RELEASE SAVEPOINT identifier 删除一个事务的保存点，当没有指定的保存点时，执行该语句会抛出一个异常；

ROLLBACK TO identifier 把事务回滚到标记点；

SET TRANSACTION 用来设置事务的隔离级别。InnoDB 存储引擎提供事务的隔离级别有READ UNCOMMITTED、READ COMMITTED、REPEATABLE READ 和 SERIALIZABLE。

MYSQL 事务处理主要有两种方法：
1、用 BEGIN, ROLLBACK, COMMIT来实现

BEGIN 开始一个事务
ROLLBACK 事务回滚
COMMIT 事务确认
2、直接用 SET 来改变 MySQL 的自动提交模式:

SET AUTOCOMMIT=0 禁止自动提交
SET AUTOCOMMIT=1 开启自动提交
```

```
什么是事务?
事务是逻辑上的一组操作，要么都执行，要么都不执行。

事务最经典也经常被拿出来说例子就是转账了。假如小明要给小红转账1000元，这个转账会涉及到两个关键操作就是：将小明的余额减少1000元，将小红的余额增加1000元。万一在这两个操作之间突然出现错误比如银行系统崩溃，导致小明余额减少而小红的余额没有增加，这样就不对了。事务就是保证这两个关键操作要么都成功，要么都要失败。

事物的特性(ACID)
事物的特性

原子性： 事务是最小的执行单位，不允许分割。事务的原子性确保动作要么全部完成，要么完全不起作用；
一致性： 执行事务前后，数据保持一致，多个事务对同一个数据读取的结果是相同的；
隔离性： 并发访问数据库时，一个用户的事务不被其他事务所干扰，各并发事务之间数据库是独立的；
持久性： 一个事务被提交之后。它对数据库中数据的改变是持久的，即使数据库发生故障也不应该对其有任何影响。
并发事务带来的问题
在典型的应用程序中，多个事务并发运行，经常会操作相同的数据来完成各自的任务（多个用户对统一数据进行操作）。并发虽然是必须的，但可能会导致以下的问题。

脏读（Dirty read）: 当一个事务正在访问数据并且对数据进行了修改，而这种修改还没有提交到数据库中，这时另外一个事务也访问了这个数据，然后使用了这个数据。因为这个数据是还没有提交的数据，那么另外一个事务读到的这个数据是“脏数据”，依据“脏数据”所做的操作可能是不正确的。
丢失修改（Lost to modify）: 指在一个事务读取一个数据时，另外一个事务也访问了该数据，那么在第一个事务中修改了这个数据后，第二个事务也修改了这个数据。这样第一个事务内的修改结果就被丢失，因此称为丢失修改。 例如：事务1读取某表中的数据A=20，事务2也读取A=20，事务1修改A=A-1，事务2也修改A=A-1，最终结果A=19，事务1的修改被丢失。
不可重复读（Unrepeatableread）: 指在一个事务内多次读同一数据。在这个事务还没有结束时，另一个事务也访问该数据。那么，在第一个事务中的两次读数据之间，由于第二个事务的修改导致第一个事务两次读取的数据可能不太一样。这就发生了在一个事务内两次读到的数据是不一样的情况，因此称为不可重复读。
幻读（Phantom read）: 幻读与不可重复读类似。它发生在一个事务（T1）读取了几行数据，接着另一个并发事务（T2）插入了一些数据时。在随后的查询中，第一个事务（T1）就会发现多了一些原本不存在的记录，就好像发生了幻觉一样，所以称为幻读。
不可重复度和幻读区别：

不可重复读的重点是修改，幻读的重点在于新增或者删除。

例1（同样的条件, 你读取过的数据, 再次读取出来发现值不一样了 ）：事务1中的A先生读取自己的工资为 1000的操作还没完成，事务2中的B先生就修改了A的工资为2000，导 致A再读自己的工资时工资变为 2000；这就是不可重复读。

例2（同样的条件, 第1次和第2次读出来的记录数不一样 ）：假某工资单表中工资大于3000的有4人，事务1读取了所有工资大于3000的人，共查到4条记录，这时事务2 又插入了一条工资大于3000的记录，事务1再次读取时查到的记录就变为了5条，这样就导致了幻读。

事务隔离级别
SQL 标准定义了四个隔离级别：

READ-UNCOMMITTED(读取未提交)： 最低的隔离级别，允许读取尚未提交的数据变更，可能会导致脏读、幻读或不可重复读。
READ-COMMITTED(读取已提交)： 允许读取并发事务已经提交的数据，可以阻止脏读，但是幻读或不可重复读仍有可能发生。
REPEATABLE-READ(可重复读)： 对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改，可以阻止脏读和不可重复读，但幻读仍有可能发生。
SERIALIZABLE(可串行化)： 最高的隔离级别，完全服从ACID的隔离级别。所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。
隔离级别	脏读	不可重复读	幻影读
READ-UNCOMMITTED	√	√	√
READ-COMMITTED	×	√	√
REPEATABLE-READ	×	×	√
SERIALIZABLE	×	×	×
MySQL InnoDB 存储引擎的默认支持的隔离级别是 REPEATABLE-READ（可重读）。我们可以通过SELECT @@tx_isolation;命令来查看

mysql> SELECT @@tx_isolation;
+-----------------+
| @@tx_isolation  |
+-----------------+
| REPEATABLE-READ |
+-----------------+
这里需要注意的是：与 SQL 标准不同的地方在于InnoDB 存储引擎在 **REPEATABLE-READ（可重读）事务隔离级别下使用的是Next-Key Lock 锁算法，因此可以避免幻读的产生，这与其他数据库系统(如 SQL Server)是不同的。所以说InnoDB 存储引擎的默认支持的隔离级别是 REPEATABLE-READ（可重读） 已经可以完全保证事务的隔离性要求，即达到了 SQL标准的SERIALIZABLE(可串行化)**隔离级别。

因为隔离级别越低，事务请求的锁越少，所以大部分数据库系统的隔离级别都是READ-COMMITTED(读取提交内容):，但是你要知道的是InnoDB 存储引擎默认使用 **REPEATABLE-READ（可重读）**并不会有任何性能损失。

InnoDB 存储引擎在 分布式事务 的情况下一般会用到**SERIALIZABLE(可串行化)**隔离级别。

实际情况演示
在下面我会使用 2 个命令行mysql ，模拟多线程（多事务）对同一份数据的脏读问题。

MySQL 命令行的默认配置中事务都是自动提交的，即执行SQL语句后就会马上执行 COMMIT 操作。如果要显式地开启一个事务需要使用命令：START TARNSACTION。

我们可以通过下面的命令来设置隔离级别。

SET [SESSION|GLOBAL] TRANSACTION ISOLATION LEVEL [READ UNCOMMITTED|READ COMMITTED|REPEATABLE READ|SERIALIZABLE]
我们再来看一下我们在下面实际操作中使用到的一些并发控制语句:

START TARNSACTION |BEGIN：显式地开启一个事务。
COMMIT：提交事务，使得对数据库做的所有修改成为永久性。
ROLLBACK：回滚会结束用户的事务，并撤销正在进行的所有未提交的修改。
```

```mysql
　事务是由一组SQL语句组成的逻辑处理单元，要么全部执行成功，要么全部执行不成功，例如银行汇款。Mysql中只有innodb和bdb类型（数据库引擎）的数据库才能支持事务处理。

　　事务处理可以确保非事务性单元的多个操作都能够完成，否则不会更新数据资源。

(1).事务的特性

　　1.原子性（atomicity）。一个事务（transaction）中的所有操作，要么全部完成，要么全部不完成，不会结束在中间某个环节。事务在执行过程中发生错误，会被回滚（Rollback）到事务开始前的状态，就像这个事务从来没有执行过一样。

　　2.一致性（consistency）。在事务开始之前和事务结束以后，数据库的完整性没有被破坏。这表示写入的资料必须完全符合所有的预设规则，这包含资料的精确度、串联性以及后续数据库可以自发性地完成预定的工作。

　　3.隔离性（isolation）。数据库允许多个并发事务同时对其数据进行读写和修改的能力，隔离性可以防止多个事务并发执行时由于交叉执行而导致数据的不一致。事务隔离分为不同级别，包括读未提交（Read uncommitted）、读提交（read committed）、可重复读（repeatable read）和串行化（Serializable）。

　　4.持久性（durability）。持久性也称永久性（permanence），指一个事务一旦提交，它对数据库中数据的改变就应该是永久性的。接下来的其他操作或故障不应该对其有任何影响。

　　这四个特性简称ACID。

(2).事务的实现

　　创建实验环境

mysql> create database test_db;
Query OK, 1 row affected (0.00 sec)
 
mysql> use test_db;
Database changed
mysql> create table user_tb(id int,name varchar(20));
Query OK, 0 rows affected (0.03 sec)
　　事务相关命令

set autocommit = {0|1};　　设置事务是否自动提交，0是禁止自动提交，1是开启自动提交。默认是自动提交。
begin;    开始事务。
start transaction;    开始事务，与begin;的作用一样。
savepoint [节点名称];    设置一个节点，可以配合rollback使用。一个事务可以有多个节点。
rollback [to 节点名];    返回到指定节点，如果不指定节点则返回上一个节点，最多返回到开始节点。
commit;    提交当前事务
　　在开始事务到提交事务或返回节点之间存在的SQL语句都是事务的一部分。但返回节点并不能结束事务。

　　事务的使用实例
mysql> begin;　　//开始一个事务
Query OK, 0 rows affected (0.00 sec)
 
mysql> insert into user_tb values(1,'张三');
Query OK, 1 row affected (0.00 sec)
 
mysql> select * from user_tb;
+------+--------+
| id   | name   |
+------+--------+
|    1 | 张三   |
+------+--------+
1 row in set (0.00 sec)
 
mysql> savepoint point1;　　//设置一个节点
Query OK, 0 rows affected (0.00 sec)
 
mysql> insert into user_tb values(2,'李四');
Query OK, 1 row affected (0.00 sec)
 
mysql> select * from user_tb;
+------+--------+
| id   | name   |
+------+--------+
|    1 | 张三   |
|    2 | 李四   |
+------+--------+
2 rows in set (0.00 sec)
 
mysql> rollback to point1;　　//回滚到节点point1
Query OK, 0 rows affected (0.00 sec)
 
mysql> select * from user_tb;　　//可以看到数据回到节点point1时了
+------+--------+
| id   | name   |
+------+--------+
|    1 | 张三   |
+------+--------+
1 row in set (0.00 sec)
 
mysql> rollback;　　//回滚到开始节点
Query OK, 0 rows affected (0.00 sec)
 
mysql> select * from user_tb;　　//查看是没有任何数据了
Empty set (0.00 sec)
 
mysql> rollback to point1;　　//再次尝试回滚到节点point1失败，说明point1节点已经被删除
ERROR 1305 (42000): SAVEPOINT point1 does not exist
 
mysql> insert into user_tb values(1,'王五');
Query OK, 1 row affected (0.00 sec)
 
mysql> select * from user_tb;
+------+--------+
| id   | name   |
+------+--------+
|    1 | 王五   |
+------+--------+
1 row in set (0.00 sec)
 
mysql> savepoint point1;
Query OK, 0 rows affected (0.00 sec)
 
mysql> insert into user_tb values(2,'赵六');
Query OK, 1 row affected (0.00 sec)
 
mysql> commit;　　//提交当前事务
Query OK, 0 rows affected (0.00 sec)
 
mysql> select * from user_tb;　　//可以看到节点对提交事务没有任何影响
+------+--------+
| id   | name   |
+------+--------+
|    1 | 王五   |
|    2 | 赵六   |
+------+--------+
2 rows in set (0.00 sec)
 
mysql> rollback;　　//尝试在事务外回滚
Query OK, 0 rows affected (0.00 sec)
 
mysql> select * from user_tb;　　//但实际并没有任何作用
+------+--------+
| id   | name   |
+------+--------+
|    1 | 王五   |
|    2 | 赵六   |
+------+--------+
2 rows in set (0.00 sec)
　　事务也可以一次写完提交，但需要修改结束字符，需要使用delimiter [新的字符]

　　注意：如果放回到设置的当前节点的上一个节点，那么当前节点就会被删除。但是返回到当前节点后继续向下操作，那么当前节点还可以使用。例如：一个事务存在开始节点、point1节点和point2节点，如果返回到了point1节点，那么point2节点就被删除无法使用；但是返回到point2节点后，向下操作，下次还可以返回到point2节点。
```

