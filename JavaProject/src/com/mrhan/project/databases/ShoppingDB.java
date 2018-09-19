package com.mrhan.project.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��Ʒ���ݿ�
 * @author MrHanHao
 *
 */
public abstract class ShoppingDB {
	private String user="sa";
	private String pwd="123456";
	
	private String dbName="";//���ݿ�����
	
	
	private SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	protected Connection connection;//���ݿ����Ӷ���
	
	/**
	 * ��������
	 * @param tableName ����
	 * @param objs ֵ���� ��д��ʽ ֵ,ֵ,ֵ
	 * @return ������Ӱ�������
	 */
	public abstract int insert(String tableName,String ...objs);
	/**
	 * ��������
	 * @param tableName ����
	 * @param where ɾ������
	 * @param objs �޸�ֵ���� ��д��ʽ: ����=ֵ,����=ֵ,����=ֵ
	 * @return ������Ӱ�������
	 */
	public abstract int update(String tableName,String where,String ...objs);
	/**
	 * ��������
	 * @param tableName ����
	 * @param where ɾ������
	 * @return ������Ӱ�������
	 */
	public abstract int delete(String tableName,String where);
	/**
	 * ��ѯ����
	 * @param tab ����
	 * @param where ��ѯ����
	 * @return ��ѯ���ݽ������
	 */
	public abstract SelectDataInterface select(String tab,String where);
	/**
	 * ��ѯ����
	 * @param tab ����
	 * @param where ��ѯ����
	 * @param jointb ������Ӳ�ѯ ��д��ʽ  ���ӷ�ʽ �� on ����,���ӷ�ʽ �� on ����,inner join TBA on a.id=TBA.id
	 * @return ��ѯ���ݽ������
	 */
	public abstract SelectDataInterface select(String tab,String where,String ...jointb);
	
	/**
	 * ��ѯ����
	 * @param tab ����
	 * @param cols ��ѯ�ֶ� ��д��ʽ �ֶ��� | �ֶ��� as �µ����� | SQL ֧�ֵ�д��
	 * @param where ��ѯ����
	 * @return ��ѯ���ݽ������
	 */
	public abstract SelectDataInterface select(String tab,String[] cols,String where);
	/**
	 * ��ѯ����
	 * @param tab ����
	 * @param where ��ѯ����
	 * @param jointb ������Ӳ�ѯ ��д��ʽ  ���ӷ�ʽ �� on ����,���ӷ�ʽ �� on ����,inner join TBA on a.id=TBA.id
	 * @return ��ѯ���ݽ������
	 */
	public abstract SelectDataInterface select(String tab,String[] cols,String where,String ...jointb);
	
	
	
	public String getUser() {
		return user;
	}
	/**
	 * �������ݿ�
	 * @throws SQLException �����쳣
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
