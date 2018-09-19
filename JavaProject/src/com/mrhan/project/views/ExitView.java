package com.mrhan.project.views;

import javax.crypto.spec.IvParameterSpec;

import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.InputView;

public class ExitView extends FunView {

	public ExitView() {
		setTitle("�˳�");
	}

	public ExitView(String title) {
		super(title);
		setTitle("�˳�");
	}
	@Override
	protected void onselect(FlowView last) {
		
		// TODO Auto-generated method stub
		super.onselect(last);
		nowSelectView=last;
		if(new InputView().getYesNo("�Ƿ��˳�ϵͳ��")){
		 System.out.println("�����˳�ϵͳ....");
			System.exit(0);
		}else{
			nowSelectView.show();
		}
	}

}
