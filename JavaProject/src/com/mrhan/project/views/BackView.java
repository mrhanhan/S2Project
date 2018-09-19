package com.mrhan.project.views;

import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;

/**
 * 返回上级视图功能
 */
public class BackView extends FunView{
	public BackView(){
		setTitle("返回上一级");
	}
	@Override
	protected void onselect(FlowView last) {
		nowSelectView=last.getParentView();//返回上一级
		if(nowSelectView!=null){
			nowSelectView.show();
		}
	}
}