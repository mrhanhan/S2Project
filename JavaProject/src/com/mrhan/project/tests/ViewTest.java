package com.mrhan.project.tests;

import com.mrhan.project.views.Login;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.InputView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;


public class ViewTest {

	public static void main(String[] args) {
		test2();
	}
	
	private static void test2() {
		Login l =new Login();
		l.show();
	}

	static void test1(){InputView iv =new InputView();
		
		
	 Layout l=	new Layout();
	 l.setTitle("主界面");;
	 FunView fv=new FunView();
	 fv.setTitle("登陆");
	 l.addView(fv);
	 fv=new FunView();
	 fv.setTitle("注册");
	 l.addView(fv);
	 fv=new FunView();
	 fv.setTitle("退出");
	 fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			now.showPath();
			System.out.println("即将退出...");
			System.exit(0);
			
		}
	});
	 l.addView(fv);
	 l.setShowCol(2);
	 l.show();
	 iv.selectView(l);
	 
	}

}
