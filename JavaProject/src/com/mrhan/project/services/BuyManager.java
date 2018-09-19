package com.mrhan.project.services;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mrhan.project.databases.CustomerInfoDao;
import com.mrhan.project.databases.GoodsInfoDao;
import com.mrhan.project.databases.OrderGoodsInfoDao;
import com.mrhan.project.databases.OrderInfoDao;
import com.mrhan.project.databases.ShopingDBDao;
import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.OrderGoodsInfo;
import com.mrhan.project.moduls.OrderInfo;
import com.mrhan.project.moduls.ShopGoods;

/**
 * �û�������
 * @author MrHanHao
 *
 */
public class BuyManager  {

	public BuyManager() {
	
		
	}
	/**
	 * �������
	 * @param sc
	 * @return
	 */
	public boolean buyGoods(ShoppingCar sc){
		boolean isok=true;
		GoodsInfoDao gifd =new GoodsInfoDao();//��Ʒ������
		CustomerInfoDao cifd =new CustomerInfoDao();//�ͻ�������
		OrderInfoDao oidf =new OrderInfoDao();//������Ϣ������
		OrderGoodsInfoDao ogif =new OrderGoodsInfoDao();//������Ʒ������
		
		try {
			oidf.setAutoCommit(false);		
			ogif.setAutoCommit(false);
			cifd.setAutoCommit(false);		
			gifd.setAutoCommit(false);
			ArrayList<ShopGoods> allg=sc.getAllGoods();
			//��ȡ�ͻ���Ϣ
			CustomerInfo ci = cifd.getDate(sc.getCusinfo().getId());
			OrderInfo oi =new OrderInfo(ci, true, new Date());//����������Ϣ
			
			//System.out.println(" �����������");
			
			

			//System.out.println(" ���붩����Ϣ");
			if(!oidf.addDate(oi)){
				try {
					cifd.rollback();
					gifd.rollback();
					oidf.rollback();
					ogif.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return false;
			}
			ArrayList<OrderGoodsInfo> allOrderGoods =new ArrayList<>();//������Ʒ��Ϣ�б�
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			//ˢ�¶�����Ϣ
			oi=oidf.getDate("OrderTime",sdf.format(oi.getOrderDate())+".000", true);
			
			
			for(int i=0;i<allg.size();i++){
				ShopGoods sg =allg.get(i);
				
				GoodsInfo gi =gifd.getDate(sg.getGoodsInfo().getGoodId());
				int count=sg.getCount();
				//����������Ʒ��Ϣ
				OrderGoodsInfo odi =new OrderGoodsInfo(oi, gi, count);
				
				
				gi.setNum(gi.getNum()-count);
				
				if(!gifd.updateData(gi)){
					try {
						gifd.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return false;
				}
				
				allOrderGoods.add(odi);
			}
			//System.out.println(" ����������Ʒ��Ϣ���");
			
			
			/**
			 * ���붩����Ϣ
			 */
			
			
			//System.out.println(" ���붩����Ϣ���");
			for(int i=0;i<allOrderGoods.size();i++ ){
			//	System.out.println(" ���붩����Ʒ��Ϣ"+i);
				OrderGoodsInfo sg =allOrderGoods.get(i);
				if(!ogif.addDate(sg)){
					try {
						
						cifd.rollback();
						gifd.rollback();
						oidf.rollback();
						ogif.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return false;
				}
				
			}
		//	System.out.println(" ���붩����Ʒ��Ϣ���");
			
			float bala=ci.getBalance();//��ȡ�����
			//��ȥ�ܼ۸�

			ci.setBalance(bala-sc.getSum());
			if(!cifd.updateData(ci)){
				try {
					cifd.rollback();
					gifd.rollback();
					oidf.rollback();
					ogif.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return false;
			}
			
			System.out.println(" �޸Ŀͻ���Ϣ���");
			
			cifd.commit();
			gifd.commit();
			oidf.commit();
			ogif.commit();
			isok=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				cifd.rollback();
				gifd.rollback();
				oidf.rollback();
				ogif.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				cifd.close();
				gifd.close();
				oidf.close();
				ogif.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
		return isok;
		
		
	}
	
	

}