package com.mrhan.project.views;

import javax.crypto.spec.IvParameterSpec;

import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.InputView;

public class ExitView extends FunView {

	public ExitView() {
		setTitle("退出");
	}

	public ExitView(String title) {
		super(title);
		setTitle("退出");
	}
	@Override
	protected void onselect(FlowView last) {
		
		// TODO Auto-generated method stub
		super.onselect(last);
		nowSelectView=last;
		if(new InputView().getYesNo("是否退出系统？")){
		 System.out.println("即将退出系统....");
			System.exit(0);
		}else{
			nowSelectView.show();
		}
	}

}
