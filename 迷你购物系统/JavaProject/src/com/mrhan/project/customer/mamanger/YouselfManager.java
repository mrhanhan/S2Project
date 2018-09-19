package com.mrhan.project.customer.mamanger;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.mrhan.project.databases.CustomerDataInfoDao;
import com.mrhan.project.databases.CustomerInfoDao;
import com.mrhan.project.databases.GoodsInfoDao;
import com.mrhan.project.databases.GoodsTypeDao;
import com.mrhan.project.databases.OrderGoodsInfoDao;
import com.mrhan.project.databases.OrderInfoDao;
import com.mrhan.project.databases.ShoppingDB;
import com.mrhan.project.moduls.CustomerDataInfo;
import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.moduls.OrderGoodsInfo;
import com.mrhan.project.moduls.OrderInfo;
import com.mrhan.project.moduls.ShopGoods;
import com.mrhan.project.services.ShoppingCar;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.UserLogin;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;

public class YouselfManager  extends Layout{

	private UserLogin login;//登陆对象
	
	private CustomerInfoDao cid ;
	private CustomerDataInfoDao cdid;
	private CustomerInfo customer;//登陆的客户
	public YouselfManager(UserLogin login) {
		this.login=login;
		customer=login.getCustomerInfo();
		cid = new CustomerInfoDao();
		cdid = new CustomerDataInfoDao();
		setTitle("个人中心");
	}

/**
 	* 加载方法
 */
	@Override
	protected void load() {
	super.load();
	
	fun();
	addView(new BackView());//添加返回功能
	addView(new ExitView());//添加退出功能
    }
	
	
	private void fun() {
		FunView fv =new FunView("显示详细信息");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					//cid.connectionSQLSERVERDB();
					cdid.connectionSQLSERVERDB();
					
					CustomerDataInfo cdi =cdid.getDate(customer.getId());
					if(cdi==null){
						addData();
						cdi =cdid.getDate(customer.getId());
					}
				
					show(cdi);
					
					//cid.close();
					cdid.close();
				}catch(SQLException se){
					
				}
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("修改密码");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					cdid.connectionSQLSERVERDB();
					
