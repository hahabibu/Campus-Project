package com.zstu.pms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 定义消息拦截器
 * 
 * @author Administrator
 */
public class MessageInterceptor implements HandlerInterceptor {
	// 定义字符串输出日志信息
	private static final Logger LOGGER = Logger.getLogger(LoginInterceptor.class);
	private StringBuilder sb = new StringBuilder();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取用户请求的路径信息
		String url = request.getRequestURI();
		// 如果是中期检查操作或者是申报管理操作则执行消息管理操作

//		if (url.indexOf("/ecm/login/") >= 0) {
//			sb.append("LoginInterceptor拦截器-->执行操作：登录操作，放行资源....");
//			LOGGER.info(sb.toString());
//			return true;
//		}
//		if (url.indexOf("/ecm/register/") >= 0) {
//			sb.append("LoginInterceptor拦截器-->执行操作：注册操作，放行资源....");
//			LOGGER.info(sb.toString());
//			return true;
//		}
//		// 浏览商城首页可以放行
//		if (url.indexOf("forntIndex.action") >= 0) {
//			sb.append("LoginInterceptor拦截器-->执行操作：浏览商城首页，放行资源....");
//			LOGGER.info(sb.toString());
//			return true;
//		}
//
//		// 如果不是登录操作，则根据判断当前用户是否已经登录决定资源的放行
//		HttpSession session = request.getSession();
//		UserInfo loginuser = (UserInfo) session.getAttribute("loginuser");
//		if (loginuser != null) {
//			// loginuser不为null，说明用户已经登录可以直接放行
//			sb.append("LoginInterceptor拦截器-->执行操作：当前用户" + loginuser.getUserName() + "已登录，放行资源....");
//			LOGGER.info(sb.toString());
//			// 根据当前的用户类型判断进入不同的管理页面
//			if (url.indexOf("personalUI.action") >= 0) {
//				// 前台登录个人中心请求
//				/*
//				 * if(loginuser.getUserType()==0) { return true; }
//				 */
//				// 此处为了方便测试：无论是管理员还是普通用户均可进行操作
//				return true;
//			} else if (url.indexOf("backUI.action") >= 0) {
//				// 后台登录管理页面请求(普通用户请求失败)
//				// if(loginuser.getUserType()==0) {
//				return false;
//				// }
//			}
//			return true;
//		}
//		// 如果用户没有登录则进行强制登录操作
//		sb.append("LoginInterceptor拦截器-->执行操作：当前用户未登录，强制登录....");
//		LOGGER.info(sb.toString());
//		request.getRequestDispatcher("/ecm/login/loginUI.action").forward(request, response);
		return true;
	}
}
