use master
go
--�׶�2 ���� ���� ��Լ?�ӹ�?
--������
exec sp_configure 'show advanced options',1
reconfigure
exec sp_configure 'xp_cmdshell',1
reconfigure
go
exec xp_cmdshell 'mkdir C:\QLZX'
go
--�ر�
exec sp_configure 'xp_cmdshell',0
reconfigure
exec sp_configure 'show advanced options',0
reconfigure
go
if DB_ID('ShoppingDB') is not null
  drop database ShoppingDB
go
create database ShoppingDB
	on primary(
		name='ShoppingDB',
		filename='C:\QLZX\ShoppingDB.mdf',
		filegrowth=10%,
		size=3MB
)
	log on(
        name='ShoppingDB_log',
		filename='C:\QLZX\ShoppingDB_log.ldf',
		filegrowth=10%,
		size=3MB
)
go
use ShoppingDB
go
--�����û���Ϣ?
create table UserInfo(
	id int   identity(1,1) constraint PK_UserInfo_if primary key ,--�û���ţ���?
	userName varchar(50) not null constraint UQ_UserInfo_userName unique,--�û����� Ψһ?
	userPwd varchar(50) not null constraint CK_UserInfo_userPwd check (len(userPwd)>=6)--�û����룬��?
)
go
--����������Ϣ?
create table BulletinInfo(
    id int identity(1,1) constraint PK_BulletinInfo_id primary key ,--�����ţ���?
    title varchar(100) not null,--�������⣬��?
    content text not null ,--�������ݣ���?
    userId int ,--���淢���ߣ����
    createTime datetime not null constraint DF_BulletinInfo_cerateTime default getdate()--����ʱ��=
)
go
--�����ͻ���Ϣ?
create table CustomerInfo(
    id int  identity(1000,1) constraint PK_CustomerInfo_id primary key ,--�ͻ���ţ���?
    username varchar(10) not null,
    email varchar(30) constraint UQ_CostomerInfo_email unique 
                       constraint CK_CustomerInfo_email check (email like '%_@_%._%'),--�������䣬@?ǰ������з�?
    pwd varchar(20) not null constraint CK_CUstomer_pwd check (len(pwd)>=6),--�˿�����
    registerTime datetime not null constraint DF_Customer_refisterTime default getdate(),--ע��ʱ��   
    balance float constraint CK_CustomerInfo_balance check(balance>=0) ,--���
    integral int constraint CK_CustomerInfo_integral check(integral>=0)
    
)
go
--�����ͻ���ϸ��Ϣ?
create table CustomerDataInfo(
    customerId int not null constraint FK_CustomerDataInfo_customerId foreign key references CustomerInfo(id),--�ͻ����
    name varchar (50) not null,--�ջ�����?
    telphone varchar(20) not null constraint CK_CustomerDataInfo_telPhone check (telPhone like '____-_______'),--�̶��绰
    mobileTelephone varchar(11) not null constraint CK_CustomerDataInfo_mobileTelephone check (len(mobileTelephone)=11),--�ƶ��绰
    address varchar(100) not null--�ջ���ַ
)
go
--������Ʒ���?
create table GoodsType(
    typeId int identity(1,1) constraint PK_GoodsType_typeId primary key,--���ͱ�ţ���?
    typeName varchar(20) not null constraint UQ_GoodsType_typeName unique--��Ʒ���� 
)
go
--������Ʒ��Ϣ?
create table GoodsInfo(
    goodsId int identity(1,1) constraint PK_GoodsInfo_goodsid primary key,--��Ʒ���
    typeId int constraint FK_GoodsInfo_typeId foreign key references GoodsType(typeId),--��Ʒ���ͱ��
    goodsName varchar(50) not null,--��Ʒ����
    price decimal(8,2) not null,--��Ʒ�۸�
   
    discount float constraint CK_GoodsInfo_discount check(discount between 0.0 and 10.0) 
    			   constraint DF_GoodsInfo_discount default 10.0,--�ۿ�
    isNew int not null constraint CK_GoodsInfo_isNew check(isNew in (0,1)),--�Ƿ�����?
    isRecommend int not null constraint CK_GoodsInfo_isRecommend check(isRecommend in (0,1)),--�Ƿ��Ƽ�
    status int  not null constraint CK_GoodsInfo_status check(status in (0,1)),--��Ʒ״?
    photo varchar(50) ,--��ƷͼƬ
    remark varchar(200),--��ע
    num int--�ִ���
)
go
--����������Ϣ?
create table OrderInfo(
    orderId int identity(1,1) constraint PK_OrderInfo_orderId primary key,--�������
    customerId int constraint FK_OrderInfo_customerId foreign key references CustomerInfo(id),--��Ʒ���
    status int  not null constraint CK_OrderInfo_status check(status in (0,1)),--����״?
    orderTime datetime not null constraint DF_OrderInfo_orderTime default getdate()--�µ�ʱ��
)
go 
--����������Ʒ��Ϣ?
create table OrderGoodsInfo(
  id int identity(1,1),--���
  orderId int not null,--�������
  goodsId int not null,--��Ʒ���
  quantity int  not null constraint CK_OrderGoodsInf0_quantity check(quantity>0) 
                         constraint DF_OrderGoodsInfo_quantity default 1 --��Ʒ����
)
go
--�����������
alter table OrderGoodsInfo 
   add constraint PK_OrderGoodsInfo_id primary key(id)
