package com.mrhan.project.moduls;
/**
 * 客户详细信息
 * @author MrHanHao
 *
 */
public class CustomerDataInfo {
	private CustomerInfo cusInfo;//客户信息
	private String name;//名字
	private String telphone;//练习方式
	private String mobileTelephone;//移动练习方式
	private String address;//练习地址
	
	
	
	
	public CustomerInfo getCusInfo() {
		return cusInfo;
	}
	public void setCusInfo(CustomerInfo cusInfo) {
		this.cusInfo = cusInfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getMobileTelephone() {
		return mobileTelephone;
	}
	public void setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 构造函数 客户 名字 练习电话 移动电话 地址
	 */
	public CustomerDataInfo(CustomerInfo cusInfo, String name, String telphone,
			String mobileTelephone, String address) {
		super();
		this.cusInfo = cusInfo;
		this.name = name;
		this.telphone = telphone;
		this.mobileTelephone = mobileTelephone;
		this.address = address;
	}
	@Override
	public String toString() {
		return "CustomerDataInfo [cusInfo=" + cusInfo + ", name=" + name
				+ ", telphone=" + telphone + ", mobileTelephone="
				+ mobileTelephone + ", address=" + address + "]";
	}
	
	
}
