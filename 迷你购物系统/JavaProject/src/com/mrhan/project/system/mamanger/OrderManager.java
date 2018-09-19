package com.mrhan.project.system.mamanger;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.mrhan.project.databases.CustomerInfoDao;
import com.mrhan.project.databases.GoodsInfoDao;
import com.mrhan.project.databases.OrderGoodsInfoDao;
import com.mrhan.project.databases.OrderInfoDao;
import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.OrderGoodsInfo;
import com.mrhan.project.moduls.OrderInfo;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;
/**
 * ������Ϣ����
 * @author MrHanHao
 *
 */
public class OrderManager extends Layout {
	private OrderInfoDao oid;
	private OrderGoodsInfoDao ogid;
	private SimpleDateFormat sdf ;
	public OrderManager() {
		setShowCol(4);
		setTitle("��������");
		sdf =new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		oid =new OrderInfoDao();
		ogid = new OrderGoodsInfoDao();
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
		FunView fv =new FunView("�鿴���ж���");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					oid.connectionSQLSERVERDB();
					List<OrderInfo>  allorder =oid.getAllData("");
					out(1,"\t");out("���");
					out(2,"\t");out("�ͻ��˺�");
					out(4,"\t");out("״̬");
					out(2,"\t");outln("ʱ��");
					for(OrderInfo oi : allorder){
						out(1,"\t");out(oi.getOrderId());
						out(2,"\t");out(oi.getCustomerInfo().getUsername());
						out(4,"\t");out(oi.isState()?"���":"δ���");
						//out(2,"\t");outln(oi.getOrderDate());
						out(2,"\t");outln(sdf.format(oi.getOrderDate()));
					}
					oid.close();
				}catch(SQLException sq){}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("�鿴ָ����Ŷ���");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					oid.connectionSQLSERVERDB();
					int id=0;
					try{
						id =Integer.parseInt(iv.get("�����붩����ţ�"));
					}catch(NumberFormatException nfe){
						out(3,"");out("���������֣�");
						oid.close();
						return; 
					}
					OrderInfo oi =oid.getDate(id);
					out(1,"\t");out("���");
					out(2,"\t");out("�ͻ��˺�");
					out(4,"\t");out("״̬");
					out(2,"\t");outln("ʱ��");
					if(oi!=null){
						out(1,"\t");out(oi.getOrderId());
						out(2,"\t");out(oi.getCustomerInfo().getUsername());
						out(4,"\t");out(oi.isState()?"���":"δ���");
						out(2,"\t");outln(sdf.format(oi.getOrderDate()));
					}else{
						out(3,"");out("δ�ҵ��˶���["+id+"]");
					}
					oid.close();
				}catch(SQLException sq){}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("�鿴��Ʒ�������");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				GoodsInfoDao gifd =new GoodsInfoDao();
				try{
					oid.connectionSQLSERVERDB();
					ogid.connectionSQLSERVERDB();
					
					List<GoodsInfo> allg =gifd.getAllData("");
					out(1,"\t");out("��Ʒ���");
					out(3,"\t");out("��Ʒ��������");
					out(3,"\t");out("��Ʒ����");
					out(3,"\t");out("��Ʒ�۸�");
					out(3,"\t");out("��Ʒ�ۿ�");
					out(3,"\t");outln("��������");
					for(GoodsInfo gi : allg){
						int size=ogid.getOrderGoodsByGoods(gi).size();//��ȡ��ǰ��Ʒ�Ķ�������
					  if(size>0){
						out(1,"\t");out(gi.getGoodId());
						out(3,"\t");out(gi.getGoodsType().getName());
						out(3,"\t");out(gi.getName());
						out(3,"\t");out(gi.getPrice());
						out(3,"\t");out(gi.getDiscount());
						out(3,"\t");outln(size);
					  }
					}
					gifd.close();
					oid.close();
					ogid.close();
					
				}catch(SQLException sql){}
				
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("�鿴ָ����������Ʒ");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					oid.connectionSQLSERVERDB();
					ogid.connectionSQLSERVERDB();
					int id=0;
					try{
						id =Integer.parseInt(iv.get("�����붩����ţ�"));
					}catch(NumberFormatException nfe){
						out(3,"");out("���������֣�");
						oid.close();
						return; 
					}
					OrderInfo oi =oid.getDate(id);
					out(1,"\t");out("���");
					out(2,"\t");out("�ͻ��˺�");
					
					out(1,"\t");out("��Ʒ���");
					out(3,"\t");out("��Ʒ��������");
					
					out(3,"\t");out("��Ʒ����");
					out(3,"\t");out("��Ʒ�۸�");
					
					out(3,"\t");out("��Ʒ�ۿ�");
					out(3,"\t");outln("��������");
					if(oi!=null){
						List<OrderGoodsInfo> allgos =ogid.getOrderGoods(oi);
						for(OrderGoodsInfo ogi : allgos){
							out(1,"\t");out(ogi.getId());
							out(2,"\t");out(ogi.getOrderInfo().getCustomerInfo().getUsername());
							out(1,"\t");out(ogi.getGoodsInfo().getGoodId());
							out(3,"\t");out(ogi.getGoodsInfo().getGoodsType().getName());
							out(3,"\t");out(ogi.getGoodsInfo().getName());
							out(3,"\t");out(ogi.getGoodsInfo().getPrice());
							
							out(3,"\t");out(ogi.getGoodsInfo().getDiscount());
							out(3,"\t");outln(ogi.getNum());
						}
					}else{
						out(3,"");outln("δ�ҵ��˶���["+id+"]");
					}
					ogid.close();
					oid.close();
				}catch(SQLException sq){}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("�鿴ָ���ͻ��Ķ�����Ϣ");
    	fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					oid.connectionSQLSERVERDB();
					ogid.connectionSQLSERVERDB();
					CustomerInfoDao cid =new CustomerInfoDao();
					int id=0;
					try{
						id =Integer.parseInt(iv.get("����ͻ���ţ�"));
					}catch(NumberFormatException nfe){
						out(3,"");out("���������֣�");
						cid.close();
						oid.close();
						ogid.close();
						return; 
					}
					CustomerInfo ci =cid.getDate(id);
					if(ci==null){
						out(3,"");outln("δ�ҵ��˿ͻ�["+id+"]");
					}else{
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
					}
					oid.close();
					cid.close();
					ogid.close();
				}catch(SQLException sq){}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		
		fv =new FunView("ɾ��ָ���ͻ��Ķ���");
        fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				CustomerInfoDao cid =new CustomerInfoDao();
				try{
					oid.connectionSQLSERVERDB();
					ogid.connectionSQLSERVERDB();
					
					int id=0;
					try{
						id =Integer.parseInt(iv.get("������ͻ���ţ�"));
					}catch(NumberFormatException nfe){
						out(3,"");outln("���������֣�");
						cid.close();
						oid.close();
						ogid.close();
						return; 
					}
					CustomerInfo ci =cid.getDate(id);
					if(ci==null){
						out(3,"");out("δ�ҵ��˿ͻ�["+id+"]");
					}else{
						if(iv.getYesNo("�Ƿ�ɾ�� �ͻ� ["+id+"]���еĶ�����")){
							List<OrderInfo> os = oid.getNewOrderInfos(ci);
							for(OrderInfo o : os){
								ogid.deleteData(o);
								oid.deleteData(o);
							}
							out(3,"");outln("ɾ���ɹ�");
						}else{
							out(3,"");outln("ɾ��ʧ�ܣ�ȡ��ɾ��");
						}
						
					}
					cid.close();
					oid.close();
					ogid.close();
				}catch(SQLException s){};
				
			}});
		addView(fv);
		fv =new FunView("ɾ��ָ����ŵĶ���");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				try{
					oid.connectionSQLSERVERDB();
					ogid.connectionSQLSERVERDB();
					int id=0;
					try{
						id =Integer.parseInt(iv.get("�����붩����ţ�"));
					}catch(NumberFormatException nfe){
						out(3,"");outln("���������֣�");
						oid.close();
						return; 
					}
					OrderInfo oi =oid.getDate(id);
					if(oi==null){
						out(3,"");outln("δ�ҵ��˶���["+id+"]");
					}else{
						if(iv.getYesNo("�Ƿ�ɾ������["+id+"]��Ϣ")){
							ogid.deleteData(oi);
							oid.deleteData(oi);
							out(3,"");outln("ɾ���ɹ�");
						}else{
							out(3,"");outln("ɾ��ʧ�ܣ�ȡ��ɾ��");
						}
					}
					oid.close();
					ogid.close();
				}catch(SQLException s){}
				
			}
		});
		addView(fv);
		
	}
	
	
	@Override
	protected void onselect(FlowView last) {
		super.onselect(last);
		show();
	}
	@Override
	public void show() {
		showPath();
		super.show();
		iv.selectView(this);
	}
}
