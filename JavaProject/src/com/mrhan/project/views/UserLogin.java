package com.mrhan.project.views;

import com.mrhan.project.customer.mamanger.GameManager;
import com.mrhan.project.customer.mamanger.ShoppingCarManager;
import com.mrhan.project.customer.mamanger.ShoppingManager;
import com.mrhan.project.customer.mamanger.YouselfManager;
import com.mrhan.project.databases.CustomerInfoDao;
import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.services.ShoppingCar;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.Layout;

public class UserLogin extends Layout {
	
	private CustomerInfo customerInfo;
	private CustomerInfoDao cido ;
	private ShoppingCar shCar;//购物车
	public UserLogin() {
		setTitle("客户登陆");
		setShowCol(2);
		cido = new CustomerInfoDao();
	}
	@Override
	protected void onselect(FlowView last) {
		super.onselect(last);
		showPath();//显示功能路径
		login();//调用登陆函数
		/**
		 * 判断是否还是登陆失败！
		 */
		if(customerInfo==null){//退回主页面
			nowSelectView=last;
			nowSelectView.show();
		}else
		{	
			//创建购物车
		 shCar = new ShoppingCar(customerInfo);
		 //添加子视图
		 addView();
		 //显示
		 show();
		}
	}
	/**
	 * 重写显示的方法
	 */
	@Override
	public void show() {
	    showPath();
	    out(1,"SYSTEM>>");outln("你好 "+customerInfo.getUsername());
	    
		super.show();
		
		iv.selectView(this);
		
	}
	
	private void addView(){
		childViews.clear();
		selectViewKey.clear();
		this.addView(new ShoppingManager(this));
		this.addView(new YouselfManager(this));
		this.addView(new ShoppingCarManager(this));
		this.addView(new GameManager(this));
		this.addView(new BackView());
		this.addView(new ExitView());
	}
	
	/**
	 * 验证
	 */
	private void yz(){
		if(customerInfo==null){
			outln(40,"x");
			outln("账号或密码错误！");
			outln(40,"x");
			//判断是否继续登陆
			if(iv.getYesNo("是否继续登陆")){
				login();
			}else{
				outln("已返回主页面");
				outln(35,"_");
			}
		}
	}

	private void login() {
		iv.showLine();
		String name=iv.get("请输入登陆账号：");
		String pwd=iv.get("请输入登陆密码：");
		customerInfo=cido.getDate("username", "'"+name+"' and pwd = '"+pwd+"' ", false);
		iv.showLine();
		yz();
		
	}
	@Override
	public void _show() {
		out("   ");out(id+":"+title);
		
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public ShoppingCar getShCar() {
		return shCar;
	}



}
