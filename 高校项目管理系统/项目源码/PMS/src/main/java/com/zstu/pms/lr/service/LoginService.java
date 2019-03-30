package com.zstu.pms.lr.service;

import java.util.List;

import com.zstu.pms.model.UserInfo;


public interface LoginService {
	
	// 根据用户名、密码查找当前用户是否存在
	public List<UserInfo> checkUserInfo(String loginAccount,String loginPassword);

}
