package com.zstu.pms.message.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zstu.pms.message.dto.MessageInfoDTO;
import com.zstu.pms.message.service.MessageService;
import com.zstu.pms.model.DataDictionary;
import com.zstu.pms.model.MessageInfo;
import com.zstu.pms.model.UserInfo;
import com.zstu.pms.system.service.DataDictionaryService;
import com.zstu.pms.utils.ConstantUtils;

@Controller
@RequestMapping("/message/messageinfo/")
public class MessageController {

	@Resource(name = "messageServiceImpl")
	private MessageService messageService;

	@Resource(name = "dataDictionaryServiceImpl")
	private DataDictionaryService dataDictionaryService;

	// 列出消息记录信息
	@RequestMapping("listMessageInfo.action")
	public String listMessageInfo(MessageInfo messageInfo, Model model, HttpSession session,
			HttpServletRequest request) {
		// 封装消息记录类型
		List<DataDictionary> messageTypeList = dataDictionaryService.getDataDictionaryByType("message");
		model.addAttribute("messageTypeList", messageTypeList);

		session = request.getSession();
		UserInfo loginUser = (UserInfo) session.getAttribute("loginUser");
		if (loginUser != null) {
			messageInfo.setReceiver(loginUser.getUserId());
			messageInfo.setReadStatus(ConstantUtils.READ_STATUS_UNREAD);
		}
		List<MessageInfoDTO> messageInfoDTOList = messageService.listMessageInfo(messageInfo);
		model.addAttribute("list", messageInfoDTOList);
		return "message/messageinfo/messageinfo_list";
	}

	// 查询单个消息记录详细信息
	@RequestMapping("showMessageInfo.action")
	public String showMessageInfo(String messageId, Model model) {
		MessageInfo messageInfo = messageService.getMessageInfo(messageId);
		messageService.readMessageInfo(messageId);
		model.addAttribute("messageInfo", messageInfo);
		return "message/messageinfo/messageinfo_show";
	}

	// 阅读单个消息记录详细信息
//	@RequestMapping("readMessageInfo.action")
//	public String readMessageInfo(String messageId, Model model, HttpSession session, HttpServletRequest request) {
//		messageService.readMessageInfo(messageId);
//		return listMessageInfo(null, model, session, request);
//	}

	// 删除单个消息记录详细信息
	@RequestMapping("deleteMessageInfo.action")
	public String deleteMessageInfo(String messageId, Model model, HttpSession session, HttpServletRequest request) {
		boolean flag = messageService.deleteMessageInfo(messageId);
		if (flag) {
			model.addAttribute("info", "消息记录删除成功");
		} else {
			model.addAttribute("info", "消息记录删除失败");
		}
		return listMessageInfo(null, model, session, request);
	}
}
