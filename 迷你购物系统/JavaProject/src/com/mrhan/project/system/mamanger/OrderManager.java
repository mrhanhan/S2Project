package com.mrhan.project.system.mamanger;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.mrhan.project.databases.CustomerInfoDao;
import com.mrhan.project.databases.GoodsInfoDao;
import com.mrhan.project.databases.OrderGoodsInfoDao;
import com.mrhan.project.databases.OrderInfoDao;
import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.OrderGoodsInfo;
import com.mrhan.project.moduls.OrderInfo;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;
/**
 * 订单信息管理
 * @author MrHanHao
 *
 */
public class OrderManager extends Layout {
	private OrderInfoDao oid;
	private OrderGoodsInfoDao ogid;
	private SimpleDateFormat sdf ;
	public OrderManager() {
		setShowCol(4);
		setTitle("订单管理");
		sdf =new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		oid =new OrderInfoDao();
		ogid = new OrderGoodsInfoDao();
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
		FunView fv =new FunView("查看所有订单");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					oid.connectionSQLSERVERDB();
					List<OrderInfo>  allorder =oid.getAllData("");
					out(1,"\t");out("编号");
					out(2,"\t");out("客户账号");
					out(4,"\t");out("状态");
					out(2,"\t");outln("时间");
					for(OrderInfo oi : allorder){
						out(1,"\t");out(oi.getOrderId());
						out(2,"\t");out(oi.getCustomerInfo().getUsername());
						out(4,"\t");out(oi.isState()?"完成":"未完成");
						//out(2,"\t");outln(oi.getOrderDate());
						out(2,"\t");outln(sdf.format(oi.getOrderDate()));
					}
					oid.close();
				}catch(SQLException sq){}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("查看指定编号订单");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					oid.connectionSQLSERVERDB();
					int id=0;
					try{
						id =Integer.parseInt(iv.get("请输入订单编号："));
					}catch(NumberFormatException nfe){
						out(3,"");out("请输入数字：");
						oid.close();
						return; 
					}
					OrderInfo oi =oid.getDate(id);
					out(1,"\t");out("编号");
					out(2,"\t");out("客户账号");
					out(4,"\t");out("状态");
					out(2,"\t");outln("时间");
					if(oi!=null){
						out(1,"\t");out(oi.getOrderId());
						out(2,"\t");out(oi.getCustomerInfo().getUsername());
						out(4,"\t");out(oi.isState()?"完成":"未完成");
						out(2,"\t");outln(sdf.format(oi.getOrderDate()));
					}else{
						out(3,"");out("未找到此订单["+id+"]");
					}
					oid.close();
				}catch(SQLException sq){}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("查看商品销售情况");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				GoodsInfoDao gifd =new GoodsInfoDao();
				try{
					oid.connectionSQLSERVERDB();
					ogid.connectionSQLSERVERDB();
					
					List<GoodsInfo> allg =gifd.getAllData("");
					out(1,"\t");out("商品编号");
					out(3,"\t");out("商品类型名称");
					out(3,"\t");out("商品名称");
					out(3,"\t");out("商品价格");
					out(3,"\t");out("商品折扣");
					out(3,"\t");outln("订单数量");
					for(GoodsInfo gi : allg){
						int size=ogid.getOrderGoodsByGoods(gi).size();//获取当前商品的订单数量
					  if(size>0){
						out(1,"\t");out(gi.getGoodId());
						out(3,"\t");out(gi.getGoodsType().getName());
						out(3,"\t");out(gi.getName());
						out(3,"\t");out(gi.getPrice());
						out(3,"\t");out(gi.getDiscount());
						out(3,"\t");outln(size);
					  }
					}
					gifd.close();
					oid.close();
					ogid.close();
					
				}catch(SQLException sql){}
				
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("查看指定订单的商品");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					oid.connectionSQLSERVERDB();
					ogid.connectionSQLSERVERDB();
					int id=0;
					try{
						id =Integer.parseInt(iv.get("请输入订单编号："));
					}catch(NumberFormatException nfe){
						out(3,"");out("请输入数字：");
						oid.close();
						return; 
					}
					OrderInfo oi =oid.getDate(id);
					out(1,"\t");out("编号");
					out(2,"\t");out("客户账号");
					
					out(1,"\t");out("商品编号");
					out(3,"\t");out("商品类型名称");
					
					out(3,"\t");out("商品名称");
					out(3,"\t");out("商品价格");
					
					out(3,"\t");out("商品折扣");
					out(3,"\t");outln("购买数量");
					if(oi!=null){
						List<OrderGoodsInfo> allgos =ogid.getOrderGoods(oi);
						for(OrderGoodsInfo ogi : allgos){
							out(1,"\t");out(ogi.getId());
							out(2,"\t");out(ogi.getOrderInfo().getCustomerInfo().getUsername());
							out(1,"\t");out(ogi.getGoodsInfo().getGoodId());
							out(3,"\t");out(ogi.getGoodsInfo().getGoodsType().getName());
							out(3,"\t");out(ogi.getGoodsInfo().getName());
							out(3,"\t");out(ogi.getGoodsInfo().getPrice());
							
							out(3,"\t");out(ogi.getGoodsInfo().getDiscount());
							out(3,"\t");outln(ogi.getNum());
						}
					}else{
						out(3,"");outln("未找到此订单["+id+"]");
					}
					ogid.close();
					oid.close();
				}catch(SQLException sq){}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("查看指定客户的订单信息");
    	fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					oid.connectionSQLSERVERDB();
					ogid.connectionSQLSERVERDB();
					CustomerInfoDao cid =new CustomerInfoDao();
					int id=0;
					try{
						id =Integer.parseInt(iv.get("请输客户编号："));
					}catch(NumberFormatException nfe){
						out(3,"");out("请输入数字：");
						cid.close();
						oid.close();
						ogid.close();
						return; 
					}
					CustomerInfo ci =cid.getDate(id);
					if(ci==null){
						out(3,"");outln("未找到此客户["+id+"]");
					}else{
						List<OrderInfo>  allorder =oid.getOldOrderInfos(ci);
						out(1,"\t");out("编号");
						out(2,"\t");out("客户账号");
						out(4,"\t");out("状态");
						out(2,"\t");outln("时间");
						for(OrderInfo oi : allorder){
							out(1,"\t");out(oi.getOrderId());
							out(2,"\t");out(oi.getCustomerInfo().getUsername());
							out(4,"\t");out(oi.isState()?"完成":"未完成");
							out(2,"\t");outln(sdf.format(oi.getOrderDate()));
							List<OrderGoodsInfo> allg =ogid.getOrderGoods(oi);
							out(3,"\t");out("编号");
							out(1,"\t");out("商品编号");
							out(3,"\t");out("商品类型名称");
							
							out(3,"\t");out("商品名称");
							out(3,"\t");out("商品价格");
							
							out(3,"\t");out("商品折扣");
							out(3,"\t");outln("购买数量");
							for(OrderGoodsInfo ogi : allg){
								out(3,"\t");out(ogi.getId());
								out(1,"\t");out(ogi.getGoodsInfo().getGoodId());
								out(3,"\t");out(ogi.getGoodsInfo().getGoodsType().getName());
								
								out(3,"\t");out(ogi.getGoodsInfo().getName());
								out(3,"\t");out(ogi.getGoodsInfo().getPrice());
								
								out(3,"\t");out(ogi.getGoodsInfo().getDiscount());
								out(3,"\t");outln(ogi.getNum());
							}
						}
					}
					oid.close();
					cid.close();
					ogid.close();
				}catch(SQLException sq){}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		
		fv =new FunView("删除指定客户的订单");
        fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				CustomerInfoDao cid =new CustomerInfoDao();
				try{
					oid.connectionSQLSERVERDB();
					ogid.connectionSQLSERVERDB();
					
					int id=0;
					try{
						id =Integer.parseInt(iv.get("请输入客户编号："));
					}catch(NumberFormatException nfe){
						out(3,"");outln("请输入数字：");
						cid.close();
						oid.close();
						ogid.close();
						return; 
					}
					CustomerInfo ci =cid.getDate(id);
					if(ci==null){
						out(3,"");out("未找到此客户["+id+"]");
					}else{
						if(iv.getYesNo("是否删除 客户 ["+id+"]所有的订单？")){
							List<OrderInfo> os = oid.getNewOrderInfos(ci);
							for(OrderInfo o : os){
								ogid.deleteData(o);
								oid.deleteData(o);
							}
							out(3,"");outln("删除成功");
						}else{
							out(3,"");outln("删除失败，取消删除");
						}
						
					}
					cid.close();
					oid.close();
					ogid.close();
				}catch(SQLException s){};
				
			}});
		addView(fv);
		fv =new FunView("删除指定编号的订单");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				try{
					oid.connectionSQLSERVERDB();
					ogid.connectionSQLSERVERDB();
					int id=0;
					try{
						id =Integer.parseInt(iv.get("请输入订单编号："));
					}catch(NumberFormatException nfe){
						out(3,"");outln("请输入数字：");
						oid.close();
						return; 
					}
					OrderInfo oi =oid.getDate(id);
					if(oi==null){
						out(3,"");outln("未找到此订单["+id+"]");
					}else{
						if(iv.getYesNo("是否删除订单["+id+"]信息")){
							ogid.deleteData(oi);
							oid.deleteData(oi);
							out(3,"");outln("删除成功");
						}else{
							out(3,"");outln("删除失败，取消删除");
						}
					}
					oid.close();
					ogid.close();
				}catch(SQLException s){}
				
			}
		});
		addView(fv);
		
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
