package com.mrhan.project.services;

import com.mrhan.project.moduls.UserInfo;

public interface UserLogin {
	/**
	 * ���õ�¼�û�
	 */
	void setLoginUser(UserInfo ui);
	/**
	 * ��ȡ��¼�û�
	 */
	UserInfo getLoginUser();
}
