package com.mrhan.project.moduls;

import java.util.Date;

/**
 * ������Ϣ
 * @author MrHanHao
 *
 */
public class OrderInfo {
	private int orderId;//�������
	private CustomerInfo customerInfo;//�����ͻ�
	private boolean state;//����״̬
	private Date orderDate;//����ʱ��
	
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public OrderInfo(CustomerInfo customerInfo, boolean state, Date orderDate) {
		super();
		this.customerInfo = customerInfo;
		this.state = state;
		this.orderDate = orderDate;
	}
	public OrderInfo(int orderId, CustomerInfo customerInfo, boolean state,
			Date orderDate) {
		super();
		this.orderId = orderId;
		this.customerInfo = customerInfo;
		this.state = state;
		this.orderDate = orderDate;
	}
	
	
}
