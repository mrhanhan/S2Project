use master
go
--阶段2 建库 建表 加约?加关?
--打开外设
exec sp_configure 'show advanced options',1
reconfigure
exec sp_configure 'xp_cmdshell',1
reconfigure
go
exec xp_cmdshell 'mkdir C:\QLZX'
go
--关闭
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
--创建用户信息?
create table UserInfo(
	id int   identity(1,1) constraint PK_UserInfo_if primary key ,--用户编号，主?
	userName varchar(50) not null constraint UQ_UserInfo_userName unique,--用户名字 唯一?
	userPwd varchar(50) not null constraint CK_UserInfo_userPwd check (len(userPwd)>=6)--用户密码，非?
)
go
--创建公告信息?
create table BulletinInfo(
    id int identity(1,1) constraint PK_BulletinInfo_id primary key ,--公告编号，主?
    title varchar(100) not null,--公共标题，非?
    content text not null ,--公告内容，非?
    userId int ,--公告发布者，外键
    createTime datetime not null constraint DF_BulletinInfo_cerateTime default getdate()--发布时间=
)
go
--创建客户信息?
create table CustomerInfo(
    id int  identity(1000,1) constraint PK_CustomerInfo_id primary key ,--客户编号，主?
    username varchar(10) not null,
    email varchar(30) constraint UQ_CostomerInfo_email unique 
                       constraint CK_CustomerInfo_email check (email like '%_@_%._%'),--电子邮箱，@?前后必须有符?
    pwd varchar(20) not null constraint CK_CUstomer_pwd check (len(pwd)>=6),--顾客密码
    registerTime datetime not null constraint DF_Customer_refisterTime default getdate(),--注册时间   
    balance float constraint CK_CustomerInfo_balance check(balance>=0) ,--余额
    integral int constraint CK_CustomerInfo_integral check(integral>=0)
    
)
go
--创建客户详细信息?
create table CustomerDataInfo(
    customerId int not null constraint FK_CustomerDataInfo_customerId foreign key references CustomerInfo(id),--客户编号
    name varchar (50) not null,--收货人姓?
    telphone varchar(20) not null constraint CK_CustomerDataInfo_telPhone check (telPhone like '____-_______'),--固定电话
    mobileTelephone varchar(11) not null constraint CK_CustomerDataInfo_mobileTelephone check (len(mobileTelephone)=11),--移动电话
    address varchar(100) not null--收货地址
)
go
--创建商品类别?
create table GoodsType(
    typeId int identity(1,1) constraint PK_GoodsType_typeId primary key,--类型编号，主?
    typeName varchar(20) not null constraint UQ_GoodsType_typeName unique--商品名称 
)
go
--创建商品信息?
create table GoodsInfo(
    goodsId int identity(1,1) constraint PK_GoodsInfo_goodsid primary key,--商品编号
    typeId int constraint FK_GoodsInfo_typeId foreign key references GoodsType(typeId),--商品类型编号
    goodsName varchar(50) not null,--商品名称
    price decimal(8,2) not null,--商品价格
   
    discount float constraint CK_GoodsInfo_discount check(discount between 0.0 and 10.0) 
    			   constraint DF_GoodsInfo_discount default 10.0,--折扣
    isNew int not null constraint CK_GoodsInfo_isNew check(isNew in (0,1)),--是否是新?
    isRecommend int not null constraint CK_GoodsInfo_isRecommend check(isRecommend in (0,1)),--是否推荐
    status int  not null constraint CK_GoodsInfo_status check(status in (0,1)),--商品状?
    photo varchar(50) ,--商品图片
    remark varchar(200),--备注
    num int--现存量
)
go
--创建订单信息?
create table OrderInfo(
    orderId int identity(1,1) constraint PK_OrderInfo_orderId primary key,--订单编号
    customerId int constraint FK_OrderInfo_customerId foreign key references CustomerInfo(id),--产品编号
    status int  not null constraint CK_OrderInfo_status check(status in (0,1)),--订单状?
    orderTime datetime not null constraint DF_OrderInfo_orderTime default getdate()--下单时间
)
go 
--创建订单产品信息?
create table OrderGoodsInfo(
  id int identity(1,1),--编号
  orderId int not null,--订单编号
  goodsId int not null,--产品编号
  quantity int  not null constraint CK_OrderGoodsInf0_quantity check(quantity>0) 
                         constraint DF_OrderGoodsInfo_quantity default 1 --商品数量
)
go
--添加联合主键
alter table OrderGoodsInfo 
   add constraint PK_OrderGoodsInfo_id primary key(id)
