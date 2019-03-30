package com.zstu.pms.user.dto;

import com.zstu.pms.model.UserInfo;

/**
 * @author 李嘉灵
 * 系统名称: 新外呼项目
 * 模块名称: 问卷管理
 * 类 名 称: UserDTO
 * 软件版权: 远传股份有限公司
 * 功能说明：
 * 系统版本：
 * 开发人员: 李嘉灵
 * 开发时间: create in 15:56 2018/12/11
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class UserInfoDTO extends UserInfo {

    private String roleName;

    private String userStateContext;

    private String departmentContext;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserStateContext() {
        return userStateContext;
    }

    public void setUserStateContext(String userStateContext) {
        this.userStateContext = userStateContext;
    }

    public String getDepartmentContext() {
        return departmentContext;
    }

    public void setDepartmentContext(String departmentContext) {
        this.departmentContext = departmentContext;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "roleName='" + roleName + '\'' +
                ", userStateContext='" + userStateContext + '\'' +
                ", departmentContext='" + departmentContext + '\'' +
                '}';
    }
}
