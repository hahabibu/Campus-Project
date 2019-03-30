package com.zstu.pms.declare.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zstu.pms.audit.dto.DeclareTypeDTO;
import com.zstu.pms.audit.service.DeclareTypeService;
import com.zstu.pms.declare.dto.DeclareRecordDTO;
import com.zstu.pms.declare.service.DeclareRecordService;
import com.zstu.pms.model.DeclareRecord;
import com.zstu.pms.model.ItemInfo;
import com.zstu.pms.model.UserInfo;

@Controller
@RequestMapping("/declare/declareinfo/")
public class DeclareRecordController {

	@Resource(name = "declareRecordServiceImpl")
	private DeclareRecordService declareRecordService;

	@Resource(name = "declareTypeServiceImpl")
	private DeclareTypeService declareTypeService;

	// 列出申报记录信息
	@RequestMapping("listDeclareRecord.action")
	public String listDeclareRecord(DeclareRecord declareRecord, Model model, HttpSession session,
			HttpServletRequest request) {
		// 设置当前用户id
		if (declareRecord == null) {
			declareRecord = new DeclareRecord();
		}
		session = request.getSession();
		UserInfo loginUser = (UserInfo) session.getAttribute("loginUser");
		if (loginUser != null) {
			declareRecord.setUserId(loginUser.getUserId());
		}
		List<DeclareTypeDTO> declareTypeDTOList = declareTypeService.listDeclareType(null);
		List<DeclareRecordDTO> list = declareRecordService.listDeclareRecord(declareRecord);
		model.addAttribute("list", list);
		model.addAttribute("declareTypeDTOList", declareTypeDTOList);
		return "declare/declareinfo/record_list";
	}

	// 查询单个申报记录详细信息
	@RequestMapping("showDeclareRecord.action")
	public String showDeclareRecord(String declareId, Model model) {
		DeclareRecordDTO declareRecordDTO = declareRecordService
				.getDTObyModel(declareRecordService.getDeclareRecord(declareId));
		model.addAttribute("declareRecordDTO", declareRecordDTO);
		return "declare/declareinfo/record_show";
	}

	@RequestMapping("entrance.action")
	public String entrance(Model model) {
		return "declare/declareinfo/declare_entrance";
	}

	@RequestMapping("addItemInfoUI.action")
	public String addItemInfoUI(Model model) {
		// 将项目类型传入到页面
		List<DeclareTypeDTO> declareTypeDTOList = declareTypeService.listDeclareType(null);
		model.addAttribute("declareTypeDTOList", declareTypeDTOList);
		return "declare/declareinfo/declare_edit";
	}

	@RequestMapping("addItemInfo.action")
	public String addItemInfo(ItemInfo itemInfo, DeclareRecord declareRecord, Model model, HttpSession session,
			HttpServletRequest request) {
		itemInfo.setItemId(UUID.randomUUID().toString().replaceAll("-", ""));
		// 获取当前登录的用户信息
		session = request.getSession();
		UserInfo loginUser = (UserInfo) session.getAttribute("loginUser");
		if (loginUser != null) {
			declareRecord.setUserId(loginUser.getUserId());
		}
		boolean remark = declareRecordService.addItemInfo(itemInfo, declareRecord);
		declareRecordService.uploadFile(request);
		if (remark) {
			model.addAttribute("info", "项目保存成功");
		} else {
			model.addAttribute("info", "项目保存失败");
		}
		return listDeclareRecord(null, model, session, request);
	}

	@RequestMapping("updateDeclareRecordUI.action")
	public String updateDeclareRecordUI(Model model, @Param(value = "declareId") String declareId) {
		// 将项目类型传入到页面
		List<DeclareTypeDTO> declareTypeDTOList = declareTypeService.listDeclareType(null);
		model.addAttribute("declareTypeDTOList", declareTypeDTOList);
		// 查找对应记录的项目详情，重新修改数据
		DeclareRecordDTO declareRecordDTO = declareRecordService
				.getDTObyModel(declareRecordService.getDeclareRecord(declareId));
		model.addAttribute("declareRecordDTO", declareRecordDTO);
		return "declare/declareinfo/declare_update";
	}

	@RequestMapping("updateDeclareRecord.action")
	public String updateDeclareRecord(ItemInfo itemInfo, DeclareRecord declareRecord, Model model, HttpSession session,
			HttpServletRequest request) {
		System.out.println("itemInfo:"+itemInfo);
		System.out.println("declareRecord:"+declareRecord);
		// 修改项目信息
		session = request.getSession();
		UserInfo loginUser = (UserInfo) session.getAttribute("loginUser");
		if (loginUser != null) {
			declareRecord.setUserId(loginUser.getUserId());
		}
		boolean remark = declareRecordService.updateItemInfo(itemInfo, declareRecord);
		declareRecordService.uploadFile(request);
		if (remark) {
			model.addAttribute("info", "记录修改成功");
		} else {
			model.addAttribute("info", "记录修改失败");
		}
		return listDeclareRecord(null, model, session, request);
	}

	@InitBinder("itemInfo")
	public void userBinder(WebDataBinder webDataBinder) {
		webDataBinder.setFieldDefaultPrefix("itemInfo.");
	}

	@InitBinder("declareRecord")
	public void userDetailBinder(WebDataBinder webDataBinder) {
		webDataBinder.setFieldDefaultPrefix("declareRecord.");
	}

}
