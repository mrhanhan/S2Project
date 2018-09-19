package com.mrhan.project.databases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mrhan.project.moduls.CustomerDataInfo;
import com.mrhan.project.moduls.CustomerInfo;

public class CustomerDataInfoDao extends ShopingDBDao implements Operating<CustomerDataInfo> {

	public CustomerDataInfoDao() {
		super("ShoppingDB");
		// TODO Auto-generated constructor stub
		try {
			connectionSQLSERVERDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 添加信息
	 */
	@Override
	public boolean addDate(CustomerDataInfo t) {
		
		int a=insert("CustomerDataInfo",
				t.getCusInfo().getId()+"",
				str(t.getName()),
				str(t.getTelphone()),
				str(t.getMobileTelephone()),
				str(t.getAddress())
				);
		
		
		return a>0;
	}
	
	/**
	 *这里是根据客户信息来获取客户详细信息
	 */
	@Override
	public CustomerDataInfo getDate(String col, String val, boolean isStr) {
		CustomerInfoDao cid =new CustomerInfoDao();
		CustomerDataInfo cdi =null;
		cdi=getDate(cid.getDate(col, val, isStr).getId());
		
		try {
			cid.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return cdi;
	}

	@Override
	public CustomerDataInfo getDate(int id) {
		
		CustomerInfoDao cid =new CustomerInfoDao();
		CustomerDataInfo cdi =null;
		SelectDataInterface sdif =select("CustomerDataInfo","customerId = "+id);
		if(sdif.hasnext()){
			sdif.next();
			CustomerInfo ci=  cid.getDate(_int(sdif.getValue(0)));
			
			 cdi =new CustomerDataInfo(ci, sdif.getValue(1), 
					 sdif.getValue(2), sdif.getValue(3), sdif.getValue(4));
		}
		try {
			cid.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return cdi;
	}

	@Override
	public List<CustomerDataInfo> getAllData(String where) {
		CustomerInfoDao cid =new CustomerInfoDao();
		List<CustomerDataInfo> all =new ArrayList<>();
		SelectDataInterface sdif =select("CustomerDataInfo",where);
		while(sdif.hasnext()){
			sdif.next();
			CustomerInfo ci=  cid.getDate(_int(sdif.getValue(0)));
			
			all.add(new CustomerDataInfo(ci, sdif.getValue(1), 
					 sdif.getValue(2), sdif.getValue(3), sdif.getValue(4)));
		}
		try {
			cid.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public boolean updateData(CustomerDataInfo t) {
		int a=update("CustomerDataInfo", " customerId="+t.getCusInfo().getId() , 
				
				"name="+str(t.getName()),
				 "telphone="+str(t.getTelphone()),
				 "mobileTelephone="+str(t.getMobileTelephone()),
				 "address="+str(t.getAddress())
				);
				
				
		return a>0;
	}

	@Override
	public boolean deleteData(CustomerDataInfo t) {
		
		return (delete("CustomerDataInfo", " id="+t.getCusInfo().getId())>0);
	}

}
