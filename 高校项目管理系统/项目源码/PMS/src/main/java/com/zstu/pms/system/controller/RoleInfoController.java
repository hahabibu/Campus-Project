package com.zstu.pms.system.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zstu.pms.model.RoleInfo;
import com.zstu.pms.model.UserInfo;
import com.zstu.pms.system.service.RoleInfoService;
import com.zstu.pms.user.dto.UserInfoDTO;
import com.zstu.pms.user.service.UserService;
import com.zstu.pms.utils.ConstantUtils;

@Controller
@RequestMapping("/system/roleinfo")
public class RoleInfoController {
	
	// 记录日志信息
	private static final Logger LOGGER = Logger.getLogger(RoleInfoController.class);
	private StringBuilder sb = new StringBuilder();
	
	@Resource(name="roleInfoServiceImpl")
	private RoleInfoService roleInfoService;
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	// 添加角色信息
    @RequestMapping("addRoleInfoUI.action")
    public String addRoleInfoUI(RoleInfo roleInfo, Model model) {
        // 跳转到添加角色页面
    	sb.append("跳转页面到添加角色页面");
    	LOGGER.info(sb.toString());
        return "system/roleinfo/roleinfo_add";
    }

    // 添加角色信息
    @RequestMapping("addRoleInfo.action")
    public String addRoleInfo(RoleInfo roleInfo, Model model) {
        roleInfo.setRoleId(UUID.randomUUID().toString().replace("-",""));
        roleInfo.setDelTag(ConstantUtils.DEL_TAG_SAVE);
        roleInfo.setCreateTime(new Date());
        boolean remark = roleInfoService.saveRoleInfo(roleInfo);
        if(remark) {
            model.addAttribute("info","角色信息添加成功");
        }else {
            model.addAttribute("info","角色信息添加失败");
        }
        // 添加完成之后跳转到列表页面
        return listRoleInfo(null, model);
    }

    // 列出角色信息
    @RequestMapping("listRoleInfo.action")
    public String listRoleInfo(RoleInfo roleInfo,Model model) {
        List<RoleInfo> roleInfoList = roleInfoService.listRoleInfo(roleInfo);
        model.addAttribute("roleInfoList",roleInfoList);
        return "system/roleinfo/roleinfo_list";
    }

    // 查询单个角色详细信息
    @RequestMapping("showRoleInfo.action")
    public String showRoleInfo(String userId,Model model) {
        RoleInfo roleInfo = roleInfoService.getRoleInfo(userId);
        model.addAttribute("roleInfo", roleInfo);
        return "system/roleinfo/roleinfo_show";
    }

    // 获取要修改角色信息进行数据回显
    @RequestMapping("updateRoleInfoUI.action")
    public String updateRoleInfoUI(@Param(value="roleId") String roleId,Model model) {
        // 根据id查找角色信息，并将数据回显
        RoleInfo roleInfo = roleInfoService.getRoleInfo(roleId);
        model.addAttribute("roleInfo", roleInfo);
        return "system/roleinfo/roleinfo_update";
    }

    // 修改角色信息
    @RequestMapping("updateRoleInfo.action")
    public String updateRoleInfo(RoleInfo roleInfo,Model model) {
        boolean remark = roleInfoService.updateRoleInfo(roleInfo);
        if(remark) {
            model.addAttribute("info","角色信息修改成功");
        }else {
            model.addAttribute("info","角色信息修改失败");
        }
        // 修改完成之后跳转到列表页面
        return listRoleInfo(null, model);
    }

    // 删除角色信息
    @RequestMapping("deleteRoleInfo.action")
    public String deleteRoleInfo(@Param(value="roleId")String roleId, Model model) {
        // 此处是根据id先查找到指定的角色信息在进行操作
        RoleInfo roleInfo = roleInfoService.getRoleInfo(roleId);
        roleInfo.setDelTag(ConstantUtils.DEL_TAG_DELETE);
        // 此处删除角色是通过修改角色状态为0作为删除，而非真正意义上的删除
        boolean remark = roleInfoService.updateRoleInfo(roleInfo);
        if(remark) {
            model.addAttribute("info","角色信息删除成功");
        }else {
            model.addAttribute("info","角色信息删除失败");
        }
        // 修改完成之后跳转到列表页面
        return listRoleInfo(null, model);
    }
    
    // 列出所有用户信息和相应的角色信息
    @RequestMapping("listUserRoleInfo.action")
    public String listUserRoleInfo(UserInfo userInfo,Model model) {
    	List<UserInfoDTO> userInfoDTOList = userService.listUserInfo(userInfo);
        model.addAttribute("list",userInfoDTOList);
        // 将所有的角色信息传入对应页面
        List<RoleInfo> roleInfoList = roleInfoService.listRoleInfo(null);
        model.addAttribute("roleInfoList",roleInfoList);
    	LOGGER.info(sb.toString());
        return "system/rolechange/role_change";
    }
    
    // 用户角色变更
    @RequestMapping("updateUserRoleInfo.action")
    public String updateUserRoleInfo(@Param(value="userId")String userId,@Param(value="roleId")String roleId,Model model) {
    	System.out.println("测试："+roleId+"userId:"+userId);
    	// 修改用户角色
    	UserInfo findUserInfo = userService.getUserInfo(userId);
    	boolean flag = false;
    	if(findUserInfo!=null) {
    		findUserInfo.setRoleId(roleId);
    		flag = userService.updateUserInfo(findUserInfo);
    	}
    	if(flag) {
    		model.addAttribute("info", "用户角色修改成功");
    	} else {
    		model.addAttribute("info", "用户角色修改失败");
    	}
        return listUserRoleInfo(null,model);
    }
    
}
