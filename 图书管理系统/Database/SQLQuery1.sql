use master
go--ʹ��ϵͳ���ݿ�
--����Χ�豸
exec sp_configure 'show advanced options',1
reconfigure 
exec sp_configure 'xp_cmdShell',1
reconfigure 
exec xp_cmdShell 'mkdir D:\Database\Books\',no_output
exec sp_configure 'xp_cmdShell',0
reconfigure 
exec sp_configure 'show advanced options',0
reconfigure 
--�ж����ݿ��Ƿ����

if DB_ID('BookDB') is not null
  drop database BookDB
go
--����
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
--����Լ��
--�û���
create table UserInfo(
  uid int identity(100,1) constraint PK_UserInfo_uid primary key,--�û����
  uName varchar(10) not null constraint QU_UserInfo_uName unique,--����
  uPwd varchar(16) not null constraint CK_UserInfo_uPwd check(len(uPwd)>6),--����
  uRegDate datetime constraint DF_UserInfo_uRegDate default Getdate()--ע��ʱ��
)
go
--ͼ�����ͱ�
create table BookTypeInfo(
 typeId int identity(1,1) constraint PK_BookTypeInfo_typeId primary key,--���ͱ��
 typeName varchar(20) not null constraint QU_BookTypeInfo_typeName unique,--��������
 remark varchar(200)--���
)
go

--����ͼ����Ϣ��

create table BookInfo(
 bookId int identity(1,1) constraint PK_BookInfo_bookId primary key,--ͼ����
 bookName varchar(30) not null ,--ͼ����
 typeId int constraint FK_BookInfo_typeId_BookTypeInfo_typeId 
         foreign key references BookTypeInfo(typeId),--ͼ���ţ����
 author varchar(30) not null,--����
 press varchar(30) not null,--������
 pubDate datetime not null constraint DF_BookInfo_pubDate default getdate(),--����ʱ��
 price money not null,--�۸�
 page int not null,--ҳ��
 imagePath varchar(200),--����ͼƬ·��
 summary nvarchar(500) --���
)
go

--
use BookDB
go
insert into BookTypeInfo Values('��ѧ','�л��Ļ����貾���')
insert into BookTypeInfo Values('�����','����Ƽ���δ��')
go
insert into BookInfo Values('��',1,'����','���ĳ�����','2004/1/2',65.0,652,'Z:\���ѧϰ\S2\��Ŀ\ͼ�����ϵͳ\Assets\images\index.jpg','��')
insert into BookInfo Values('��Ҷ',1,'����','���ĳ�����','2004/1/2',65.0,652,'Z:\���ѧϰ\S2\��Ŀ\ͼ�����ϵͳ\Assets\images\index.jpg','��')


insert into BookInfo Values('Linux',2,'[��]����ɭ','���ĳ�����','2004/1/2',65.0,652,'Z:\���ѧϰ\S2\��Ŀ\ͼ�����ϵͳ\Assets\images\index.jpg','��')
insert into BookInfo Values('���ݽṹ',2,'[��]������','���ĳ�����','2004/1/2',65.0,652,'Z:\���ѧϰ\S2\��Ŀ\ͼ�����ϵͳ\Assets\images\index.jpg','��')

select * from BookInfo
select * from BookTypeInfo

select * from BookTypeInfo where typeName='��ѧ'