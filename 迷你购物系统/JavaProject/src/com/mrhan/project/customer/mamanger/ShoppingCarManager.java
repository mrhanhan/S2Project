package com.mrhan.project.customer.mamanger;

import java.sql.SQLException;
import java.util.List;

import com.mrhan.project.databases.CustomerInfoDao;
import com.mrhan.project.databases.GoodsInfoDao;
import com.mrhan.project.databases.GoodsTypeDao;
import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.ShopGoods;
import com.mrhan.project.services.BuyManager;
import com.mrhan.project.services.ShoppingCar;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.UserLogin;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;

public class ShoppingCarManager extends Layout {
	private UserLogin login;//��½����
	private CustomerInfoDao cido;
	private ShoppingCar  car;//���ﳵ
	public ShoppingCarManager(UserLogin login) {
		this.login=login;
		cido = new CustomerInfoDao();
		car=login.getShCar();
		setTitle("���ﳵ");
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
		FunView fv = new FunView("�鿴���ﳵ");
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
		fv = new FunView("�ύ����");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				BuyManager bm =new BuyManager();
				float sum = car.getSum();
				//��ȡ���
				float balance = login.getCustomerInfo().getBalance();
				if(iv.getYesNo("�Ƿ��ύ����[���:"+balance+",�ܼ�:"+sum+"]��")){
				
					if(balance-sum<0){
						out(3," ");outln("�ύʧ�ܣ�����");
					}else{
						if(bm.buyGoods(car)){
							out(3," ");outln("�ύ�ɹ�!��ϲ��� "+((int)sum+1)+" ����");
							try{
								cido.connectionSQLSERVERDB();
								CustomerInfo ci=login.getCustomerInfo();
								ci.setIntegral(ci.getIntegral()+(int)sum+1);
								cido.updateData(ci);
								cido.close();
							}catch(SQLException q){}
							clear();//������ﳵ
						}else{
							out(3," ");outln("�ύʧ�ܣ�");
						}
					}
				}else{
						out(3," ");outln("�ύʧ�ܣ�ȡ���ύ");
				}
				nowSelectView.show();
			}
		});
		addView(fv);
		fv = new FunView("ɾ����Ʒ");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					int id=Integer.parseInt(iv.get("��������Ҫɾ�����ﳵ�е����ݣ�"));
					removeGoods(id);
				}catch(NumberFormatException nf){
					out(3," ");outln("����������...[0-9]��");
				}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		 fv = new FunView("������ﳵ");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				if(iv.getYesNo("�Ƿ�������ﳵ��")){
					clear();
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
	/**
	 * ������ﳵ
	 */
	private void clear(){
		car.getAllGoods().clear();
	}
	/**
	 * �Ƴ����ﳵ�е���Ʒ
	 * @param id
	 */
	private void removeGoods(int id){
		ShopGoods sg =car.getGoods(id);
		if(sg==null){
			out(3," ");outln("�Ƴ�ʧ�ܣ���������Ʒ["+id+"]");
		}else{
			car.removeShopGoods(sg);
		}
		
	}
	
	
	
	@Override
	public void show() {
		showPath();
		super.show();
		iv.selectView(this);
	}

}
