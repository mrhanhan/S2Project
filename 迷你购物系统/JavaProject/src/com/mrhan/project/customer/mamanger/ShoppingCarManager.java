package com.mrhan.project.customer.mamanger;

import java.sql.SQLException;
import java.util.List;

import com.mrhan.project.databases.CustomerInfoDao;
import com.mrhan.project.databases.GoodsInfoDao;
import com.mrhan.project.databases.GoodsTypeDao;
import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.ShopGoods;
import com.mrhan.project.services.BuyManager;
import com.mrhan.project.services.ShoppingCar;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.UserLogin;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;

public class ShoppingCarManager extends Layout {
	private UserLogin login;//登陆对象
	private CustomerInfoDao cido;
	private ShoppingCar  car;//购物车
	public ShoppingCarManager(UserLogin login) {
		this.login=login;
		cido = new CustomerInfoDao();
		car=login.getShCar();
		setTitle("购物车");
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
		FunView fv = new FunView("查看购物车");
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
		fv = new FunView("提交订单");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				BuyManager bm =new BuyManager();
				float sum = car.getSum();
				//获取余额
				float balance = login.getCustomerInfo().getBalance();
				if(iv.getYesNo("是否提交订单[余额:"+balance+",总价:"+sum+"]？")){
				
					if(balance-sum<0){
						out(3," ");outln("提交失败！余额不足");
					}else{
						if(bm.buyGoods(car)){
							out(3," ");outln("提交成功!恭喜获得 "+((int)sum+1)+" 积分");
							try{
								cido.connectionSQLSERVERDB();
								CustomerInfo ci=login.getCustomerInfo();
								ci.setIntegral(ci.getIntegral()+(int)sum+1);
								cido.updateData(ci);
								cido.close();
							}catch(SQLException q){}
							clear();//清除购物车
						}else{
							out(3," ");outln("提交失败！");
						}
					}
				}else{
						out(3," ");outln("提交失败！取消提交");
				}
				nowSelectView.show();
			}
		});
		addView(fv);
		fv = new FunView("删除商品");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					int id=Integer.parseInt(iv.get("请输入需要删除购物车中的内容："));
					removeGoods(id);
				}catch(NumberFormatException nf){
					out(3," ");outln("请输入数字...[0-9]！");
				}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		 fv = new FunView("清除购物车");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				if(iv.getYesNo("是否清除购物车？")){
					clear();
				}
				nowSelectView.show();
			}
		});
		addView(fv);
	}
	
	@Override
	protected void onselect(FlowView last) {
		super.onselect(last);
		show();
	}
	/**
	 * 清除购物车
	 */
	private void clear(){
		car.getAllGoods().clear();
	}
	/**
	 * 移除购物车中的商品
	 * @param id
	 */
	private void removeGoods(int id){
		ShopGoods sg =car.getGoods(id);
		if(sg==null){
			out(3," ");outln("移除失败！不存在商品["+id+"]");
		}else{
			car.removeShopGoods(sg);
		}
		
	}
	
	
	
	@Override
	public void show() {
		showPath();
		super.show();
		iv.selectView(this);
	}

}
