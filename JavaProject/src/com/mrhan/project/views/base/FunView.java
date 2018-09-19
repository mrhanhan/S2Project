package com.mrhan.project.views.base;

public class FunView extends FlowView {
	
	

	public FunView() {
		
	}
	public FunView(String title) {
		setTitle(title);
	}
	@Override
	protected void onselect(FlowView last) {
		nowSelectView=last;
		if(se!=null){
			se.select(last, this);
		}
	}

	@Override
	public void otherFun() {
		

	}

	@Override
	public void _show() {
		out(3," ");out(id+":");out(title);
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

}
