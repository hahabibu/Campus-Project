package com.zstu.pms.message.dto;

import com.zstu.pms.model.MessageInfo;

public class MessageInfoDTO extends MessageInfo{
	
	private String receiverName;
	
	private String readStatusContext;

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReadStatusContext() {
		return readStatusContext;
	}

	public void setReadStatusContext(String readStatusContext) {
		this.readStatusContext = readStatusContext;
	}

	@Override
	public String toString() {
		return "MessageInfoDTO [receiverName=" + receiverName + ", readStatusContext=" + readStatusContext + "]";
	}
}
