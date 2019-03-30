package com.zstu.pms.system.service;

import com.zstu.pms.model.RoleInfo;

import java.util.List;



public interface RoleInfoService {

	// 添加角色信息
	public boolean saveRoleInfo(RoleInfo roleInfo);
	
	// 修改角色信息
	public boolean updateRoleInfo(RoleInfo roleInfo);
	
	// 删除角色信息
	public boolean deleteRoleInfo(String roleId);
	
	// 获取所有角色信息
	public List<RoleInfo> listRoleInfo(RoleInfo roleInfo);
	
	// 根据角色id获取角色信息
	public RoleInfo getRoleInfo(String roleId);
}


