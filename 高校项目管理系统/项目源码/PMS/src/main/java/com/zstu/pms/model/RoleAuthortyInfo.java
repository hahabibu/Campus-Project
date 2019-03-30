package com.zstu.pms.model;

public class RoleAuthortyInfo {
    private String roleAuthortyId;

    private String roleId;

    private String authortyId;

    public String getRoleAuthortyId() {
        return roleAuthortyId;
    }

    public void setRoleAuthortyId(String roleAuthortyId) {
        this.roleAuthortyId = roleAuthortyId == null ? null : roleAuthortyId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getAuthortyId() {
        return authortyId;
    }

    public void setAuthortyId(String authortyId) {
        this.authortyId = authortyId == null ? null : authortyId.trim();
    }
}