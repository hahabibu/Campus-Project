package com.zstu.pms.model;

import java.util.Date;

public class DeclareType {
    private String typeId;

    private String typeName;

    private String typeDescr;

    private Date createTime;

    private Date modifiedTime;

    private Date middleTime;

    private Date endTime;

    private Integer startStatus;

    private Integer delTag;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeDescr() {
        return typeDescr;
    }

    public void setTypeDescr(String typeDescr) {
        this.typeDescr = typeDescr == null ? null : typeDescr.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Date getMiddleTime() {
        return middleTime;
    }

    public void setMiddleTime(Date middleTime) {
        this.middleTime = middleTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStartStatus() {
        return startStatus;
    }

    public void setStartStatus(Integer startStatus) {
        this.startStatus = startStatus;
    }

    public Integer getDelTag() {
        return delTag;
    }

    public void setDelTag(Integer delTag) {
        this.delTag = delTag;
    }
}