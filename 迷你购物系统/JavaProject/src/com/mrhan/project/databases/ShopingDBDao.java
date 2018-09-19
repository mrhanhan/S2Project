package com.mrhan.project.databases;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库操作
 * @author MrHanHao
 *
 */
public class ShopingDBDao extends ShoppingDB {
	
	
	
	@Override
	public int insert(String tableName, String... objs) {
		Statement stm=null;
		int a=0;
		try {
			stm= connection.createStatement();
			StringBuilder sb =new StringBuilder("insert into ");
			sb.append(tableName);
			sb.append(" values(");
			for(String s:objs){
				sb.append(s).append(" ,");
			}
			//去除最后一个空格
			sb=new StringBuilder(sb.substring(0, sb.length()-1));
			sb.append(")");
			
			
			
			 a= stm.executeUpdate(sb.toString());
			 
			
		} catch (SQLException e) {
		         e.printStackTrace();
		}finally{
			if(stm!=null){
				try {
					stm.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		return a;
	}
	public ShopingDBDao(String db) {
		setDbName(db);
	}
	@Override
	public int update(String tableName, String where, String... objs) {
		Statement stm=null;
		where=where.isEmpty()?"":" where "+where;
		int a=0;
		try {
			stm= connection.createStatement();
			StringBuilder sb =new StringBuilder("update ");
			sb.append(tableName);
			sb.append(" set ");
			for(String s:objs){
				sb.append(s).append(" ,");
			}
			//去除最后一个空格
			sb=new StringBuilder(sb.substring(0, sb.length()-1));
			sb.append(where);
			
			 a= stm.executeUpdate(sb.toString());
			
			
		} catch (SQLException e) {
		         e.printStackTrace();
		}finally{
			if(stm!=null){
				try {
					stm.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		return a;
	}

	@Override
	public int delete(String tableName, String where) {
		Statement stm=null;
		where=where.isEmpty()?"":" where "+where;
		int a=0;
		try {
			stm= connection.createStatement();
			
			 a= stm.executeUpdate("delete "+tableName+where);
			
			
		} catch (SQLException e) {
		         e.printStackTrace();
		}finally{
			if(stm!=null){
				try {
					stm.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		return a;
	}

	@Override
	public SelectDataInterface select(String tab, String where) {
		Statement stm=null;
		where=where.isEmpty()?"":" where "+where;
		SelectDataInterface sdif =null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			StringBuilder sb =new StringBuilder();
			sb.append("select * from ");
			sb.append(tab);
			sb.append(where);
			sdif=new SelectData(stm.executeQuery(sb.toString()));
			
			
			
		} catch (SQLException e) {
		         e.printStackTrace();
		}finally{
			
				try {
					if(rs!=null){
						rs.close();
					}
					if(stm!=null){
						stm.close();
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
		}
		
		return sdif;
	}

	@Override
	public SelectDataInterface select(String tab, String where,
			String... jointb) {
		Statement stm=null;
		where=where.isEmpty()?"":" where "+where;
		SelectDataInterface sdif =null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			StringBuilder sb =new StringBuilder();
			sb.append("select * from ");
			sb.append(tab);
			//设置多表联合查询
			for(String s : jointb){
				sb.append(" ");
				sb.append(s);
			}
			sb.append(where);
			sdif=new SelectData(stm.executeQuery(sb.toString()));
			
			
			
		} catch (SQLException e) {
		         e.printStackTrace();
		}finally{
			
				try {
					if(rs!=null){
						rs.close();
					}
					if(stm!=null){
						stm.close();
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
		}
		
		return sdif;
	}
	
	/**
	 * 查询方法
	 * @param tab 表名
	 * @param cols 查询字段 书写方式 字段名 | 字段名 as 新的名称 | SQL 支持的写法
	 * @param where 查询条件
	 * @return 查询数据结果对象
	 */
	@Override
	public  SelectDataInterface select(String tab,String[] cols,String where){
		Statement stm=null;
		where=where.isEmpty()?"":" where "+where;
		SelectDataInterface sdif =null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			StringBuilder sb =new StringBuilder("select ");
			
			for(String s : cols){
				sb.append(s).append(" ,");
			}
			sb=new StringBuilder(sb.substring(0, sb.length()-1));
			sb.append(" from ");
			sb.append(tab);
			sb.append(where);
			
			//System.out.println(sb.toString());
			sdif=new SelectData(stm.executeQuery(sb.toString()));
			
			
			
		} catch (SQLException e) {
		         e.printStackTrace();
		}finally{
			
				try {
					if(rs!=null){
						rs.close();
					}
					if(stm!=null){
						stm.close();
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
		}
		
		return sdif;
	}
	/**
	 * 查询方法
	 * @param tab 表名
	 * @param where 查询条件
	 * @param jointb 多表连接查询 书写方式  连接方式 表 on 条件,连接方式 表 on 条件,inner join TBA on a.id=TBA.id
	 * @return 查询数据结果对象
	 */
	@Override
	public  SelectDataInterface select(String tab,String[] cols,String where,String ...jointb)
	{
		Statement stm=null;
		where=where.isEmpty()?"":" where "+where;
		SelectDataInterface sdif =null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
	StringBuilder sb =new StringBuilder("select ");
			
			for(String s : cols){
				sb.append(s).append(" ,");
			}
			sb=new StringBuilder(sb.substring(0, sb.length()-1));
			sb.append(" from ");
			sb.append(tab);
			//设置多表联合查询
			for(String s : jointb){
				sb.append(" ");
				sb.append(s);
			}
			sb.append(where);
			sdif=new SelectData(stm.executeQuery(sb.toString()));
			
			
			
		} catch (SQLException e) {
		         e.printStackTrace();
		}finally{
			
				try {
					if(rs!=null){
						rs.close();
					}
					if(stm!=null){
						stm.close();
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
		}
		
		return sdif;
		
	}
	
	
	private class SelectData implements SelectDataInterface{
		
		/**
		 * 当前行
		 */
		private int nowRow =-1;
		/**
		 * 
		 */
		private String cols[];
		
		private int colnumber;//列数
		
		private List<Map<String,String>> allRow;
		
		public SelectData(ResultSet rs){
			allRow=new ArrayList<>();
			try{
				ResultSetMetaData rsmd=rs.getMetaData();
				
				int colnum=rsmd.getColumnCount();//获取列数
				colnumber=colnum;
				 cols = new String[colnum];
				for(int i=0;i<colnum;i++){
					
					String s=rsmd.getColumnLabel(i+1);
					if(s==null || s=="null"){
						s=rsmd.getColumnName(i+1);
					}
					
					cols[i]=s;
					
				}
				
				while(rs.next()){
					Map<String,String> r =new HashMap<String, String>();
					for(int i=0;i<colnum;i++){
						
						r.put(cols[i],rs.getObject(i+1).toString());//获取值
					}
					allRow.add(r);
				}
				
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	
		
		@Override
		public boolean hasnext() {
			
			return (nowRow+1)<allRow.size();
		}

		@Override
		public String[] getColNames() {
			
			return cols;
		}

		@Override
		public String[] getNowRowValues() {
			
			String [] s=null;
			if(nowRow>=0 && nowRow<allRow.size()){
				s=new String[colnumber];
				Map<String, String> row=allRow.get(nowRow);
				
				/**
				 * 获取值
				 */
				
				for(int i=0;i<colnumber;i++){
					
					s[i]=row.get(cols[i]);
				}
								
			}
			return s;
		}

		@Override
		public String getValue(int key) {
			if(nowRow>=0 && nowRow<allRow.size() && key>=0 && key<colnumber){
				
				Map<String, String> row=allRow.get(nowRow);
				return row.get(cols[key]);
				
			}
			return null;
		}

		@Override
		public String getValue(String key) {
			if(nowRow>=0 && nowRow<allRow.size()){
				
				Map<String, String> row=allRow.get(nowRow);
				return row.get(key);
				
			}
			return null;
		}

		@Override
		public void next() {
			nowRow++;
			
		}

		@Override
		public int row() {
			// TODO Auto-generated method stub
			return allRow.size();
		}
		@Override
		public int col() {
			return colnumber;
		}
		
	}
	
}
