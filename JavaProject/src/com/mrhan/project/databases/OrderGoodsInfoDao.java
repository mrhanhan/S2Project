package com.mrhan.project.databases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.OrderGoodsInfo;
import com.mrhan.project.moduls.OrderInfo;

public class OrderGoodsInfoDao extends ShopingDBDao implements Operating<OrderGoodsInfo> {

	public OrderGoodsInfoDao() {
		super("ShoppingDB");
		try {
			connectionSQLSERVERDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡָ���������µ����ж�����Ʒ��Ϣ
	 * @param t
	 * @return
	 */
	public List<OrderGoodsInfo> getOrderGoods(OrderInfo t){
		
		return getAllData("orderId="+t.getOrderId());
		
		
	}

	@Override
	public boolean addDate(OrderGoodsInfo t) {
		// TODO Auto-generated method stub
		
		int a=insert("OrderGoodsInfo",
				t.getOrderInfo().getOrderId()+"",//�������
				t.getGoodsInfo().getGoodId()+"",//��Ʒ���
				t.getNum()+""//����
				);
		
		return a>0;
	}
	@Deprecated
	@Override
	public OrderGoodsInfo getDate(String col, String val, boolean isStr) {
		
		return null;
	}
	
	
	/**
	 * ��ѯָ�������ŵ���Ʒ��Ϣ
	 */
	@Override
	public OrderGoodsInfo getDate(int id) {
		SelectDataInterface sdif =select("OrderGoodsInfo","id="+id);
		
		OrderInfoDao oid =new OrderInfoDao();
		
		GoodsInfoDao gif =new GoodsInfoDao();
		
		OrderGoodsInfo ogif=null;
		if(sdif.hasnext()){
			sdif.next();
			/**
			 * ��ȡ������Ϣ
			 */
			OrderInfo o = oid.getDate(_int(sdif.getValue(1)));
			/**
			 * ��ȡ��Ʒ��Ϣ
			 */
			GoodsInfo g = gif.getDate(_int(sdif.getValue(2)));
			
			int num =_int(sdif.getValue(3));
			int id1=_int(sdif.getValue(0));
			 ogif =new OrderGoodsInfo(id1,o, g, num);
			
		}
		
		try {
			oid.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			gif.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ogif;
	}

	@Override
	public List<OrderGoodsInfo> getAllData(String where) {
	SelectDataInterface sdif =select("OrderGoodsInfo", where);
		
	List<OrderGoodsInfo> all =new ArrayList<>();
	
		OrderInfoDao oid =new OrderInfoDao();
		
		GoodsInfoDao gif =new GoodsInfoDao();
		
		OrderGoodsInfo ogif=null;
		while(sdif.hasnext()){
			sdif.next();
			/**
			 * ��ȡ������Ϣ
			 */
			OrderInfo o = oid.getDate(_int(sdif.getValue(1)));
			/**
			 * ��ȡ��Ʒ��Ϣ
			 */
			GoodsInfo g = gif.getDate(_int(sdif.getValue(2)));
			
			int num =_int(sdif.getValue(3));
			int id1=_int(sdif.getValue(0));
			 ogif =new OrderGoodsInfo(id1,o, g, num);
			 all.add(ogif);
		}
		
		
		return all;
	}

	@Override
	public boolean updateData(OrderGoodsInfo t) {
		 int a=update("OrderGoodsInfo","id="+t.getId(),
				"orderId="+t.getOrderInfo().getOrderId()+"",//�������
					"goodsId="+t.getGoodsInfo().getGoodId()+"",//��Ʒ���
					"quantity="+t.getNum()+""//����
					);
		return a>0;
	}

	@Override
	public boolean deleteData(OrderGoodsInfo t) {
		int a=delete("OrderGoodsInfo","id="+t.getId());
		return a>0;
	}
	
	/**
	 * ɾ��ָ��������Ϣ�Ķ�����Ϣ
	 * @param t
	 * @return
	 */
	public boolean deleteData(OrderInfo t) {
		int a=delete("OrderGoodsInfo","orderId="+t.getOrderId());
		return a>0;
	}
	/**
	 * ��ȡָ����Ʒ�Ķ�����Ϣ
	 * @param gi
	 * @return
	 */
	public List<OrderGoodsInfo> getOrderGoodsByGoods(GoodsInfo gi){
		return getAllData("goodsId="+gi.getGoodId());
	}
	
	/**
	 * ��ȡָ����Ʒ�Ķ�����Ϣ
	 * @param gi
	 * @return
	 */
	public List<OrderGoodsInfo> getOrderGoodsByOrder(OrderInfo oi){
		return getAllData("orderId="+oi.getOrderId());
	}
	
	/**
	 * ɾ��ָ����Ʒ�Ķ�����Ʒ��Ϣ
	 * @param ci
	 */
	public void deleteOrderGoodsCustomer(CustomerInfo ci){
		OrderInfoDao uid =new OrderInfoDao();
		
		List<OrderInfo> allu =uid.getOrderInfos(ci);
		for(OrderInfo ui : allu){
			delete("OrderGoodsInfo", "orderId="+ui.getOrderId());
		}
		try {
			uid.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
