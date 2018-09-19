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
 * ϵͳ�û���¼
 * @author MrHanHao
 *
 */
public class SysLogin extends Layout {
	
	
	private UserInfoManager uim;
	private CustomerManager cmv;//�ͻ�����
	
	private UserInfo loginUser;
	
	/**
	 * �û���Ϣ������
	 */
	private UserInfoDao uifd;
	/**
	 * �û���Ϣ
	 */
	
	
	public SysLogin() {
		uifd =new UserInfoDao();
		
		setShowCol(3);//����3����ʾ
	}
	
	
	@Override
	protected void load() {
		super.load();
		uim=new UserInfoManager();
		cmv=new CustomerManager();
		
		addView(uim);//����û�������
		addView(cmv);//
		addView(new GoodManager());//�����Ʒ����
		addView(new OrderManager());//��Ӷ�������
		addView(new BackView());//��ӷ��ع���
		addView(new ExitView());//����˳�����
	}
	
	@Override
	protected void onselect(FlowView last) {
		super.onselect(last);
		showPath();
		login();
		/**
		 * �ж��Ƿ��ǵ�½ʧ�ܣ�
		 */
		if(loginUser==null){//�˻���ҳ��
			nowSelectView=last;
			nowSelectView.show();
		}else
		{	
		uim.setLoginUser(loginUser);//�����û�
		cmv.setLoginUser(loginUser);
		 show();
		}
	}
	/**
	 * ��д��ʾ�ķ���
	 */
	@Override
	public void show() {
	    showPath();
		super.show();
		iv.selectView(this);
		
	}
	/**
	 * ��֤
	 */
	private void yz(){
		if(loginUser==null){
			outln(40,"x");
			outln("�˺Ż��������");
			outln(40,"x");
			//�ж��Ƿ������½
			if(iv.getYesNo("�Ƿ������½")){
				login();
			}else{
				outln("�ѷ�����ҳ��");
				outln(35,"_");
			}
		}
	}

	private void login() {
		iv.showLine();
		String name=iv.get("�������½�˺ţ�");
		String pwd=iv.get("�������½���룺");
		loginUser=uifd.getUserInfo(name, pwd);
		iv.showLine();
		yz();
		
	}
	@Override
	public void _show() {
		out("   ");out(id+":"+title);
	}


	
	
}
