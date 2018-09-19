package com.mrhan.project.databases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mrhan.project.moduls.BulletinInfo;
import com.mrhan.project.moduls.UserInfo;

public class BulletinInfoDao extends ShopingDBDao implements Operating<BulletinInfo> {
	
	
	public BulletinInfoDao() {
		super("ShoppingDB");
		try {
			connectionSQLSERVERDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addDate(BulletinInfo t) {
		// TODO Auto-generated method stub
		return (insert("BulletinInfo", str(t.getTitle()),
				 str(t.getContent()),
				t.getUserInfo().getUserId()+"",
				str(t.getCreateTime()) )>0);
	}

	@Override
	public BulletinInfo getDate(String col, String val, boolean isStr) {
		
		SelectDataInterface sdif =select("BulletinInfo", " "+col+"="+(isStr?str(val):val));
		UserInfoDao uif =new UserInfoDao();
		if(sdif.hasnext()){
			sdif.next();
			UserInfo ui =uif.getUserInfoById(_int(sdif.getValue(3)));
			 try {
				uif.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					return new BulletinInfo(
							_int(sdif.getValue(0)),
							sdif.getValue(1),
							sdif.getValue(2),
							ui,
							date(sdif.getValue(4)));
		}
		return null;
	}

	@Override
	public BulletinInfo getDate(int id) {
		SelectDataInterface sdif =select("BulletinInfo", " id="+id);
		UserInfoDao uif =new UserInfoDao();
		if(sdif.hasnext()){
			sdif.next();
			UserInfo ui =uif.getUserInfoById(_int(sdif.getValue(3)));
			 try {
				uif.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					return new BulletinInfo(
							_int(sdif.getValue(0)),
							sdif.getValue(1),
							sdif.getValue(2),
							ui,
							date(sdif.getValue(4)));
		}
		return null;
	}

	@Override
	public List<BulletinInfo> getAllData(String where) {
		List<BulletinInfo> ls =new ArrayList<>();
		
		SelectDataInterface sdif =select("BulletinInfo", where);
		UserInfoDao uif =new UserInfoDao();
		for(;sdif.hasnext();){
			sdif.next();
			
			ls.add(
					new BulletinInfo(
							_int(sdif.getValue(0)),
							sdif.getValue(1),
							sdif.getValue(2),
							uif.getUserInfoById(_int(sdif.getValue(3))),
							date(sdif.getValue(4)))
							
					);
		}
		try {
			uif.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public boolean updateData(BulletinInfo t) {
		
		return (update("BulletinInfo", " id="+t.getBulletId(),
				"title="+str(t.getTitle()),
				"content="+str(t.getContent()),
				 "userId="+t.getUserInfo().getUserId(),
				 "createTime="+str(t.getCreateTime())
				)>0);
	}

	@Override
	public boolean deleteData(BulletinInfo t) {
		
		return (delete("BulletinInfo", " id="+t.getBulletId())>0);
	}
	/**
	 * 获取指定用户所发布的公告
	 * @param ui
	 * @return
	 */
	public List<BulletinInfo> getBulletinInfo(UserInfo ui){
		return getAllData("userId="+ui.getUserId());
	}
}
