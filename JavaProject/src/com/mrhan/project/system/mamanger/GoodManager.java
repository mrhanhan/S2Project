package com.mrhan.project.system.mamanger;

import java.sql.SQLException;
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
/**
 * 商品管理类
 * @author MrHanHao
 *
 */
public class GoodManager extends Layout {
	
	
	
	
	public GoodManager() {
		setShowCol(4);//设置3列显示
		setTitle("商品管理");
	
	}
	/**
	 * 加载方法
	 */
	@Override
	protected void load() {
		super.load();
		addView(new GoodsInfoManager());
		addView(new TypeManager());
		addView(new BackView());//添加返回功能
		addView(new ExitView());//添加退出功能
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
