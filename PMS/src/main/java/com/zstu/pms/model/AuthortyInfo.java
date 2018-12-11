package com.zstu.pms.model;

public class AuthortyInfo {
    private String authortyId;

    private String authortyName;

    private String authortyDesc;

    private String parentId;

    private String authortyUrl;

    public String getAuthortyId() {
        return authortyId;
    }

    public void setAuthortyId(String authortyId) {
        this.authortyId = authortyId == null ? null : authortyId.trim();
    }

    public String getAuthortyName() {
        return authortyName;
    }

    public void setAuthortyName(String authortyName) {
        this.authortyName = authortyName == null ? null : authortyName.trim();
    }

    public String getAuthortyDesc() {
        return authortyDesc;
    }

    public void setAuthortyDesc(String authortyDesc) {
        this.authortyDesc = authortyDesc == null ? null : authortyDesc.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getAuthortyUrl() {
        return authortyUrl;
    }

    public void setAuthortyUrl(String authortyUrl) {
        this.authortyUrl = authortyUrl == null ? null : authortyUrl.trim();
    }
}