package com.mrhan.project.views;

import com.mrhan.project.databases.UserInfoDao;
import com.mrhan.project.moduls.UserInfo;
import com.mrhan.project.services.UserLogin;
import com.mrhan.project.system.mamanger.CustomerManager;
import com.mrhan.project.system.mamanger.GoodManager;
import com.mrhan.project.system.mamanger.OrderManager;
import com.mrhan.project.system.mamanger.UserInfoManager;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.InputView;
import com.mrhan.project.views.base.Layout;

/**
 * 系统用户登录
 * @author MrHanHao
 *
 */
public class SysLogin extends Layout {
	
	
	private UserInfoManager uim;
	private CustomerManager cmv;//客户管理
	
	private UserInfo loginUser;
	
	/**
	 * 用户信息操作类
	 */
	private UserInfoDao uifd;
	/**
	 * 用户信息
	 */
	
	
	public SysLogin() {
		uifd =new UserInfoDao();
		
		setShowCol(3);//设置3列显示
	}
	
	
	@Override
	protected void load() {
		super.load();
		uim=new UserInfoManager();
		cmv=new CustomerManager();
		
		addView(uim);//添加用户管理功能
		addView(cmv);//
		addView(new GoodManager());//添加商品管理
		addView(new OrderManager());//添加订单管理
		addView(new BackView());//添加返回功能
		addView(new ExitView());//添加退出功能
	}
	
	@Override
	protected void onselect(FlowView last) {
		super.onselect(last);
		showPath();
		login();
		/**
		 * 判断是否还是登陆失败！
		 */
		if(loginUser==null){//退回主页面
			nowSelectView=last;
			nowSelectView.show();
		}else
		{	
		uim.setLoginUser(loginUser);//设置用户
		cmv.setLoginUser(loginUser);
		 show();
		}
	}
	/**
	 * 重写显示的方法
	 */
	@Override
	public void show() {
	    showPath();
		super.show();
		iv.selectView(this);
		
	}
	/**
	 * 验证
	 */
	private void yz(){
		if(loginUser==null){
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
		loginUser=uifd.getUserInfo(name, pwd);
		iv.showLine();
		yz();
		
	}
	@Override
	public void _show() {
		out("   ");out(id+":"+title);
	}


	
	
}
