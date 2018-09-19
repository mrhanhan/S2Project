package com.mrhan.project.databases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mrhan.project.moduls.UserInfo;

/**
 * 用户操作类
 * @author MrHanHao
 *
 */
public class UserInfoDao extends ShopingDBDao implements Operating<UserInfo> {

	public UserInfoDao() {
		super("ShoppingDB");
		try {
			connectionSQLSERVERDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<UserInfo> getAllUserInfo(String w){
		List<UserInfo> all =new ArrayList<>();
		SelectDataInterface sdif =select("UserInfo", w);
		for(;sdif.hasnext();){
			sdif.next();
			UserInfo user =new UserInfo(Integer.parseInt(sdif.getValue(0)), sdif.getValue(1), sdif.getValue(2));
			all.add(user);
		}
		return all;
	}
	/**
	 * 获取指定编号的用户信息
	 * @param id 用户编号
	 * @return 指定的用户对象
	 */
	public UserInfo getUserInfoById(int id){
		SelectDataInterface sdif =select("UserInfo", " id="+id);
		if(sdif.hasnext()){
			sdif.next();
			return new UserInfo(Integer.parseInt(sdif.getValue(0)), sdif.getValue(1), sdif.getValue(2));
		}
		return null;
	}
	
	/**
	 * 获取指定编号的用户信息
	 * @param id 用户编号
	 * @return 指定的用户对象
	 */
	public UserInfo getUserInfoByName(String name){
		SelectDataInterface sdif =select("UserInfo", " userName="+str(name));
		if(sdif.hasnext()){
			sdif.next();
			return new UserInfo(Integer.parseInt(sdif.getValue(0)), sdif.getValue(1), sdif.getValue(2));
		}
		return null;
	}
	
	/**
	 * 删除指定用户
	 */
	public boolean deleteUserInfo(UserInfo uis){
		return delete("UserInfo", " id="+uis.getUserId())>0;
	}
	/**
	 * 添加用户
	 */
	public boolean addUserInfo(UserInfo uis){
		return insert("UserInfo",str(uis.getUserName()),str(uis.getUserPwd()))>0;
	}
	
	/**
	 * 修改指定用户
	 */
	public boolean updateUserInfo(UserInfo ui){
		return update("UserInfo"," id="+ui.getUserId()," userName="+str(ui.getUserName())," userPwd="+str(ui.getUserPwd()))>0;
	}

	@Override
	public boolean addDate(UserInfo t) {
		// TODO Auto-generated method stub
		return addUserInfo(t);
	}

	@Override
	public UserInfo getDate(String col, String val,boolean isStr) {
		SelectDataInterface sdif=null;
		if(isStr){
			sdif =select("UserInfo", " "+col+"="+str(val));
		}else{
			sdif =select("UserInfo", " "+col+"="+val);
		}
		if(sdif.hasnext()){
			sdif.next();
			return new UserInfo(Integer.parseInt(sdif.getValue(0)), sdif.getValue(1), sdif.getValue(2));
		}
		return null;
	}

	@Override
	public UserInfo getDate(int id) {
		// TODO Auto-generated method stub
		return getUserInfoById(id);
	}

	@Override
	public List<UserInfo> getAllData(String w) {
		// TODO Auto-generated method stub
		return getAllUserInfo(w);
	}

	@Override
	public boolean updateData(UserInfo t) {
		// TODO Auto-generated method stub
		return updateUserInfo(t);
	}

	@Override
	public boolean deleteData(UserInfo t) {
		// TODO Auto-generated method stub
		return deleteUserInfo(t);
	}

	
	/**
	 * 根据账号密码获取用户
	 */
	public UserInfo getUserInfo(String name,String pwd){
		return getDate("userName" ,str(name)+" and userPwd="+str(pwd) , false);
	}
}
