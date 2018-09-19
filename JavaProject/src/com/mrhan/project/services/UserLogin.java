package com.mrhan.project.services;

import com.mrhan.project.moduls.UserInfo;

public interface UserLogin {
	/**
	 * 设置登录用户
	 */
	void setLoginUser(UserInfo ui);
	/**
	 * 获取登录用户
	 */
	UserInfo getLoginUser();
}