go
--插入数据
--插入用户数据
insert into UserInfo Values('admin','123456')
insert into UserInfo Values('zhangsan','123456')
insert into UserInfo Values('lisi','123456')
go
--插入公共信息
insert into BulletinInfo Values('测试数据-公告标题1','测试数据-公告内容1',1,'2009-07-22 10:25:08.800')
insert into BulletinInfo Values('测试数据-公告标题2','测试数据-公告内容2',1,'2009-07-22 10:25:08.800')
insert into BulletinInfo Values('测试数据-公告标题3','测试数据-公告内容3',1,'2009-07-22 10:25:08.800')
insert into BulletinInfo Values('测试数据-公告标题4','测试数据-公告内容4',1,'2009-07-22 10:25:08.800')
insert into BulletinInfo Values('测试数据-公告标题5','测试数据-公告内容5',1,'2009-07-22 10:25:08.800')
insert into BulletinInfo Values('测试数据-公告标题6','测试数据-公告内容6',1,'2009-07-22 10:25:08.800')
insert into BulletinInfo Values('测试数据-公告标题7','测试数据-公告内容7',1,'2009-07-22 10:25:08.800')
go
--插入客户信息
insert into CustomerInfo Values('4455','a@sina.com','123456','2009-06-06 12:30:45',0,0)
insert into CustomerInfo Values('5566','b@sina.com','123456','2009-06-07 12:30:15',0,0)
insert into CustomerInfo Values('6677','c@sina.com','123456','2009-06-08 12:30:25',0,0)
insert into CustomerInfo Values('7788','d@sina.com','123456','2009-06-09 12:30:35',0,0)
go
--插入客户详细信息
insert into CustomerDataInfo Values(1001,'张三','3241-5622275','13685697453','重庆市万州区本国路1号')
insert into CustomerDataInfo Values(1002,'李四','3241-5622275','13685697453','重庆市万州区本国路3号')
insert into CustomerDataInfo Values(1003,'王五','3241-5622275','13685697453','重庆市万州区本国路2号')
go
--插入商品类型
insert into GoodsType Values('野营帐篷')
insert into GoodsType Values('睡袋垫子')
insert into GoodsType Values('户外座椅')
insert into GoodsType Values('运动手表')
insert into GoodsType Values('野营用品')
insert into GoodsType Values('登山攀岩器材')
insert into GoodsType Values('户外服装')
go
insert into GoodsInfo Values(1,'ND-1182 双人双层帐',498,1,1,1,0,'zangpeng2t2','双人双层帐篷',100)
insert into GoodsInfo Values(1,'ND-1133 三人两门帐',256,1,0,1,0,'zangpeng2t2','三人两门帐篷',100)
insert into GoodsInfo Values(1,'ND-1132 三人帐篷',296,1,1,0,0,'zangpeng2t2','三人帐篷',100)
insert into GoodsInfo Values(1,'ND-1136 四人双层帐',438,1,0,1,0,'zangpeng2t2','四人双层帐篷',100)
insert into GoodsInfo Values(1,'ND-1121 六角纱网帐篷',680,1,1,0,0,'zangpeng2t2','六角纱网帐篷',100)

