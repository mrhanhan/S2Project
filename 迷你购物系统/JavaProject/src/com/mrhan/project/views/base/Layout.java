package com.mrhan.project.views.base;


public class Layout extends FlowView {
	protected InputView iv;
	public Layout() {
		iv=new InputView();
	}
	/**\
	 *显示的列数
	 */
	private int showCol=1;

	@Override
	public void otherFun() {
		

	}
	
	public int getShowCol() {
		return showCol;
	}

	public void setShowCol(int showCol) {
		this.showCol = showCol;
	}

	@Override
	public void show() {
	//	_show();
		for(int i=1;i<=childViews.size();i++){
			FlowView fv =childViews.get(i-1);
			fv._show();//调用子类的显示方法
			//out(i);out(showCol);out(i%showCol);
			if(i%showCol==0){
				ln();
			}
		}
		ln();
	}
	@Override
	public void _show() {
		out(3," ");out(id+":"+title);
	
	}

	@Override
	protected void onselect(FlowView last) {
		
		if(se!=null){
			se.select(last, this);
		}
	}

	@Override
	protected void load() {
		
		
	}
	@Override
	public void onNotSelect(Object key) {
		super.onNotSelect(key);
		show();
	    iv.selectView(this);
	}	

}
