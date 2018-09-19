package com.mrhan.project.views;

import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;
/**
 * 主界面，所有有功能的入口
 * @param msg
 */
public class Login extends Layout {
	
	public Login() {
		//iv=new InputView();
		setTitle("青春购物系统");
		
	}
	@Override
	protected void load() {
		SysLogin sys=new SysLogin();
		 sys.setTitle("系统人员登陆");
		 
		 this.addView(sys);
		 this.addView(new UserLogin());
		
		 this.addView(new ExitView());
	}
	@Override
	public void show() {
		_show();
		super.show();
		iv.selectView(this);
		
	}
	@Override
	public void _show(){
		
		outln(60, "*");
		out(35," ");outln(" 欢迎来到青春购物系统");
		outln(60, "*");
	}
	
}
