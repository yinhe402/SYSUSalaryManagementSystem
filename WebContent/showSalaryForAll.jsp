<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
		<title>工资生成列表</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		<script type="text/javascript">
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>";
		
		if (nid == "null" || nid == "") {			
			window.location.href="login.jsp";
			$(".alert").alert("请先登录！");
		}
	}
</script>
</head>
<body onload="checkLogin()">
	<div class="span9" align="center">
	<h2>月工资生成列表</h2>
	<table class="table table-bordered">
	<thead>
	<tr>
		<th>职工号</th>
		<th>月薪</th>
		<th>时间</th>
	</tr>
	</thead>
	
	<tbody>
	<s:iterator id="salaryList" value="#session.newSalaryList">
	<tr>
	<td><s:property value="#salaryList.eid"/></td>
	<td><s:property value="#salaryList.totleSalary"/></td>
	<td><s:property value="#salaryList.time"/></td>
	</tr>
	</s:iterator>
	</tbody>
	</table>
	</div>
</body>
</html>