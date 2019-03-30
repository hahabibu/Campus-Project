package com.zstu.pms.user.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zstu.pms.model.DataDictionary;
import com.zstu.pms.model.RoleInfo;
import com.zstu.pms.model.UserInfo;
import com.zstu.pms.system.service.DataDictionaryService;
import com.zstu.pms.system.service.RoleInfoService;
import com.zstu.pms.user.dto.UserInfoDTO;
import com.zstu.pms.user.service.UserService;
import com.zstu.pms.utils.ConstantUtils;

/**
 * @author 李嘉灵
 * 系统名称: 新外呼项目
 * 模块名称: 问卷管理
 * 类 名 称: UserController
 * 软件版权: 远传股份有限公司
 * 功能说明：
 * 系统版本：
 * 开发人员: 李嘉灵
 * 开发时间: create in 13:27 2018/12/11
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Controller
@RequestMapping("/user/userinfo/")
public class UserController {

    @Resource(name="userServiceImpl")
    private UserService userService;

    @Resource(name="roleInfoServiceImpl")
    private RoleInfoService roleInfoService;

    @Resource(name="dataDictionaryServiceImpl")
    private DataDictionaryService dataDictionaryService;

    // 添加用户信息
    @RequestMapping("addUserInfoUI.action")
    public String addUserInfoUI(UserInfo userInfo, Model model) {
        // 封装部门信息
        List<DataDictionary> dataDictionaryList = dataDictionaryService.getDataDictionaryByType("department");
        model.addAttribute("departmentList",dataDictionaryList);

        // 封装角色信息
        List<RoleInfo> roleInfoList = roleInfoService.listRoleInfo(null);
        model.addAttribute("roleInfoList",roleInfoList);

        // 跳转到添加用户页面
        return "user/userinfo/user_add";
    }

    // 添加用户信息
    @RequestMapping("addUserInfo.action")
    public String addUserInfo(UserInfo userInfo, Model model) {
        userInfo.setUserId(UUID.randomUUID().toString().replace("-",""));
        userInfo.setUserState(ConstantUtils.USER_STATE_ENABLE);
        userInfo.setDelTag(ConstantUtils.DEL_TAG_SAVE);
        boolean remark = userService.saveUserInfo(userInfo);
        if(remark) {
            model.addAttribute("info","用户信息添加成功");
        }else {
            model.addAttribute("info","用户信息添加失败");
        }
        // 添加完成之后跳转到列表页面
        return listUserInfo(null, model);
    }

    // 列出用户信息
    @RequestMapping("listUserInfo.action")
    public String listUserInfo(UserInfo userInfo,Model model) {
        List<UserInfoDTO> list = userService.listUserInfo(userInfo);
        model.addAttribute("list",list);
        return "user/userinfo/user_list";
    }

    // 查询单个用户详细信息
    @RequestMapping("showUserInfo.action")
    public String showUserInfo(String userId,Model model) {
        UserInfo userInfo = userService.getUserInfo(userId);
        UserInfoDTO userInfoDTO = userService.getDTOByModel(userInfo);
        model.addAttribute("userInfo", userInfoDTO);
        return "user/userinfo/user_show";
    }

    // 获取要修改用户信息进行数据回显
    @RequestMapping("updateUserInfoUI.action")
    public String updateUserInfoUI(String userId,Model model) {
    	// 封装部门信息
        List<DataDictionary> dataDictionaryList = dataDictionaryService.getDataDictionaryByType(ConstantUtils.DATA_TYPE_DEPARTMENT);
        model.addAttribute("departmentList",dataDictionaryList);

        // 封装角色信息
        List<RoleInfo> roleInfoList = roleInfoService.listRoleInfo(null);
        model.addAttribute("roleInfoList",roleInfoList);

        // 根据id查找用户信息，并将数据回显
        UserInfo userInfo = userService.getUserInfo(userId);
        model.addAttribute("userInfo", userInfo);
        return "user/userinfo/user_update";
    }

    // 修改用户信息
    @RequestMapping("updateUserInfo.action")
    public String updateUserInfo(UserInfo userInfo,Model model) {
        boolean remark = userService.updateUserInfo(userInfo);
        if(remark) {
            model.addAttribute("info","用户信息修改成功");
        }else {
            model.addAttribute("info","用户信息修改失败");
        }
        // 修改完成之后跳转到列表页面
        return listUserInfo(null, model);
    }

    // 删除用户信息
    @RequestMapping("deleteUserInfo.action")
    public String deleteUserInfo(@Param(value="userId")String userId, Model model) {
        // 此处是根据id先查找到指定的用户信息在进行操作
        UserInfo userInfo = userService.getUserInfo(userId);
        userInfo.setDelTag(ConstantUtils.DEL_TAG_DELETE);
        // 此处删除用户是通过修改用户状态为0作为删除，而非真正意义上的删除
        boolean remark = userService.updateUserInfo(userInfo);
        if(remark) {
            model.addAttribute("info","用户信息删除成功");
        }else {
            model.addAttribute("info","用户信息删除失败");
        }
        // 修改完成之后跳转到列表页面
        return listUserInfo(null, model);
    }
}
