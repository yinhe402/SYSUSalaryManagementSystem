<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>中山大学教职工工资系统</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/index.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript">
		function addEmployee() {
			var topWin = window.top.document.getElementById("mainFrame").contentWindow;
			var myform = topWin.document.getElementById("myform1");
			myform.action = "employee/addEmployee_success";
			myform.method = "post";
			myform.submit();
		}

		function modifyEmployee() {
			var mainframe = window.frames['mainFrame'];
			var myform = mainframe.contentDocument.getElementById('myform1');
			myform.action = "employee/modifyEmployee_success";
			myform.method = "post";
			myform.submit();
		}

		function findEmployee() {
			var mainframe = window.frames['mainFrame'];
			var myform = mainframe.contentDocument.getElementById('myform1');
			myform.action = "employee/getEmployeeInfo_success";
			myform.method = "post";
			myform.submit();
		}
		
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
	<h3>职工信息</h3>
	<br>
	<form id="myform1">
		职工号：<input type="text" name="employee.id" /><br /> 
		姓名：<input type="text" name="employee.name" /><br /> 
		邮箱：<input type="text" name="employee.email" /><br /> 
		性别：<input type="radio" name="employee.gender" value="true" checked="checked" />
		男<input
		type="radio" name="employee.gender" value="false" />女<br /> 
		出生日期：<input type="text" name="employee.birthday" /><br /> 
		身份证号：<input type="text" name="employee.uid" /><br /> 
		单位：<input type="text" name="employee.department" /><br />
		岗位性质：<input type="text" name="employee.jobType" /><br /> 
		人员身份：<input type="text" name="employee.type" /><br /> 
		进校来源：<input type="text" name="employee.source" /><br /> 
		入校报到时间：<input type="text" name="employee.reachSchoolDate" /><br /> 
		最高学历：<input type="text" name="employee.maxEducation" /><br /> 
		最高学历获得时间：<input type="text" name="employee.maxEducationDate" /><br /> 
		最高学位：<input type="text" name="employee.maxDegree" /><br /> 
		最高学位获得时间：<input type="text" name="employee.maxDegreeDate" /><br /> 
		聘任职务：<input type="text" name="employee.hireWork" /><br /> 
		职务级别：<input type="text" name="employee.workLevel" /><br /> 
		任职时间：<input type="text" name="employee.startWorkDate" /><br /> 
		聘任职称：<input type="text" name="employee.hireTitle" /><br />
		职称级别：<input type="text" name="employee.titleLevel" /><br /> 
		聘任时间：<input type="text" name="employee.hireDate" /><br /> 
		（拟）聘任岗位：<input type="text" name="employee.hireJob" /><br /> 
		聘岗级别：<input type="text" name="employee.jobLevel" /><br />
		<button type="button" class="btn btn-success" onclick="addEmployee()">增加</button>
	</form>
</body>
</html>