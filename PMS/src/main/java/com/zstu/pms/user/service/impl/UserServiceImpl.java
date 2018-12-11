package com.zstu.pms.user.service.impl;

import com.zstu.pms.mapper.DataDictionaryMapper;
import com.zstu.pms.mapper.RoleInfoMapper;
import com.zstu.pms.mapper.UserInfoMapper;
import com.zstu.pms.model.DataDictionary;
import com.zstu.pms.model.RoleInfo;
import com.zstu.pms.model.UserInfo;
import com.zstu.pms.model.UserInfoExample;
import com.zstu.pms.user.dto.UserInfoDTO;
import com.zstu.pms.user.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;


    @Override
    public boolean saveUserInfo(UserInfo user) {
        int i = userInfoMapper.insert(user);
        return i>0;
    }

    @Override
    public boolean updateUserInfo(UserInfo user) {
        int i = userInfoMapper.updateByPrimaryKeySelective(user);
        return i>0;
    }

    @Override
    public boolean deleteUserInfo(String userId) {
        int i = userInfoMapper.deleteByPrimaryKey(userId);
        return i>0;
    }

    @Override
    public UserInfo getUserInfo(String userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<UserInfoDTO> listUserInfo(UserInfo userInfo) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria= userInfoExample.createCriteria();
        // 拼接不同的筛选条件
        if(!StringUtils.isEmpty(userInfo.getUserName())){
            criteria.andUserNameLike("%"+userInfo.getUserName()+"%");
        }
        if(!StringUtils.isEmpty(userInfo.getRoleId())){
            criteria.andRoleIdEqualTo(userInfo.getRoleId());
        }
        if(!StringUtils.isEmpty(userInfo.getDepartment())){
            criteria.andDepartmentEqualTo(userInfo.getDepartment());
        }
        if(!StringUtils.isEmpty(userInfo.getCreateTime().toString())){
            criteria.andCreateTimeEqualTo(userInfo.getCreateTime());
        }
        if(!StringUtils.isEmpty(userInfo.getUserState().toString())){
            criteria.andUserStateEqualTo(userInfo.getUserState());
        }
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
        List<UserInfoDTO> userInfoDTOList = new ArrayList<>(userInfoList.size());
        // 封装属性
        for(UserInfo ui:userInfoList){
            userInfoDTOList.add(getDTOByModel(ui));
        }
        return userInfoDTOList;
    }

    @Override
    public UserInfoDTO getDTOByModel(UserInfo userInfo){
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        BeanUtils.copyProperties(userInfo,userInfoDTO);
        // 根据相应的内容封装属性
        String roleId = userInfo.getRoleId();
        RoleInfo roleInfo = roleInfoMapper.selectByPrimaryKey(roleId);
        if(roleInfo!=null){
            userInfoDTO.setRoleName(roleInfo.getRoleName());
        }
        String department = userInfo.getDepartment();
        DataDictionary dataDictionary = dataDictionaryMapper.selectByPrimaryKey(department);
        if(dataDictionary!=null){
            userInfoDTO.setDepartmentContext(dataDictionary.getDataContent());
        }
        Integer userState = userInfo.getUserState();
        if(userState==0){
            userInfoDTO.setUserStateContext("启用");
        }else if(userState==1){
            userInfoDTO.setUserStateContext("禁用");
        }
        return userInfoDTO;
    }
}
