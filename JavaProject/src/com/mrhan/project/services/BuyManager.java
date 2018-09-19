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
 * 用户操作类
 * @author MrHanHao
 *
 */
public class BuyManager  {

	public BuyManager() {
	
		
	}
	/**
	 * 购买操作
	 * @param sc
	 * @return
	 */
	public boolean buyGoods(ShoppingCar sc){
		boolean isok=true;
		GoodsInfoDao gifd =new GoodsInfoDao();//商品操作类
		CustomerInfoDao cifd =new CustomerInfoDao();//客户操作类
		OrderInfoDao oidf =new OrderInfoDao();//订单信息操作类
		OrderGoodsInfoDao ogif =new OrderGoodsInfoDao();//订单商品操作类
		
		try {
			oidf.setAutoCommit(false);		
			ogif.setAutoCommit(false);
			cifd.setAutoCommit(false);		
			gifd.setAutoCommit(false);
			ArrayList<ShopGoods> allg=sc.getAllGoods();
			//获取客户信息
			CustomerInfo ci = cifd.getDate(sc.getCusinfo().getId());
			OrderInfo oi =new OrderInfo(ci, true, new Date());//创建订单信息
			
			//System.out.println(" 创建订单完毕");
			
			

			//System.out.println(" 插入订单信息");
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
			ArrayList<OrderGoodsInfo> allOrderGoods =new ArrayList<>();//订单商品信息列表
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			//刷新订单信息
			oi=oidf.getDate("OrderTime",sdf.format(oi.getOrderDate())+".000", true);
			
			
			for(int i=0;i<allg.size();i++){
				ShopGoods sg =allg.get(i);
				
				GoodsInfo gi =gifd.getDate(sg.getGoodsInfo().getGoodId());
				int count=sg.getCount();
				//创建定点商品信息
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
			//System.out.println(" 创建订单商品信息完毕");
			
			
			/**
			 * 插入订单信息
			 */
			
			
			//System.out.println(" 插入订单信息完毕");
			for(int i=0;i<allOrderGoods.size();i++ ){
			//	System.out.println(" 插入订单商品信息"+i);
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
		//	System.out.println(" 插入订单商品信息完毕");
			
			float bala=ci.getBalance();//获取用余额
			//减去总价格

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
			
			System.out.println(" 修改客户信息完毕");
			
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