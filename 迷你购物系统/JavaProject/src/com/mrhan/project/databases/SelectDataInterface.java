package com.mrhan.project.databases;
/**
 * 数据查询结果接口
 * @author MrHanHao
 *
 */
public interface SelectDataInterface {
	/**
	 * 是否有下一行
	 * @return 返回后或者没有
	 */
	boolean hasnext();
	/**
	 * 
	 * 获取列名称
	 * @return 返回当前结果中的列名称
	 */
	String[] getColNames();
	
	/**
	 * 获取当前行的所有数据
	 */
	String[] getNowRowValues();
	
	/**
	 * 获取当前行指定列的值
	 * @param key 列明
	 * @return 值
	 */
	String getValue(int i);
	/**
	 * 获取当前行指定列的值
	 * @param key 列明
	 * @return 值
	 */
	String getValue(String key);
	/**
	 * 移动到下一行
	 */
	void next();
	
	/**
	 * 获取当前结果有多少数据
	 * @return 返回数据行数
	 */
	int row();
	/**
	 * 获取当前列
	 * @return 返回数据行数
	 */
	int col();
	
}
