package com.zstu.pms.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zstu.pms.mapper.RoleInfoMapper;
import com.zstu.pms.model.RoleInfo;
import com.zstu.pms.model.RoleInfoExample;
import com.zstu.pms.system.service.RoleInfoService;
import com.zstu.pms.utils.ConstantUtils;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("roleInfoServiceImpl")
@Transactional
public class RoleInfoServiceImpl implements RoleInfoService {
	
	@Resource(name="roleInfoMapper")
	private RoleInfoMapper roleInfoMapper;
	
	// 添加角色信息
	@Override
	public boolean saveRoleInfo(RoleInfo roleInfo) {
		int i= roleInfoMapper.insertSelective(roleInfo);
		return i>0;
	}

	// 修改角色信息
	@Override
	public boolean updateRoleInfo(RoleInfo roleInfo) {
		int i= roleInfoMapper.updateByPrimaryKeySelective(roleInfo);
		return i>0;
	}
	
	// 删除角色信息
	@Override
	public boolean deleteRoleInfo(String roleId) {
		int i = roleInfoMapper.deleteByPrimaryKey(roleId);
		return i>0;
	}

	// 获取所有角色信息
	@Override
	public List<RoleInfo> listRoleInfo(RoleInfo roleInfo) {
		RoleInfoExample roleInfoExample=new RoleInfoExample();
		RoleInfoExample.Criteria criteria =roleInfoExample.createCriteria();
		if(roleInfo!=null) {
			if(roleInfo.getRoleId()!=null) {
				criteria.andRoleIdEqualTo(roleInfo.getRoleId());
			}
			if(roleInfo.getRoleName()!=null){
				criteria.andRoleNameLike("%"+roleInfo.getRoleName()+"%");
			}
		}
		criteria.andDelTagEqualTo(ConstantUtils.DEL_TAG_SAVE);
		return roleInfoMapper.selectByExample(roleInfoExample);
	}

	// 根据角色id获取角色信息
	@Override
	public RoleInfo getRoleInfo(String roleId) {
		return roleInfoMapper.selectByPrimaryKey(roleId);
	}

}


