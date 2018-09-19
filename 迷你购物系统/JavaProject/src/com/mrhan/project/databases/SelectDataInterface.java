package com.mrhan.project.databases;
/**
 * ���ݲ�ѯ����ӿ�
 * @author MrHanHao
 *
 */
public interface SelectDataInterface {
	/**
	 * �Ƿ�����һ��
	 * @return ���غ����û��
	 */
	boolean hasnext();
	/**
	 * 
	 * ��ȡ������
	 * @return ���ص�ǰ����е�������
	 */
	String[] getColNames();
	
	/**
	 * ��ȡ��ǰ�е���������
	 */
	String[] getNowRowValues();
	
	/**
	 * ��ȡ��ǰ��ָ���е�ֵ
	 * @param key ����
	 * @return ֵ
	 */
	String getValue(int i);
	/**
	 * ��ȡ��ǰ��ָ���е�ֵ
	 * @param key ����
	 * @return ֵ
	 */
	String getValue(String key);
	/**
	 * �ƶ�����һ��
	 */
	void next();
	
	/**
	 * ��ȡ��ǰ����ж�������
	 * @return ������������
	 */
	int row();
	/**
	 * ��ȡ��ǰ��
	 * @return ������������
	 */
	int col();
	
}
