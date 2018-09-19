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

private UserLogin login;//��½����
	
	private CustomerInfoDao cid ;
	private int jf=0;
	private CustomerInfo customer;//��½�Ŀͻ�
	public GameManager(UserLogin login) {
		this.login=login;
		customer=login.getCustomerInfo();
		cid = new CustomerInfoDao();
		jf=customer.getIntegral();
		setTitle("С��Ϸ");
	}

/**
 	* ���ط���
 */
	@Override
	protected void load() {
	super.load();
	
	fun();
	addView(new BackView());//��ӷ��ع���
	addView(new ExitView());//����˳�����
    }
	
	private void fun() {
		FunView fv =new FunView("�齱С��Ϸ(ÿ�λ���10����)");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				outln(100,"x");
				out(5,"\t");outln("�齱С��Ϸ");
				outln("  �淨��ÿ�λ���10����������ʼ��Ϸ��ͨ��������1-5�ķ�ʽ����ȡ����,��5���ֵĽ�����80���ֵĽ���������ֽ���");
				outln("  ��ǰ����:"+jf);
				outln(100,"x");
				
				if(jf>10){
					
					jf-=10;//�ȿ�10��
				
					int flag[]={1,1,2,2,3};//�����Ǽ�
					Random random=new Random();
					
					List<Integer> newF=new ArrayList<>();
					while(newF.size()<5){
						newF.add(random.nextInt(4)+1);
					}
					try{
						int id= Integer.parseInt(iv.get("����������[1-5]"));
						switch(flag[newF.get(id-1)]){
						case 1:
							out(3," ");outln("��ϲ��ȡ5����");
							jf+=5;
							break;
						case 2:
							out(3," ");outln("��ϲ��ȡ80����");
							jf+=80;
							break;
						case 3:
							float b=customer.getBalance();
							float f =random.nextFloat()*random.nextInt(100);
							out(3," ");outln("��ϲ�ɺ� ��ȡ�ֽ� "+f);
							customer.setBalance(b+f);
							break;
						}
						
						out(3," ");out("�����");
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
						
						out(3," ");outln("��Ϸ���ִ�����������Ϸ����");
					}
				}else{
					out(3," ");outln("���ֲ��㣬����ȥ������Ʒ׬ȡ���ְɣ�");
				}
				nowSelectView.show();
				
			}
			
			private String flag(int f){
				if(f>2)
					return "����ֽ�";
				if(f>1)
					return "80����";
							return "5����";
			}
		}
		
				
				);
		addView(fv);
		fv =new FunView("һ������(ÿ�λ���10����)");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				outln(100,"x");
				out(5,"\t");outln("һ������ С��Ϸ");
				out(1," �淨");outln("�������һ����Χ������С��-�������,�û�������������������");
				outln("     �������Χ��100 ��С�����أ�0  ����ԭ��(100-��Χ��)������");
				outln("  ��ǰ����:"+jf);
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
						int f=max-min;//����
						int id =Integer.parseInt(iv.get("��������µ�����:"));
						if(id>=min && id<=max){
							int hd=100-f;
							out(3," ");outln("��ϲ��ȡ"+hd+"����");
							jf+=hd;
						}else{
							out(3," ");outln("���ź�δ����");
						}
						customer.setIntegral(jf);;
						cid.connectionSQLSERVERDB();
						cid.updateData(customer);
						cid.close();
						
					}catch(Exception e){
						
						out(3," ");outln("��Ϸ���ִ�����������Ϸ����");
					}
				}else{
					out(3," ");outln("���ֲ��㣬����ȥ������Ʒ׬ȡ���ְɣ�");
				}
				nowSelectView.show();
				
				
			}
		});
		addView(fv);
		fv =new FunView("����ת�ֽ�");
		fv.setSe(new SelectEvent() {
			
			@Override
			public void select(FlowView last, FlowView now) {
				nowSelectView=last;
				outln(100,"x");
				out(5,"\t");outln("����ת�ֽ�");
				outln("  ����ֽ�=ת������*0.8");
				outln("  ��ǰ����:"+jf);
				outln(100,"x");
				
				
				  try{
						
						int id =Integer.parseInt(iv.get("��������Ҫת���Ļ�������:"));
						if(id>jf){
							out(3," ");outln("ת���������ֲ�ס");
							return;
							
						}
						
						float b=id*0.8f;
						if(iv.getYesNo("�Ƿ� "+id+"����ת��Ϊ "+b+" �ֽ�")){
							jf-=id;
							
							customer.setIntegral(jf);;
							customer.setBalance(customer.getBalance()+b);;
							cid.connectionSQLSERVERDB();
							cid.updateData(customer);
							cid.close();
						}
						
					}catch(Exception e){
						
						out(3," ");outln("ת������");
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
