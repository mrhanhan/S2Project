package com.mrhan.project.moduls;
/**
 * ������Ʒ��Ϣ
 * @author MrHanHao
 *
 */
public class OrderGoodsInfo {
	private int id;
	private OrderInfo orderInfo;//������Ϣ
	private GoodsInfo goodsInfo;//��Ʒ��Ϣ
	private int num;//��Ʒ����
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public OrderInfo getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public OrderGoodsInfo(int id,OrderInfo orderInfo, GoodsInfo goodsInfo, int num) {
		super();
		this.id=id;
		this.orderInfo = orderInfo;
		this.goodsInfo = goodsInfo;
		this.num = num;
	}
	public OrderGoodsInfo(OrderInfo orderInfo, GoodsInfo goodsInfo, int num) {
		super();
		this.orderInfo = orderInfo;
		this.goodsInfo = goodsInfo;
		this.num = num;
	}
	
	
}
