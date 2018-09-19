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
	private CustomerDataInfoDao cusDataInfoDao;//�ͻ���ϸ��Ϣ������
	private CustomerInfoDao cusDao;//�ͻ���Ϣ������
	
	public CustomerManager() {
		setTitle("�ͻ�����");
		setShowCol(3);//����3����ʾ
		cusDao = new CustomerInfoDao();
		cusDataInfoDao = new CustomerDataInfoDao();
		
	}
	
	
	@Override
	protected void load() {
		super.load();
		
		viewFun();
		addView(new BackView());//�����ϼ�
		addView(new ExitView());//�˳�
	}
	
	/**
	 * ������ͼ����
	 */
	private void viewFun() {
		/**
		 * ��ѯ
		 */
		FunView fv =new FunView("��ѯ���пͻ�");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					
					//������
					cusDao .connectionSQLSERVERDB();
					List<CustomerInfo> allcus =cusDao.getAllData("");//��ȡ���пͻ�
					cusDao.close();//�ر�����
					int c=2;
					out(1,"\t");
					out("���");out(c,"\t");out("�˺�");
					out(c,"\t");out("�ʼ�");out(c,"\t");out("����");
					out(c,"\t");out("ע��ʱ��");out(c,"\t");out("���");out(c,"\t");outln("����");

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
		 fv =new FunView("ע��ͻ�");
			fv.setSe(new SelectEvent() {
				
				@Override
				public void select(FlowView last, FlowView now) {
					nowSelectView=last;
					try{
						
						//������
						cusDao .connectionSQLSERVERDB();
						String name = "";
						boolean isre=false;
						do{
							name=iv.get("�������û�����");
							isre=(name.isEmpty() || cusDao.getDate("username", name, true)!=null);
							if(isre){
								if(name.isEmpty()){
									out(3," ");outln("�û�������Ϊ��");
								}else{

									out(3," ");outln("�û����Ѿ���ʹ�ã�");
								}
							}
							
						}while(isre);
						String emial="";
						do{
							emial=iv.get("���������� ��");
							if(!emailOk(emial)){
								out(3," ");outln("�������䲻�Ϸ���");
							}
						}while(!emailOk(emial));
						String pwd="";
						do{
							pwd=iv.get("���������룺");
							if(pwd.length()<6){
								out(3," ");
								outln("���볤�ȱ������6λ");
							}
						}while(pwd.length()<6);
						CustomerInfo ci =new CustomerInfo(name, emial, pwd, new Date(),0, 0);
						
						if(cusDao.addDate(ci)){
							out(3," ");outln("["+name+"] �ͻ���ӳɹ���");
						}else{
							out(3," ");outln("["+name+"] �ͻ����ʧ�ܣ�");
						}
						cusDao.close();
					}catch(SQLException sqlException){
						
					}
					nowSelectView.show();
					
				}
			});
			addView(fv);
			fv =new FunView("��ѯ���пͻ�(��ϸ)");
			fv.setSe(new SelectEvent() {
				
				@Override
				public void select(FlowView last, FlowView now) {
					nowSelectView=last;
					try{
						
						//������
						cusDataInfoDao .connectionSQLSERVERDB();
						List<CustomerDataInfo> allcus =cusDataInfoDao.getAllData("");//��ȡ���пͻ�
						cusDataInfoDao.close();//�ر�����
						int c=2;
						out(1,"\t");
						out("���");out(c,"\t");out("�˺�");
						out(c,"\t");out("�ʼ�");out(c,"\t");out("����");
						out(c,"\t");out("ע��ʱ��");out(c,"\t");out("���");out(c,"\t");out("����");
						out(c,"\t");out("��ʵ����");
						out(c,"\t");out("��ϵ�绰");
						out(c+2,"\t");out("�ƶ��绰");
						out(c,"\t");outln("��ַ");SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd ");
						
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
			fv =new FunView("ɾ���ͻ�");
			fv.setSe(new SelectEvent() {
				
				@Override
				public void select(FlowView last, FlowView now) {
					nowSelectView=last;
					String id=iv.get("������ɾ���Ŀͻ����ƣ�");
					OrderInfoDao uid =new OrderInfoDao();
					OrderGoodsInfoDao ogid =new OrderGoodsInfoDao();
					try{
						cusDao.connectionSQLSERVERDB();
						cusDataInfoDao.connectionSQLSERVERDB();
						CustomerInfo ci =cusDao.getDate("username", id, true);
						if(ci!=null){
							CustomerDataInfo cdi = cusDataInfoDao.getDate(ci.getId());
							if(iv.getYesNo("�Ƿ�ɾ���û� ["+id+"] �Լ�����ͻ������ж�����Ϣ ?")){
								
								List<OrderInfo> all =uid.getOrderInfos(ci);
								for(OrderInfo ui : all){
									ogid.deleteData(ui);
									uid.deleteData(ui);
								}
								
								if(cdi!=null){
									cusDataInfoDao.deleteData(cdi);
								}
								if(cusDao.deleteData(ci)){
									out(3," ");out("ɾ�� �û� [");out(id);out("] �ɹ�");
									
								}else{
									out(3," ");out("ɾ�� �û� [");out(id);out("] ʧ��");
									
								}
							}
						}else{
							out(3," ");out("δ�ҵ� ����Ϊ[");out(id);out("]�ĺǻ�");
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
		//��ʵ����
		showPath();
		super.show();
		iv.selectView(this);//ѡ����
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
	 * ������ͼ��ѡ��ʱ����
	 */
	@Override
	protected void onselect(FlowView last) {
		this.show();
	}
	

}
