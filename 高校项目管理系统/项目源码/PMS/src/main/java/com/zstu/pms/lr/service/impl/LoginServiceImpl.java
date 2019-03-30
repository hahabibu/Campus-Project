package com.zstu.pms.lr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.zstu.pms.lr.service.LoginService;
import com.zstu.pms.mapper.UserInfoMapper;
import com.zstu.pms.model.UserInfo;
import com.zstu.pms.model.UserInfoExample;
import com.zstu.pms.model.UserInfoExample.Criteria;
import com.zstu.pms.utils.ConstantUtils;




@Service("loginServiceImpl")
@Transactional
public class LoginServiceImpl implements LoginService{

	@Resource(name="userInfoMapper")
	UserInfoMapper userInfoMapper;
	
	@Override
	public List<UserInfo> checkUserInfo(String loginAccount, String loginPassword) {
		UserInfoExample userExample  = new UserInfoExample();
		Criteria criteria = userExample.createCriteria();
		if(!StringUtils.isEmpty(loginAccount)) {
			criteria.andLoginAccountEqualTo(loginAccount);
		}
		if(StringUtils.isEmpty(loginPassword)) {
			criteria.andLoginPasswordEqualTo(loginPassword);
		}
		// 判断当前用户是否已删除(查找的是未删除的用户)
		criteria.andDelTagEqualTo(ConstantUtils.DEL_TAG_SAVE);
		// 判断用户是否已启用
		criteria.andUserStateEqualTo(ConstantUtils.USER_STATE_ENABLE);
		return userInfoMapper.selectByExample(userExample);
	}

}