insert into GoodsInfo Values(1,'MOBI GARDEN 牧高迪帐篷',642,1,1,0,0,'zangpeng2t2','双层自动两秒帐篷',100)
insert into GoodsInfo Values(1,'多人双层铝杆帐篷',846,1,1,1,0,'zangpeng2t2','双层自动两秒帐篷',100)
insert into GoodsInfo Values(1,'冷山三人双层铝杆帐篷',957,1,1,1,0,'zangpeng2t2','双层自动两秒帐篷',100)
insert into GoodsInfo Values(1,'山赖三人双层铝杆帐篷',654,0.67,0,0,0,'zangpeng2t2','双层自动两秒帐篷',100)

insert into GoodsInfo Values(2,'ND-1327 蛋巢双人睡袋',198,0.85,1,1,0,'zangpeng2t2','野营系列',100)
insert into GoodsInfo Values(2,'ND-1255L 信封睡袋',146,0.95,0,1,0,'zangpeng2t2','野营系列',100)
insert into GoodsInfo Values(2,'ND-1202 羽绒妈咪睡袋',296,0.67,1,0,0,'zangpeng2t2','野营系列',100)
insert into GoodsInfo Values(2,'艾菲比尔斯 500睡袋',438,1,0,1,0,'zangpeng2t2','野营系列',100)
insert into GoodsInfo Values(2,'ND-1202 羽绒妈咪睡袋',296,0.67,1,0,0,'zangpeng2t2','野营系列',100)
insert into GoodsInfo values(2,'CHAMONIX334SOFT睡袋','186.00',1.0,1,1,0,'shui','野营系列',100)
insert into GoodsInfo values(2,'CHAMONIX265超小睡袋','267.00',1.0,'1','0','0','shui','野营系列',100)
insert into GoodsInfo values(2,'highrocks106107','467.00','0.65','1','0','0','shui','野营系列',100)
insert into GoodsInfo values(2,'highrocks4543萤火虫','456.00','0.88','1','0','0','shui','野营系列',100)
insert into GoodsInfo values(3,'featherf4005木','198.00','0.85','1','1','0','zuoy','野营系列',100)
insert into GoodsInfo values(3,'featherf4007蓝色','146.00','0.95','0','0','0','zuoy','野营系列',100)
insert into GoodsInfo values(4,'MAINNAV950DM 高..','298.00','0.85','1','1','0','biao','野营系列',100)
insert into GoodsInfo values(4,'MAINNAV950D GPS户','286.00','1','1','1','0','biao','野营系列',100)
insert into GoodsInfo values(4,'SUUNTO D6 潜水系列','358.00','0.85','1','1','0','biao','野营系列',100)
insert into GoodsInfo values(4,'SUUNTOt3c black...','434.00','0.95','0','1','0','biao','野营系列',100)
insert into GoodsInfo values(4,'SUUNTOT3C black..','499.00','0.85','1','1','0','biao','野营系列',100)
insert into GoodsInfo values(4,'驱动之星A77心率表','564.00','0.95','0','1','0','biao','野营系列',100)
insert into GoodsInfo values(4,'风尚之星高精度表','532.00','1','1','0','0','biao','时尚系列',100)
insert into GoodsInfo values(4,'高度精表','342.00','1','0','1','0','biao','时尚系列',100)
insert into GoodsInfo values(5,'ND-8629背包防雨罩xl','198.00','0.85','1','1','0','bao1.jpg','60L-80L',100)
insert into GoodsInfo values(5,'ND-8627背包防雨罩M','186.00','1','0','1','0','bao2.jpg','25L-40L',100)
insert into GoodsInfo values(5,'ND-8626背包防雨罩s','99.00','1','1','1','0','bao3.jpg','25L以下',100)
insert into GoodsInfo values(5,'ND-2129小号挎包','121.00','0.95','0','1','0','kuab','野营系列',100)
insert into GoodsInfo values(5,'ND-2125腰包','43.00','1','1','0','0','yaob','野营系列',100)
insert into GoodsInfo values(5,'ND-3211腰包','34.00','0.95','0','1','0','yaob','野营系列',100)
insert into GoodsInfo values(5,'ND-3210急救包','59.00','0.95','0','1','0','jiji','野营系列',100)
insert into GoodsInfo values(5,'ND-护脖','55.00','0.95','0','0','0','mao','野营系列',100)
insert into GoodsInfo values(5,'featherf201 遮阳伞','532.00','1','1','1','0','zhey','遮阳伞',100)
insert into GoodsInfo values(5,'ND-3565 3+5LED 头灯','89.00','1','0','1','0','tou','头灯',100)
insert into GoodsInfo values(5,'ND-3566 2+1x头灯','68.00','1','1','1','0','tou','头灯',100)
insert into GoodsInfo values(5,'ND-3565 3+5LED头灯','92.00','0.65','0','1','0','tou','头灯',100)
insert into GoodsInfo values(5,'ND-3613 1X手电（u40)','55.00','1','1','0','0','shou','手电',100)
insert into GoodsInfo values(5,'ND-3612 3LED手电','58.00','1','0','1','0','shou','手电',100)
insert into GoodsInfo values(5,'D-3611 1X手电','34.00','0.77','0','1','0','shou','手电',100) 
insert into GoodsInfo values(6,'Edelrid1781 000','158.00','0.85','1','1','0','xiaj','mini 8 fig',100)
insert into GoodsInfo values(6,'Edelrid1772 138','186.00','1','0','1','0','xiaj','petit 8',100)
insert into GoodsInfo values(6,'Edelrid1813 153','68.00','1','1','1','0','zhus','登山系列',100)
insert into GoodsInfo values(6,'Edelrid1813 213','84.00','0.95','0','1','0','zhus','登山系列',100)
insert into GoodsInfo values(6,'Edelrid1813 234','99.00','0.35','1','1','0','zhus','登山系列',100)
insert into GoodsInfo values(7,'snowwolf女款步行','298.00','0.85','1','1','0','yi1.jpg','minni 8 fig',100)
insert into GoodsInfo values(7,'snowwolf男款步行','286.00','1','0','1','0','yi2.jpg','petit 8',100)
insert into GoodsInfo values(7,'snowwolf女款衣','358.00','1','1','1','0','yi3.jpg','野营系列',100)
insert into GoodsInfo values(7,'garmont zephyr4','265.00','0.95','0','1','0','xie2.jpg','野营系列',100)
insert into GoodsInfo values(7,'gamont zephye5','258.00','0.85','1','1','0','xie3.jpg','野营系列',100)
insert into GoodsInfo values(7,'gamont sncro','199.00','1','1','1','0','xie4.jpg','野营系列',100)
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


