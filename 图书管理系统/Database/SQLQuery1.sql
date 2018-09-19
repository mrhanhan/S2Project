use master
go--使用系统数据库
--打开外围设备
exec sp_configure 'show advanced options',1
reconfigure 
exec sp_configure 'xp_cmdShell',1
reconfigure 
exec xp_cmdShell 'mkdir D:\Database\Books\',no_output
exec sp_configure 'xp_cmdShell',0
reconfigure 
exec sp_configure 'show advanced options',0
reconfigure 
--判断数据库是否存在

if DB_ID('BookDB') is not null
  drop database BookDB
go
--建库
create database BookDB
 on primary(
  name='BookDB',
  filename='D:\Database\Books\BookDB.mdf',
  size=3MB,
  maxSize=5MB,
  filegrowth=10%
 )
 log on (
  name='BookDBL',
  filename='D:\Database\Books\BookDB.ldf',
  size=1MB,
  maxSize=3MB,
  filegrowth=10%
 )
 go

use BookDB
go
--建表建约束
--用户表
create table UserInfo(
  uid int identity(100,1) constraint PK_UserInfo_uid primary key,--用户编号
  uName varchar(10) not null constraint QU_UserInfo_uName unique,--名称
  uPwd varchar(16) not null constraint CK_UserInfo_uPwd check(len(uPwd)>6),--密码
  uRegDate datetime constraint DF_UserInfo_uRegDate default Getdate()--注册时间
)
go
--图书类型表
create table BookTypeInfo(
 typeId int identity(1,1) constraint PK_BookTypeInfo_typeId primary key,--类型编号
 typeName varchar(20) not null constraint QU_BookTypeInfo_typeName unique,--类型名称
 remark varchar(200)--简介
)
go

--创建图书信息表

create table BookInfo(
 bookId int identity(1,1) constraint PK_BookInfo_bookId primary key,--图书编号
 bookName varchar(30) not null ,--图书编号
 typeId int constraint FK_BookInfo_typeId_BookTypeInfo_typeId 
         foreign key references BookTypeInfo(typeId),--图书编号，外键
 author varchar(30) not null,--作者
 press varchar(30) not null,--出版社
 pubDate datetime not null constraint DF_BookInfo_pubDate default getdate(),--出版时间
 price money not null,--价格
 page int not null,--页数
 imagePath varchar(200),--封面图片路径
 summary nvarchar(500) --简介
)
go

--
use BookDB
go
insert into BookTypeInfo Values('文学','中华文化的璀璨精华')
insert into BookTypeInfo Values('计算机','世界科技的未来')
go
insert into BookInfo Values('家',1,'冰心','华夏出版社','2004/1/2',65.0,652,'Z:\帮初学习\S2\项目\图书管理系统\Assets\images\index.jpg','斌')
insert into BookInfo Values('荷叶',1,'冰心','华夏出版社','2004/1/2',65.0,652,'Z:\帮初学习\S2\项目\图书管理系统\Assets\images\index.jpg','斌')


insert into BookInfo Values('Linux',2,'[美]埃里森','华夏出版社','2004/1/2',65.0,652,'Z:\帮初学习\S2\项目\图书管理系统\Assets\images\index.jpg','斌')
insert into BookInfo Values('数据结构',2,'[法]因陀罗','华夏出版社','2004/1/2',65.0,652,'Z:\帮初学习\S2\项目\图书管理系统\Assets\images\index.jpg','斌')

select * from BookInfo
select * from BookTypeInfo

select * from BookTypeInfo where typeName='文学'