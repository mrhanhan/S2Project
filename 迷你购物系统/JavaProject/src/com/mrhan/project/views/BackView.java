package com.mrhan.project.views;

import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;

/**
 * �����ϼ���ͼ����
 */
public class BackView extends FunView{
	public BackView(){
		setTitle("������һ��");
	}
	@Override
	protected void onselect(FlowView last) {
		nowSelectView=last.getParentView();//������һ��
		if(nowSelectView!=null){
			nowSelectView.show();
		}
	}
}