go
--��������
--�����û�����
insert into UserInfo Values('admin','123456')
insert into UserInfo Values('zhangsan','123456')
insert into UserInfo Values('lisi','123456')
go
--���빫����Ϣ
insert into BulletinInfo Values('��������-�������1','��������-��������1',1,'2009-07-22 10:25:08.800')
insert into BulletinInfo Values('��������-�������2','��������-��������2',1,'2009-07-22 10:25:08.800')
insert into BulletinInfo Values('��������-�������3','��������-��������3',1,'2009-07-22 10:25:08.800')
insert into BulletinInfo Values('��������-�������4','��������-��������4',1,'2009-07-22 10:25:08.800')
insert into BulletinInfo Values('��������-�������5','��������-��������5',1,'2009-07-22 10:25:08.800')
insert into BulletinInfo Values('��������-�������6','��������-��������6',1,'2009-07-22 10:25:08.800')
insert into BulletinInfo Values('��������-�������7','��������-��������7',1,'2009-07-22 10:25:08.800')
go
--����ͻ���Ϣ
insert into CustomerInfo Values('4455','a@sina.com','123456','2009-06-06 12:30:45',0,0)
insert into CustomerInfo Values('5566','b@sina.com','123456','2009-06-07 12:30:15',0,0)
insert into CustomerInfo Values('6677','c@sina.com','123456','2009-06-08 12:30:25',0,0)
insert into CustomerInfo Values('7788','d@sina.com','123456','2009-06-09 12:30:35',0,0)
go
--����ͻ���ϸ��Ϣ
insert into CustomerDataInfo Values(1001,'����','3241-5622275','13685697453','����������������·1��')
insert into CustomerDataInfo Values(1002,'����','3241-5622275','13685697453','����������������·3��')
insert into CustomerDataInfo Values(1003,'����','3241-5622275','13685697453','����������������·2��')
go
--������Ʒ����
insert into GoodsType Values('ҰӪ����')
insert into GoodsType Values('˯������')
insert into GoodsType Values('��������')
insert into GoodsType Values('�˶��ֱ�')
insert into GoodsType Values('ҰӪ��Ʒ')
insert into GoodsType Values('��ɽ��������')
insert into GoodsType Values('�����װ')
go
insert into GoodsInfo Values(1,'ND-1182 ˫��˫����',498,1,1,1,0,'zangpeng2t2','˫��˫������',100)
insert into GoodsInfo Values(1,'ND-1133 ����������',256,1,0,1,0,'zangpeng2t2','������������',100)
insert into GoodsInfo Values(1,'ND-1132 ��������',296,1,1,0,0,'zangpeng2t2','��������',100)
insert into GoodsInfo Values(1,'ND-1136 ����˫����',438,1,0,1,0,'zangpeng2t2','����˫������',100)
insert into GoodsInfo Values(1,'ND-1121 ����ɴ������',680,1,1,0,0,'zangpeng2t2','����ɴ������',100)

