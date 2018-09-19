package com.mrhan.project.databases;

import java.util.List;

/**
 * �����ӿ�
 * @author MrHanHao
 *
 * @param <T>
 */
public interface Operating<T>{
	/**
	 * �������
	 * @param t ����
	 * @return ���
	 */
	boolean addDate(T t);
	/**
	 * ��ȡ����
	 * @param col ָ���ֶ�
	 * @param val ָ��ֵ
	 * @param isStr �Ƿ����ַ���
	 * @return ����
	 */
	T getDate(String col,String val,boolean isStr);
	/**
	 * ��ȡָ����ŵ�����
	 * @param id ��� 
	 * @return ����
	 */
	T getDate(int id);
	/**
	 * ��ȡ��������
	 * @return ��������
	 */
	List<T> getAllData(String where);
	/**
	 * �޸�����
	 * @param t
	 * @return
	 */
	boolean updateData(T t);
	/**
	 * ɾ������
	 */
	boolean deleteData(T t);
	
}
