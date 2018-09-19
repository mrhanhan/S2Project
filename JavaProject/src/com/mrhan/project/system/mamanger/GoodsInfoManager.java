package com.mrhan.project.system.mamanger;

import java.sql.SQLException;
import java.util.List;

import com.mrhan.project.databases.GoodsInfoDao;
import com.mrhan.project.databases.GoodsTypeDao;
import com.mrhan.project.databases.OrderGoodsInfoDao;
import com.mrhan.project.databases.OrderInfoDao;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.GoodsType;
import com.mrhan.project.moduls.OrderGoodsInfo;
import com.mrhan.project.moduls.OrderInfo;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;

public class GoodsInfoManager extends Layout{
	private GoodsTypeDao gtd ;//��Ʒ���͹���
	private GoodsInfoDao gifd;//��Ʒ��Ϣ����
	public GoodsInfoManager() {
		// TODO Auto-generated constructor stub
		setShowCol(4);
	setTitle("��Ʒ��Ϣ����");
	gtd = new GoodsTypeDao();
	gifd = new GoodsInfoDao();
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
	
	FunView fv = new FunView("�鿴�������ͼ���Ʒ");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					gtd.connectionSQLSERVERDB();
					gifd.connectionSQLSERVERDB();
					List<GoodsType> allType =gtd.getAllData("");//��ȡ������Ʒ����
					gtd.close();
					int sp=2;
					out(1,"  ");out("���");
					out(sp,"\t");outln("����");
					out(sp-1,"\t");out("���");
					out(sp,"\t");out("����");
					out(sp,"\t");out("�۸�");
					out(sp-1,"\t");out("�ۿ�");
					out(sp-1,"\t");out("��Ʒ");
					out(sp-1,"\t");out("��Ʒ�Ƽ�");
					out(sp-1,"\t");out("״̬");
					out(sp-1,"\t");out("�ִ���");
					out(sp-1,"\t");outln("��ע");
					outln(80,"**");
					for(GoodsType gt :allType){
						outln(130,"_");
						out(1,"  ");out(gt.getId());
						String a=gt.getName();
						out(sp,"\t");outln(a);
						List<GoodsInfo> all = gifd.getGoods(gt);//��ȡ��ǰ�����µ���Ʒ��Ϣ
						outln(130,"_");
						for(GoodsInfo gi :all){
							out(sp-1,"\t");out(gi.getGoodId());
							String b=gi.getName();
							out(sp,"\t");out(b);
							out(sp,"\t");out(gi.getPrice());
							out(sp-1,"\t");out(gi.getDiscount());
							out(sp-1,"\t");out(gi.isNew());
							out(sp-1,"\t");out(gi.isRecommend());
							out(sp-1,"\t");out(gi.isState()?"�ϼ�":"�¼�");
							out(sp-1,"\t");out(gi.getNum());
							out(sp-1,"\t");outln(gi.getRemark());
						}
					}
					gifd.close();
				}catch(SQLException s){outln(s.toString());};
				nowSelectView.show();
			}
		});
		addView(fv);
	   fv = new FunView("�鿴�������ͼ��ϼ���Ʒ");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					gtd.connectionSQLSERVERDB();
					gifd.connectionSQLSERVERDB();
					List<GoodsType> allType =gtd.getAllData("");//��ȡ������Ʒ����
					gtd.close();
					int sp=2;
					out(1,"  ");out("���");
					out(sp,"\t");outln("����");
					out(sp-1,"\t");out("���");
					out(sp,"\t");out("����");
					out(sp,"\t");out("�۸�");
					out(sp-1,"\t");out("�ۿ�");
					out(sp-1,"\t");out("��Ʒ");
					out(sp-1,"\t");out("��Ʒ�Ƽ�");
					out(sp-1,"\t");out("״̬");
					out(sp-1,"\t");out("�ִ���");
					out(sp-1,"\t");outln("��ע");
					outln(80,"**");
					for(GoodsType gt :allType){
						outln(130,"_");
						out(1,"  ");out(gt.getId());
						String a=gt.getName();
						out(sp,"\t");outln(a);
						List<GoodsInfo> all = gifd.getGoods(gt);//��ȡ��ǰ�����µ���Ʒ��Ϣ
						outln(130,"_");
						for(GoodsInfo gi :all){
							if(gi.isState()){
								out(sp-1,"\t");out(gi.getGoodId());
								
								String b=gi.getName();
								out(sp,"\t");out(b);
								out(sp,"\t");out(gi.getPrice());
								out(sp-1,"\t");out(gi.getDiscount());
								out(sp-1,"\t");out(gi.isNew());
								out(sp-1,"\t");out(gi.isRecommend());
								out(sp-1,"\t");out(gi.isState()?"�ϼ�":"�¼�");
								out(sp-1,"\t");out(gi.getNum());
								out(sp-1,"\t");outln(gi.getRemark());
							}
						}
					}
					gifd.close();
				}catch(SQLException s){outln(s.toString());};
				nowSelectView.show();
			}
		});
		addView(fv);
	fv =new FunView("�鿴ָ�������µ���Ʒ");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gtd.connectionSQLSERVERDB();
				gifd.connectionSQLSERVERDB();
				String name=iv.get("�������������ƣ�");
				GoodsType gt =gtd.getDate("typeName", name, true);//��ȡ������Ʒ����
				
					
				
				gtd.close();
				int sp=2;
				if(gt!=null){
				
					out(1,"   ");out("���");
					out(sp,"\t");out("����");
					out(sp,"\t");out("�۸�");
					out(sp-1,"\t");out("�ۿ�");
					out(sp-1,"\t");out("��Ʒ");
					out(sp-1,"\t");out("��Ʒ�Ƽ�");
					out(sp-1,"\t");out("״̬");
					out(sp-1,"\t");out("�ִ���");
					out(sp-1,"\t");outln("��ע");
					outln(80,"_");
					
						List<GoodsInfo> all = gifd.getGoods(gt);//��ȡ��ǰ�����µ���Ʒ��Ϣ
						for(GoodsInfo gi :all){
							out(1,"   ");out(gi.getGoodId());
							String b=gi.getName();
							out(sp,"\t");out(b);
							out(sp,"\t");out(gi.getPrice());
							out(sp-1,"\t");out(gi.getDiscount());
							out(sp-1,"\t");out(gi.isNew());
							out(sp-1,"\t");out(gi.isRecommend());
							out(sp-1,"\t");out(gi.isState()?"�ϼ�":"�¼�");
							out(sp-1,"\t");out(gi.getNum());
							out(sp-1,"\t");outln(gi.getRemark());
						}
				
				}else{
					out(3,"");outln("�Ҳ�������Ʒ����");
				}
				gtd.close();
				gifd.close();
			}catch(SQLException s){};
			nowSelectView.show();
		}
	});
	addView(fv);
	
	fv =new FunView("�����Ʒ");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
		
			try {
				gtd.connectionSQLSERVERDB();
				gifd.connectionSQLSERVERDB();
				
				String name ="";//����
				GoodsType type=null;//����
				float price=0.0f;//�۸�
				float discount=0.0f;//�ۿ�
				int num=0;//����
				String remark="";//��Ʒ
				boolean a = false;
				do{
					name = iv.get("��������Ʒ���ƣ�");
					a=false;
					if(name.isEmpty()){
						out(3," ");outln("��Ʒ���Ʋ���Ϊ��!");
						out(3," ");outln("����������");
						a=true;
						continue;
					}
					if(gifd.getDate("goodsName", name, true)!=null){
						out(3," ");outln("���ڴ�����["+name+"]����Ʒ��Ϣ!");
						out(3," ");outln("����������");
						a=true;
					}
				}while(a);
				
				do{
					String tn = iv.get("��������Ʒ�������ƣ�");
					type=gtd.getDate("typename", tn, true);
					if(type==null){
						a=true;
						out(3," ");
						if(iv.getYesNo("������["+tn+"]������!�Ƿ���ӣ�")){
							gtd.addDate(new GoodsType(tn));
							type=gtd.getDate("typename", tn, true);
							a=type==null;
						}
					}
					
				}while(a);
				
				
				
				do{
					a=false;
					String tn = iv.get("��������Ʒ�۸�");
					try{
						price=Float.parseFloat(tn);
					}catch(NumberFormatException nef){
						out(3," ");outln("����������[...0-9.0-9...]");
						out(3," ");outln("����������");
						a=true;
						
					}
					
				}while(a);
				
				do{
					a=false;
					String tn = iv.get("��������Ʒ�ۿۣ�");
					try{
						discount=Float.parseFloat(tn);
					}catch(NumberFormatException nef){
						out(3," ");outln("����������[...0-9.0-9...]");
						out(3," ");outln("����������");
						a=true;
						
					}
					
				}while(a);
				

				do{
					a=false;
					String tn = iv.get("��������Ʒ������");
					try{
						num=Integer.parseInt(tn);
					}catch(NumberFormatException nef){
						out(3," ");outln("����������[...0-9]");
						out(3," ");outln("����������");
						a=true;
						
					}
					
				}while(a);
				
				remark = iv.get("��������Ʒ��ע��");
				GoodsInfo gi =new GoodsInfo(type, name, price, discount, true, true, true, num);
				if(gifd.addDate(gi)){
					out(3," ");outln("��ӳɹ�");
				}else{
					out(3," ");outln("���ʧ��");
				}
				
				gtd.close();
				gifd.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			nowSelectView.show();
		}
	});
	addView(fv);
	fv =new FunView("�޸���Ʒ�۸�");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				
				 String sid =iv.get("��������Ʒ��ţ�");
				 try{
				  int id=Integer.parseInt(sid);
				  GoodsInfo gi = gifd.getDate(id);
				  if(gi==null){
					  out(3," ");outln("��������Ʒ["+id+"]");
					  gifd.close();
					  return ;
				  }
				  float p =Float.parseFloat(iv.get("�������µ���Ʒ�۸�"));
				  gi.setPrice(p);
				  if(gifd.updateData(gi)){
						out(3," ");outln("�޸ĳɹ�");
					}else{
						out(3," ");outln("�޸�ʧ��");
					}
				 
				 }catch(NumberFormatException e){
					 out(3," ");outln("����������[...0-9]");
				 }
				
				gifd.close();
			}catch(SQLException s){};
			nowSelectView.show();
		}
	});
	addView(fv);
	
	fv =new FunView("�޸���Ʒ�۸�");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				
				 String sid =iv.get("��������Ʒ��ţ�");
				 try{
				  int id=Integer.parseInt(sid);
				  GoodsInfo gi = gifd.getDate(id);
				  if(gi==null){
					  out(3," ");outln("��������Ʒ["+id+"]");
					  gifd.close();
					  return ;
				  }
				  float p =Float.parseFloat(iv.get("�������µ���Ʒ�ۿۣ�"));
				  gi.setDiscount(p);
				  if(gifd.updateData(gi)){
						out(3," ");outln("�޸ĳɹ�");
					}else{
						out(3," ");outln("�޸�ʧ��");
					}
				 
				 }catch(NumberFormatException e){
					 out(3," ");outln("����������[...0-9]");
				 }
				
				gifd.close();
			}catch(SQLException s){};
			nowSelectView.show();
		}
	});
	addView(fv);
	fv =new FunView("������Ʒ����");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				
				 String sid =iv.get("��������Ʒ��ţ�");
				 try{
				  int id=Integer.parseInt(sid);
				  GoodsInfo gi = gifd.getDate(id);
				  if(gi==null){
					  out(3," ");outln("��������Ʒ["+id+"]");
					  gifd.close();
					  return ;
				  }
				  int n=Integer.parseInt(iv.get("������������Ʒ����[-/+]��"));
				  gi.setNum(gi.getNum()+n);
				  if(gifd.updateData(gi)){
						out(3," ");outln("�޸ĳɹ�");
					}else{
						out(3," ");outln("�޸�ʧ��");
					}
				 
				 }catch(NumberFormatException e){
					 out(3," ");outln("����������[...0-9]");
				 }
				
				gifd.close();
			}catch(SQLException s){};
			nowSelectView.show();
		}
	});
	addView(fv);
	
	fv =new FunView("�޸���Ʒ����");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				
				gtd.connectionSQLSERVERDB();
				
				 String sid =iv.get("��������Ʒ��ţ�");
				 try{
				  int id=Integer.parseInt(sid);
				  GoodsInfo gi = gifd.getDate(id);
				  if(gi==null){
					  out(3," ");outln("��������Ʒ["+id+"]");
					  gifd.close();
					  return ;
				  }
				  String tn = iv.get("��������Ʒ�������ƣ�");
					GoodsType type = gtd.getDate("typename", tn, true);
					if(type==null){
						out(3," ");
						if(iv.getYesNo("������["+tn+"]������!�Ƿ���ӣ�")){
							gtd.addDate(new GoodsType(tn));
							type=gtd.getDate("typename", tn, true);
						}
					}
					if(type!=null){
						gi.setGoodsType(type);
						 if(gifd.updateData(gi)){
								out(3," ");outln("�޸ĳɹ�");
							}else{
								out(3," ");outln("�޸�ʧ��");
							}
					}else{
						out(3," ");outln("�޸�ʧ��");
					}
					 
				 
				 }catch(NumberFormatException e){
					 out(3," ");outln("����������[...0-9]");
				 }
				
				gifd.close();
				gtd.close();
			}catch(SQLException s){};
			nowSelectView.show();
		}
	});
	addView(fv);
	
	
	fv =new FunView("�޸�ָ�����͵���Ʒ������");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				
				gtd.connectionSQLSERVERDB();
				
				
			
				  String tn = iv.get("��������Ʒ�������ƣ�");
					GoodsType type = gtd.getDate("typename", tn, true);
					if(type==null){
						out(3," ");
						if(iv.getYesNo("������["+tn+"]������!�Ƿ���ӣ�")){
							gtd.addDate(new GoodsType(tn));
							type=gtd.getDate("typename", tn, true);
						}
					}
					
					 String tn1 = iv.get("��������Ʒ�������ƣ�");
						GoodsType type1 = gtd.getDate("typename", tn1, true);
						if(type1==null){
							out(3," ");
							if(iv.getYesNo("������["+tn+"]������!�Ƿ���ӣ�")){
								gtd.addDate(new GoodsType(tn));
								type1=gtd.getDate("typename", tn, true);
							}
						}
						//�ж��Ƿ�Ϊ��
						if(type1==null || type==null){
							gifd.close();
							gtd.close();
							out(3," ");outln("�޸�ʧ�� ���Ϳ�");
							return ;
						}
						
						List<GoodsInfo> all = gifd.getGoods(type);
						if(iv.getYesNo("�Ƿ��޸�����["+tn+"]�µ�������Ʒ Ϊ �µ�����["+tn1+"]")){
							for(GoodsInfo gi : all){
								gi.setGoodsType(type1);
								if(gifd.updateData(gi)){
									  out(1,"\t");outln("�޸� ["+gi.getGoodId()+":"+gi.getName()+"] �ɹ�");
								  }else{
									  out(1,"\t");outln("�޸� ["+gi.getGoodId()+":"+gi.getName()+"] ʧ��");
								}
							}
						}else{
							out(3," ");outln("ȡ���޸�");
						}
					
					
				
				gifd.close();
				gtd.close();
			}catch(SQLException s){};
			nowSelectView.show();
		}
	});
	addView(fv);
	
	
	fv =new FunView("ɾ����Ʒ");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				OrderInfoDao uid =new OrderInfoDao();
				OrderGoodsInfoDao ogid =new OrderGoodsInfoDao();
				
				 String sid =iv.get("��������Ʒ��ţ�");
				 try{
				  int id=Integer.parseInt(sid);
				  GoodsInfo gi = gifd.getDate(id);
				  if(gi==null){
					  out(3," ");outln("��������Ʒ["+id+"]");
					  gifd.close();
					  return ;
				  }
				  if(iv.getYesNo("�Ƿ�ɾ����Ʒ["+id+"] ע:���������Ʒ��������ƷҲ�ᱻɾ��")){
					 
					  List<OrderGoodsInfo> all = ogid.getOrderGoodsByGoods(gi);
					  for(OrderGoodsInfo ois : all){
						  ogid.deleteData(ois.getOrderInfo());
						  uid.deleteData(ois.getOrderInfo());
						  
					  }
					  
					  
					  if(gifd.deleteData(gi)){
						  out(3," ");outln("ɾ���ɹ�");
					  }else{
							out(3," ");outln("ɾ��ʧ��");
						}
				  }else{
					  out(3," ");outln("ȡ��ɾ��");
				  }
				 }catch(NumberFormatException e){
					 out(3," ");outln("����������[...0-9]");
				 }
				
				gifd.close();
				ogid.close();
				uid.close();
				
			}catch(SQLException s){};
			nowSelectView.show();
		}
	});
	addView(fv);
	
	fv =new FunView("ɾ��ָ�������µ���Ʒ");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				
				gtd.connectionSQLSERVERDB();
				
				  String tn = iv.get("��������Ʒ�������ƣ�");
					GoodsType type = gtd.getDate("typename", tn, true);
					if(type==null){
						out(3," ");
						if(iv.getYesNo("������["+tn+"]������!�Ƿ���ӣ�")){
							gtd.addDate(new GoodsType(tn));
							type=gtd.getDate("typename", tn, true);
						}
					}
					List<GoodsInfo> all = gifd.getGoods(type);
					if(iv.getYesNo("�Ƿ�ɾ������["+tn+"]�µ�������Ʒ")){
						for(GoodsInfo gi : all){
							if(gifd.deleteData(gi)){
								  out(1,"\t");outln("ɾ�� ["+gi.getGoodId()+":"+gi.getName()+"] �ɹ�");
							  }else{
								  out(1,"\t");outln("ɾ�� ["+gi.getGoodId()+":"+gi.getName()+"] ʧ��");
							}
						}
					}else{
						out(3," ");outln("ȡ��ɾ��");
					}
				
				gifd.close();
				gtd.close();
				
				
			}catch(SQLException s){};
			nowSelectView.show();
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
