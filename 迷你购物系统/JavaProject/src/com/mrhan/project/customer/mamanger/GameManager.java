package com.mrhan.project.customer.mamanger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mrhan.project.databases.CustomerDataInfoDao;
import com.mrhan.project.databases.CustomerInfoDao;
import com.mrhan.project.moduls.CustomerInfo;
import com.mrhan.project.views.BackView;
import com.mrhan.project.views.ExitView;
import com.mrhan.project.views.UserLogin;
import com.mrhan.project.views.base.FlowView;
import com.mrhan.project.views.base.FunView;
import com.mrhan.project.views.base.Layout;
import com.mrhan.project.views.base.SelectEvent;

public class GameManager extends Layout {

private UserLogin login;//登陆对象
	
	private CustomerInfoDao cid ;
	private int jf=0;
	private CustomerInfo customer;//登陆的客户
	public GameManager(UserLogin login) {
		this.login=login;
		customer=login.getCustomerInfo();
		cid = new CustomerInfoDao();
		jf=customer.getIntegral();
		setTitle("小游戏");
	}

/**
 	* 加载方法
 */
	@Override
	protected void load() {
	super.load();
	
	fun();
	addView(new BackView());//添加返回功能
	addView(new ExitView());//添加退出功能
    }
	
	private void fun() {
		FunView fv =new FunView("抽奖小游戏(每次花费10积分)");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				outln(100,"x");
				out(5,"\t");outln("抽奖小游戏");
				outln("  玩法：每次花费10个积分来开始游戏！通过猜数字1-5的方式来获取奖励,有5积分的奖励，80积分的奖励，随机现金奖励");
				outln("  当前积分:"+jf);
				outln(100,"x");
				
				if(jf>10){
					
					jf-=10;//先扣10分
				
					int flag[]={1,1,2,2,3};//奖励登记
					Random random=new Random();
					
					List<Integer> newF=new ArrayList<>();
					while(newF.size()<5){
						newF.add(random.nextInt(4)+1);
					}
					try{
						int id= Integer.parseInt(iv.get("请输入数字[1-5]"));
						switch(flag[newF.get(id-1)]){
						case 1:
							out(3," ");outln("恭喜获取5积分");
							jf+=5;
							break;
						case 2:
							out(3," ");outln("恭喜获取80积分");
							jf+=80;
							break;
						case 3:
							float b=customer.getBalance();
							float f =random.nextFloat()*random.nextInt(100);
							out(3," ");outln("可喜可贺 获取现金 "+f);
							customer.setBalance(b+f);
							break;
						}
						
						out(3," ");out("结果：");
						out(flag(flag[0]));out(3," ");
						out(flag(flag[1]));out(3," ");
						out(flag(flag[2]));out(3," ");
						out(flag(flag[3]));out(3," ");
						outln(flag(flag[4]));
						customer.setIntegral(jf);;
						cid.connectionSQLSERVERDB();
						cid.updateData(customer);
						cid.close();
						
					}catch(Exception e){
						
						out(3," ");outln("游戏出现错误！请遵守游戏规则");
					}
				}else{
					out(3," ");outln("积分不足，请先去购买商品赚取积分吧！");
				}
				nowSelectView.show();
				
			}
			
			private String flag(int f){
				if(f>2)
					return "随机现金";
				if(f>1)
					return "80积分";
							return "5积分";
			}
		}
		
				
				);
		addView(fv);
		fv =new FunView("一击命中(每次花费10积分)");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				outln(100,"x");
				out(5,"\t");outln("一击命中 小游戏");
				out(1," 玩法");outln("电脑随机一个范围数（最小数-最大数）,用户如果猜中这个返回则奖励");
				outln("     最大数范围：100 最小数返回：0  奖励原则(100-范围差)个积分");
				outln("  当前积分:"+jf);
				outln(100,"x");
			  if(jf>10){
				jf-=10;

				Random ran =new Random();
				  try{
						int max=0,min=100;
						int a=ran.nextInt(100);
						int b=ran.nextInt(100);
						max=a>b?a:b;
						min=a>b?b:a;
						int f=max-min;//返回
						int id =Integer.parseInt(iv.get("请输入你猜的数字:"));
						if(id>=min && id<=max){
							int hd=100-f;
							out(3," ");outln("恭喜获取"+hd+"积分");
							jf+=hd;
						}else{
							out(3," ");outln("很遗憾未猜中");
						}
						customer.setIntegral(jf);;
						cid.connectionSQLSERVERDB();
						cid.updateData(customer);
						cid.close();
						
					}catch(Exception e){
						
						out(3," ");outln("游戏出现错误！请遵守游戏规则");
					}
				}else{
					out(3," ");outln("积分不足，请先去购买商品赚取积分吧！");
				}
				nowSelectView.show();
				
				
			}
		});
		addView(fv);
		fv =new FunView("积分转现金");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				outln(100,"x");
				out(5,"\t");outln("积分转现金");
				outln("  获得现金=转换积分*0.8");
				outln("  当前积分:"+jf);
				outln(100,"x");
				
				
				  try{
						
						int id =Integer.parseInt(iv.get("请输入需要转换的积分数量:"));
						if(id>jf){
							out(3," ");outln("转换出错！积分不住");
							return;
							
						}
						
						float b=id*0.8f;
						if(iv.getYesNo("是否将 "+id+"积分转换为 "+b+" 现金？")){
							jf-=id;
							
							customer.setIntegral(jf);;
							customer.setBalance(customer.getBalance()+b);;
							cid.connectionSQLSERVERDB();
							cid.updateData(customer);
							cid.close();
						}
						
					}catch(Exception e){
						
						out(3," ");outln("转换出错");
					}
				
				nowSelectView.show();
				
				
				
			}
		});
		addView(fv);
		
	}
	@Override
	public void show() {
		showPath();
		super.show();
		iv.selectView(this);
	}
	@Override
	protected void onselect(FlowView last) {
		super.onselect(last);
		show();
	}
}
