package com.mrhan.project.system.mamanger;

import java.sql.SQLException;
import java.util.List;

import com.mrhan.project.databases.GoodsInfoDao;
import com.mrhan.project.databases.GoodsTypeDao;
import com.mrhan.project.databases.OrderGoodsInfoDao;
import com.mrhan.project.databases.OrderInfoDao;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.GoodsType;
import com.mrhan.project.moduls.OrderGoodsInfo;
import com.mrhan.project.moduls.OrderInfo;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;

public class GoodsInfoManager extends Layout{
	private GoodsTypeDao gtd ;//商品类型管理
	private GoodsInfoDao gifd;//商品信息管理
	public GoodsInfoManager() {
		// TODO Auto-generated constructor stub
		setShowCol(4);
	setTitle("商品信息管理");
	gtd = new GoodsTypeDao();
	gifd = new GoodsInfoDao();
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
					out(sp-1,"\t");out("新品");
					out(sp-1,"\t");out("商品推荐");
					out(sp-1,"\t");out("状态");
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
							out(sp-1,"\t");out(gi.getDiscount());
							out(sp-1,"\t");out(gi.isNew());
							out(sp-1,"\t");out(gi.isRecommend());
							out(sp-1,"\t");out(gi.isState()?"上架":"下架");
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
					out(sp-1,"\t");out("新品");
					out(sp-1,"\t");out("商品推荐");
					out(sp-1,"\t");out("状态");
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
							if(gi.isState()){
								out(sp-1,"\t");out(gi.getGoodId());
								
								String b=gi.getName();
								out(sp,"\t");out(b);
								out(sp,"\t");out(gi.getPrice());
								out(sp-1,"\t");out(gi.getDiscount());
								out(sp-1,"\t");out(gi.isNew());
								out(sp-1,"\t");out(gi.isRecommend());
								out(sp-1,"\t");out(gi.isState()?"上架":"下架");
								out(sp-1,"\t");out(gi.getNum());
								out(sp-1,"\t");outln(gi.getRemark());
							}
						}
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
					out(sp-1,"\t");out("新品");
					out(sp-1,"\t");out("商品推荐");
					out(sp-1,"\t");out("状态");
					out(sp-1,"\t");out("现存量");
					out(sp-1,"\t");outln("备注");
					outln(80,"_");
					
