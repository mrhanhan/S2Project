package com.mrhan.project.databases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mrhan.project.moduls.GoodsType;

public class GoodsTypeDao extends ShopingDBDao implements Operating<GoodsType> {

	public GoodsTypeDao() {
		super("ShoppingDB");
	
		try {
			connectionSQLSERVERDB();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public boolean addDate(GoodsType t) {
		
		int a=insert("GoodsType", 
				str(t.getName())
				
				);
		return a>0;
	}

	@Override
	public GoodsType getDate(String col, String val, boolean isStr) {
		SelectDataInterface sdif =select("GoodsType", " "+col+"="+(isStr?str(val):val));
		GoodsType gt =null;
		if(sdif.hasnext()){
			sdif.next();
			gt=new GoodsType(_int(sdif.getValue(0)),sdif.getValue(1));
		}
		return gt;
	}

	@Override
	public GoodsType getDate(int id) {
		SelectDataInterface sdif =select("GoodsType", " typeId="+id);
		GoodsType gt =null;
		if(sdif.hasnext()){
			sdif.next();
			gt=new GoodsType(_int(sdif.getValue(0)),sdif.getValue(1));
		}
		return gt;
	}

	@Override
	public List<GoodsType> getAllData(String w) {
		List<GoodsType> all =new ArrayList<>();
		SelectDataInterface sdif =select("GoodsType", w);
		GoodsType gt =null;
		while(sdif.hasnext()){
			sdif.next();
			gt=new GoodsType(_int(sdif.getValue(0)),sdif.getValue(1));
			all.add(gt);
		}
		
		return all;
	}

	@Override
	public boolean updateData(GoodsType t) {
		int a=update("GoodsType"," typeId="+t.getId(),
				"typeName="+str(t.getName())
				);
		return a>0;
	}

	@Override
	public boolean deleteData(GoodsType t) {
		int a=delete("GoodsType"," typeId="+t.getId());
		return a>0;
	}

}
