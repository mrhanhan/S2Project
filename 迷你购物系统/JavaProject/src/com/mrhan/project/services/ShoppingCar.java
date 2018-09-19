package com.mrhan.project.services;

import java.util.ArrayList;

import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.ShopGoods;

/**
 * 购物车
 * @author MrHanHao
 *
 */
public class ShoppingCar {
	/**
	 * 选购商品列表
	 */
	private ArrayList<ShopGoods> allGoods;
	private CustomerInfo cusinfo;//客户信息
	
	
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
	 * 添加购物
	 */
	public void addShopGoods(ShopGoods sg){
		if(allGoods.contains(sg)){
		int a=allGoods.indexOf(sg);//获取相同的购物信息对象所在的下表
		  ShopGoods sg1=allGoods.get(a);
		  sg1.addCount(sg.getCount());//添加数量
		}else{
			allGoods.add(sg);
		}
	}
	/**
	 * 移除购物信息
	 * @param sg
	 */
	public void removeShopGoods(ShopGoods sg){
		allGoods.remove(sg);
	}
	/**
	 * 移除指定的购物信息
	 * @param sg
	 */
	public void removeShopGoods(GoodsInfo sg){
		allGoods.remove(new ShopGoods(sg,0));
	}
	/**
	 * 获取当前购物车的所有商品的总价格
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
	 * 获取指定购物车里商品的信息
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
	 * 获取指定购物车里商品的信息
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
