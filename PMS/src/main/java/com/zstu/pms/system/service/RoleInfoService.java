package com.zstu.pms.system.service;

import com.zstu.pms.model.RoleInfo;

import java.util.List;



public interface RoleInfoService {

	public boolean saveRoleInfo(RoleInfo roleInfo);
	
	public boolean updateRoleInfo(RoleInfo roleInfo);
	
	public List<RoleInfo> listRoleInfo(RoleInfo roleInfo);
	
	public RoleInfo getRoleInfo(String roleId);
}


