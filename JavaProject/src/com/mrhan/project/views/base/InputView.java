package com.mrhan.project.views.base;

import java.util.Scanner;

public class InputView extends FlowView {
	
	
	private Scanner sc =new Scanner(System.in);
	public InputView() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected void load() {
		
	}
	@Deprecated
	@Override
	protected void onselect(FlowView last) {
		// TODO Auto-generated method stub

	}
	@Deprecated
	@Override
	public void otherFun() {
		// TODO Auto-generated method stub

	}
	@Deprecated
	@Override
	public void _show() {
		// TODO Auto-generated method stub

	}
	
	public void selectView(FlowView fv){
		outln(40,"_");
		out("请选择功能：");
		String a=sc.nextLine();
		int n=-1;
		try{
			n=Integer.parseInt(a);
		
			
		}catch(Exception e){
		
			
	    }finally{
			outln(40,"_");
		}
		if(n>=0){
			fv.select(n);
		}else{
			fv.select(a);
		}
	}
	
	public void showLine(){
		outln(40,"_");
	}
	public String get(String msg){
		outln(msg);
		String a=sc.nextLine();
		
		return a;
	}
	
	
	public boolean getYesNo(String msg){
		outln(msg+" 请选择（Y/N）:");
		String a=sc.nextLine();
		return (a.toUpperCase().equals("Y"));
	}
}
