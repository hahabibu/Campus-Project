package com.zstu.pms.declare.dto;

import com.zstu.pms.model.DeclareRecord;
import com.zstu.pms.model.DeclareType;
import com.zstu.pms.model.ItemInfo;
import com.zstu.pms.model.UserInfo;

public class DeclareRecordDTO extends DeclareRecord{

	// 申报项目详情
	private ItemInfo itemInfo;
	
	// 申报类型详情
	private DeclareType declareType;
	
	// 申报的用户详情
	private UserInfo userInfo;
	
	// 申报的处理状态
	private String processStatusContext;

	public ItemInfo getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(ItemInfo itemInfo) {
		this.itemInfo = itemInfo;
	}

	public DeclareType getDeclareType() {
		return declareType;
	}

	public void setDeclareType(DeclareType declareType) {
		this.declareType = declareType;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getProcessStatusContext() {
		return processStatusContext;
	}

	public void setProcessStatusContext(String processStatusContext) {
		this.processStatusContext = processStatusContext;
	}

	@Override
	public String toString() {
		return "DeclareRecordDTO [itemInfo=" + itemInfo + ", declareType=" + declareType + ", userInfo=" + userInfo
				+ ", processStatusContext=" + processStatusContext + "]";
	}

}
