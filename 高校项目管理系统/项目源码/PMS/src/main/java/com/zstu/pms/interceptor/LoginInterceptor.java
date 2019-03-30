package com.zstu.pms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import com.zstu.pms.model.UserInfo;
import com.zstu.pms.utils.ConstantUtils;

public class LoginInterceptor implements HandlerInterceptor {
	// 定义字符串输出日志信息
	private static final Logger LOGGER = Logger.getLogger(LoginInterceptor.class);
	private StringBuilder sb = new StringBuilder();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取用户请求的路径信息
		String url = request.getRequestURI();
		// 如果是登录、注册操作，则放行资源
		if (url.indexOf("loginUI.action") >= 0) {
			sb.append("LoginInterceptor拦截器-->执行操作：跳转登录页面操作，放行资源....");
			LOGGER.info(sb.toString());
			return true;
		}
		if (url.indexOf("login.action") >= 0) {
			sb.append("LoginInterceptor拦截器-->执行操作：登录操作，放行资源....");
			return true;
		}
		if (url.indexOf("registerUserUI.action") >= 0) {
			sb.append("LoginInterceptor拦截器-->执行操作：跳转注册页面操作，放行资源....");
			LOGGER.info(sb.toString());
			return true;
		}
		if (url.indexOf("registerUser.action") >= 0) {
			sb.append("LoginInterceptor拦截器-->执行操作：注册操作，放行资源....");
			LOGGER.info(sb.toString());
			return true;
		}

