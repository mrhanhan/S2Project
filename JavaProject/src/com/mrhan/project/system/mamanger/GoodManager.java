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
 * ��Ʒ������
 * @author MrHanHao
 *
 */
public class GoodManager extends Layout {
	
	
	
	
	public GoodManager() {
		setShowCol(4);//����3����ʾ
		setTitle("��Ʒ����");
	
	}
	/**
	 * ���ط���
	 */
	@Override
	protected void load() {
		super.load();
		addView(new GoodsInfoManager());
		addView(new TypeManager());
		addView(new BackView());//��ӷ��ع���
		addView(new ExitView());//����˳�����
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
