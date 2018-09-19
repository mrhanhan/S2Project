package com.mrhan.project.moduls;
/**
 * ������Ʒ
 * @author MrHanHao
 *
 */
public class ShopGoods {
	private GoodsInfo goodsInfo;//��Ʒ��Ϣ
	private int count;//����
	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}
	
	/**
	 * ���캯�� 
	 * @param goodsInfo ��Ʒ��Ϣ
	 * @param count ����
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
	 * ��ȡ������Ʒ���ܼ۸�
	 * @return
	 */
	public float getGoodsSum(){
		return goodsInfo.getPrice()*goodsInfo.getDiscount()*count;
	}
	
	public void addCount(int count){
		this.count+=count;
	}
	
	/**
	 * ��дequals����������Ʒ��Ϣ�ı�źͼ�Ǯһ��ʱ���Ź�����ȣ����Ժϲ�
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
