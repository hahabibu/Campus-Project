package com.zstu.pms.lr.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zstu.pms.lr.service.LoginService;
import com.zstu.pms.message.dto.MessageInfoDTO;
import com.zstu.pms.message.service.MessageService;
import com.zstu.pms.model.DataDictionary;
import com.zstu.pms.model.MessageInfo;
import com.zstu.pms.model.RoleInfo;
import com.zstu.pms.model.UserInfo;
import com.zstu.pms.system.service.DataDictionaryService;
import com.zstu.pms.system.service.RoleInfoService;
import com.zstu.pms.user.service.UserService;
import com.zstu.pms.utils.ConstantUtils;

@Controller
@RequestMapping("/login/")
public class LoginController {

	@Resource(name = "loginServiceImpl")
	private LoginService loginService;

	@Resource(name = "userServiceImpl")
	private UserService userService;

	@Resource(name = "roleInfoServiceImpl")
	private RoleInfoService roleInfoService;

	@Resource(name = "dataDictionaryServiceImpl")
	private DataDictionaryService dataDictionaryService;

	@Resource(name = "messageServiceImpl")
	private MessageService messageService;

	// 进入首页
	@RequestMapping("index.action")
	public String Index(HttpSession session, HttpServletRequest request, Model model) {
		// 进入到主页（将当前的账号的消息记录传送到页面）
		session = request.getSession();
		UserInfo loginUser = (UserInfo) session.getAttribute("loginUser");
		MessageInfo messageInfo = new MessageInfo();
		List<MessageInfoDTO> messageInfoList = messageService.listMessageInfo(messageInfo);
		model.addAttribute("messageInfoListCount", messageInfoList.size());
		if (loginUser != null) {
			messageInfo.setReceiver(loginUser.getUserId());
		}
		return "index";
	}

	// 模拟用户登录
	@RequestMapping("loginUI.action")
	public String loginUI(HttpServletRequest request, String error) {
		if (error != null) {
			request.setAttribute("error", error);
		}
		return "login";
	}

	// 模拟用户登录
	@RequestMapping("login.action")
	public String login(HttpServletRequest request, HttpSession session, String loginAccount, String loginPassword) {
		// 数据类型转化
		List<UserInfo> users = loginService.checkUserInfo(loginAccount, loginPassword);
		if (users != null && users.size() != 0) {
			// 默认查找到的数据即为当前登录的user
			UserInfo loginUser = users.get(0);
			// 根据不同的用户类型跳转到不同的主页
			session.setAttribute("loginUser", loginUser);
			return "redirect:/login/index.action";
		}
		request.setAttribute("error", "yes");
		return loginUI(request, "yes");
	}

	// 模拟用户登录退出
	@RequestMapping("logout.action")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/loginUI.action";
	}

	// 获取当前登录的用户信息(可以进行编辑)
	@RequestMapping("updatepersonalInfoUI.action")
	public String updatepersonalInfoUI(Model model, HttpSession session, HttpServletRequest request) {
		// 封装部门信息
		List<DataDictionary> dataDictionaryList = dataDictionaryService
				.getDataDictionaryByType(ConstantUtils.DATA_TYPE_DEPARTMENT);
		model.addAttribute("departmentList", dataDictionaryList);

		// 封装角色信息
		List<RoleInfo> roleInfoList = roleInfoService.listRoleInfo(null);
		model.addAttribute("roleInfoList", roleInfoList);

		// 根据id查找用户信息，并将数据回显
		session = request.getSession();
		UserInfo loginUser = (UserInfo) session.getAttribute("loginUser");
		String userId = null;
		if (loginUser != null) {
			userId = loginUser.getUserId();
		}
		UserInfo userInfo = userService.getUserInfo(userId);
		model.addAttribute("userInfo", userInfo);
		return "personal_update";
	}

	@RequestMapping("updatePersonalInfo.action")
	public String updatePersonalInfo(UserInfo userInfo, HttpSession session, HttpServletRequest request, Model model) {
		// 根据id查找用户信息，并将数据回显
		boolean remark = userService.updateUserInfo(userInfo);
		if (remark) {
			model.addAttribute("info", "个人信息修改成功");
		} else {
			model.addAttribute("info", "个人信息修改失败");
		}
		return updatepersonalInfoUI(model,session,request);
	}
	
	@RequestMapping("limit.action")
	public String limit(UserInfo userInfo, HttpSession session, HttpServletRequest request, Model model) {
		// 跳转到提示页面（当前用户没有权限）
		return "static/limit";
	}

}
