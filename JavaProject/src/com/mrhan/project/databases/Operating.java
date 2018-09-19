package com.mrhan.project.databases;

import java.util.List;

/**
 * 操作接口
 * @author MrHanHao
 *
 * @param <T>
 */
public interface Operating<T>{
	/**
	 * 添加数据
	 * @param t 数据
	 * @return 结果
	 */
	boolean addDate(T t);
	/**
	 * 获取数据
	 * @param col 指定字段
	 * @param val 指定值
	 * @param isStr 是否数字符串
	 * @return 数据
	 */
	T getDate(String col,String val,boolean isStr);
	/**
	 * 获取指定编号的数据
	 * @param id 编号 
	 * @return 数据
	 */
	T getDate(int id);
	/**
	 * 获取所有数据
	 * @return 所有数据
	 */
	List<T> getAllData(String where);
	/**
	 * 修改数据
	 * @param t
	 * @return
	 */
	boolean updateData(T t);
	/**
	 * 删除数据
	 */
	boolean deleteData(T t);
	
}
