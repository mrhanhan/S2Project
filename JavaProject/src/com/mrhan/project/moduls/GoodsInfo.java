package com.mrhan.project.moduls;
/**
 * 商品信息类
 * @author MrHanHao
 *
 */
public class GoodsInfo {
	private int goodId;//商品编号
	private GoodsType goodsType;//商品类型
	private String name;//商品编号
	private float price;//商品价格
	private float discount;//商品折扣
	private boolean isNew;//是否是新品
	private boolean isRecommend;//是否推荐
	private boolean state;//是否上架
	private String photo;//图片
	private String remark;//备注
	private int num=0;
	/**
	
	 */
	
	
	public GoodsInfo(int goodId, GoodsType goodsType, String name, float price,
			float discount, boolean isNew, boolean isRecommend, boolean state,int num) {
		
		this.goodId = goodId;
		this.goodsType = goodsType;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.isNew = isNew;
		this.isRecommend = isRecommend;
		this.state = state;
		this.num=num;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public GoodsInfo( GoodsType goodsType, String name, float price,
			float discount, boolean isNew, boolean isRecommend, boolean state,int num) {
		
		
		this.goodsType = goodsType;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.isNew = isNew;
		this.isRecommend = isRecommend;
		this.state = state;
		this.num=num;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public boolean isRecommend() {
		return isRecommend;
	}

	public void setRecommend(boolean isRecommend) {
		this.isRecommend = isRecommend;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "GoodsInfo [goodId=" + goodId + ", goodsType=" + goodsType
				+ ", name=" + name + ", price=" + price + ", discount="
				+ discount + ", isNew=" + isNew + ", isRecommend="
				+ isRecommend + ", state=" + state + ", photo=" + photo
				+ ", remark=" + remark + ", num=" + num + "]";
	}

	
	
	
	
}