insert into GoodsInfo Values(1,'MOBI GARDEN ���ߵ�����',642,1,1,0,0,'zangpeng2t2','˫���Զ���������',100)
insert into GoodsInfo Values(1,'����˫����������',846,1,1,1,0,'zangpeng2t2','˫���Զ���������',100)
insert into GoodsInfo Values(1,'��ɽ����˫����������',957,1,1,1,0,'zangpeng2t2','˫���Զ���������',100)
insert into GoodsInfo Values(1,'ɽ������˫����������',654,0.67,0,0,0,'zangpeng2t2','˫���Զ���������',100)

insert into GoodsInfo Values(2,'ND-1327 ����˫��˯��',198,0.85,1,1,0,'zangpeng2t2','ҰӪϵ��',100)
insert into GoodsInfo Values(2,'ND-1255L �ŷ�˯��',146,0.95,0,1,0,'zangpeng2t2','ҰӪϵ��',100)
insert into GoodsInfo Values(2,'ND-1202 ��������˯��',296,0.67,1,0,0,'zangpeng2t2','ҰӪϵ��',100)
insert into GoodsInfo Values(2,'���Ʊȶ�˹ 500˯��',438,1,0,1,0,'zangpeng2t2','ҰӪϵ��',100)
insert into GoodsInfo Values(2,'ND-1202 ��������˯��',296,0.67,1,0,0,'zangpeng2t2','ҰӪϵ��',100)
insert into GoodsInfo values(2,'CHAMONIX334SOFT˯��','186.00',1.0,1,1,0,'shui','ҰӪϵ��',100)
insert into GoodsInfo values(2,'CHAMONIX265��С˯��','267.00',1.0,'1','0','0','shui','ҰӪϵ��',100)
insert into GoodsInfo values(2,'highrocks106107','467.00','0.65','1','0','0','shui','ҰӪϵ��',100)
insert into GoodsInfo values(2,'highrocks4543ө���','456.00','0.88','1','0','0','shui','ҰӪϵ��',100)
insert into GoodsInfo values(3,'featherf4005ľ','198.00','0.85','1','1','0','zuoy','ҰӪϵ��',100)
insert into GoodsInfo values(3,'featherf4007��ɫ','146.00','0.95','0','0','0','zuoy','ҰӪϵ��',100)
insert into GoodsInfo values(4,'MAINNAV950DM ��..','298.00','0.85','1','1','0','biao','ҰӪϵ��',100)
insert into GoodsInfo values(4,'MAINNAV950D GPS��','286.00','1','1','1','0','biao','ҰӪϵ��',100)
insert into GoodsInfo values(4,'SUUNTO D6 Ǳˮϵ��','358.00','0.85','1','1','0','biao','ҰӪϵ��',100)
insert into GoodsInfo values(4,'SUUNTOt3c black...','434.00','0.95','0','1','0','biao','ҰӪϵ��',100)
insert into GoodsInfo values(4,'SUUNTOT3C black..','499.00','0.85','1','1','0','biao','ҰӪϵ��',100)
insert into GoodsInfo values(4,'����֮��A77���ʱ�','564.00','0.95','0','1','0','biao','ҰӪϵ��',100)
insert into GoodsInfo values(4,'����֮�Ǹ߾��ȱ�','532.00','1','1','0','0','biao','ʱ��ϵ��',100)
insert into GoodsInfo values(4,'�߶Ⱦ���','342.00','1','0','1','0','biao','ʱ��ϵ��',100)
insert into GoodsInfo values(5,'ND-8629����������xl','198.00','0.85','1','1','0','bao1.jpg','60L-80L',100)
insert into GoodsInfo values(5,'ND-8627����������M','186.00','1','0','1','0','bao2.jpg','25L-40L',100)
insert into GoodsInfo values(5,'ND-8626����������s','99.00','1','1','1','0','bao3.jpg','25L����',100)
insert into GoodsInfo values(5,'ND-2129С�ſ��','121.00','0.95','0','1','0','kuab','ҰӪϵ��',100)
insert into GoodsInfo values(5,'ND-2125����','43.00','1','1','0','0','yaob','ҰӪϵ��',100)
insert into GoodsInfo values(5,'ND-3211����','34.00','0.95','0','1','0','yaob','ҰӪϵ��',100)
insert into GoodsInfo values(5,'ND-3210���Ȱ�','59.00','0.95','0','1','0','jiji','ҰӪϵ��',100)
insert into GoodsInfo values(5,'ND-����','55.00','0.95','0','0','0','mao','ҰӪϵ��',100)
insert into GoodsInfo values(5,'featherf201 ����ɡ','532.00','1','1','1','0','zhey','����ɡ',100)
insert into GoodsInfo values(5,'ND-3565 3+5LED ͷ��','89.00','1','0','1','0','tou','ͷ��',100)
insert into GoodsInfo values(5,'ND-3566 2+1xͷ��','68.00','1','1','1','0','tou','ͷ��',100)
insert into GoodsInfo values(5,'ND-3565 3+5LEDͷ��','92.00','0.65','0','1','0','tou','ͷ��',100)
insert into GoodsInfo values(5,'ND-3613 1X�ֵ磨u40)','55.00','1','1','0','0','shou','�ֵ�',100)
insert into GoodsInfo values(5,'ND-3612 3LED�ֵ�','58.00','1','0','1','0','shou','�ֵ�',100)
insert into GoodsInfo values(5,'D-3611 1X�ֵ�','34.00','0.77','0','1','0','shou','�ֵ�',100) 
insert into GoodsInfo values(6,'Edelrid1781 000','158.00','0.85','1','1','0','xiaj','mini 8 fig',100)
insert into GoodsInfo values(6,'Edelrid1772 138','186.00','1','0','1','0','xiaj','petit 8',100)
insert into GoodsInfo values(6,'Edelrid1813 153','68.00','1','1','1','0','zhus','��ɽϵ��',100)
insert into GoodsInfo values(6,'Edelrid1813 213','84.00','0.95','0','1','0','zhus','��ɽϵ��',100)
insert into GoodsInfo values(6,'Edelrid1813 234','99.00','0.35','1','1','0','zhus','��ɽϵ��',100)
insert into GoodsInfo values(7,'snowwolfŮ���','298.00','0.85','1','1','0','yi1.jpg','minni 8 fig',100)
insert into GoodsInfo values(7,'snowwolf�п��','286.00','1','0','1','0','yi2.jpg','petit 8',100)
insert into GoodsInfo values(7,'snowwolfŮ����','358.00','1','1','1','0','yi3.jpg','ҰӪϵ��',100)
insert into GoodsInfo values(7,'garmont zephyr4','265.00','0.95','0','1','0','xie2.jpg','ҰӪϵ��',100)
insert into GoodsInfo values(7,'gamont zephye5','258.00','0.85','1','1','0','xie3.jpg','ҰӪϵ��',100)
insert into GoodsInfo values(7,'gamont sncro','199.00','1','1','1','0','xie4.jpg','ҰӪϵ��',100)
go
insert into  orderinfo   values(1001,0,'2009-07-22 10:25:08')
insert into  orderinfo   values(1002,0,'2009-07-22 10:25:08')           
insert into  orderinfo   values(1003,'0','2009-07-22 10:25:08')
go
insert into orderGoodsInfo values('1','44','10')
insert into orderGoodsInfo values('1','46','16')
insert into orderGoodsInfo values('1','47','1')
insert into orderGoodsInfo values('1','48','1')
insert into orderGoodsInfo values('1','53','1')
insert into orderGoodsInfo values(2,'8',2)
insert into orderGoodsInfo values(2,'14','1')
insert into orderGoodsInfo values(2,'15','1')
insert into orderGoodsInfo values(2,'16','1')
insert into orderGoodsInfo values(2,'18','1')
                 
