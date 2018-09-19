package com.mrhan.project.moduls;
/**
 * �ͻ���ϸ��Ϣ
 * @author MrHanHao
 *
 */
public class CustomerDataInfo {
	private CustomerInfo cusInfo;//�ͻ���Ϣ
	private String name;//����
	private String telphone;//��ϰ��ʽ
	private String mobileTelephone;//�ƶ���ϰ��ʽ
	private String address;//��ϰ��ַ
	
	
	
	
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
	 * ���캯�� �ͻ� ���� ��ϰ�绰 �ƶ��绰 ��ַ
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
