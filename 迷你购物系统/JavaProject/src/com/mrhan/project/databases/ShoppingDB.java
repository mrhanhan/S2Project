package com.mrhan.project.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 商品数据库
 * @author MrHanHao
 *
 */
public abstract class ShoppingDB {
	private String user="sa";
	private String pwd="123456";
	
	private String dbName="";//数据库名称
	
	
	private SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	protected Connection connection;//数据库连接对象
	
	/**
	 * 插入数据
	 * @param tableName 表名
	 * @param objs 值数组 书写方式 值,值,值
	 * @return 返回受影响的行数
	 */
	public abstract int insert(String tableName,String ...objs);
	/**
	 * 插入数据
	 * @param tableName 表名
	 * @param where 删除条件
	 * @param objs 修改值数字 书写方式: 列明=值,列明=值,列明=值
	 * @return 返回受影响的行数
	 */
	public abstract int update(String tableName,String where,String ...objs);
	/**
	 * 插入数据
	 * @param tableName 表名
	 * @param where 删除条件
	 * @return 返回受影响的行数
	 */
	public abstract int delete(String tableName,String where);
	/**
	 * 查询方法
	 * @param tab 表名
	 * @param where 查询条件
	 * @return 查询数据结果对象
	 */
	public abstract SelectDataInterface select(String tab,String where);
	/**
	 * 查询方法
	 * @param tab 表名
	 * @param where 查询条件
	 * @param jointb 多表连接查询 书写方式  连接方式 表 on 条件,连接方式 表 on 条件,inner join TBA on a.id=TBA.id
	 * @return 查询数据结果对象
	 */
	public abstract SelectDataInterface select(String tab,String where,String ...jointb);
	
	/**
	 * 查询方法
	 * @param tab 表名
	 * @param cols 查询字段 书写方式 字段名 | 字段名 as 新的名称 | SQL 支持的写法
	 * @param where 查询条件
	 * @return 查询数据结果对象
	 */
	public abstract SelectDataInterface select(String tab,String[] cols,String where);
	/**
	 * 查询方法
	 * @param tab 表名
	 * @param where 查询条件
	 * @param jointb 多表连接查询 书写方式  连接方式 表 on 条件,连接方式 表 on 条件,inner join TBA on a.id=TBA.id
	 * @return 查询数据结果对象
	 */
	public abstract SelectDataInterface select(String tab,String[] cols,String where,String ...jointb);
	
	
	
	public String getUser() {
		return user;
	}
	/**
	 * 连接数据库
	 * @throws SQLException 连接异常
	 */
	public  void connectionSQLSERVERDB() throws SQLException  {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		     connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName="+dbName,user,pwd);
		     
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	public void close() throws SQLException{
		connection.close();
	}
	
	protected String str(Object s){
		return "'"+s+"'";
	}
	
	
	protected String str(Date d){
		
		
		return "'"+sdf.format(d)+"'";
	}
	protected Date date(String s){
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
			return null;
		}
	}
	
	boolean bool(String s){
		
			return s.equals("1");
	}
	protected int _int(String s) {
		return Integer.parseInt(s);
	}
	protected float _float(String s) {
		return Float.parseFloat(s);
	}
	protected double _double(String s) {
		return Double.parseDouble(s);
	}
	
	public void setAutoCommit(boolean a) throws SQLException{
		connection.setAutoCommit(a);
	}
	public boolean getAutoCommit(boolean a) throws SQLException{
		return connection.getAutoCommit();
	}
	public void commit() throws SQLException{
		connection.commit();
	}
	public void rollback() throws SQLException{
		connection.rollback();
	}
}