					CustomerDataInfo cdi =cdid.getDate(customer.getId());
				 if(iv.getYesNo("是否修改密码？修改完成后即将回到主页面,不会保留购物车信息!"))
				 {
					 String pwd="";
						do{
							pwd = iv.get("亲输入新的密码:");
							if(pwd.length()>6){
								outln("   密码长度需要大于6个字符!");
							}else{
								break;
							}
						}while(true);
						customer.setPwd(pwd);
						if(cid.updateData(customer)){
							out(3," ");outln("修改成功！即将回到主页面!");
							nowSelectView=getRootView();
						}
						else{
							out(3," ");outln("修改失败");
							
						}
						
				 }else{
					 out(3," ");outln("取消修改");
				 }
				 cdid.close();
				}catch(SQLException s){}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("修改收获地址");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					 cid.connectionSQLSERVERDB();
					 
					 if(iv.getYesNo("是否修改地址？"))
					 {
						 cdid.connectionSQLSERVERDB();
							
							CustomerDataInfo cdi =cdid.getDate(customer.getId());
							if(cdi==null){
								addData();
								cdi =cdid.getDate(customer.getId());
							}
							String add=iv.get("亲输入新的地址");
							 
								if(add.isEmpty()){
									out(3," ");outln("修改失败！地址不能为空");
								}else{
									cdi.setAddress(add);
									if(cdid.updateData(cdi)){
										out(3," ");outln("修改成功");
									}
									else{
										out(3," ");outln("修改失败");
										
									}
								}	
					 }else{
						 out(3," ");outln("取消修改");
					 }
					 cdid.close();
					}catch(SQLException s){}
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("修改邮箱");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					cid.connectionSQLSERVERDB();
					if(iv.getYesNo("是否修改邮箱？"))
					 {
						String em =iv.get("请输入新的邮箱地址：");
						if(emailOk(em)){
							customer.setEmail(em);
							if(cid.updateData(customer)){
								out(3," ");outln("修改成功");
							}else{
								out(3," ");outln("修改失败");
							}
						}else{
							out(3," ");outln("修改失败，邮箱不合法");
						}
					 }else{
						 out(3," ");outln("取消修改");
					 }
				}catch(SQLException s){
					
				}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		
		fv =new FunView("修改练习电话");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					 
					 
					 if(iv.getYesNo("是否修改地址？"))
					 {
						 cdid.connectionSQLSERVERDB();
							
							CustomerDataInfo cdi =cdid.getDate(customer.getId());
							if(cdi==null){
								addData();
								cdi =cdid.getDate(customer.getId());
							}
								String tel=iv.get("亲输入新的练习电话");
							 
								if(tel.length()==11 || tel.length()==8){
								
									out(3," ");outln("修改失败！电话号码长度为[8 | 11]个字符!");
								}else{
									cdi.setAddress(tel);
									if(cdid.updateData(cdi)){
										out(3," ");outln("修改成功");
									}
									else{
										out(3," ");outln("修改失败");
										
									}
								}	
					 }else{
						 out(3," ");outln("取消修改");
					 }
					 cdid.close();
					}catch(SQLException s){}
				nowSelectView.show();
			}
		});
		addView(fv);
		
		fv =new FunView("充值余额");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					cid.connectionSQLSERVERDB();
					float cz=0;
					
					try{
						cz =Float.parseFloat(iv.get("请输入充值的金额："));
					    if(cz<0)
					    {
					    	out(3," ");outln("充值失败 请输入正确的数据");
							cid.close();
							return;
					    }
					}catch(NumberFormatException eg){
						out(3," ");outln("充值失败 请输入正确的数据");
						cid.close();
						return;
					}
					customer.setBalance(customer.getBalance()+cz);
					if(cid.updateData(customer)){
						out(3," ");outln("充值成功");
					}
					else{
						out(3," ");outln("充值失败");
						
					}
					cid.close();
				}catch(SQLException s){
					
				}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("查看历史订单信息");
    	fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
					OrderInfoDao oid =new OrderInfoDao();
					OrderGoodsInfoDao ogid = new OrderGoodsInfoDao();
					CustomerInfoDao cid =new CustomerInfoDao();
					int id=0;
					
					CustomerInfo ci =customer;
					
						List<OrderInfo>  allorder =oid.getOldOrderInfos(ci);
						out(1,"\t");out("编号");
						out(2,"\t");out("客户账号");
						out(4,"\t");out("状态");
						out(2,"\t");outln("时间");
						for(OrderInfo oi : allorder){
							out(1,"\t");out(oi.getOrderId());
							out(2,"\t");out(oi.getCustomerInfo().getUsername());
							out(4,"\t");out(oi.isState()?"完成":"未完成");
							out(2,"\t");outln(sdf.format(oi.getOrderDate()));
							List<OrderGoodsInfo> allg =ogid.getOrderGoods(oi);
							out(3,"\t");out("编号");
							out(1,"\t");out("商品编号");
							out(3,"\t");out("商品类型名称");
							
							out(3,"\t");out("商品名称");
							out(3,"\t");out("商品价格");
							
							out(3,"\t");out("商品折扣");
							out(3,"\t");outln("购买数量");
							for(OrderGoodsInfo ogi : allg){
								out(3,"\t");out(ogi.getId());
								out(1,"\t");out(ogi.getGoodsInfo().getGoodId());
								out(3,"\t");out(ogi.getGoodsInfo().getGoodsType().getName());
								
								out(3,"\t");out(ogi.getGoodsInfo().getName());
								out(3,"\t");out(ogi.getGoodsInfo().getPrice());
								
								out(3,"\t");out(ogi.getGoodsInfo().getDiscount());
								out(3,"\t");outln(ogi.getNum());
							}
						}
					oid.close();
					cid.close();
					ogid.close();
				}catch(SQLException sq){}
				
				nowSelectView.show();
			}
		});
		addView(fv);
	
	}
	/**
	 * 显示个人信息
	 * @param cdi
	 */
	private void show(CustomerDataInfo cdi) {
		CustomerInfo cc =cdi.getCusInfo();
		out(1,"\t");out("编号:");out(1,"\t");outln(cdi.getCusInfo().getId()); 
		out(1,"\t");out("账号:");out(1,"\t");outln(cc.getUsername()); 
		out(1,"\t");out("密码:");out(1,"\t");outln(cc.getPwd()); 
		out(1,"\t");out("账户余额:");out(1,"\t");outln(cc.getBalance()); 
		out(1,"\t");out("账户积分:");out(1,"\t");outln(cc.getIntegral());
		out(1,"\t");out("邮箱:");out(1,"\t");outln(cc.getEmail());
		out(1,"\t");out("真实姓名:");out(1,"\t");outln(cdi.getName());
		out(1,"\t");out("练习方式:");out(1,"\t");outln(cdi.getMobileTelephone()+" "+cdi.getTelphone()); 
		out(1,"\t");out("地址:");out(1,"\t");outln(cdi.getAddress()); 
	}

	@Override
	protected void onselect(FlowView last) {
		super.onselect(last);
		show();
	}
	
	/**
	 * 添加详细信息
	 */
	private void addData(){
		outln("   您还没有详细信息!");
		CustomerDataInfo cdi;
		
		String name="";
		do{
			name = iv.get("亲输入姓名");
			if(name.length()>12){
				outln("   名字不能为空,[2-12个字符]!");
			}else{
				break;
			}
		}while(true);
		String tel="";
		do{
			tel = iv.get("亲输入电话号码");
			if(tel.length()==11 || tel.length()==8){
				outln("   电话号码长度为[8 | 11]个字符!");
			}else{
				break;
			}
		}while(true);
		String add="";
		do{
			add = iv.get("亲输入地址");
			if(add.isEmpty()){
				outln("   地址不能为空");
			}else{
				break;
			}
		}while(true);
		 cdi = new CustomerDataInfo(customer,name,tel,tel,add);
	
	    cdid.addDate(cdi);
	   
	}
	
	
	
	@Override
	public void show() {
		showPath();
		super.show();
		iv.selectView(this);
	}

}