						List<GoodsInfo> all = gifd.getGoods(gt);//获取当前类型下的商品信息
						for(GoodsInfo gi :all){
							out(1,"   ");out(gi.getGoodId());
							String b=gi.getName();
							out(sp,"\t");out(b);
							out(sp,"\t");out(gi.getPrice());
							out(sp-1,"\t");out(gi.getDiscount());
							out(sp-1,"\t");out(gi.isNew());
							out(sp-1,"\t");out(gi.isRecommend());
							out(sp-1,"\t");out(gi.isState()?"上架":"下架");
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
	
	fv =new FunView("添加商品");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
		
			try {
				gtd.connectionSQLSERVERDB();
				gifd.connectionSQLSERVERDB();
				
				String name ="";//名称
				GoodsType type=null;//类型
				float price=0.0f;//价格
				float discount=0.0f;//折扣
				int num=0;//存量
				String remark="";//商品
				boolean a = false;
				do{
					name = iv.get("请输入商品名称：");
					a=false;
					if(name.isEmpty()){
						out(3," ");outln("商品名称不许为空!");
						out(3," ");outln("请重新输入");
						a=true;
						continue;
					}
					if(gifd.getDate("goodsName", name, true)!=null){
						out(3," ");outln("存在此名称["+name+"]的商品信息!");
						out(3," ");outln("请重新输入");
						a=true;
					}
				}while(a);
				
				do{
					String tn = iv.get("请输入商品类型名称：");
					type=gtd.getDate("typename", tn, true);
					if(type==null){
						a=true;
						out(3," ");
						if(iv.getYesNo("不存在["+tn+"]的类型!是否添加？")){
							gtd.addDate(new GoodsType(tn));
							type=gtd.getDate("typename", tn, true);
							a=type==null;
						}
					}
					
				}while(a);
				
				
				
				do{
					a=false;
					String tn = iv.get("请输入商品价格：");
					try{
						price=Float.parseFloat(tn);
					}catch(NumberFormatException nef){
						out(3," ");outln("请输入数字[...0-9.0-9...]");
						out(3," ");outln("请重新输入");
						a=true;
						
					}
					
				}while(a);
				
				do{
					a=false;
					String tn = iv.get("请输入商品折扣：");
					try{
						discount=Float.parseFloat(tn);
					}catch(NumberFormatException nef){
						out(3," ");outln("请输入数字[...0-9.0-9...]");
						out(3," ");outln("请重新输入");
						a=true;
						
					}
					
				}while(a);
				

				do{
					a=false;
					String tn = iv.get("请输入商品存量：");
					try{
						num=Integer.parseInt(tn);
					}catch(NumberFormatException nef){
						out(3," ");outln("请输入数字[...0-9]");
						out(3," ");outln("请重新输入");
						a=true;
						
					}
					
				}while(a);
				
				remark = iv.get("请输入商品备注：");
				GoodsInfo gi =new GoodsInfo(type, name, price, discount, true, true, true, num);
				if(gifd.addDate(gi)){
					out(3," ");outln("添加成功");
				}else{
					out(3," ");outln("添加失败");
				}
				
				gtd.close();
				gifd.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			nowSelectView.show();
		}
	});
	addView(fv);
	fv =new FunView("修改商品价格");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				
				 String sid =iv.get("请输入商品编号：");
				 try{
				  int id=Integer.parseInt(sid);
				  GoodsInfo gi = gifd.getDate(id);
				  if(gi==null){
					  out(3," ");outln("不存在商品["+id+"]");
					  gifd.close();
					  return ;
				  }
				  float p =Float.parseFloat(iv.get("请输入新的商品价格："));
				  gi.setPrice(p);
				  if(gifd.updateData(gi)){
						out(3," ");outln("修改成功");
					}else{
						out(3," ");outln("修改失败");
					}
				 
				 }catch(NumberFormatException e){
					 out(3," ");outln("请输入数字[...0-9]");
				 }
				
				gifd.close();
			}catch(SQLException s){};
			nowSelectView.show();
		}
	});
	addView(fv);
	
	fv =new FunView("修改商品价格");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				
				 String sid =iv.get("请输入商品编号：");
				 try{
				  int id=Integer.parseInt(sid);
				  GoodsInfo gi = gifd.getDate(id);
				  if(gi==null){
					  out(3," ");outln("不存在商品["+id+"]");
					  gifd.close();
					  return ;
				  }
				  float p =Float.parseFloat(iv.get("请输入新的商品折扣："));
				  gi.setDiscount(p);
				  if(gifd.updateData(gi)){
						out(3," ");outln("修改成功");
					}else{
						out(3," ");outln("修改失败");
					}
				 
				 }catch(NumberFormatException e){
					 out(3," ");outln("请输入数字[...0-9]");
				 }
				
				gifd.close();
			}catch(SQLException s){};
			nowSelectView.show();
		}
	});
	addView(fv);
	fv =new FunView("增加商品存量");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				
				 String sid =iv.get("请输入商品编号：");
				 try{
				  int id=Integer.parseInt(sid);
				  GoodsInfo gi = gifd.getDate(id);
				  if(gi==null){
					  out(3," ");outln("不存在商品["+id+"]");
					  gifd.close();
					  return ;
				  }
				  int n=Integer.parseInt(iv.get("请输入增加商品数量[-/+]："));
				  gi.setNum(gi.getNum()+n);
				  if(gifd.updateData(gi)){
						out(3," ");outln("修改成功");
					}else{
						out(3," ");outln("修改失败");
					}
				 
				 }catch(NumberFormatException e){
					 out(3," ");outln("请输入数字[...0-9]");
				 }
				
				gifd.close();
			}catch(SQLException s){};
			nowSelectView.show();
		}
	});
	addView(fv);
	
	fv =new FunView("修改商品类型");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				
				gtd.connectionSQLSERVERDB();
				
				 String sid =iv.get("请输入商品编号：");
				 try{
				  int id=Integer.parseInt(sid);
				  GoodsInfo gi = gifd.getDate(id);
				  if(gi==null){
					  out(3," ");outln("不存在商品["+id+"]");
					  gifd.close();
					  return ;
				  }
				  String tn = iv.get("请输入商品类型名称：");
					GoodsType type = gtd.getDate("typename", tn, true);
					if(type==null){
						out(3," ");
						if(iv.getYesNo("不存在["+tn+"]的类型!是否添加？")){
							gtd.addDate(new GoodsType(tn));
							type=gtd.getDate("typename", tn, true);
						}
					}
					if(type!=null){
						gi.setGoodsType(type);
						 if(gifd.updateData(gi)){
								out(3," ");outln("修改成功");
							}else{
								out(3," ");outln("修改失败");
							}
					}else{
						out(3," ");outln("修改失败");
					}
					 
				 
				 }catch(NumberFormatException e){
					 out(3," ");outln("请输入数字[...0-9]");
				 }
				
				gifd.close();
				gtd.close();
			}catch(SQLException s){};
			nowSelectView.show();
		}
	});
	addView(fv);
	
	
	fv =new FunView("修改指定类型的商品的类型");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				
				gtd.connectionSQLSERVERDB();
				
				
			
				  String tn = iv.get("请输入商品类型名称：");
					GoodsType type = gtd.getDate("typename", tn, true);
					if(type==null){
						out(3," ");
						if(iv.getYesNo("不存在["+tn+"]的类型!是否添加？")){
							gtd.addDate(new GoodsType(tn));
							type=gtd.getDate("typename", tn, true);
						}
					}
					
					 String tn1 = iv.get("请输入商品类型名称：");
						GoodsType type1 = gtd.getDate("typename", tn1, true);
						if(type1==null){
							out(3," ");
							if(iv.getYesNo("不存在["+tn+"]的类型!是否添加？")){
								gtd.addDate(new GoodsType(tn));
								type1=gtd.getDate("typename", tn, true);
							}
						}
						//判断是否都为空
						if(type1==null || type==null){
							gifd.close();
							gtd.close();
							out(3," ");outln("修改失败 类型空");
							return ;
						}
						
						List<GoodsInfo> all = gifd.getGoods(type);
						if(iv.getYesNo("是否修改类型["+tn+"]下的所有商品 为 新的类型["+tn1+"]")){
							for(GoodsInfo gi : all){
								gi.setGoodsType(type1);
								if(gifd.updateData(gi)){
									  out(1,"\t");outln("修改 ["+gi.getGoodId()+":"+gi.getName()+"] 成功");
								  }else{
									  out(1,"\t");outln("修改 ["+gi.getGoodId()+":"+gi.getName()+"] 失败");
								}
							}
						}else{
							out(3," ");outln("取消修改");
						}
					
					
				
				gifd.close();
				gtd.close();
			}catch(SQLException s){};
			nowSelectView.show();
		}
	});
	addView(fv);
	
	
	fv =new FunView("删除商品");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				OrderInfoDao uid =new OrderInfoDao();
				OrderGoodsInfoDao ogid =new OrderGoodsInfoDao();
				
				 String sid =iv.get("请输入商品编号：");
				 try{
				  int id=Integer.parseInt(sid);
				  GoodsInfo gi = gifd.getDate(id);
				  if(gi==null){
					  out(3," ");outln("不存在商品["+id+"]");
					  gifd.close();
					  return ;
				  }
				  if(iv.getYesNo("是否删除商品["+id+"] 注:如果订单商品包含此商品也会被删除")){
					 
					  List<OrderGoodsInfo> all = ogid.getOrderGoodsByGoods(gi);
					  for(OrderGoodsInfo ois : all){
						  ogid.deleteData(ois.getOrderInfo());
						  uid.deleteData(ois.getOrderInfo());
						  
					  }
					  
					  
					  if(gifd.deleteData(gi)){
						  out(3," ");outln("删除成功");
					  }else{
							out(3," ");outln("删除失败");
						}
				  }else{
					  out(3," ");outln("取消删除");
				  }
				 }catch(NumberFormatException e){
					 out(3," ");outln("请输入数字[...0-9]");
				 }
				
				gifd.close();
				ogid.close();
				uid.close();
				
			}catch(SQLException s){};
			nowSelectView.show();
		}
	});
	addView(fv);
	
	fv =new FunView("删除指定类型下的商品");
	fv.setSe(new SelectEvent() {
		
		@Override
		public void select(FlowView last, FlowView now) {
			nowSelectView=last;
			try{
				gifd.connectionSQLSERVERDB();
				
				gtd.connectionSQLSERVERDB();
				
				  String tn = iv.get("请输入商品类型名称：");
					GoodsType type = gtd.getDate("typename", tn, true);
					if(type==null){
						out(3," ");
						if(iv.getYesNo("不存在["+tn+"]的类型!是否添加？")){
							gtd.addDate(new GoodsType(tn));
							type=gtd.getDate("typename", tn, true);
						}
					}
					List<GoodsInfo> all = gifd.getGoods(type);
					if(iv.getYesNo("是否删除类型["+tn+"]下的所有商品")){
						for(GoodsInfo gi : all){
							if(gifd.deleteData(gi)){
								  out(1,"\t");outln("删除 ["+gi.getGoodId()+":"+gi.getName()+"] 成功");
							  }else{
								  out(1,"\t");outln("删除 ["+gi.getGoodId()+":"+gi.getName()+"] 失败");
							}
						}
					}else{
						out(3," ");outln("取消删除");
					}
				
				gifd.close();
				gtd.close();
				
				
			}catch(SQLException s){};
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
	@Override
	public void show() {
		showPath();
		super.show();
		iv.selectView(this);
	}

}
