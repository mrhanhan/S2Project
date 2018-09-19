package com.mrhan.project.system.mamanger;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.mrhan.project.databases.GoodsInfoDao;
import com.mrhan.project.databases.GoodsTypeDao;
import com.mrhan.project.moduls.GoodsInfo;
import com.mrhan.project.moduls.GoodsType;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;

public class TypeManager extends Layout {
	private GoodsTypeDao gtd ;//商品类型管理
	private GoodsInfoDao gifd;//商品信息管理
	public TypeManager() {
		setTitle("类型管理类");
		setShowCol(4);//设置3列显示
		
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
		FunView fv =new FunView("查看所有类型");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					gtd.connectionSQLSERVERDB();
					
					List<GoodsType> allType =gtd.getAllData("");//获取所有商品类型
					gtd.close();
					int sp=3;
					out(1,"\t");out("编号");
					out(sp,"\t");outln("名称");
					for(GoodsType gt :allType){
						out(1,"\t");out(gt.getId());
						String a=gt.getName();
						out(sp,"\t");outln(a);
						
					}
				}catch(SQLException s){outln(s.toString());};
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("添加类型");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				String types = iv.get("请输入商品类型[type name1,type name2,...]：");
				try {
					gtd.connectionSQLSERVERDB();
					
					String [] tps =types.split(",");
					
					
					for(String type : tps){
						try{
						if(gtd.addDate(new GoodsType(type))){
							out(3," ");outln("["+type+"] 添加成功");
						}else{
							out(3," ");outln("["+type+"] 添加失败！已存在");
						}
						}catch(Exception sql){out(3," ");outln("["+type+"] 添加失败！已存在");}
					}
					gtd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				nowSelectView.show();
			}
		});
		addView(fv);
		fv =new FunView("删除类型");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				String types = iv.get("请输入商品类型[type id 1,type id 2,...]：");
				try {
					gtd.connectionSQLSERVERDB();
					gifd.connectionSQLSERVERDB();
					String [] tps =types.split(",");
					for(String type : tps){
						GoodsType gt =gtd.getDate("typeid", type, false);
						
						List<GoodsInfo> all = gifd.getGoods(gt);
						if(all.size()>0){
						   if(iv.getYesNo("    当前类型["+gt.getId()+":"+gt.getName()+"]下有商品\n    如果继续删除则删除所有此类型的商品,是否继续删除？")){
							   for(GoodsInfo gi : all){
								   //删除上商品
								   gifd.deleteData(gi);
							   }
						   }else{
							  
							   out(3," ");outln("["+gt.getName()+"] 删除失败！");
							   continue;
						   }
						}
						
						if(gtd.deleteData(gt)){
							out(3," ");outln("["+gt.getName()+"] 删除成功");
						
						
						}else{
							out(3," ");outln("["+gt.getName()+"] 删除失败！不存在");
						}
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
		fv =new FunView("修改类型名称");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				String types = iv.get("请输入需要修改类型的编号：");
				try {
					gtd.connectionSQLSERVERDB();
					gifd.connectionSQLSERVERDB();
					
					//for(String type : tps){
						GoodsType gt =gtd.getDate("typeid", types, false);
						if(gt!=null){
							String name= iv.get("请输入新的类型名称:");
							if(name.isEmpty() || gtd.getDate("typename",name,true)!=null){
								out(3,"");outln("类型名称重复!");
							}else{
								gt.setName(name);
								if(gtd.updateData(gt)){
									out(3,"");outln("类型修改成功!");
								}else{
									out(3,"");outln("类型修改失败!");
								}
							}
						}else{
							out(3,"");outln("不存在此类型!");
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
