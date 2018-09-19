package com.mrhan.project.moduls;

import java.util.Date;

import com.mrhan.project.services.ShoppingCar;

/**
 * 客户信息类
 * @author MrHanHao
 *
 */
public class CustomerInfo {
	private int id;//客户编号
	private String email;//客户邮箱
	private String pwd;//客户密码
	private Date regDateTiem;//注册时间
	
	private String username;//账号
	
	private float balance;//余额
	private int integral;//积分
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getRegDateTiem() {
		return regDateTiem;
	}
	public void setRegDateTiem(Date regDateTiem) {
		this.regDateTiem = regDateTiem;
	}
	/**
	 *  构造函数
	 *  @param id 编号
	 *  @param email 邮箱
	 *  @param pwd 密码
	 *  @param regDateTime 注册时间
	 */
	public CustomerInfo(int id,String username, String email, String pwd, Date regDateTiem,float balance,int integral) {
		
		this.id = id;
		this.email = email;
		this.username=username;
		this.balance=balance;
		this.integral=integral;
		this.pwd = pwd;
		this.regDateTiem = regDateTiem;
	}
	
	
	@Override
	public String toString() {
		return "CustomerInfo [id=" + id + ", email=" + email + ", pwd=" + pwd
				+ ", regDateTiem=" + regDateTiem + ", username=" + username
				+ ", balance=" + balance + ", integral=" + integral + "]";
	}
	public CustomerInfo( String username, String email, String pwd, Date regDateTiem,float balance,int integral) {
		this.email = email;
		this.username=username;
		this.balance=balance;
		this.integral=integral;
		this.pwd = pwd;
		this.regDateTiem = regDateTiem;
	}
	
}
