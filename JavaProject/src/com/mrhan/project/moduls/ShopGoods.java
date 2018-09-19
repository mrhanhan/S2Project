package com.mrhan.project.moduls;
/**
 * 购物商品
 * @author MrHanHao
 *
 */
public class ShopGoods {
	private GoodsInfo goodsInfo;//商品信息
	private int count;//数量
	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}
	
	/**
	 * 构造函数 
	 * @param goodsInfo 商品信息
	 * @param count 数量
	 */
	public ShopGoods(GoodsInfo goodsInfo, int count) {
		
		this.goodsInfo = goodsInfo;
		this.count = count;
	}


	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * 获取所有商品的总价格
	 * @return
	 */
	public float getGoodsSum(){
		return goodsInfo.getPrice()*goodsInfo.getDiscount()*count;
	}
	
	public void addCount(int count){
		this.count+=count;
	}
	
	/**
	 * 重写equals方法，当商品信息的编号和价钱一样时，着购物相等，何以合并
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ShopGoods){
			ShopGoods o =(ShopGoods)obj;
			return (o.goodsInfo.getGoodId()==goodsInfo.getGoodId() && o.goodsInfo.getPrice()==goodsInfo.getPrice());
		}
		return false;
	}

}
