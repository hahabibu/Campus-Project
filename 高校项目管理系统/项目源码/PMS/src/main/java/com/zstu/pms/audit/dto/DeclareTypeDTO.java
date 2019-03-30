package com.zstu.pms.audit.dto;

import java.util.Date;

import com.zstu.pms.model.DeclareType;

public class DeclareTypeDTO extends DeclareType{
	
	private String startStatusContext;
	
	private Date middleTimeLimit;
	
	private Date endTimeLimit;

	public String getStartStatusContext() {
		return startStatusContext;
	}

	public void setStartStatusContext(String startStatusContext) {
		this.startStatusContext = startStatusContext;
	}

	public Date getMiddleTimeLimit() {
		return middleTimeLimit;
	}

	public void setMiddleTimeLimit(Date middleTimeLimit) {
		this.middleTimeLimit = middleTimeLimit;
	}

	public Date getEndTimeLimit() {
		return endTimeLimit;
	}

	public void setEndTimeLimit(Date endTimeLimit) {
		this.endTimeLimit = endTimeLimit;
	}

	@Override
	public String toString() {
		return "DeclareTypeDTO [startStatusContext=" + startStatusContext + "]";
	}

	
}
