package com.mrhan.project.customer.mamanger;

import java.sql.SQLException;
import java.util.List;

import com.mrhan.project.databases.GoodsInfoDao;
import com.mrhan.project.databases.GoodsTypeDao;
import com.mrhan.project.databases.OrderGoodsInfoDao;
import com.mrhan.project.databases.OrderInfoDao;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.GoodsType;
import com.mrhan.project.moduls.OrderGoodsInfo;
import com.mrhan.project.moduls.ShopGoods;
import com.mrhan.project.services.ShoppingCar;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.UserLogin;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;

public class ShoppingManager extends Layout {
	private UserLogin login;//登陆对象
	private GoodsTypeDao gtd ;//商品类型管理
	private GoodsInfoDao gifd;//商品信息管理
	private ShoppingCar  car;//购物车
	public ShoppingManager(UserLogin login) {
		this.login=login;
		car=login.getShCar();
		setTitle("购物中心");
		gifd = new  GoodsInfoDao();
		gtd= new GoodsTypeDao();
	}

/**
 * 加载方法
 */
@Override
protected void load() {
	super.load();
	
	fun();
	addView(new BackView());//添加返回功能
	addView(new ExitView());//添加退出功能
    }

	private void fun() {
	
	    FunView fv = new FunView("查看所有类型及商品");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					gtd.connectionSQLSERVERDB();
					gifd.connectionSQLSERVERDB();
					List<GoodsType> allType =gtd.getAllData("");//获取所有商品类型
					gtd.close();
					int sp=2;
					out(1,"  ");out("编号");
					out(sp,"\t");outln("名称");
					out(sp-1,"\t");out("编号");
					out(sp,"\t");out("名称");
					out(sp,"\t");out("价格");
					out(sp-1,"\t");out("折扣");
					out(sp-1,"\t");out("现存量");
					out(sp-1,"\t");outln("备注");
					outln(80,"**");
					for(GoodsType gt :allType){
						outln(130,"_");
						out(1,"  ");out(gt.getId());
						String a=gt.getName();
						out(sp,"\t");outln(a);
						List<GoodsInfo> all = gifd.getGoods(gt);//获取当前类型下的商品信息
						outln(130,"_");
						for(GoodsInfo gi :all){
							out(sp-1,"\t");out(gi.getGoodId());
							String b=gi.getName();
							out(sp,"\t");out(b);
							out(sp,"\t");out(gi.getPrice());
							out(3,"\t");out(gi.getDiscount());
							out(sp-1,"\t");out(gi.getNum());
							out(sp-1,"\t");outln(gi.getRemark());
						}
					}
					gifd.close();
				}catch(SQLException s){outln(s.toString());};
				nowSelectView.show();
			}
		});
		addView(fv);
		fv = new FunView("查看所有类型及上架商品");
		fv.setSe(new SelectEvent() {
				
				@Override
				public void select(FlowView last, FlowView now) {
					nowSelectView=last;
					try{
						gtd.connectionSQLSERVERDB();
						gifd.connectionSQLSERVERDB();
						List<GoodsType> allType =gtd.getAllData("");//获取所有商品类型
						gtd.close();
						int sp=2;
						out(1,"  ");out("编号");
						out(sp,"\t");outln("名称");
						out(sp-1,"\t");out("编号");
						out(sp,"\t");out("名称");
						out(sp,"\t");out("价格");
						out(sp-1,"\t");out("折扣");
						out(sp-1,"\t");out("现存量");
						out(sp-1,"\t");outln("备注");
						outln(80,"**");
						for(GoodsType gt :allType){
							outln(130,"_");
							out(1,"  ");out(gt.getId());
							String a=gt.getName();
							out(sp,"\t");outln(a);
							List<GoodsInfo> all = gifd.getGoods(gt);//获取当前类型下的商品信息
							outln(130,"_");
							for(GoodsInfo gi :all){
								out(sp-1,"\t");out(gi.getGoodId());
								String b=gi.getName();
								out(sp,"\t");out(b);
								out(sp,"\t");out(gi.getPrice());
								out(3,"\t");out(gi.getDiscount());
								out(sp-1,"\t");out(gi.getNum());
								out(sp-1,"\t");outln(gi.getRemark());
							}
						}
						gifd.close();
					}catch(SQLException s){outln(s.toString());};
					nowSelectView.show();
				}
			});
		addView(fv);
		
		fv = new FunView("查看相识名称的商品");
		fv.setSe(new SelectEvent() {
				
				@Override
				public void select(FlowView last, FlowView now) {
					nowSelectView=last;
					try{
						
						gifd.connectionSQLSERVERDB();
						String like =iv.get("请输入商品的大概名称:");
						
						int sp=2;
						out(1,"  ");out("编号");
						out(sp,"\t");outln("名称");
						out(sp-1,"\t");out("编号");
						out(sp,"\t");out("名称");
						out(sp,"\t");out("价格");
						out(sp-1,"\t");out("折扣");
						out(sp-1,"\t");out("现存量");
						out(sp-1,"\t");outln("备注");
						 
						
							
							List<GoodsInfo> all = gifd.getAllData("goodsName like '%"+like+"%'");//获取当前类型下的商品信息
							
							for(GoodsInfo gi :all){
								GoodsType gt =gi.getGoodsType();
								out(1,"  ");out(gt.getId());
								String a=gt.getName();
								out(sp,"\t");outln(a);
								out(sp-1,"\t");out(gi.getGoodId());
								String b=gi.getName();
								out(sp,"\t");out(b);
								out(sp,"\t");out(gi.getPrice());
								out(3,"\t");out(gi.getDiscount());
								out(sp-1,"\t");out(gi.getNum());
								out(sp-1,"\t");outln(gi.getRemark());
							}
						
						gifd.close();
					}catch(SQLException s){outln(s.toString());};
					nowSelectView.show();
				}
			});
		addView(fv);
		
		fv =new FunView("查看指定类型下的商品");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					gtd.connectionSQLSERVERDB();
					gifd.connectionSQLSERVERDB();
					String name=iv.get("请输入类型名称：");
					GoodsType gt =gtd.getDate("typeName", name, true);//获取所有商品类型
					
						
					
					gtd.close();
					int sp=2;
					if(gt!=null){
					
						out(1,"   ");out("编号");
						out(sp,"\t");out("名称");
						out(sp,"\t");out("价格");
						out(sp-1,"\t");out("折扣");
						out(sp-1,"\t");out("现存量");
						out(sp-1,"\t");outln("备注");
						outln(80,"_");
						
							List<GoodsInfo> all = gifd.getGoods(gt);//获取当前类型下的商品信息
							for(GoodsInfo gi :all){
								out(1,"   ");out(gi.getGoodId());
								String b=gi.getName();
								out(sp,"\t");out(b);
								out(sp,"\t");out(gi.getPrice());
								out(3,"\t");out(gi.getDiscount());
								out(sp-1,"\t");out(gi.getNum());
								out(sp-1,"\t");outln(gi.getRemark());
							}
					
					}else{
						out(3,"");outln("找不到此商品类型");
					}
					gtd.close();
					gifd.close();
				}catch(SQLException s){};
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("添加到购物车");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					gtd.connectionSQLSERVERDB();
					gifd.connectionSQLSERVERDB();
					int id=0;
					int num=0;
					try{
						id = Integer.parseInt(iv.get("请输入商品编号"));
						num=Integer.parseInt(iv.get("请输入购买数量"));
					
					}catch(NumberFormatException sn){
						gtd.close();
						gifd.close();
						out(2," ");outln("请输入数字[0-9]");
						return;
					}
					add(id,num);
					
					
					
					
					
					gtd.close();
					gifd.close();
				}catch(SQLException s){};
				nowSelectView.show();
			}

			
		});
		addView(fv);
		fv =new FunView("添加到购物车(多选)");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					gtd.connectionSQLSERVERDB();
					gifd.connectionSQLSERVERDB();
					String ss=iv.get("请输入商品编号 及数量[id count,id count]:");
					
					String []s = ss.split(",");
					for(String item : s){
						add(item);
					}
					
					gtd.close();
					gifd.close();
				}catch(SQLException s){};
				nowSelectView.show();
			}

			
		});
		addView(fv);
		fv =new FunView("查看购物车");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				List<ShopGoods> allg = car.getAllGoods();//获取购物车信息
				out(1,"\t");out("商品编号");
				out(2,"\t");out("商品名称");
				out(3,"\t");out("商品类型名称");
				out(3,"\t");out("商品单价");
				out(3,"\t");out("商品折扣");
				out(3,"\t");out("购买数量");
				out(3,"\t");outln("购买总价");
				for(ShopGoods sg : allg){
					GoodsInfo fi =sg.getGoodsInfo();
					out(1,"\t");out(fi.getGoodId());
					out(2,"\t");out(fi.getName());
					out(3,"\t");out(fi.getGoodsType().getName());
					out(3,"\t");out(fi.getPrice());
					out(3,"\t");out(fi.getDiscount());
					out(3,"\t");out(sg.getCount());
					out(3,"\t");outln(sg.getGoodsSum());
				}
				outln(150,"_");
				out(15,"\t");out("总价格：");outln(car.getSum());
				nowSelectView.show();
			}
		});
		addView(fv);
		
}
	
	private void add(String add){
		int id=0;
		int num;
		String []ss =add.split(" ");
		if(ss.length>1){
			try{
				id = Integer.parseInt(ss[0]);
				num=Integer.parseInt(ss[1]);
				add(id,num);
			}catch(NumberFormatException s){
				out(2," ");outln("请输入数字[0-9]");
				
			}
			
		}else{
			out(3," ");outln("'"+add+"'格式错误");
		}
	}
	private void add(int id, int num) {
		GoodsInfo gi =gifd.getDate(id);
		
		
		if(gi==null){
			out(2," ");outln("添加失败！未找到此商品信息");
		}else{
			//获取购物车当前商品数量
			int carSum = car.getGoodsSum(gi.getGoodId());
			//计算总数量
			int sums=carSum+num;
			if(sums>gi.getNum()){
				out(2," ");outln("商品库存不足请从新选择[最大值:"+gi.getNum()+"]");
				out(2," ");outln("添加失败！商品库存不足");
			}else{
				car.addShopGoods(new ShopGoods(gi, num));
				out(2," ");outln("添加成功");
			}
			
		}
		
	}
	
	@Override
	protected void onselect(FlowView last) {
		super.onselect(last);
		show();
	}
	@Override
	public void show() {
		showPath();
		super.show();
		iv.selectView(this);
	}

}