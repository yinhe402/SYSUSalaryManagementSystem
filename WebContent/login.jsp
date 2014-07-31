<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
	<% // String path=r equest.getContextPath(); // String basePath=r equest.getScheme()+"://"+request.getServerName()+ ":"+request.getServerPort()+path+ "/"; %>
		<%@taglib prefix="s" uri="/struts-tags" %>
			<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
			<html>
				<head>
					<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
					<title>
						中山大学职工基本工资信息管理系统
					</title>
					<link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css"
					media="all" />
					<link href="css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css"
					media="all" />
					<link href="css/bootstrap.min.css" rel="stylesheet">
					<script type="text/javascript" src="js/jquery1.42.min.js">
					</script>
					<script type="text/javascript" src="js/jquery.SuperSlide.js">
					</script>
					<script type="text/javascript" src="js/Validform_v5.3.2_min.js">
					</script>
					<script type="text/javascript">
						window.onload = function() {
							var verifyObj = document.getElementById("Verify");
							verifyObj.onclick = function() {
								this.src = "initCaptcha?timestamp=" + new Date().getTime();
							};
						}
					</script>
				</head>
				<body>
					<div class="header">
						<h1 class="headerLogo">
							<a title="" target="_blank" href="http://www.baidu.com/">
								<img alt="logo" src="images/logo.jpg">
							</a>
						</h1>
					</div>
					<div class="banner">
						<div class="login-aside">
							<div id="o-box-up">
							</div>
							<div id="o-box-down" style="table-layout:fixed;">
								<div class="error-box">
								</div>
								<form class="registerform" action="login" method="post">
									<div class="fm-item">
										<label for="logonId" class="form-label">
											账号
										</label>
										<input type="text" maxlength="10" name="user.id" class="i-text" datatype="s6-18"
										/>
										<div class="ui-form-explain">
										</div>
									</div>
									<div class="fm-item">
										<label for="logonId" class="form-label">
											密码
										</label>
										<input type="password" maxlength="10" name="user.password" class="i-text"
										datatype="*6-16" />
										<div class="ui-form-explain">
										</div>
									</div>
									<div class="fm-item pos-r">
										<label for="logonId" class="form-label">
											验证码
										</label>
										<div style="float:left;">
											<input type="text" value="输入验证码" maxlength="10" size="8
											" name="inputCaptcha" id="yzm" class="i-text yzm" onfocus="javascript:if(this.value='输入验证码')this.value='';"
											/>
										</div>
										<div style="float:left;margin-left:2px;">
											<img src="initCaptcha" id="Verify" class="i-text yzm" style="cursor:hand;"
											alt="看不清，换一张" />
										</div>
									</div>
									<div class="fm-item">
										<div class="span12">
											<button class="btn btn-info btn-block btn-large" type="submit">
												登陆
											</button>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="bd">
						</div>
					</div>
					<div class="banner-shadow">
					</div>
					<div class="footer">
						<p>
							版权所有：中山大学财务处
							<a target="_blank" href="http://www.baidu.com">
							</a>
						</p>
					</div>
				</body>
			
			</html>