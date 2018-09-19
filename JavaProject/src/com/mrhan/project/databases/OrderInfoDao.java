package com.mrhan.project.databases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.OrderGoodsInfo;
import com.mrhan.project.moduls.OrderInfo;

public class OrderInfoDao extends ShopingDBDao implements Operating<OrderInfo> {

	public OrderInfoDao() {
		super("ShoppingDB");
		try {
			connectionSQLSERVERDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean addDate(OrderInfo t) {
		int a=insert("OrderInfo", 
				t.getCustomerInfo().getId()+"",//客户
				(t.isState()?1:0)+"",
				 str(t.getOrderDate())
				);
		return a>0;
	}

	@Override
	public OrderInfo getDate(String col, String val, boolean isStr) {
		SelectDataInterface sdif =select("OrderInfo", " "+col+"="+(isStr?str(val):val));
		CustomerInfoDao cifd =new CustomerInfoDao();
		OrderInfo oi =null;
		if(sdif.hasnext()){
			sdif.next();
			CustomerInfo ci =cifd.getDate(_int(sdif.getValue(1)));
			
			oi =new OrderInfo(_int(sdif.getValue(0)),ci,//客户信息
					bool(sdif.getValue(2)),//订单状态
					date(sdif.getValue(3)) );//订单时间
			
		}
		try {
			cifd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oi;
	}

	@Override
	public OrderInfo getDate(int id) {
		SelectDataInterface sdif =select("OrderInfo", " orderId="+id);
		CustomerInfoDao cifd =new CustomerInfoDao();
		OrderInfo oi =null;
		if(sdif.hasnext()){
			sdif.next();
			CustomerInfo ci =cifd.getDate(_int(sdif.getValue(1)));
			
			oi =new OrderInfo(_int(sdif.getValue(0)),ci,//客户信息
					bool(sdif.getValue(2)),//订单状态
					date(sdif.getValue(3)) );//订单时间
			
		}
		try {
			cifd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oi;
	}

	@Override
	public List<OrderInfo> getAllData(String where) {
		SelectDataInterface sdif =select("OrderInfo", where);
		CustomerInfoDao cifd =new CustomerInfoDao();
		List<OrderInfo> all =new ArrayList<>();
		OrderInfo oi =null;
		while(sdif.hasnext()){
			sdif.next();
			CustomerInfo ci =cifd.getDate(_int(sdif.getValue(1)));
			
			oi =new OrderInfo(_int(sdif.getValue(0)),ci,//客户信息
					bool(sdif.getValue(2)),//订单状态
					date(sdif.getValue(3)) );//订单时间
			all.add(oi);
		}
		try {
			cifd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return all;
	}

	@Override
	public boolean updateData(OrderInfo t) {
		int a=update("OrderInfo", " orderId="+t.getOrderId(),
				"customerId="+t.getCustomerInfo().getId()+"",//客户
				"status="+(t.isState()?1:0)+"",
				"orderTime="+str(t.getOrderDate())
				);
		return a>0;
	}

	@Override
	public boolean deleteData(OrderInfo t) {
	    int a=delete("OrderInfo", " orderId="+t.getOrderId());
		return a>0;
	}
	
	/**
	 * 获取指定客户的所有订单
	 * @param c
	 * @return
	 */
	public List<OrderInfo> getOrderInfos(CustomerInfo c) {
		
		return getAllData(" customerId="+c.getId());
	}
	
	/**
	 * 获取指定客户的指定时间内的所有订单
	 * @param c
	 * @return
	 */
	public List<OrderInfo> getOrderInfos(CustomerInfo c,Date d1,Date d2) {
		
		return getAllData(" customerId="+c.getId()+" and "
				+ "orderTime>="+str(d1)+" and orderTime<="+str(d2));
	}
	
	
	/**
	 * 获取指定客户的未提交订单
	 * @param c
	 * @return
	 */
	public List<OrderInfo> getNewOrderInfos(CustomerInfo c) {
		
		return getAllData(" customerId="+c.getId()+" and status=0");
	}
	/**
	 * 获取指定客户的已经提交的订单
	 * @param c
	 * @return
	 */
	public List<OrderInfo> getOldOrderInfos(CustomerInfo c) {
		
		return getAllData(" customerId="+c.getId()+" and status=1");
	}
	
	/**
	 * 获取指定客户的指定时间内未提交订单
	 * @param c
	 * @return
	 */
	public List<OrderInfo> getNewOrderInfos(CustomerInfo c,Date d1,Date d2) {
		
		return getAllData(" customerId="+c.getId()+" and status=0 and "
				+ "orderTime>="+str(d1)+" and orderTime<="+str(d2));
	}
	/**
	 * 获取指定客户的已经提交的订单
	 * @param c
	 * @return
	 */
	public List<OrderInfo> getOldOrderInfos(CustomerInfo c,Date d1,Date d2) {
		
		return getAllData(" customerId="+c.getId()+" and status=1 and "
				+ "orderTime>="+str(d1)+" and orderTime<="+str(d2));
	}
	
	/**
	 * 删除指定客户的订单信息
	 * @param ci
	 */
	public void  deleteCustomerOrder(CustomerInfo ci){
		delete("OrderInfo", "customerId="+ci.getId());
	}
	
	
	
}
