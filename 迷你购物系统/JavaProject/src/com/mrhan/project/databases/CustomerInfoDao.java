package com.mrhan.project.databases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.OrderInfo;

public class CustomerInfoDao extends ShopingDBDao implements Operating<CustomerInfo> {

	public CustomerInfoDao() {
		super("ShoppingDB");
		try {
			connectionSQLSERVERDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 添加客户信息
	 */
	@Override
	public boolean addDate(CustomerInfo t) {
		
		// TODO Auto-generated method stub
				return (insert("CustomerInfo", 
						str(t.getUsername()),
						str(t.getEmail()),
						 str(t.getPwd()),
					     str(t.getRegDateTiem()),
					     str(t.getBalance()),
					     str(t.getIntegral()))>0);
	}

	@Override
	public CustomerInfo getDate(String col, String val, boolean isStr) {
		SelectDataInterface sdif =select("CustomerInfo"," "+col+"="+(isStr?str(val):val));
		
		if(sdif.hasnext()){
			sdif.next();
					return new CustomerInfo(
							_int(sdif.getValue(0)),
							sdif.getValue(1),
							sdif.getValue(2),
							sdif.getValue(3),
							date(sdif.getValue(4)),
							_float(sdif.getValue(5)),
							_int(sdif.getValue(6))
								);
		}
		return null;
		
	}

	@Override
	public CustomerInfo getDate(int id) {
		SelectDataInterface sdif =select("CustomerInfo", " id="+id);
	
		if(sdif.hasnext()){
			sdif.next();

					return new CustomerInfo(
							_int(sdif.getValue(0)),
							sdif.getValue(1),
							sdif.getValue(2),
							sdif.getValue(3),
							date(sdif.getValue(4)),
							_float(sdif.getValue(5)),
							_int(sdif.getValue(6)));
		}
		return null;
	}

	@Override
	public List<CustomerInfo> getAllData(String w) {
		
		List<CustomerInfo> all =new ArrayList<>();
		SelectDataInterface sdif =select("CustomerInfo", w);
		
		for(;sdif.hasnext();){
			sdif.next();
			
			all.add(
					new CustomerInfo(
							_int(sdif.getValue(0)),
							sdif.getValue(1),
							sdif.getValue(2),
							sdif.getValue(3),
							date(sdif.getValue(4)),
							_float(sdif.getValue(5)),
							_int(sdif.getValue(6)))
					);
		}
		
		return all;
	}

	/**
	 * 修改
	 */
	@Override
	public boolean updateData(CustomerInfo t) {
		
		return (update("CustomerInfo", " id="+t.getId()
				,"username="+str(t.getUsername())
				,"email="+str(t.getEmail()),
				  "pwd="+str(t.getPwd())
				  ,"registerTime="+str(t.getRegDateTiem())
				   ,"balance="+t.getBalance(),
				   "integral="+t.getIntegral()
				)>0
				  
				);
	}
	/**
	 * 删除
	 */
	@Override
	public boolean deleteData(CustomerInfo t) {
		
		return (delete("CustomerInfo", " id="+t.getId())>0);
	}
	
}
