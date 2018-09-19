package com.mrhan.project.system.mamanger;

import java.sql.SQLException;
import java.util.List;

import com.mrhan.project.databases.UserInfoDao;
import com.mrhan.project.moduls.UserInfo;
import com.mrhan.project.services.UserLogin;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;
/**
 * �û���Ϣ����
 * @author MrHanHao
 *
 */
public class UserInfoManager extends Layout implements UserLogin {
	private UserInfo uiInfo;//��ǰ��¼���û�
	private UserInfoDao uido ;
	public UserInfoManager() {
		setShowCol(3);//����3����ʾ
		setTitle("�û���Ϣ����");
		uido  =new UserInfoDao();
	}
	/**
	
	
	/**
	 * ������ͼ��ѡ��ʱ����
	 */
	@Override
	protected void onselect(FlowView last) {
		this.show();
	}
	
	@Override
	protected void load(){
		
		fun();//���ܼ���
		addView(new BackView());//��ӷ��ع���
		addView(new ExitView());//����˳�����
	}
	
	private void fun(){
		FlowView selectUser =new FunView("��ѯ�����û�");
		selectUser.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				
				nowSelectView=last;
				
				
				try {
					uido.connectionSQLSERVERDB();
					List<UserInfo> allUser =uido.getAllData("");
					out(1,"\t");out("���");
					out(3,"\t");out("�û���");
					out(3,"\t");outln("����");
					for(UserInfo ui : allUser){
						out(1,"\t");out(ui.getUserId()+"");
						String name=ui.getUserName();
						out(3,"\t");out(name);
						out(3-name.length()/8,"\t");outln(ui.getUserPwd());
					}
					
					uido.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				nowSelectView.show();//����ִ����󣬻ص�������ʾ
				
				
			}
		});
		addView(selectUser);
		
		FunView fv =new FunView("ע���µ��û�");
			fv.setSe(new SelectEvent() {
				
				@Override
				public void select(FlowView last, FlowView now) {
					nowSelectView=last;
					try{
						uido.connectionSQLSERVERDB();//������
						String name="";
						boolean isre=false;
						do{
							name=iv.get("�������˺ţ�");
							if(name.isEmpty()){
								out(3," ");out("�˺Ų���Ϊ��");
							}
							isre=uido.getDate("userName", name, true)!=null;
							if(isre)
							{
								out(3," ");outln("�˺��ѱ�ʹ��");
							}
						}while(name.isEmpty() || isre);
								
							
						String pwd="";
						do{
							pwd=iv.get("���������룺");
							if(pwd.length()<6){
								out(3," ");
								outln("���볤�ȱ������6λ");
							}
						}while(pwd.length()<6);
						
						UserInfo ui =new UserInfo(name, pwd);
						if(uido.addDate(ui)){
							out(3," ");outln(name+" ע��ɹ�");
						}else{
							out(3," ");outln(name+" ע��ʧ��");
						}
						uido.close();
					}catch(SQLException se){
						
					}
					nowSelectView.show();//����ִ����󣬻ص�������ʾ
					
				}
			});
			addView(fv);
		
		
		 fv =new FunView("�޸ĵ�½����");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					uido.connectionSQLSERVERDB();//������
					String newpwd = iv.get("�������µ�����[����>=6]��");//��ȡ�µ�����
					if(newpwd.length()<6){
						out(3," ");outln("�޸�ʧ�ܣ����벻�Ϸ�");
					}else{
						String pwd =uiInfo.getUserPwd();
						uiInfo.setUserPwd(newpwd);
						if(iv.getYesNo("�Ƿ��޸ĵ�ǰ��½�û����룿")){
							if(uido.updateData(uiInfo)){
								out(3," ");outln("�޸ĳɹ��������룺"+pwd);
								outln("   �����˻�������");
								nowSelectView=getRootView();
							}
						}
					}
					uido.close();
				}catch(SQLException se){
					
				}
				nowSelectView.show();//����ִ����󣬻ص�������ʾ
				
			}
		});
		addView(fv);
		
		fv =new FunView("ɾ����½�û�");
			fv.setSe(new SelectEvent() {
				
				@Override
				public void select(FlowView last, FlowView now) {
					nowSelectView=last;
					try{
						uido.connectionSQLSERVERDB();//������
						if(iv.getYesNo("�Ƿ�ɾ����ǰ�û�["+uiInfo.getUserName()+"]��")){
							if(uido.deleteData(uiInfo)){
								out(3," ");outln("ɾ���ɹ��������˻�������");
								nowSelectView=getRootView();
							}
						}
						
						uido.close();
					}catch(SQLException se){
						
					}
					nowSelectView.show();//����ִ����󣬻ص�������ʾ
					
				}
			});
			addView(fv);
		
	}
	
	
	@Override
	public void show() {
		showPath();
		super.show();
		iv.selectView(this);//���û�ѡ��
	}
	@Override
	public void setLoginUser(UserInfo ui) {
		this.uiInfo=ui;
		
	}
	@Override
	public UserInfo getLoginUser() {
		// TODO Auto-generated method stub
		return this.uiInfo;
	}
}
