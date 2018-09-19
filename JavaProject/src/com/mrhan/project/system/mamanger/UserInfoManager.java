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
 * 用户信息管理
 * @author MrHanHao
 *
 */
public class UserInfoManager extends Layout implements UserLogin {
	private UserInfo uiInfo;//当前登录的用户
	private UserInfoDao uido ;
	public UserInfoManager() {
		setShowCol(3);//设置3列显示
		setTitle("用户信息管理");
		uido  =new UserInfoDao();
	}
	/**
	
	
	/**
	 * 当此视图被选中时调用
	 */
	@Override
	protected void onselect(FlowView last) {
		this.show();
	}
	
	@Override
	protected void load(){
		
		fun();//功能集合
		addView(new BackView());//添加返回功能
		addView(new ExitView());//添加退出功能
	}
	
	private void fun(){
		FlowView selectUser =new FunView("查询所有用户");
		selectUser.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				
				nowSelectView=last;
				
				
				try {
					uido.connectionSQLSERVERDB();
					List<UserInfo> allUser =uido.getAllData("");
					out(1,"\t");out("编号");
					out(3,"\t");out("用户名");
					out(3,"\t");outln("密码");
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
				
				nowSelectView.show();//任务执行完后，回掉父级显示
				
				
			}
		});
		addView(selectUser);
		
		FunView fv =new FunView("注册新的用户");
			fv.setSe(new SelectEvent() {
				
				@Override
				public void select(FlowView last, FlowView now) {
					nowSelectView=last;
					try{
						uido.connectionSQLSERVERDB();//打开链接
						String name="";
						boolean isre=false;
						do{
							name=iv.get("请输入账号：");
							if(name.isEmpty()){
								out(3," ");out("账号不许为空");
							}
							isre=uido.getDate("userName", name, true)!=null;
							if(isre)
							{
								out(3," ");outln("账号已被使用");
							}
						}while(name.isEmpty() || isre);
								
							
						String pwd="";
						do{
							pwd=iv.get("请输入密码：");
							if(pwd.length()<6){
								out(3," ");
								outln("密码长度必须大于6位");
							}
						}while(pwd.length()<6);
						
						UserInfo ui =new UserInfo(name, pwd);
						if(uido.addDate(ui)){
							out(3," ");outln(name+" 注册成功");
						}else{
							out(3," ");outln(name+" 注册失败");
						}
						uido.close();
					}catch(SQLException se){
						
					}
					nowSelectView.show();//任务执行完后，回掉父级显示
					
				}
			});
			addView(fv);
		
		
		 fv =new FunView("修改登陆密码");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				try{
					uido.connectionSQLSERVERDB();//打开链接
					String newpwd = iv.get("请输入新的密码[长度>=6]：");//获取新的密码
					if(newpwd.length()<6){
						out(3," ");outln("修改失败！密码不合法");
					}else{
						String pwd =uiInfo.getUserPwd();
						uiInfo.setUserPwd(newpwd);
						if(iv.getYesNo("是否修改当前登陆用户密码？")){
							if(uido.updateData(uiInfo)){
								out(3," ");outln("修改成功！旧密码："+pwd);
								outln("   即将退回主界面");
								nowSelectView=getRootView();
							}
						}
					}
					uido.close();
				}catch(SQLException se){
					
				}
				nowSelectView.show();//任务执行完后，回掉父级显示
				
			}
		});
		addView(fv);
		
		fv =new FunView("删除登陆用户");
			fv.setSe(new SelectEvent() {
				
				@Override
				public void select(FlowView last, FlowView now) {
					nowSelectView=last;
					try{
						uido.connectionSQLSERVERDB();//打开链接
						if(iv.getYesNo("是否删除当前用户["+uiInfo.getUserName()+"]？")){
							if(uido.deleteData(uiInfo)){
								out(3," ");outln("删除成功！即将退回主界面");
								nowSelectView=getRootView();
							}
						}
						
						uido.close();
					}catch(SQLException se){
						
					}
					nowSelectView.show();//任务执行完后，回掉父级显示
					
				}
			});
			addView(fv);
		
	}
	
	
	@Override
	public void show() {
		showPath();
		super.show();
		iv.selectView(this);//让用户选择
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
