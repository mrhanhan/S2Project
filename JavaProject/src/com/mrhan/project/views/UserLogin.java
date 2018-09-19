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
	private ShoppingCar shCar;//���ﳵ
	public UserLogin() {
		setTitle("�ͻ���½");
		setShowCol(2);
		cido = new CustomerInfoDao();
	}
	@Override
	protected void onselect(FlowView last) {
		super.onselect(last);
		showPath();//��ʾ����·��
		login();//���õ�½����
		/**
		 * �ж��Ƿ��ǵ�½ʧ�ܣ�
		 */
		if(customerInfo==null){//�˻���ҳ��
			nowSelectView=last;
			nowSelectView.show();
		}else
		{	
			//�������ﳵ
		 shCar = new ShoppingCar(customerInfo);
		 //�������ͼ
		 addView();
		 //��ʾ
		 show();
		}
	}
	/**
	 * ��д��ʾ�ķ���
	 */
	@Override
	public void show() {
	    showPath();
	    out(1,"SYSTEM>>");outln("��� "+customerInfo.getUsername());
	    
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
	 * ��֤
	 */
	private void yz(){
		if(customerInfo==null){
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
