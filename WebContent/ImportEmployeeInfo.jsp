<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>导入职工信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript">
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>";

		if (nid == "null" || nid == "") {
			window.location.href = "login.jsp";
			$(".alert").alert("请先登录！");
		}
	}

	function succeed() {
		alert("导入成功！");
	}
</script>
</head>

<body onload="checkLogin()">
	<s:form action="employee/importEmployeeInfo_ImportEmployeeInfo" method="post"
		enctype="multipart/form-data" role="form">
		<div
			style="margin-top:5%; font-size:30px; font-weight:bold; text-align:center;">职工信息批量导入</div>
		<div style="margin-left:40%; margin-top:5%; ">
			<input type="file" title="选择文件" name="employeeFile" label="excelFile"
				class="file-input-wrapper btn btn-default btn-primary" />
			<button type="submit" class="btn btn-success" onclick="succeed()">导入</button>
		</div>

	</s:form>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.file-input.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script>
	$('input[type=file]').bootstrapFileInput();
	$('.file-inputs').bootstrapFileInput();
</script>
</html>
