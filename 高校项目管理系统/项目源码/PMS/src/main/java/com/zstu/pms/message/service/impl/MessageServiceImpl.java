package com.zstu.pms.message.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.zstu.pms.mapper.MessageInfoMapper;
import com.zstu.pms.mapper.UserInfoMapper;
import com.zstu.pms.message.dto.MessageInfoDTO;
import com.zstu.pms.message.service.MessageService;
import com.zstu.pms.model.MessageInfo;
import com.zstu.pms.model.MessageInfoExample;
import com.zstu.pms.model.MessageInfoExample.Criteria;
import com.zstu.pms.system.service.DataDictionaryService;
import com.zstu.pms.model.UserInfo;
import com.zstu.pms.utils.ConstantUtils;

@Service("messageServiceImpl")
public class MessageServiceImpl implements MessageService{

	@Resource(name="messageInfoMapper")
	private MessageInfoMapper messageInfoMapper;
	
	@Resource(name="userInfoMapper")
	private UserInfoMapper userInfoMapper;
	
	@Override
	public boolean addMessageInfo(String messageType,String messageContent,String receiver) {
		
		if(StringUtils.isEmpty(messageType)) {
//			throw new CommonException("输入消息类型不能为空!");
		}
		MessageInfo messageInfo = new MessageInfo();
		messageInfo.setMessageId(UUID.randomUUID().toString().replaceAll("-", ""));
		messageInfo.setMessageType(messageType);
		messageInfo.setMessageContent(messageContent);
		messageInfo.setCreateTime(new Date());
		messageInfo.setReceiver(receiver);
		messageInfo.setReadStatus(ConstantUtils.READ_STATUS_UNREAD);
		messageInfo.setDelTag(ConstantUtils.DEL_TAG_SAVE);
		int i  = messageInfoMapper.insert(messageInfo);
		return i>0;
	}

	@Override
	public boolean deleteMessageInfo(String messageId) {
		MessageInfo findMessageInfo = messageInfoMapper.selectByPrimaryKey(messageId);
		findMessageInfo.setDelTag(ConstantUtils.DEL_TAG_DELETE);
		int i = messageInfoMapper.updateByPrimaryKey(findMessageInfo);
		return i>0;
	}

	@Override
	public boolean readMessageInfo(String messageId) {
		MessageInfo findMessageInfo = messageInfoMapper.selectByPrimaryKey(messageId);
		findMessageInfo.setReadStatus(ConstantUtils.READ_STATUS_READ);
		int i = messageInfoMapper.updateByPrimaryKey(findMessageInfo);
		return i>0;
	}

	@Override
	public List<MessageInfoDTO> listMessageInfo(MessageInfo messageInfo) {
		MessageInfoExample messageInfoExample = new MessageInfoExample();
		Criteria criteria = messageInfoExample.createCriteria();
		if(messageInfo!=null) {
			if(!StringUtils.isEmpty(messageInfo.getReceiver())) {
				criteria.andReceiverEqualTo(messageInfo.getReceiver());
			}
			if(!StringUtils.isEmpty(messageInfo.getMessageType())) {
				if(!ConstantUtils.DEFAULT_CHECK_CONDITION.equals(messageInfo.getMessageType())) {
					criteria.andMessageTypeEqualTo(messageInfo.getMessageType());
				}
			}
		}
		criteria.andDelTagEqualTo(ConstantUtils.DEL_TAG_SAVE);
		List<MessageInfo> MessageInfoList = messageInfoMapper.selectByExample(messageInfoExample);
		List<MessageInfoDTO> MessageInfoDTOList = new ArrayList<>(MessageInfoList.size());
		for(MessageInfo mi : MessageInfoList) {
			MessageInfoDTOList.add(getDTOByModel(mi));
		}
		return MessageInfoDTOList;
	}

	@Override
	public MessageInfoDTO getMessageInfo(String messageId) {
		return getDTOByModel(messageInfoMapper.selectByPrimaryKey(messageId));
	}
	
	// 获取用户DTO详情
    @Override
    public MessageInfoDTO getDTOByModel(MessageInfo messageInfo){
    	MessageInfoDTO messageInfoDTO = new MessageInfoDTO();
        BeanUtils.copyProperties(messageInfo,messageInfoDTO);
        // 根据相应的内容封装属性
        String receiver = messageInfo.getReceiver();
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(receiver);
        if(userInfo!=null) {
        	messageInfoDTO.setReceiverName(userInfo.getUserName());
        }
        String readStatus = messageInfo.getReadStatus();
        if(readStatus.equals(ConstantUtils.READ_STATUS_UNREAD)){
        	messageInfoDTO.setReadStatusContext(ConstantUtils.READ_STATUS_UNREAD_CONTEXT);
        }else if(readStatus.equals(ConstantUtils.READ_STATUS_READ)){
        	messageInfoDTO.setReadStatusContext(ConstantUtils.READ_STATUS_READ_CONTEXT);
        }
        return messageInfoDTO;
    }
}