--第五阶段
--存储过程，订单查询，根据订单编号和客户账号和邮箱，模糊查询
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
--第六阶段 创建事务
--下单事务
 if exists (select * from sysobjects where name='proc_insertOrder')
    drop procedure proc_insertOrder
   go
  create procedure proc_insertOrder
   @acc varchar(50),--下单账号
   @goodsId int ,--商品编号
   @num int--购买数量
   as
     begin
        begin transaction --开始事务
        declare @iserr int --是否出错
        set @iserr=0
        --查询客户编号
        declare @userId int
        select @userId = id from CustomerInfo where email=@acc
        if not @@ERROR<>0
          set @iserr=1
         --插入数据
        insert into OrderInfo Values(@userId,0,GETDATE())
        if @@ERROR<>0 
          set @iserr=1
        --插入购入的商品
        declare @oid int
        set @oid =@@IDENTITY--获取之前插入的编号
        insert into OrderGoodsInfo Values(@oid,@goodsId,@num)
        if @@ERROR<>0 
          set @iserr=1
        if @iserr=0
         begin
           print '下单成功'
           commit transaction
         end
        else
         begin
          print '下单失败'
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
       select a.customerId '编号',a.name '名字',a.telphone '固定电话',a.mobileTelephone '移动电话',b.email '电子邮件',a.address '地址' from CustomerDataInfo as a inner join CustomerInfo as b on a.customerId=b.id
       go
       --创建触发器
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
           print '无法删除'
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