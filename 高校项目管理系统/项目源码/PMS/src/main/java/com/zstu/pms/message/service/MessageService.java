package com.zstu.pms.message.service;

import java.util.List;

import com.zstu.pms.message.dto.MessageInfoDTO;
import com.zstu.pms.model.MessageInfo;

public interface MessageService {
	
	// 添加消息记录
	public boolean addMessageInfo(String messageType,String messageContent,String receiver);
	
	// 删除消息记录
	public boolean deleteMessageInfo(String messageId);
	
	// 修改消息记录状态（由未读变已读）
	public boolean readMessageInfo(String messageId);
	
	// 根据接收人id获取相应的消息记录
	public List<MessageInfoDTO> listMessageInfo(MessageInfo messageInfo);
	
	// 查看详细的消息记录
	public MessageInfoDTO getMessageInfo(String messageId);
	
	public MessageInfoDTO getDTOByModel(MessageInfo messageInfo);
	
}
