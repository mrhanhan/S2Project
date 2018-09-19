package com.mrhan.project.moduls;
/**
 * ��Ʒ��Ϣ��
 * @author MrHanHao
 *
 */
public class GoodsInfo {
	private int goodId;//��Ʒ���
	private GoodsType goodsType;//��Ʒ����
	private String name;//��Ʒ���
	private float price;//��Ʒ�۸�
	private float discount;//��Ʒ�ۿ�
	private boolean isNew;//�Ƿ�����Ʒ
	private boolean isRecommend;//�Ƿ��Ƽ�
	private boolean state;//�Ƿ��ϼ�
	private String photo;//ͼƬ
	private String remark;//��ע
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
