package com.zstu.pms.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zstu.pms.mapper.RoleInfoMapper;
import com.zstu.pms.model.RoleInfo;
import com.zstu.pms.model.RoleInfoExample;
import com.zstu.pms.system.service.RoleInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("roleInfoServiceImpl")
@Transactional
public class RoleInfoServiceImpl implements RoleInfoService {
	
	@Resource(name="roleInfoMapper")
	private RoleInfoMapper roleInfoMapper;
	
	@Override
	public boolean saveRoleInfo(RoleInfo roleInfo) {
		
		int i=roleInfoMapper.insertSelective(roleInfo);
		return i>0;
	}

	@Override
	public boolean updateRoleInfo(RoleInfo roleInfo) {
		
		int i=roleInfoMapper.updateByPrimaryKeySelective(roleInfo);
		return i>0;
	}

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
		
//		criteria.andRoleStateEqualTo("1");
		return roleInfoMapper.selectByExample(roleInfoExample);
	}

	@Override
	public RoleInfo getRoleInfo(String roleId) {
		
		return roleInfoMapper.selectByPrimaryKey(roleId);
	}

}


