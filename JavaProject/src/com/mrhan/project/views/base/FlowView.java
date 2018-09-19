package com.mrhan.project.views.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����ͼ<br/>
 * ����ͼ����뱻�����������̳�<br/>
 * ��������ͼ��ʾʱ(����show()����ʱ,Ҳ����õ�ǰ�����show����,
 * ��ǰ����ͼ����ͼҲ��������ͼʱ���򲻻��������ͼ������ͼ
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
	 * ��ǰ��ͼ�ı���
	 */
	protected String title;
	//��ǰ��ͼ���
	protected int id;
	//������ͼ
	protected FlowView parentView;
	//��ǰ��ͼ�µ�����ͼ
	protected List<FlowView> childViews;

	protected Map<String,Integer> selectViewKey;//
	
	public FlowView() {
		_init();
		load();
	}
	/**
	 * ��ͼ��ʼ������
	 */
	private void _init(){
		if(nowSelectView==null)
			nowSelectView=this;
		childViews = new ArrayList<>();
		selectViewKey = new HashMap<String, Integer>();
	}
	/**
	 * ���ط���
	 */
	protected abstract void load();
	/**
	 * 
	 * @param fv
	 */
	public void addView(FlowView fv){
		childViews.add(fv);
		int a=childViews.indexOf(fv);//�ҵ���Ӧ��λ��
		selectViewKey.put(fv.title, a);
		fv.setParentView(this);//���ðְ�
		fv.id=a;//���ñ��
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
	 * ��ȡ����ڵ�
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
	 * δѡ��ʱ���õķ���
	 */
	public  void onNotSelect(Object a){
		out("Error:δ֪ѡ�� ");outln(a);
	}
	
	public void select(int id){
		
		if(id<childViews.size()){
			FlowView fv= childViews.get(id);//��ȡѡ�е���ͼ
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
	 * ͨ����������ȡ
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
	 * ��������
	 */
	public abstract void otherFun();	
	/**
	 * ��ʵ�ķ���
	 */
	public abstract void _show();
	/**
	 * ��ʵ�ķ���
	 */
	public  void show(){
		_show();//���õ�ǰ��ʾ�ķ���
		for(int i=0;i<childViews.size();i++){
			FlowView fv =childViews.get(i);
			fv._show();//�����������ʾ����
		}
	}
	/**
	 * ���ָ�����ո�
	 * @param size
	 */
	protected final void outSpace(int size){
		for(int i=0;i<size;i++){
			System.out.print(" ");
		}
	}
	/**
	 * ���ָ��������ָ���ַ�
	 * @param size
	 * @param s �ַ�
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
	 * ���ָ���ַ�����
	 * @param s
	 */
	protected final void outln(Object s){
		System.out.println(s);
	}
	/**
	 * ���ָ��������ָ���ַ�����
	 * @param size
	 * @param s �ַ�
	 */
	protected final void outln(int size,Object s){
		for(int i=0;i<size;i++){
			System.out.print(s);
		}
		System.out.println();
	}
	/**
	 * �������
	 */
	protected final void ln(){
		System.out.println();
	}
	/**
	 * ���ָ�������Ļ���
	 */
	protected final void ln(int size){
		for(int i=0;i<size;i++)
		System.out.println();
	}
	/**
	 * �ж������Ƿ�Ϸ�
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
