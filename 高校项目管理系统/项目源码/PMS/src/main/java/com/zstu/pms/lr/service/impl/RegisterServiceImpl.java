package com.zstu.pms.lr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.zstu.pms.lr.service.RegisterService;
import com.zstu.pms.mapper.UserInfoMapper;
import com.zstu.pms.model.UserInfo;
import com.zstu.pms.model.UserInfoExample;
import com.zstu.pms.model.UserInfoExample.Criteria;


@Service("registerServiceImpl")
@Transactional
public class RegisterServiceImpl implements RegisterService{

	@Resource(name="userInfoMapper")
	private UserInfoMapper userInfoMapper;
	
	@Override
	public boolean registerUserInfo(UserInfo userInfo) {
		int i = userInfoMapper.insertSelective(userInfo);
		if(i>0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean checkLoginAccount(String loginAccount) {
		UserInfoExample userExample = new UserInfoExample();
		Criteria criteria = userExample.createCriteria();
		if(!StringUtils.isEmpty(loginAccount)) {
			criteria.andLoginAccountEqualTo(loginAccount);
		}
		List<UserInfo> userList = userInfoMapper.selectByExample(userExample);
		if(CollectionUtils.isEmpty(userList)) {
			return true;
		}
		return false;
	}
}
