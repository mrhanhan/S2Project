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

	private UserLogin login;//��½����
	
	private CustomerInfoDao cid ;
	private CustomerDataInfoDao cdid;
	private CustomerInfo customer;//��½�Ŀͻ�
	public YouselfManager(UserLogin login) {
		this.login=login;
		customer=login.getCustomerInfo();
		cid = new CustomerInfoDao();
		cdid = new CustomerDataInfoDao();
		setTitle("��������");
	}

/**
 	* ���ط���
 */
	@Override
	protected void load() {
	super.load();
	
	fun();
	addView(new BackView());//��ӷ��ع���
	addView(new ExitView());//����˳�����
    }
	
	
	private void fun() {
		FunView fv =new FunView("��ʾ��ϸ��Ϣ");
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
		fv =new FunView("�޸�����");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					cdid.connectionSQLSERVERDB();
					
					CustomerDataInfo cdi =cdid.getDate(customer.getId());
				 if(iv.getYesNo("�Ƿ��޸����룿�޸���ɺ󼴽��ص���ҳ��,���ᱣ�����ﳵ��Ϣ!"))
				 {
					 String pwd="";
						do{
							pwd = iv.get("�������µ�����:");
							if(pwd.length()>6){
								outln("   ���볤����Ҫ����6���ַ�!");
							}else{
								break;
							}
						}while(true);
						customer.setPwd(pwd);
						if(cid.updateData(customer)){
							out(3," ");outln("�޸ĳɹ��������ص���ҳ��!");
							nowSelectView=getRootView();
						}
						else{
							out(3," ");outln("�޸�ʧ��");
							
						}
						
				 }else{
					 out(3," ");outln("ȡ���޸�");
				 }
				 cdid.close();
				}catch(SQLException s){}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("�޸��ջ��ַ");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					 cid.connectionSQLSERVERDB();
					 
					 if(iv.getYesNo("�Ƿ��޸ĵ�ַ��"))
					 {
						 cdid.connectionSQLSERVERDB();
							
							CustomerDataInfo cdi =cdid.getDate(customer.getId());
							if(cdi==null){
								addData();
								cdi =cdid.getDate(customer.getId());
							}
							String add=iv.get("�������µĵ�ַ");
							 
								if(add.isEmpty()){
									out(3," ");outln("�޸�ʧ�ܣ���ַ����Ϊ��");
								}else{
									cdi.setAddress(add);
									if(cdid.updateData(cdi)){
										out(3," ");outln("�޸ĳɹ�");
									}
									else{
										out(3," ");outln("�޸�ʧ��");
										
									}
								}	
					 }else{
						 out(3," ");outln("ȡ���޸�");
					 }
					 cdid.close();
					}catch(SQLException s){}
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("�޸�����");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					cid.connectionSQLSERVERDB();
					if(iv.getYesNo("�Ƿ��޸����䣿"))
					 {
						String em =iv.get("�������µ������ַ��");
						if(emailOk(em)){
							customer.setEmail(em);
							if(cid.updateData(customer)){
								out(3," ");outln("�޸ĳɹ�");
							}else{
								out(3," ");outln("�޸�ʧ��");
							}
						}else{
							out(3," ");outln("�޸�ʧ�ܣ����䲻�Ϸ�");
						}
					 }else{
						 out(3," ");outln("ȡ���޸�");
					 }
				}catch(SQLException s){
					
				}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		
		fv =new FunView("�޸���ϰ�绰");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					 
					 
					 if(iv.getYesNo("�Ƿ��޸ĵ�ַ��"))
					 {
						 cdid.connectionSQLSERVERDB();
							
							CustomerDataInfo cdi =cdid.getDate(customer.getId());
							if(cdi==null){
								addData();
								cdi =cdid.getDate(customer.getId());
							}
								String tel=iv.get("�������µ���ϰ�绰");
							 
								if(tel.length()==11 || tel.length()==8){
								
									out(3," ");outln("�޸�ʧ�ܣ��绰���볤��Ϊ[8 | 11]���ַ�!");
								}else{
									cdi.setAddress(tel);
									if(cdid.updateData(cdi)){
										out(3," ");outln("�޸ĳɹ�");
									}
									else{
										out(3," ");outln("�޸�ʧ��");
										
									}
								}	
					 }else{
						 out(3," ");outln("ȡ���޸�");
					 }
					 cdid.close();
					}catch(SQLException s){}
				nowSelectView.show();
			}
		});
		addView(fv);
		
		fv =new FunView("��ֵ���");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					cid.connectionSQLSERVERDB();
					float cz=0;
					
					try{
						cz =Float.parseFloat(iv.get("�������ֵ�Ľ�"));
					    if(cz<0)
					    {
					    	out(3," ");outln("��ֵʧ�� ��������ȷ������");
							cid.close();
							return;
					    }
					}catch(NumberFormatException eg){
						out(3," ");outln("��ֵʧ�� ��������ȷ������");
						cid.close();
						return;
					}
					customer.setBalance(customer.getBalance()+cz);
					if(cid.updateData(customer)){
						out(3," ");outln("��ֵ�ɹ�");
					}
					else{
						out(3," ");outln("��ֵʧ��");
						
					}
					cid.close();
				}catch(SQLException s){
					
				}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("�鿴��ʷ������Ϣ");
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
						out(1,"\t");out("���");
						out(2,"\t");out("�ͻ��˺�");
						out(4,"\t");out("״̬");
						out(2,"\t");outln("ʱ��");
						for(OrderInfo oi : allorder){
							out(1,"\t");out(oi.getOrderId());
							out(2,"\t");out(oi.getCustomerInfo().getUsername());
							out(4,"\t");out(oi.isState()?"���":"δ���");
							out(2,"\t");outln(sdf.format(oi.getOrderDate()));
							List<OrderGoodsInfo> allg =ogid.getOrderGoods(oi);
							out(3,"\t");out("���");
							out(1,"\t");out("��Ʒ���");
							out(3,"\t");out("��Ʒ��������");
							
							out(3,"\t");out("��Ʒ����");
							out(3,"\t");out("��Ʒ�۸�");
							
							out(3,"\t");out("��Ʒ�ۿ�");
							out(3,"\t");outln("��������");
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
	 * ��ʾ������Ϣ
	 * @param cdi
	 */
	private void show(CustomerDataInfo cdi) {
		CustomerInfo cc =cdi.getCusInfo();
		out(1,"\t");out("���:");out(1,"\t");outln(cdi.getCusInfo().getId()); 
		out(1,"\t");out("�˺�:");out(1,"\t");outln(cc.getUsername()); 
		out(1,"\t");out("����:");out(1,"\t");outln(cc.getPwd()); 
		out(1,"\t");out("�˻����:");out(1,"\t");outln(cc.getBalance()); 
		out(1,"\t");out("�˻�����:");out(1,"\t");outln(cc.getIntegral());
		out(1,"\t");out("����:");out(1,"\t");outln(cc.getEmail());
		out(1,"\t");out("��ʵ����:");out(1,"\t");outln(cdi.getName());
		out(1,"\t");out("��ϰ��ʽ:");out(1,"\t");outln(cdi.getMobileTelephone()+" "+cdi.getTelphone()); 
		out(1,"\t");out("��ַ:");out(1,"\t");outln(cdi.getAddress()); 
	}

	@Override
	protected void onselect(FlowView last) {
		super.onselect(last);
		show();
	}
	
	/**
	 * �����ϸ��Ϣ
	 */
	private void addData(){
		outln("   ����û����ϸ��Ϣ!");
		CustomerDataInfo cdi;
		
		String name="";
		do{
			name = iv.get("����������");
			if(name.length()>12){
				outln("   ���ֲ���Ϊ��,[2-12���ַ�]!");
			}else{
				break;
			}
		}while(true);
		String tel="";
		do{
			tel = iv.get("������绰����");
			if(tel.length()==11 || tel.length()==8){
				outln("   �绰���볤��Ϊ[8 | 11]���ַ�!");
			}else{
				break;
			}
		}while(true);
		String add="";
		do{
			add = iv.get("�������ַ");
			if(add.isEmpty()){
				outln("   ��ַ����Ϊ��");
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