insert into orderGoodsInfo values(2,'19','1')
insert into orderGoodsInfo values(2,'20','1')
insert into orderGoodsInfo values(2,'25','1')
insert into orderGoodsInfo values(2,'41','1')
insert into orderGoodsInfo values(2,'43','1')
               
insert into orderGoodsInfo values(2,'50','1')
insert into orderGoodsInfo values(2,'51','1')
insert into orderGoodsInfo values(2,'52','1')
insert into orderGoodsInfo values(2,'53',4)
insert into orderGoodsInfo values(2,'54',3) 
insert into orderGoodsInfo values(3,'9','1')
insert into orderGoodsInfo values(3,'26','1')
insert into orderGoodsInfo values(3,'40',2)
insert into orderGoodsInfo values(3,'42','1')


--����׶�
--�洢���̣�������ѯ�����ݶ�����źͿͻ��˺ź����䣬ģ����ѯ
if exists (select * from sysobjects where name='proc_queryOrderInfo')
   drop procedure proc_queryOrderInfo
 go
 create procedure proc_queryOrderInfo
 @orderText varchar(50)
 as
   begin
   declare @sql varchar(200)
   if @orderText =''
     begin
       select * from OrderInfo
       return
     end
   set @sql = 'select * from OrderInfo as a inner join   CustomerInfo as b
    on a.customerId = b.id  inner join  CustomerDataInfo as c on b.id=c.customerId
      where a.orderId like ''%'+@orderText+'%'' or b.email like ''%'+@orderText+'%'' 
       or c.name like ''%'+@orderText+'%'''
     --  print @sql
      execute(@sql)  
   end
 go
 
-- execute proc_queryOrderInfo '3'
--�����׶� ��������
--�µ�����
 if exists (select * from sysobjects where name='proc_insertOrder')
    drop procedure proc_insertOrder
   go
  create procedure proc_insertOrder
   @acc varchar(50),--�µ��˺�
   @goodsId int ,--��Ʒ���
   @num int--��������
   as
     begin
        begin transaction --��ʼ����
        declare @iserr int --�Ƿ����
        set @iserr=0
        --��ѯ�ͻ����
        declare @userId int
        select @userId = id from CustomerInfo where email=@acc
        if not @@ERROR<>0
          set @iserr=1
         --��������
        insert into OrderInfo Values(@userId,0,GETDATE())
        if @@ERROR<>0 
          set @iserr=1
        --���빺�����Ʒ
        declare @oid int
        set @oid =@@IDENTITY--��ȡ֮ǰ����ı��
        insert into OrderGoodsInfo Values(@oid,@goodsId,@num)
        if @@ERROR<>0 
          set @iserr=1
        if @iserr=0
         begin
           print '�µ��ɹ�'
           commit transaction
         end
        else
         begin
          print '�µ�ʧ��'
           rollback transaction
         end
     end
   go
     if exists (select * from sys.indexes where name = 'index_orderInfo')
       drop index OrderInfo.index_orderInfo
      go
      
      create nonclustered index index_orderInfo
       on OrderInfo(customerId)
      with 
       fillfactor=70
      go
      
       if exists (select * from sys.views where name = 'view_a')
       drop view view_a
      go
      create view view_a
      as
       select a.customerId '���',a.name '����',a.telphone '�̶��绰',a.mobileTelephone '�ƶ��绰',b.email '�����ʼ�',a.address '��ַ' from CustomerDataInfo as a inner join CustomerInfo as b on a.customerId=b.id
       go
       --����������
       if exists (select * from sys.triggers where name = 'trg_dele')
       drop trigger trg_dele
      go
       create trigger trg_dele
        on CustomerInfo
        instead of  delete
        as 
         begin
          declare @cs int 
          select @cs = id from deleted
          if (exists (select * from CustomerDataInfo where customerId =@cs) or 
              exists(select * from OrderInfo where customerId =@cs)  
           )begin
           print '�޷�ɾ��'
           rollback transaction
           end
           else
            delete CustomerInfo where id=@cs
         end
        go
      
       
       
      use ShoppingDB
      
      
      select * from UserInfo
      select * from BulletinInfo
      select * from CustomerInfo
      select * from CustomerDataInfo