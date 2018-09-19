package com.mrhan.project.views;

import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;
/**
 * �����棬�����й��ܵ����
 * @param msg
 */
public class Login extends Layout {
	
	public Login() {
		//iv=new InputView();
		setTitle("�ഺ����ϵͳ");
		
	}
	@Override
	protected void load() {
		SysLogin sys=new SysLogin();
		 sys.setTitle("ϵͳ��Ա��½");
		 
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
		out(35," ");outln(" ��ӭ�����ഺ����ϵͳ");
		outln(60, "*");
	}
	
}
