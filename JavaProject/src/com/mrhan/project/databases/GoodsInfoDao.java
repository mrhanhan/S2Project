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
				t.getGoodsType().getId()+"",//���ͱ��
				str(t.getName()),//����
				t.getPrice()+"",//�۸�
				t.getDiscount()+"",//�ۿ�
				(t.isNew()?1:0)+"",//�Ƿ�����Ʒ
				(t.isRecommend()?1:0)+"",//�Ƿ��Ƽ�
				(t.isState()?1:0)+"",//�Ƿ��ϼ�
				str(t.getPhoto()),//ͼƬ
				str(t.getRemark()),//��ע
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
					_int(sdif.getValue(0))//���
					, gd, //����
					sdif.getValue(2)//����
					, _float(sdif.getValue(3))//�۸�
					, _float(sdif.getValue(4))//�ۿ�
					, bool(sdif.getValue(5)),//�Ƿ�����Ʒ
					bool(sdif.getValue(6)),//�Ƿ��Ƽ�
					bool(sdif.getValue(7)),
					_int(sdif.getValue(10)));//�Ƿ��ϼ�
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
					_int(sdif.getValue(0))//���
					, gd, //����
					sdif.getValue(2)//����
					, _float(sdif.getValue(3))//�۸�
					, _float(sdif.getValue(4))//�ۿ�
					, bool(sdif.getValue(5)),//�Ƿ�����Ʒ
					bool(sdif.getValue(6)),//�Ƿ��Ƽ�
					bool(sdif.getValue(7)),_int(sdif.getValue(10)));//�Ƿ��ϼ�
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
					_int(sdif.getValue(0))//���
					, gd, //����
					sdif.getValue(2)//����
					, _float(sdif.getValue(3))//�۸�
					, _float(sdif.getValue(4))//�ۿ�
					, bool(sdif.getValue(5)),//�Ƿ�����Ʒ
					bool(sdif.getValue(6)),//�Ƿ��Ƽ�
					bool(sdif.getValue(7)),//�Ƿ��ϼ�
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
				"typeId="+t.getGoodsType().getId()+"",//���ͱ��
				"goodsName="+str(t.getName()),//����
				"price="+t.getPrice()+"",//�۸�
				"discount="+t.getDiscount()+"",//�ۿ�
				"isNew="+(t.isNew()?1:0)+"",//�Ƿ�����Ʒ
				"isRecommend="+(t.isRecommend()?1:0)+"",//�Ƿ��Ƽ�
				"status="+(t.isState()?1:0)+"",//�Ƿ��ϼ�
				"photo="+str(t.getPhoto()),//ͼƬ
				"remark="+str(t.getRemark())//��ע
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
	 * ��ȡָ����Ʒ�����µ�������Ʒ
	 * @param gt
	 * @return
	 */
	public List<GoodsInfo> getGoods(GoodsType gt)
	{
		return getAllData(" typeId="+gt.getId());
	}
	/**
	 * ��ȡָ����Ʒ�����µ�������Ʒ����ȡ��Ʒ �Ƿ��Ƽ�
	 * @param gt
	 * @param isNew
	 * @return
	 */
	public List<GoodsInfo> getGoods(GoodsType gt,boolean isNew,boolean isRecommend)
	{
		return getAllData(" typeId="+gt.getId()+" and isNew="+(isNew?1:0)+" and isRecommend="+(isRecommend?1:0));
	}
	/**
	 * ��ȡ�Ƿ�����Ʒ�Ļ���
	 * @param isNew
	 * @return
	 */
	public List<GoodsInfo> getisNewGoods(boolean isNew){
		return getAllData("isNew="+(isNew?1:0));
	}
	/**
	 * ��ȡ�Ƿ����Ƽ��Ļ���
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
	 * ��ȡ�Ƿ�����Ʒ�Ļ���
	 * @param isNew
	 * @return
	 */
	public List<GoodsInfo> getisNewGoods(GoodsType gt,boolean isNew){
		return getAllData(" typeId="+gt.getId()+" and isNew="+(isNew?1:0));
	}
	/**
	 * ��ȡ�Ƿ����Ƽ��Ļ���
	 * @param isNew
	 * @return
	 */
	public List<GoodsInfo> getisRecommendGoods(boolean isRecommend){
		return getAllData("isRecommend="+(isRecommend?1:0));
	}
}
