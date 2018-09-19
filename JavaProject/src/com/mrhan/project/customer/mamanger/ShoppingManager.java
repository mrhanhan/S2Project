package com.mrhan.project.customer.mamanger;

import java.sql.SQLException;
import java.util.List;

import com.mrhan.project.databases.GoodsInfoDao;
import com.mrhan.project.databases.GoodsTypeDao;
import com.mrhan.project.databases.OrderGoodsInfoDao;
import com.mrhan.project.databases.OrderInfoDao;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.GoodsType;
import com.mrhan.project.moduls.OrderGoodsInfo;
import com.mrhan.project.moduls.ShopGoods;
import com.mrhan.project.services.ShoppingCar;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.UserLogin;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;

public class ShoppingManager extends Layout {
	private UserLogin login;//��½����
	private GoodsTypeDao gtd ;//��Ʒ���͹���
	private GoodsInfoDao gifd;//��Ʒ��Ϣ����
	private ShoppingCar  car;//���ﳵ
	public ShoppingManager(UserLogin login) {
		this.login=login;
		car=login.getShCar();
		setTitle("��������");
		gifd = new  GoodsInfoDao();
		gtd= new GoodsTypeDao();
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
							out(3,"\t");out(gi.getDiscount());
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
								out(3,"\t");out(gi.getDiscount());
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
		
		fv = new FunView("�鿴��ʶ���Ƶ���Ʒ");
		fv.setSe(new SelectEvent() {
				
				@Override
				public void select(FlowView last, FlowView now) {
					nowSelectView=last;
					try{
						
						gifd.connectionSQLSERVERDB();
						String like =iv.get("��������Ʒ�Ĵ������:");
						
						int sp=2;
						out(1,"  ");out("���");
						out(sp,"\t");outln("����");
						out(sp-1,"\t");out("���");
						out(sp,"\t");out("����");
						out(sp,"\t");out("�۸�");
						out(sp-1,"\t");out("�ۿ�");
						out(sp-1,"\t");out("�ִ���");
						out(sp-1,"\t");outln("��ע");
						 
						
							
							List<GoodsInfo> all = gifd.getAllData("goodsName like '%"+like+"%'");//��ȡ��ǰ�����µ���Ʒ��Ϣ
							
							for(GoodsInfo gi :all){
								GoodsType gt =gi.getGoodsType();
								out(1,"  ");out(gt.getId());
								String a=gt.getName();
								out(sp,"\t");outln(a);
								out(sp-1,"\t");out(gi.getGoodId());
								String b=gi.getName();
								out(sp,"\t");out(b);
								out(sp,"\t");out(gi.getPrice());
								out(3,"\t");out(gi.getDiscount());
								out(sp-1,"\t");out(gi.getNum());
								out(sp-1,"\t");outln(gi.getRemark());
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
						out(sp-1,"\t");out("�ִ���");
						out(sp-1,"\t");outln("��ע");
						outln(80,"_");
						
							List<GoodsInfo> all = gifd.getGoods(gt);//��ȡ��ǰ�����µ���Ʒ��Ϣ
							for(GoodsInfo gi :all){
								out(1,"   ");out(gi.getGoodId());
								String b=gi.getName();
								out(sp,"\t");out(b);
								out(sp,"\t");out(gi.getPrice());
								out(3,"\t");out(gi.getDiscount());
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
		fv =new FunView("��ӵ����ﳵ");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					gtd.connectionSQLSERVERDB();
					gifd.connectionSQLSERVERDB();
					int id=0;
					int num=0;
					try{
						id = Integer.parseInt(iv.get("��������Ʒ���"));
						num=Integer.parseInt(iv.get("�����빺������"));
					
					}catch(NumberFormatException sn){
						gtd.close();
						gifd.close();
						out(2," ");outln("����������[0-9]");
						return;
					}
					add(id,num);
					
					
					
					
					
					gtd.close();
					gifd.close();
				}catch(SQLException s){};
				nowSelectView.show();
			}

			
		});
		addView(fv);
		fv =new FunView("��ӵ����ﳵ(��ѡ)");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					gtd.connectionSQLSERVERDB();
					gifd.connectionSQLSERVERDB();
					String ss=iv.get("��������Ʒ��� ������[id count,id count]:");
					
					String []s = ss.split(",");
					for(String item : s){
						add(item);
					}
					
					gtd.close();
					gifd.close();
				}catch(SQLException s){};
				nowSelectView.show();
			}

			
		});
		addView(fv);
		fv =new FunView("�鿴���ﳵ");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				List<ShopGoods> allg = car.getAllGoods();//��ȡ���ﳵ��Ϣ
				out(1,"\t");out("��Ʒ���");
				out(2,"\t");out("��Ʒ����");
				out(3,"\t");out("��Ʒ��������");
				out(3,"\t");out("��Ʒ����");
				out(3,"\t");out("��Ʒ�ۿ�");
				out(3,"\t");out("��������");
				out(3,"\t");outln("�����ܼ�");
				for(ShopGoods sg : allg){
					GoodsInfo fi =sg.getGoodsInfo();
					out(1,"\t");out(fi.getGoodId());
					out(2,"\t");out(fi.getName());
					out(3,"\t");out(fi.getGoodsType().getName());
					out(3,"\t");out(fi.getPrice());
					out(3,"\t");out(fi.getDiscount());
					out(3,"\t");out(sg.getCount());
					out(3,"\t");outln(sg.getGoodsSum());
				}
				outln(150,"_");
				out(15,"\t");out("�ܼ۸�");outln(car.getSum());
				nowSelectView.show();
			}
		});
		addView(fv);
		
}
	
	private void add(String add){
		int id=0;
		int num;
		String []ss =add.split(" ");
		if(ss.length>1){
			try{
				id = Integer.parseInt(ss[0]);
				num=Integer.parseInt(ss[1]);
				add(id,num);
			}catch(NumberFormatException s){
				out(2," ");outln("����������[0-9]");
				
			}
			
		}else{
			out(3," ");outln("'"+add+"'��ʽ����");
		}
	}
	private void add(int id, int num) {
		GoodsInfo gi =gifd.getDate(id);
		
		
		if(gi==null){
			out(2," ");outln("���ʧ�ܣ�δ�ҵ�����Ʒ��Ϣ");
		}else{
			//��ȡ���ﳵ��ǰ��Ʒ����
			int carSum = car.getGoodsSum(gi.getGoodId());
			//����������
			int sums=carSum+num;
			if(sums>gi.getNum()){
				out(2," ");outln("��Ʒ��治�������ѡ��[���ֵ:"+gi.getNum()+"]");
				out(2," ");outln("���ʧ�ܣ���Ʒ��治��");
			}else{
				car.addShopGoods(new ShopGoods(gi, num));
				out(2," ");outln("��ӳɹ�");
			}
			
		}
		
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