		// 如果不是登录操作，则根据判断当前用户是否已经登录及相应的角色决定资源的放行
		HttpSession session = request.getSession();
		UserInfo loginUser = (UserInfo) session.getAttribute("loginUser");
		if (loginUser != null) {
			// loginUser不为null，说明用户已经登录则根据当前用户的角色管理相应的访问模块
			sb.append("LoginInterceptor拦截器-->执行操作：当前用户：" + loginUser.getUserName() + "-角色：" + loginUser.getRoleId()
					+ "--已登录，放行资源...." + "\n");
			LOGGER.info(sb.toString());
			// 主页页面访问
			// if (url.indexOf("/login/index.action") >= 0) {
			// sb.append("LoginInterceptor拦截器-->执行操作：跳转到首页...." + "\n");
			// LOGGER.info(sb.toString());
			// return true;
			// }
			// 登录退出
			// if (url.indexOf("/login/logout.action") >= 0) {
			// sb.append("LoginInterceptor拦截器-->执行操作：登录退出...." + "\n");
			// LOGGER.info(sb.toString());
			// return true;
			// }
			// 权限提示
			// if (url.indexOf("/login/limit.action") >= 0) {
			// sb.append("LoginInterceptor拦截器-->执行操作：转发到拦截页面，放行资源...." + "\n");
			// LOGGER.info(sb.toString());
			// return true;
			// }
			// 开放接口
			if (url.indexOf("/login") >= 0) {
				sb.append("LoginInterceptor拦截器-->执行操作：放行资源...." + "\n");
				LOGGER.info(sb.toString());
				return true;
			}
			// 根据不同的模块结合用户角色决定相应的使用权限
			String roleId = loginUser.getRoleId();
			// 系统管理、用户管理模块只能超级管理员使用
			if (url.indexOf("/system/") >= 0 || url.indexOf("/user/") >= 0) {
				if (ConstantUtils.ROLE_ADMIN.equals(roleId)) {
					sb.append("LoginInterceptor拦截器-->执行操作：系统管理员拥有绝对权限...." + "\n");
					LOGGER.info(sb.toString() + "/n");
					return true;
				} else {
					sb.append("LoginInterceptor拦截器-->执行操作：拦截...." + "\n");
					LOGGER.info(sb.toString());
					request.getRequestDispatcher("/login/limit.action").forward(request, response);
					return true;
				}
			}

			// 申报管理模块供学生、超级管理员使用
			if (url.indexOf("/declare/declareinfo") >= 0) {
				if (ConstantUtils.ROLE_STUDENT.equals(roleId) || ConstantUtils.ROLE_ADMIN.equals(roleId)) {
					sb.append("LoginInterceptor拦截器-->执行操作：学生/管理员访问申报管理模块...." + "\n");
					LOGGER.info(sb.toString());
					return true;
				} else {
					sb.append("LoginInterceptor拦截器-->执行操作：申报管理模块访问受限...." + "\n");
					LOGGER.info(sb.toString());
					request.getRequestDispatcher("/login/limit.action").forward(request, response);
					return true;
				}
			}
			// 项目审核的项目类型管理（中期管理员、结题验收管理员、超级管理员可以使用）
			if (url.indexOf("/audit/declaretype/") >= 0) {
				if (ConstantUtils.ROLE_MIDCHECK.equals(roleId) || ConstantUtils.ROLE_ENDCHECK.equals(roleId)
						|| ConstantUtils.ROLE_ADMIN.equals(roleId)) {
					sb.append("LoginInterceptor拦截器-->执行操作：中期管理员、结题验收管理员、超级管理员可以访问申报类型管理模块...." + "\n");
					LOGGER.info(sb.toString());
					return true;
				} else {
					sb.append("LoginInterceptor拦截器-->执行操作：申报类型管理模块访问受限...." + "\n");
					LOGGER.info(sb.toString());
					request.getRequestDispatcher("/login/limit.action").forward(request, response);
					return true;
				}
			}
			// 项目审核的立项检查管理（立项检查管理员、超级管理员可以使用）
			if (url.indexOf("/audit/approval/") >= 0) {
				if (ConstantUtils.ROLE_SET.equals(roleId) || ConstantUtils.ROLE_ADMIN.equals(roleId)) {
					sb.append("LoginInterceptor拦截器-->执行操作：立项检查管理员、超级管理员可以访问立项检查模块...." + "\n");
					LOGGER.info(sb.toString());
					return true;
				} else {
					sb.append("LoginInterceptor拦截器-->执行操作：立项检查模块访问受限...." + "\n");
					LOGGER.info(sb.toString());
					request.getRequestDispatcher("/login/limit.action").forward(request, response);
					return true;
				}
			}
			// 项目审核的中期检查管理（中期检查管理员、超级管理员可以使用）
			if (url.indexOf("/audit/midcheck/") >= 0) {
				if (ConstantUtils.ROLE_MIDCHECK.equals(roleId) || ConstantUtils.ROLE_ADMIN.equals(roleId)) {
					sb.append("LoginInterceptor拦截器-->执行操作：中期检查管理员、超级管理员可以访问中期检查模块...." + "\n");
					LOGGER.info(sb.toString());
					return true;
				} else {
					sb.append("LoginInterceptor拦截器-->执行操作：中期检查模块访问受限...." + "\n");
					LOGGER.info(sb.toString());
					request.getRequestDispatcher("/login/limit.action").forward(request, response);
					return true;
				}
			}
			// 项目审核的结题验收管理（结题验收管理员可以使用）
			if (url.indexOf("/audit/endcheck/") >= 0) {
				if (ConstantUtils.ROLE_ENDCHECK.equals(roleId) || ConstantUtils.ROLE_ADMIN.equals(roleId)) {
					sb.append("LoginInterceptor拦截器-->执行操作：结题验收管理员、超级管理员可以访问结题验收模块...." + "\n");
					LOGGER.info(sb.toString());
					return true;
				} else {
					sb.append("LoginInterceptor拦截器-->执行操作：结题验收模块访问受限...." + "\n");
					LOGGER.info(sb.toString());
					request.getRequestDispatcher("/login/limit.action").forward(request, response);
					return true;
				}
			}
			// 站内消息管理（超级管理员可以使用）
			if (url.indexOf("/message/messageinfo/") >= 0) {
				sb.append("LoginInterceptor拦截器-->执行操作：查看站内消息（开放）...." + "\n");
				LOGGER.info(sb.toString());
				return true;
			}
		} else {
			// 如果用户没有登录则进行强制登录操作
			sb.append("LoginInterceptor拦截器-->执行操作：当前用户未登录，强制登录....");
			LOGGER.info(sb.toString());
			request.getRequestDispatcher("/login/loginUI.action").forward(request, response);
			return true;
		}
		return false;
	}
}
