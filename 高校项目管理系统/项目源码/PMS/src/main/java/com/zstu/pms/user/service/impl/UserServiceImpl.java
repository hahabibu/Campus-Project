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
import com.zstu.pms.utils.ConstantUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    // 添加用户信息
    @Override
    public boolean saveUserInfo(UserInfo user) {
        int i = userInfoMapper.insert(user);
        return i>0;
    }

    // 修改用户信息
    @Override
    public boolean updateUserInfo(UserInfo user) {
        int i = userInfoMapper.updateByPrimaryKeySelective(user);
        return i>0;
    }

    // 根据用户id删除用户信息
    @Override
    public boolean deleteUserInfo(String userId) {
        int i = userInfoMapper.deleteByPrimaryKey(userId);
        return i>0;
    }

    // 根据用户id获取用户信息详情
    @Override
    public UserInfo getUserInfo(String userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    // 获取用户信息列表
    @Override
    public List<UserInfoDTO> listUserInfo(UserInfo userInfo) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria= userInfoExample.createCriteria();
        // 拼接不同的筛选条件
        if(userInfo!=null){
            if(!StringUtils.isEmpty(userInfo.getUserName())){
                criteria.andUserNameLike("%"+userInfo.getUserName()+"%");
            }
            if(!StringUtils.isEmpty(userInfo.getRoleId())){
                criteria.andRoleIdEqualTo(userInfo.getRoleId());
            }
            if(!StringUtils.isEmpty(userInfo.getDepartment())){
                criteria.andDepartmentEqualTo(userInfo.getDepartment());
            }
            if(userInfo.getCreateTime()!=null){
                criteria.andCreateTimeEqualTo(userInfo.getCreateTime());
            }
            if(!StringUtils.isEmpty(userInfo.getPhone())){
                criteria.andPhoneLike("%"+userInfo.getPhone()+"%");
            }
            if(!StringUtils.isEmpty(userInfo.getUserState())){
                criteria.andUserStateEqualTo(userInfo.getUserState());
            }
        }else {
        	userInfo = new UserInfo();
        }
        // 添加删除标识设置
        criteria.andDelTagEqualTo(ConstantUtils.DEL_TAG_SAVE);
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
        List<UserInfoDTO> userInfoDTOList = new ArrayList<>(userInfoList.size());
        // 封装属性
        for(UserInfo ui:userInfoList){
            userInfoDTOList.add(getDTOByModel(ui));
        }
        return userInfoDTOList;
    }

    // 获取用户DTO详情
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
        String userState = userInfo.getUserState();
        if(userState.equals(ConstantUtils.USER_STATE_ENABLE)){
            userInfoDTO.setUserStateContext(ConstantUtils.USER_STATE_ENABLE_CONTEXT);
        }else if(userState.equals(ConstantUtils.USER_STATE_FORBIDDEN)){
            userInfoDTO.setUserStateContext(ConstantUtils.USER_STATE_FORBIDDEN_CONTEXT);
        }
        return userInfoDTO;
    }
}
