package com.mrhan.project.tests;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.mrhan.project.databases.BulletinInfoDao;
import com.mrhan.project.databases.CustomerDataInfoDao;
import com.mrhan.project.databases.CustomerInfoDao;
import com.mrhan.project.databases.GoodsInfoDao;
import com.mrhan.project.databases.GoodsTypeDao;
import com.mrhan.project.databases.SelectDataInterface;
import com.mrhan.project.databases.ShopingDBDao;
import com.mrhan.project.databases.UserInfoDao;
import com.mrhan.project.moduls.BulletinInfo;
import com.mrhan.project.moduls.CustomerDataInfo;
import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.GoodsType;
import com.mrhan.project.moduls.ShopGoods;
import com.mrhan.project.moduls.UserInfo;
import com.mrhan.project.services.BuyManager;
import com.mrhan.project.services.ShoppingCar;

public class TestDB {

	public static void main(String[] args) {
		//test4();
		test12();
		
		
		
	}

	private static void test12() {
		GoodsInfoDao gifd =new GoodsInfoDao();
		// TODO Auto-generated method stub
		CustomerInfoDao c =new CustomerInfoDao();
		GoodsTypeDao gtd =new GoodsTypeDao();
		
		CustomerInfo ci=c.getDate(1);
		//ci.setBalance(1000000f);
		c.updateData(ci);
		ShoppingCar sc=new ShoppingCar(ci);
		 ci=c.getDate(ci.getId());
		List<GoodsType> allType=gtd.getAllData("");//��ȡ��������
		for(GoodsType gt : allType){
			
			List<GoodsInfo> allGoods=gifd.getisNewGoods(gt, true);
			for(GoodsInfo gi : allGoods){
				ShopGoods sg=	new ShopGoods(gi, 1);
				System.out.println(" �۸�"+sg.getGoodsSum());
				sc.addShopGoods(sg);
			}
		}
		System.out.println(" �����ܼ�Ǯ��"+sc.getSum());
		System.out.println(" �û� "+ci.getUsername()+" ���Ϊ��"+ci.getBalance());
		System.out.println(" �����ύ������........");
		BuyManager bm =new BuyManager();
		 System.out.println("֧���ɹ���"+ bm.buyGoods(sc));
		 ci=c.getDate(ci.getId());
		 System.out.println(" �û� "+ci.getUsername()+" ���Ϊ��"+ci.getBalance());
		
	}

	private static void test11() {
		GoodsTypeDao gtd =new GoodsTypeDao();
		GoodsInfoDao gifd =new GoodsInfoDao();
		
		List<GoodsType> allType=gtd.getAllData("");//��ȡ��������
		for(GoodsType gt : allType){
			System.out.println(gt);
			List<GoodsInfo> allGoods=gifd.getisNewGoods(gt, true);
			for(GoodsInfo gi : allGoods){
				System.out.println("\t"+gi);
			}
		}
		
	}

	private static void test10() {
		UserInfoDao uid =new UserInfoDao();
		
		BulletinInfoDao biDao =new BulletinInfoDao();
		List<UserInfo> uis =uid.getAllData("");
		for(UserInfo ui :uis){
			System.out.println(ui);
			List<BulletinInfo> all =biDao.getBulletinInfo(ui);
			for(BulletinInfo bi : all){
				System.out.println("\t"+bi);
			}
		}
	}

	private static void test9() {
		GoodsInfoDao c =new GoodsInfoDao();
		List<GoodsInfo> all =c.getAllData("");
	
	
	
	for(GoodsInfo bi : all){
		System.out.println(bi);
		//System.out.println("ɾ�� "+c.deleteData(bi));
		//System.out.println("��� "+c.addDate(bi));
		
	}
		
	}

	private static void test8() {
		GoodsTypeDao c =new GoodsTypeDao();
			List<GoodsType> all =c.getAllData("");
		
		
		
		for(GoodsType bi : all){
			System.out.println(bi);
			//System.out.println("ɾ�� "+c.deleteData(bi));
			//System.out.println("��� "+c.addDate(bi));
			
		}
	}

	private static void test7() {
		// TODO Auto-generated method stub
		CustomerDataInfoDao c =new CustomerDataInfoDao();
		List<CustomerDataInfo> all =c.getAllData("");
		
		
		
		for(CustomerDataInfo bi : all){
			System.out.println(bi);
			//System.out.println("ɾ�� "+c.deleteData(bi));
			//System.out.println("��� "+c.addDate(bi));
			
		}
	}

	private static void test6() {
		CustomerInfoDao c =new CustomerInfoDao();
		List<CustomerInfo> all =c.getAllData("");
		
		
		
		for(CustomerInfo bi : all){
			System.out.println(bi);
			//System.out.println("ɾ�� "+c.deleteData(bi));
			//System.out.println("��� "+c.addDate(bi));
			
		}
		
		
	}

	private static void test5() {
		BulletinInfoDao biDao =new BulletinInfoDao();
		List<BulletinInfo> all =biDao.getAllData("");
		for(BulletinInfo bi : all){
			System.out.println(bi);
		}
		try {
			biDao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void test4() {
		UserInfoDao uid =new UserInfoDao();
		UserInfo ui =uid.getUserInfoByName("zhangsan");
		System.out.println(ui);
		ui.setUserName("����");
		System.out.println(uid.updateUserInfo(ui));
		System.out.println(uid.getUserInfoById(ui.getUserId()));
		
	}

	private static void test3() {
		ShopingDBDao sdd =new ShopingDBDao("ShoppingDB");
		
		try {
			sdd.connectionSQLSERVERDB();
			//test1(sdd);
			test2(sdd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test2(ShopingDBDao sdd) {
		SelectDataInterface dsd= sdd.select("CustomerDataInfo as a", "",
				
				" inner join CustomerInfo as b on a.customerid=b.id "," inner join CustomerDataInfo as c on c.customerid=b.id");
			System.out.println(Arrays.toString(dsd.getColNames()));
			while(dsd.hasnext()){
				dsd.next();
				
				System.out.println(Arrays.toString(dsd.getNowRowValues()));
			}
		
	}

	private static void test1(ShopingDBDao sdd) {
		SelectDataInterface dsd= sdd.select("CustomerDataInfo", new String[]{
				"name '����'"
			}," name like '_��'");
			System.out.println(Arrays.toString(dsd.getColNames()));
			while(dsd.hasnext()){
				dsd.next();
				
				System.out.println(Arrays.toString(dsd.getNowRowValues()));
			}
		
	}

}
