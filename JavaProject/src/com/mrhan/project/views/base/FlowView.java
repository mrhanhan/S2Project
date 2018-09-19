package com.mrhan.project.views.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流视图<br/>
 * 此视图类必须被其他子类来继承<br/>
 * 当此流视图显示时(调用show()方法时,也会调用当前子类的show方法,
 * 当前流视图子视图也存在子视图时，则不会调用子视图的子视图
 * @author MrHanHao
 *
 */
public abstract class FlowView {
	
	

	protected  SelectEvent se;
	
	
	
	public SelectEvent getSe() {
		return se;
	}

	public void setSe(SelectEvent se) {
		this.se = se;
	}
	
	protected static FlowView nowSelectView=null;
	
	
	public static FlowView getNowSelectView() {
		return nowSelectView;
	}
	/**
	 * 当前视图的标题
	 */
	protected String title;
	//当前视图编号
	protected int id;
	//父级视图
	protected FlowView parentView;
	//当前视图下的子视图
	protected List<FlowView> childViews;

	protected Map<String,Integer> selectViewKey;//
	
	public FlowView() {
		_init();
		load();
	}
	/**
	 * 视图初始化方法
	 */
	private void _init(){
		if(nowSelectView==null)
			nowSelectView=this;
		childViews = new ArrayList<>();
		selectViewKey = new HashMap<String, Integer>();
	}
	/**
	 * 加载方法
	 */
	protected abstract void load();
	/**
	 * 
	 * @param fv
	 */
	public void addView(FlowView fv){
		childViews.add(fv);
		int a=childViews.indexOf(fv);//找到对应的位置
		selectViewKey.put(fv.title, a);
		fv.setParentView(this);//设置爸爸
		fv.id=a;//设置编号
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public FlowView getParentView() {
		return parentView;
	}
	public void setParentView(FlowView parentView) {
		this.parentView = parentView;
	}
	public int getId() {
		return id;
	}
	public List<FlowView> getChildViews() {
		return childViews;
	}
	public Map<String, Integer> getSelectViewKey() {
		return selectViewKey;
	}
	
	/**
	 * 获取最根节点
	 * @return
	 */
	public FlowView getRootView(){
		return getRoot(this);
	}
	private FlowView getRoot(FlowView p){
		if(p.parentView==null)
			return p;
		else
			return getRoot(p.parentView);
	}
	
	
	/**
	 * 未选中时调用的方法
	 */
	public  void onNotSelect(Object a){
		out("Error:未知选项 ");outln(a);
	}
	
	public void select(int id){
		
		if(id<childViews.size()){
			FlowView fv= childViews.get(id);//获取选中的视图
			FlowView fv1=nowSelectView;
			nowSelectView=fv;
			if(fv!=null)
				fv.onselect(fv1);
			else
				onNotSelect(id);

		}else
		onNotSelect(id);
	}
	/**
	 * 通过内容来获取
	 * @param title
	 */
	public void select(String title){
		if(selectViewKey.containsKey(title)){
			select(selectViewKey.get(title));
		}else{
			onNotSelect(title);
		}
	}
	
	public void showPath(){
		StringBuilder sb =new StringBuilder();
		showPath(this, sb);
		outln(sb.length(),"**");
		outln(sb.toString());
		outln(sb.length(),"**");
	}
	private void showPath(FlowView fv,StringBuilder sb){
		if(fv!=null){
			sb.insert(0,">>").insert(0, fv.title);
			showPath(fv.parentView,sb);
		}
		
	}
	
	protected abstract void onselect(FlowView last);
	
	/**
	 * 其他功能
	 */
	public abstract void otherFun();	
	/**
	 * 现实的方法
	 */
	public abstract void _show();
	/**
	 * 现实的方法
	 */
	public  void show(){
		_show();//调用当前显示的方法
		for(int i=0;i<childViews.size();i++){
			FlowView fv =childViews.get(i);
			fv._show();//调用子类的显示方法
		}
	}
	/**
	 * 输出指定个空格
	 * @param size
	 */
	protected final void outSpace(int size){
		for(int i=0;i<size;i++){
			System.out.print(" ");
		}
	}
	/**
	 * 输出指定个数的指定字符
	 * @param size
	 * @param s 字符
	 */
	protected final void out(int size,Object s){
		for(int i=0;i<size;i++){
			System.out.print(s);
		}
	}
	protected final void out(Object s){
		System.out.print(s);
	}
	/**
	 * 输出指定字符后换行
	 * @param s
	 */
	protected final void outln(Object s){
		System.out.println(s);
	}
	/**
	 * 输出指定个数的指定字符后换行
	 * @param size
	 * @param s 字符
	 */
	protected final void outln(int size,Object s){
		for(int i=0;i<size;i++){
			System.out.print(s);
		}
		System.out.println();
	}
	/**
	 * 输出换行
	 */
	protected final void ln(){
		System.out.println();
	}
	/**
	 * 输出指定个数的换行
	 */
	protected final void ln(int size){
		for(int i=0;i<size;i++)
		System.out.println();
	}
	/**
	 * 判断邮箱是否合法
	 * @param em
	 * @return
	 */
	protected final boolean emailOk(String em){
		int a1=em.indexOf('@');
		int a2=em.lastIndexOf('@');
		int b1=em.indexOf('.');
		int b2=em.lastIndexOf('.');
		return ((a1-a2+b1-b2==0) && a1>0 && b1-a1>0 && b1<em.length()-1);
		
	}
	
}
