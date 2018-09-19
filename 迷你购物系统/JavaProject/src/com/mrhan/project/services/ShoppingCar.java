package com.mrhan.project.services;

import java.util.ArrayList;

import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.ShopGoods;

/**
 * ���ﳵ
 * @author MrHanHao
 *
 */
public class ShoppingCar {
	/**
	 * ѡ����Ʒ�б�
	 */
	private ArrayList<ShopGoods> allGoods;
	private CustomerInfo cusinfo;//�ͻ���Ϣ
	
	
	public CustomerInfo getCusinfo() {
		return cusinfo;
	}
	public void setCusinfo(CustomerInfo cusinfo) {
		this.cusinfo = cusinfo;
	}
	public ShoppingCar(CustomerInfo cusinfo) {
		this.cusinfo=cusinfo;
		allGoods=new ArrayList<>();
	}
	/**
	 * ��ӹ���
	 */
	public void addShopGoods(ShopGoods sg){
		if(allGoods.contains(sg)){
		int a=allGoods.indexOf(sg);//��ȡ��ͬ�Ĺ�����Ϣ�������ڵ��±�
		  ShopGoods sg1=allGoods.get(a);
		  sg1.addCount(sg.getCount());//�������
		}else{
			allGoods.add(sg);
		}
	}
	/**
	 * �Ƴ�������Ϣ
	 * @param sg
	 */
	public void removeShopGoods(ShopGoods sg){
		allGoods.remove(sg);
	}
	/**
	 * �Ƴ�ָ���Ĺ�����Ϣ
	 * @param sg
	 */
	public void removeShopGoods(GoodsInfo sg){
		allGoods.remove(new ShopGoods(sg,0));
	}
	/**
	 * ��ȡ��ǰ���ﳵ��������Ʒ���ܼ۸�
	 * @return
	 */
	public float getSum(){
		float sum=0;
		for(ShopGoods sg :allGoods)
			sum+=sg.getGoodsSum();
		return sum;
	}
	
	public void clear(){
		allGoods.clear();
	}
	public ArrayList<ShopGoods> getAllGoods() {
		return allGoods;
	}
	
	/**
	 * ��ȡָ�����ﳵ����Ʒ����Ϣ
	 * @param goodid
	 * @return
	 */
	public int getGoodsSum(int goodid){
		for(ShopGoods sg :allGoods)
			  if(sg.getGoodsInfo().getGoodId()==goodid){
				  return sg.getCount();
			  }
		
		return 0;
	}
	
	/**
	 * ��ȡָ�����ﳵ����Ʒ����Ϣ
	 * @param goodid
	 * @return
	 */
	public ShopGoods getGoods(int goodid){
		for(ShopGoods sg :allGoods)
			  if(sg.getGoodsInfo().getGoodId()==goodid){
				  return sg;
			  }
		
		return null;
	}
	
}
