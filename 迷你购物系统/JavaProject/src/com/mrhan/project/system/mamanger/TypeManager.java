package com.mrhan.project.system.mamanger;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.mrhan.project.databases.GoodsInfoDao;
import com.mrhan.project.databases.GoodsTypeDao;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.GoodsType;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;

public class TypeManager extends Layout {
	private GoodsTypeDao gtd ;//��Ʒ���͹���
	private GoodsInfoDao gifd;//��Ʒ��Ϣ����
	public TypeManager() {
		setTitle("���͹�����");
		setShowCol(4);//����3����ʾ
		
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
		FunView fv =new FunView("�鿴��������");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					gtd.connectionSQLSERVERDB();
					
					List<GoodsType> allType =gtd.getAllData("");//��ȡ������Ʒ����
					gtd.close();
					int sp=3;
					out(1,"\t");out("���");
					out(sp,"\t");outln("����");
					for(GoodsType gt :allType){
						out(1,"\t");out(gt.getId());
						String a=gt.getName();
						out(sp,"\t");outln(a);
						
					}
				}catch(SQLException s){outln(s.toString());};
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("�������");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				String types = iv.get("��������Ʒ����[type name1,type name2,...]��");
				try {
					gtd.connectionSQLSERVERDB();
					
					String [] tps =types.split(",");
					
					
					for(String type : tps){
						try{
						if(gtd.addDate(new GoodsType(type))){
							out(3," ");outln("["+type+"] ��ӳɹ�");
						}else{
							out(3," ");outln("["+type+"] ���ʧ�ܣ��Ѵ���");
						}
						}catch(Exception sql){out(3," ");outln("["+type+"] ���ʧ�ܣ��Ѵ���");}
					}
					gtd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("ɾ������");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				String types = iv.get("��������Ʒ����[type id 1,type id 2,...]��");
				try {
					gtd.connectionSQLSERVERDB();
					gifd.connectionSQLSERVERDB();
					String [] tps =types.split(",");
					for(String type : tps){
						GoodsType gt =gtd.getDate("typeid", type, false);
						
						List<GoodsInfo> all = gifd.getGoods(gt);
						if(all.size()>0){
						   if(iv.getYesNo("    ��ǰ����["+gt.getId()+":"+gt.getName()+"]������Ʒ\n    �������ɾ����ɾ�����д����͵���Ʒ,�Ƿ����ɾ����")){
							   for(GoodsInfo gi : all){
								   //ɾ������Ʒ
								   gifd.deleteData(gi);
							   }
						   }else{
							  
							   out(3," ");outln("["+gt.getName()+"] ɾ��ʧ�ܣ�");
							   continue;
						   }
						}
						
						if(gtd.deleteData(gt)){
							out(3," ");outln("["+gt.getName()+"] ɾ���ɹ�");
						
						
						}else{
							out(3," ");outln("["+gt.getName()+"] ɾ��ʧ�ܣ�������");
						}
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
		fv =new FunView("�޸���������");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				String types = iv.get("��������Ҫ�޸����͵ı�ţ�");
				try {
					gtd.connectionSQLSERVERDB();
					gifd.connectionSQLSERVERDB();
					
					//for(String type : tps){
						GoodsType gt =gtd.getDate("typeid", types, false);
						if(gt!=null){
							String name= iv.get("�������µ���������:");
							if(name.isEmpty() || gtd.getDate("typename",name,true)!=null){
								out(3,"");outln("���������ظ�!");
							}else{
								gt.setName(name);
								if(gtd.updateData(gt)){
									out(3,"");outln("�����޸ĳɹ�!");
								}else{
									out(3,"");outln("�����޸�ʧ��!");
								}
							}
						}else{
							out(3,"");outln("�����ڴ�����!");
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
