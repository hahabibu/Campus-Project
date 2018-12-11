package com.zstu.pms.user.service;

import com.zstu.pms.model.UserInfo;
import com.zstu.pms.model.UserInfoExample;
import com.zstu.pms.user.dto.UserInfoDTO;

import java.util.List;

public interface UserService {

    public boolean saveUserInfo(UserInfo user);

    public boolean updateUserInfo(UserInfo user);

    public boolean deleteUserInfo(String userId);

    public UserInfo getUserInfo(String userId);

    public List<UserInfoDTO> listUserInfo(UserInfo userInfo);

    public UserInfoDTO getDTOByModel(UserInfo userInfo);

}
