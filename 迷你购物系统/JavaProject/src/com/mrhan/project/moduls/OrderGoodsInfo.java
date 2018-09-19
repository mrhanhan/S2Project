package com.mrhan.project.moduls;
/**
 * 订单商品信息
 * @author MrHanHao
 *
 */
public class OrderGoodsInfo {
	private int id;
	private OrderInfo orderInfo;//订单信息
	private GoodsInfo goodsInfo;//商品信息
	private int num;//商品数量
	
	
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
