package com.mrhan.project.system.mamanger;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.mrhan.project.databases.CustomerDataInfoDao;
import com.mrhan.project.databases.CustomerInfoDao;
import com.mrhan.project.databases.OrderGoodsInfoDao;
import com.mrhan.project.databases.OrderInfoDao;
import com.mrhan.project.moduls.CustomerDataInfo;
import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.moduls.OrderInfo;
import com.mrhan.project.moduls.UserInfo;
import com.mrhan.project.services.UserLogin;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;

public class CustomerManager extends Layout implements UserLogin {
	
	private UserInfo userInfo;
	private CustomerDataInfoDao cusDataInfoDao;//客户详细信息操作类
	private CustomerInfoDao cusDao;//客户信息操作类
	
	public CustomerManager() {
		setTitle("客户管理");
		setShowCol(3);//设置3列显示
		cusDao = new CustomerInfoDao();
		cusDataInfoDao = new CustomerDataInfoDao();
		
	}
	
	
	@Override
	protected void load() {
		super.load();
		
		viewFun();
		addView(new BackView());//返回上级
		addView(new ExitView());//退出
	}
	
	/**
	 * 其他视图函数
	 */
	private void viewFun() {
		/**
		 * 查询
		 */
		FunView fv =new FunView("查询所有客户");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					
					//打开链接
					cusDao .connectionSQLSERVERDB();
					List<CustomerInfo> allcus =cusDao.getAllData("");//获取所有客户
					cusDao.close();//关闭连接
					int c=2;
					out(1,"\t");
					out("编号");out(c,"\t");out("账号");
					out(c,"\t");out("邮件");out(c,"\t");out("密码");
					out(c,"\t");out("注册时间");out(c,"\t");out("余额");out(c,"\t");outln("积分");

					SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd ");
					
					for(CustomerInfo ci : allcus){
						out(1,"\t");out(ci.getId());
						String a=ci.getUsername();
						out(c,"\t");out(a);
						out(c-a.length()/8,"\t");
						 a=ci.getEmail();
						out(a);
						
						out(c-a.length()/8,"\t");a=ci.getPwd();out(a);
						out(c-a.length()/8,"\t");a=sdf.format(ci.getRegDateTiem());out(a);
						out(c-a.length()/8,"\t");a=ci.getBalance()+"";out(a);
						out(c-a.length()/8,"\t");a=ci.getIntegral()+"";outln(a);
						
					
						
					}
					
				}catch(SQLException sqlException){
					
				}
				nowSelectView.show();
				
			}
		});
		addView(fv);
		 fv =new FunView("注册客户");
			fv.setSe(new SelectEvent() {
				
				@Override
				public void select(FlowView last, FlowView now) {
					nowSelectView=last;
					try{
						
						//打开链接
						cusDao .connectionSQLSERVERDB();
						String name = "";
						boolean isre=false;
						do{
							name=iv.get("请输入用户名：");
							isre=(name.isEmpty() || cusDao.getDate("username", name, true)!=null);
							if(isre){
								if(name.isEmpty()){
									out(3," ");outln("用户名不能为空");
								}else{

									out(3," ");outln("用户名已经被使用！");
								}
							}
							
						}while(isre);
						String emial="";
						do{
							emial=iv.get("请输入邮箱 ：");
							if(!emailOk(emial)){
								out(3," ");outln("输入邮箱不合法！");
							}
						}while(!emailOk(emial));
						String pwd="";
						do{
							pwd=iv.get("请输入密码：");
							if(pwd.length()<6){
								out(3," ");
								outln("密码长度必须大于6位");
							}
						}while(pwd.length()<6);
						CustomerInfo ci =new CustomerInfo(name, emial, pwd, new Date(),0, 0);
						
						if(cusDao.addDate(ci)){
							out(3," ");outln("["+name+"] 客户添加成功！");
						}else{
							out(3," ");outln("["+name+"] 客户添加失败！");
						}
						cusDao.close();
					}catch(SQLException sqlException){
						
					}
					nowSelectView.show();
					
				}
			});
			addView(fv);
			fv =new FunView("查询所有客户(详细)");
			fv.setSe(new SelectEvent() {
				
				@Override
				public void select(FlowView last, FlowView now) {
					nowSelectView=last;
					try{
						
						//打开链接
						cusDataInfoDao .connectionSQLSERVERDB();
						List<CustomerDataInfo> allcus =cusDataInfoDao.getAllData("");//获取所有客户
						cusDataInfoDao.close();//关闭连接
						int c=2;
						out(1,"\t");
						out("编号");out(c,"\t");out("账号");
						out(c,"\t");out("邮件");out(c,"\t");out("密码");
						out(c,"\t");out("注册时间");out(c,"\t");out("余额");out(c,"\t");out("积分");
						out(c,"\t");out("真实姓名");
						out(c,"\t");out("联系电话");
						out(c+2,"\t");out("移动电话");
						out(c,"\t");outln("地址");SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd ");
						
						for(CustomerDataInfo cid : allcus){
							CustomerInfo ci=cid.getCusInfo();
							out(1,"\t");out(ci.getId());
							String a=ci.getUsername();
							out(c,"\t");out(a);
							out(c-a.length()/8,"\t");
							 a=ci.getEmail();
							out(a);
							
							out(c-a.length()/8,"\t");a=ci.getPwd();out(a);
							out(c-a.length()/8,"\t");a=sdf.format(ci.getRegDateTiem());out(a);
							out(c-a.length()/8,"\t");a=ci.getBalance()+"";out(a);
							out(c-a.length()/8,"\t");a=ci.getIntegral()+"";out(a);
							out(c-a.length()/8,"\t");a=cid.getName();out(a);
							out(c-a.length()/8,"\t");a=cid.getTelphone();out(a);
							out(c-a.length()/8+2,"\t");a=cid.getMobileTelephone()+"";out(a);
							out(c-a.length()/8,"\t");outln(cid.getAddress());
						}
						
					}catch(SQLException sqlException){
						
					}finally{
						
					}
					nowSelectView.show();
					
				}
			});
			addView(fv);
			fv =new FunView("删除客户");
			fv.setSe(new SelectEvent() {
				
				@Override
				public void select(FlowView last, FlowView now) {
					nowSelectView=last;
					String id=iv.get("请输入删除的客户名称：");
					OrderInfoDao uid =new OrderInfoDao();
					OrderGoodsInfoDao ogid =new OrderGoodsInfoDao();
					try{
						cusDao.connectionSQLSERVERDB();
						cusDataInfoDao.connectionSQLSERVERDB();
						CustomerInfo ci =cusDao.getDate("username", id, true);
						if(ci!=null){
							CustomerDataInfo cdi = cusDataInfoDao.getDate(ci.getId());
							if(iv.getYesNo("是否删除用户 ["+id+"] 以及这个客户的所有订单信息 ?")){
								
								List<OrderInfo> all =uid.getOrderInfos(ci);
								for(OrderInfo ui : all){
									ogid.deleteData(ui);
									uid.deleteData(ui);
								}
								
								if(cdi!=null){
									cusDataInfoDao.deleteData(cdi);
								}
								if(cusDao.deleteData(ci)){
									out(3," ");out("删除 用户 [");out(id);out("] 成功");
									
								}else{
									out(3," ");out("删除 用户 [");out(id);out("] 失败");
									
								}
							}
						}else{
							out(3," ");out("未找到 名称为[");out(id);out("]的呵护");
						}
						ogid.close();
						uid.close();
						cusDao.close();
						cusDataInfoDao.close();
					}catch(SQLException sqle){
						
					}
					nowSelectView.show();
					
				}
			});
			addView(fv);
	}
	
	@Override
	public void show() {
		//现实功能
		showPath();
		super.show();
		iv.selectView(this);//选择功能
	}

	@Override
	public void setLoginUser(UserInfo ui) {
		userInfo=ui;
	}

	@Override
	public UserInfo getLoginUser() {
		
		return userInfo;
	}
	/**
	 * 当此视图被选中时调用
	 */
	@Override
	protected void onselect(FlowView last) {
		this.show();
	}
	

}
