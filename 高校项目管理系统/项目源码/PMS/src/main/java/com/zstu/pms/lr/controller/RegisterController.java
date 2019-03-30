package com.zstu.pms.lr.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zstu.pms.lr.service.RegisterService;
import com.zstu.pms.model.UserInfo;
import com.zstu.pms.utils.ConstantUtils;


@Controller
@RequestMapping("/register/")
public class RegisterController {
	
	// 记录日志信息
	private static final Logger LOGGER = Logger.getLogger(RegisterController.class);
	private StringBuilder sb = new StringBuilder();
	
	@Resource(name="registerServiceImpl")
	private RegisterService registerService;
	
	@RequestMapping("registerUserUI.action")
	public String registerUserUI(HttpServletRequest request,Model model,UserInfo userInfo) {
		// 跳转到注册界面
		return "register";
	}
	
	@ResponseBody
	@RequestMapping("CheckLoginname.action")
	public String CheckLoginname(HttpServletRequest request) throws Exception {
		// 检查当前的用户是否已存在，如果已存在不能够重复添加
		String loginAccount = request.getParameter("loginAccount");
		if(!StringUtils.isEmpty(loginAccount)) {
			boolean res = registerService.checkLoginAccount(loginAccount);
			if(res) {
				sb.append("RegisterController-->用户名已存在");
				LOGGER.info(sb.toString());
				return "illegal";
			}else {
				sb.append("RegisterController-->用户名不存在");
				LOGGER.info(sb.toString());
				return "legal";
			}
		}else {
			sb.append("RegisterController-->查找失败");
			LOGGER.info(sb.toString());
		}
		return null;
	}
	
	@RequestMapping("registerUser.action")
	public String registerUser(Model model,UserInfo userInfo) {
		userInfo.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
		userInfo.setDelTag(ConstantUtils.DEL_TAG_SAVE);
		userInfo.setUserState(ConstantUtils.USER_STATE_ENABLE);
		boolean flag = registerService.registerUserInfo(userInfo);
		if(flag) {
			model.addAttribute("info", "用户注册成功！");
		}else {
			model.addAttribute("info", "用户注册失败");
		}
		// 完成注册跳转到登录页面
		return "redirect:/login/loginUI.action";
	}
}
