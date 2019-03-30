package com.zstu.pms.user.service;

import com.zstu.pms.model.UserInfo;
import com.zstu.pms.user.dto.UserInfoDTO;

import java.util.List;

/**
 * 用户管理相关Service
 */
public interface UserService {

	// 添加用户信息
    public boolean saveUserInfo(UserInfo user);

    // 修改用户信息
    public boolean updateUserInfo(UserInfo user);

    // 根据用户id删除用户信息
    public boolean deleteUserInfo(String userId);

    // 根据用户id获取用户信息详情
    public UserInfo getUserInfo(String userId);

    // 获取用户信息列表
    public List<UserInfoDTO> listUserInfo(UserInfo userInfo);

    // 获取用户DTO详情
    public UserInfoDTO getDTOByModel(UserInfo userInfo);

}
