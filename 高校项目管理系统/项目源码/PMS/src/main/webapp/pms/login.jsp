<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>用户登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<%@include file="/pms/public/commons.jspf"%>
<script type="text/javascript">
	function check() {
		var userId = $("#username").val();
		var pwd = $("#password").val();
		var deValue = $("#userId").defaultValue;
		var flag = true;
		if (userId == ""){
			alert('用户名不能为空！');
			flag = false;
		}
		if(pwd.trim() -= ""){
			alert('密码不能为空！');
			flag = false;
		}
		/* if (userId != "" && userId != deValue && pwd.trim() != "") {
			var param = {
				p1 : userId,
				p2 : pwd
			};

			$
					.ajax({
						type : "POST",
						url : "${pageContext.request.contextPath}/login/login.action",
						async : false,
						data : param,
						success : function(returnData) {
							pro = eval('(' + returnData + ')');
							var gnl = confirm("id" + pro[0].staffId + "账号"
									+ pro[0].staffPassword + "密码"
									+ pro[0].staffNumber);
							if (pro[0].staffId == '') {
								alert("账号密码信息错误");
							} else {
								flag = true;
								alert("账号密码信息正确 ");
							}
						}
					});
		} else {
			alert("账号密码信息错误");
		}
 */
		return flag;
	}
</script>
</head>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i> <span class="red">浙江理工</span> 
								<!-- <span class="white">项目管理系统</span> -->
							</h1>
							<h4 class="blue">项目管理系统</h4>
						</div>
						<div class="space-6"></div>
						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 请输入您的账号和密码
										</h4>

										<div class="space-6"></div>
										<%-- <form
											action="${pageContext.request.contextPath }/view/index.jsp"
											method="post" onsubmit="return check()">
										 --%>
										<form
											action="${pageContext.request.contextPath }/login/login.action"
											method="post" onsubmit="return check()">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="userId" name="loginAccount" type="text"
														class="form-control" value="请输入账号" autocomplete="off" />
														<i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="userPw_show" name="" type="text" class="form-control"
														value="请输入密码" /> <input id="userPw" name="loginPassword"
														type="password" class="form-control" style="display: none" />
														<i class="icon-lock"></i>
												</span>
												</label>

												<!-- <div class="code">
													<div>
														<input type="text" class="form-control" id="code_input2"
															placeholder="请输入验证码" required autofocus /> <span
															id="v_container2"></span>
													</div>
												</div> -->

												<div class="clearfix">
													<button type="submit"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> 登陆
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>

									</div>

								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 图片验证码  -->
	<%-- <script
		src="${pageContext.request.contextPath }/resource/custom/gVerify.js"></script>
	<script>
		$(function() {
			var verifyCode2 = new GVerify("v_container2");
			document.getElementById("code_input2").onblur = function() {
				var res = verifyCode2.validate(document
						.getElementById("code_input2").value);
				if (res) {
					alert("验证正确");
				} else {
					alert("验证码错误");
				}
			}
		});
	</script> --%>

	<script type="text/javascript">
		$("#userId").focus(function() {
			//获得当前文本框的值
			var curValue = $(this).val();
			//如果当前文本的值和默认值相等 
			if (curValue == this.defaultValue) {
				//设置当前文本框为""
				$(this).val("");
			}
		});
		$("#userId").blur(function() {
			//获得当前文本框的值
			var curValue = $(this).val();
			//如果当前文本框的值为空
			if ($.trim(curValue) == "") {
				//设置当前文本框的值为 默认值
				$(this).val(this.defaultValue);
			}
		});

		$("#userPw_show").focus(function() {
			//获得当前文本框的值
			var curValue = $(this).val();
			//如果当前文本的值和默认值相等 
			if (curValue == this.defaultValue) {
				//设置当前文本框为""
				$("#userPw_show").hide();
				$("#userPw").show().focus();
				$("#userPw").val("");
			}
		});
		//失去焦点
		$("#userPw").blur(function() {
			//获得当前文本框的值
			var curValue = $(this).val();
			//如果当前文本框的值为空
			if ($.trim(curValue) == "") {
				$("#userPw_show").show();
				$("#userPw").hide();
				//设置当前文本框的值为 默认值
				$("#userPw_show").val($("#userPw_show").val());
			}
		});

		function check1() {
			var userId = $("#userId").val();
			var pwd = $("#userPw").val();
			if (userId.trim() != null
					&& userId != $("#userId").val(this.defaultValue)) {
				if (pwd.trim() != null
						&& pwd != $("#userId").val(this.defaultValue)) {
					var param = {
						p1 : userId,
						p2 : pwd
					};
					$
							.ajax({
								type : "POST",
								url : "${pageContext.request.contextPath}/system/check.action",
								data : param,
								success : function(returnData) {
									alter(returnData);
								}
							});
					if (returnData) {
						return true;
					}
				}
			} else {
				alter("请输入账号密码");
				return false;
			}
		}
	</script>

	<%
		String userId = request.getParameter("userId");
		String pdw = request.getParameter("passWord");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		//存储cookie
		Cookie cookie1 = new Cookie("user", userId);
		Cookie cookie2 = new Cookie("pwd", pdw);
		cookie1.setMaxAge(3600);
		cookie2.setMaxAge(3600);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.getWriter().print("OK");
	%>
</body>
</html>