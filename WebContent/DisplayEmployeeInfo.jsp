<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DisplayEmployeeInfo</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/index.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>

<script type="text/javascript">
	function findEmployee() {
			var topWin = window.top.document.getElementById("mainFrame").contentWindow;
			var myform1 = topWin.document.getElementById("myform1");
			myform1.action = "employee/getEmployeeInfo_DisplayEmployeeInfo";
			myform1.method = "post";
			myform1.submit();
		}
</script>
</head>

<body>

<s:form id="myform1" >
	<input type="text" name="employee.id" id="input" class="form-control">
	<button type="button" class="btn btn-success" onclick="findEmployee()">查询</button>
</s:form>

<s:form id="myform" > 
<table class="table table-bordered" >
	<thead>
		<tr>
			<th>职工信息表</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>职工号：</td> <td><s:property value="#session.eInfo.id"/></td>
		</tr>

		<tr>
			<td>姓名:</td> <td><s:property  value="#session.eInfo.name"/></td>
		</tr>

		<tr>
			<td>邮箱:</td> <td><s:property  value="#session.eInfo.email"/></td>
		</tr>

		<tr>
			<td>性别:</td> <td><s:if test="#session.eInfo.gender"> 男</s:if> <s:else>女</s:else> </td>
		</tr>

		<tr>
			<td>出生日期:</td> <td><s:property  value="#session.eInfo.birthday" /></td>
		</tr>

		<tr>
			<td>身份证号:</td> <td><s:property  value="#session.eInfo.uid" /></td>
		</tr>

		<tr>
			<td>单位:</td> <td><s:property  value="#session.eInfo.department" /></td>
		</tr>

		<tr>
			<td>岗位性质:</td> <td><s:property  value="#session.eInfo.jobType" /></td>
		</tr>

		<tr>
			<td>人员身份:</td> <td><s:property  value="#session.eInfo.type" /></td>
		</tr>

		<tr>
			<td>进校来源:</td> <td><s:property  value="#session.eInfo.source" /></td>
		</tr>

		<tr>
			<td>入校报到时间:</td> <td><s:property  value="#session.eInfo.reachSchoolDate" /></td>
		</tr>

		<tr>
			<td>最高学历:</td> <td><s:property  value="#session.eInfo.maxEducation" /></td>
		</tr>

		<tr>
			<td>最高学历获得时间:</td> <td><s:property  value="#session.eInfo.maxEducationDate" /></td>
		</tr>

		<tr>
			<td>最高学位:</td> <td><s:property  value="#session.eInfo.maxDegree" /></td>
		</tr>

		<tr>
			<td>最高学位获得时间:</td> <td><s:property  value="#session.eInfo.maxDegreeDate" /></td>
		</tr>

		<tr>
			<td>聘任职务:</td> <td><s:property  value="#session.eInfo.hireWork" /></td>
		</tr>

		<tr>
			<td>职务级别:</td> <td><s:property  value="#session.eInfo.workLevel" /></td>
		</tr>
		<tr>
			<td>聘任时间:</td> <td><s:property  value="#session.eInfo.startWorkDate" /></td>
		</tr>
		<tr>
			<td>聘任职称:</td> <td><s:property  value="#session.eInfo.hireTitle" /></td>
		</tr>
		<tr>
			<td>职称级别:</td> <td><s:property  value="#session.eInfo.titleLevel" /></td>
		</tr>
		<tr>
			<td>聘任时间:</td> <td><s:property  value="#session.eInfo.hireDate" /></td>
		</tr>
		<tr>
			<td>（拟）聘任岗位:</td> <td><s:property  value="#session.eInfo.hireJob" /></td>
		</tr>
		<tr>
			<td>聘岗级别:</td> <td><s:property  value="#session.eInfo.jobLevel" /></td>
		</tr>
	</tbody>
</table>
</s:form>

	
</body>
</html>