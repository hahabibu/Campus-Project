package com.zstu.pms.lr.service;

import com.zstu.pms.model.UserInfo;

public interface RegisterService {
	
	// 用户注册
	public boolean registerUserInfo(UserInfo userInfo);

	// 检查用户名是否已存在
	public boolean checkLoginAccount(String loginAccount);
}
