package com.mrhan.project.databases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.GoodsType;

public class GoodsInfoDao extends ShopingDBDao implements Operating<GoodsInfo> {

	public GoodsInfoDao() {
		super("ShoppingDB");
		try {
			connectionSQLSERVERDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean addDate(GoodsInfo t) {
		int a=insert("GoodsInfo", 
				t.getGoodsType().getId()+"",//类型编号
				str(t.getName()),//名称
				t.getPrice()+"",//价格
				t.getDiscount()+"",//折扣
				(t.isNew()?1:0)+"",//是否数新品
				(t.isRecommend()?1:0)+"",//是否推荐
				(t.isState()?1:0)+"",//是否上架
				str(t.getPhoto()),//图片
				str(t.getRemark()),//备注
				t.getNum()+""
				);
		return a>0;
	}

	@Override
	public GoodsInfo getDate(String col, String val, boolean isStr) {
		SelectDataInterface sdif = select("GoodsInfo"," "+col+"="+(isStr?str(val):val));
		GoodsInfo gi =null;
		
		GoodsTypeDao gtd =new GoodsTypeDao();
		
		if(sdif.hasnext()){
			sdif.next();
			GoodsType gd =gtd.getDate(_int(sdif.getValue(1)));
			
			gi=new GoodsInfo(
					_int(sdif.getValue(0))//编号
					, gd, //类型
					sdif.getValue(2)//名称
					, _float(sdif.getValue(3))//价格
					, _float(sdif.getValue(4))//折扣
					, bool(sdif.getValue(5)),//是否是新品
					bool(sdif.getValue(6)),//是否推荐
					bool(sdif.getValue(7)),
					_int(sdif.getValue(10)));//是否上架
			gi.setPhoto(sdif.getValue(8));
			gi.setRemark(sdif.getValue(9));
		}
		try {
			gtd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gi;
	}

	@Override
	public GoodsInfo getDate(int id) {
		SelectDataInterface sdif = select("GoodsInfo"," goodsId="+id);
		GoodsInfo gi =null;
		
		GoodsTypeDao gtd =new GoodsTypeDao();
		
		if(sdif.hasnext()){
			sdif.next();
			GoodsType gd =gtd.getDate(_int(sdif.getValue(1)));
			
			gi=new GoodsInfo(
					_int(sdif.getValue(0))//编号
					, gd, //类型
					sdif.getValue(2)//名称
					, _float(sdif.getValue(3))//价格
					, _float(sdif.getValue(4))//折扣
					, bool(sdif.getValue(5)),//是否是新品
					bool(sdif.getValue(6)),//是否推荐
					bool(sdif.getValue(7)),_int(sdif.getValue(10)));//是否上架
			gi.setPhoto(sdif.getValue(8));
			gi.setRemark(sdif.getValue(9));
			
		}
		try {
			gtd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gi;
	}

	@Override
	public List<GoodsInfo> getAllData(String w) {
		SelectDataInterface sdif = select("GoodsInfo",w);
		GoodsInfo gi =null;
		List<GoodsInfo> all =new ArrayList<>();
		GoodsTypeDao gtd =new GoodsTypeDao();
		
		while(sdif.hasnext()){
			sdif.next();
			GoodsType gd =gtd.getDate(_int(sdif.getValue(1)));
			//System.out.println(sdif.getValue(10));
			gi=new GoodsInfo(
					_int(sdif.getValue(0))//编号
					, gd, //类型
					sdif.getValue(2)//名称
					, _float(sdif.getValue(3))//价格
					, _float(sdif.getValue(4))//折扣
					, bool(sdif.getValue(5)),//是否是新品
					bool(sdif.getValue(6)),//是否推荐
					bool(sdif.getValue(7)),//是否上架
					_int(sdif.getValue(10)));
			gi.setPhoto(sdif.getValue(8));
			gi.setRemark(sdif.getValue(9));
			all.add(gi);
		}
		try {
			gtd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
		
	}

	@Override
	public boolean updateData(GoodsInfo t) {
		int a=update("GoodsInfo", " goodsId="+t.getGoodId(),
				"typeId="+t.getGoodsType().getId()+"",//类型编号
				"goodsName="+str(t.getName()),//名称
				"price="+t.getPrice()+"",//价格
				"discount="+t.getDiscount()+"",//折扣
				"isNew="+(t.isNew()?1:0)+"",//是否数新品
				"isRecommend="+(t.isRecommend()?1:0)+"",//是否推荐
				"status="+(t.isState()?1:0)+"",//是否上架
				"photo="+str(t.getPhoto()),//图片
				"remark="+str(t.getRemark())//备注
				,"num="+(t.getNum()<0?0:t.getNum())
				);
		return a>0;
	}

	@Override
	public boolean deleteData(GoodsInfo t) {
		int a=delete("GoodsInfo", " goodsId="+t.getGoodId());
		return a>0;
	}
	
	/**
	 * 获取指定商品类型下的所有商品
	 * @param gt
	 * @return
	 */
	public List<GoodsInfo> getGoods(GoodsType gt)
	{
		return getAllData(" typeId="+gt.getId());
	}
	/**
	 * 获取指定商品类型下的所有商品，获取新品 是否推荐
	 * @param gt
	 * @param isNew
	 * @return
	 */
	public List<GoodsInfo> getGoods(GoodsType gt,boolean isNew,boolean isRecommend)
	{
		return getAllData(" typeId="+gt.getId()+" and isNew="+(isNew?1:0)+" and isRecommend="+(isRecommend?1:0));
	}
	/**
	 * 获取是否数新品的货物
	 * @param isNew
	 * @return
	 */
	public List<GoodsInfo> getisNewGoods(boolean isNew){
		return getAllData("isNew="+(isNew?1:0));
	}
	/**
	 * 获取是否数推荐的货物
	 * @param isNew
	 * @return
	 */
	public List<GoodsInfo> getisRecommendGoods(GoodsType gt,boolean isRecommend){
		return getAllData(" typeId="+gt.getId()+" and isRecommend="+(isRecommend?1:0));
	}
	
	
	public List<GoodsInfo> getGoodsInfos(String where){
		return getAllData(where);
	}
	
	
	/**
	 * 获取是否数新品的货物
	 * @param isNew
	 * @return
	 */
	public List<GoodsInfo> getisNewGoods(GoodsType gt,boolean isNew){
		return getAllData(" typeId="+gt.getId()+" and isNew="+(isNew?1:0));
	}
	/**
	 * 获取是否数推荐的货物
	 * @param isNew
	 * @return
	 */
	public List<GoodsInfo> getisRecommendGoods(boolean isRecommend){
		return getAllData("isRecommend="+(isRecommend?1:0));
	}
}
