package com.zstu.pms.model;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component("declareRecord")
public class DeclareRecord {
    private String declareId;

    private String itemId;

    private String typeId;

    private String userId;

    private Date createTime;

    private Date modifiedTime;

    private String processStatus;

    private String result;

    private String delTag;

    public String getDeclareId() {
        return declareId;
    }

    public void setDeclareId(String declareId) {
        this.declareId = declareId == null ? null : declareId.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getDelTag() {
        return delTag;
    }

    public void setDelTag(String delTag) {
        this.delTag = delTag == null ? null : delTag.trim();
    }

	@Override
	public String toString() {
		return "DeclareRecord [declareId=" + declareId + ", itemId=" + itemId + ", typeId=" + typeId + ", userId="
				+ userId + ", createTime=" + createTime + ", modifiedTime=" + modifiedTime + ", processStatus="
				+ processStatus + ", result=" + result + ", delTag=" + delTag + "]";
	}
    
    
}