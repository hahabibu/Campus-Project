package com.zstu.pms.user.service.impl;

import com.zstu.pms.model.UserInfo;
import com.zstu.pms.model.UserInfoExample;
import com.zstu.pms.user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public boolean saveUserInfo(UserInfo user) {
        return false;
    }

    @Override
    public boolean updateUserInfo(UserInfo user) {
        return false;
    }

    @Override
    public boolean deleteUserInfo(String userId) {
        return false;
    }

    @Override
    public UserInfo getUserInfo(String userId) {
        return null;
    }

    @Override
    public List<UserInfo> listUserInfo(UserInfoExample userInfoExample) {
        return null;
    }
}
