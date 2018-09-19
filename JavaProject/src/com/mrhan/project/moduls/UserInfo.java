package com.mrhan.project.moduls;

/**
 * 用户信息类
 * @author MrHanHao
 *
 */
public class UserInfo {
	private int userId;
	private String userName;
	private String userPwd;
	/**
	 * 
	 */
	public UserInfo(String name,String pwd){this.userName=name;
	this.userPwd=pwd;}
	
	/**
	 * 
	 */
	public UserInfo(int userid,String name,String pwd){
		this.userId=userid;
		this.userName=name;
		this.userPwd=pwd;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName
				+ ", userPwd=" + userPwd + "]";
	}
	
	
}
