<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>减员停薪、取消工资关系</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");
	
		function yesToSubmit()
		{
			var myform=document.getElementById("myform1");
			myform.action="employee/infoSubmit_success";
			myform.method="post";
			myform.submit();
		}
		
		function yestoSubmit()
		{
			var myform=document.getElementById("myform2");
			myform.action="employee/infoSubmit2_success";
			myform.method="post";
			myform.submit();
		}
		
		function Query()
		{
			var myform=document.getElementById("myform3");
			myform.action="employee/query_remove";
			myform.method="post";
			myform.submit();
		}
		function ok1()
		{
			/* var a=document.getElementById("div1");
			if(a.style.display=="none")
				a.style.display="block";
			else
				a.style.display="none"; */
			var myform1=document.getElementById("myform1");
			myform1.style.display="block";
		}
	</script>
</head>

<body>
	<div style="margin-top:20px;margin-left:20px;"> 
	<s:form action="employee/importStopEmployeeInfo_remove" method="post"
		enctype="multipart/form-data" role="form">
		<s:file name="stopEmployeeFile" label="excelFile" />
		<button type="submit" class="btn btn-success" onclick="ok1()">导入</button>
	</s:form>
	</div>
	
	<form id="myform1">
		<s:iterator id="lList" value="#session.lList">
		姓名：<td><s:textfield value="%{#lList.getName()}" /></td>
		性别：<td><s:textfield value="%{#lList.getGender()}" /></td>
		职工号：<td><s:textfield value="%{#lList.geteId()}" /></td>
		单位：<td><s:textfield value="%{#lList.getDepartment()}" /></td>
		离校时间：<td><s:textfield value="%{#lList.getLeaveDate()}" /></td>
		离校原因：<td><s:textfield value="%{#lList.getReason()}" /></td>
		人员工资状态：<td><s:textfield value="%{#lList.getState()}" /></td>
		停发时间：<td><s:textfield value="%{#lList.getStopDate()}" /></td>
		备注：<td><s:textfield value="%{#lList.getNote()}" /></td>
			<br />
		</s:iterator>
		<input type="button" name="btnSubmit" value="确认"
			onclick="yesToSubmit()" />
	</form>
	<hr/>
	
	<div style="margin-left:30px;">
	<form id="myform2">
		职工号 ：&nbsp;&nbsp;<input type="text" name="eId" /><br /> 
		离校时间：<input type="text" name="leaveDate" /><br /> 
		离校原因：<input type="text" name="leaveReason" /><br /> 
		工资状态：<input type="text" name="salaryState" /><br /> 
		停发时间：<input type="text" name="stopDate" /><br />
		备注 ：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="remark" /><br /> 
		业务处理：<input type="radio" name="business" value="停薪" checked="checked" />&nbsp;停薪&nbsp;&nbsp;&nbsp;<input	type="radio" name="business" value="取消工资关系" />&nbsp;取消工资关系<br /> 
		<input type="button" name="btnsubmit" value="确认" onclick="yestoSubmit()" />
	</form>
	</div>
	<hr/>
	
	<div>
	<form id="myform3" style="margin-left:30px;">
		职工号：<input type="text" name="queryId" /><br />
		姓名：&nbsp;&nbsp;&nbsp;<input type="text" name="queryName" /><br />
		单位：&nbsp;&nbsp;&nbsp;<input type="text" name="queryDepartment" /><br />
		<input type="button" name="btnsmit" onclick="Query()" value="查询">
	</form>
	</div>
	
	<div style="margin:0 auto;text-align:center;width:80%;">
	<form id="myform4">
		<s:iterator id="idList" value="#session.idList">
		姓名：<td><s:textfield value="%{#idList.getName()}" /></td>
		性别：<td><s:textfield value="%{#idList.getGender()}" /></td>
		职工号：<td><s:textfield value="%{#idList.geteId()}" /></td>
		单位：<td><s:textfield value="%{#idList.getDepartment()}" /></td>
		离校时间：<td><s:textfield value="%{#idList.getLeaveDate()}" /></td>
		离校原因：<td><s:textfield value="%{#idList.getReason()}" /></td>
		人员工资状态：<td><s:textfield value="%{#idList.getState()}" /></td>
		停发时间：<td><s:textfield value="%{#idList.getStopDate()}" /></td>
		备注：<td><s:textfield value="%{#idList.getNote()}" /></td>
			<br />
		</s:iterator>
	</form>
	</div>
	
	<div style="margin:0 auto;text-align:center;width:80%;">
	<form id="myform5">
		<s:iterator id="nameList" value="#session.nameList">
		姓名：<td><s:textfield value="%{#nameList.getName()}" /></td>
		性别：<td><s:textfield value="%{#nameList.getGender()}" /></td>
		职工号：<td><s:textfield value="%{#nameList.geteId()}" /></td>
		单位：<td><s:textfield value="%{#nameList.getDepartment()}" /></td>
		离校时间：<td><s:textfield value="%{#nameList.getLeaveDate()}" /></td>
		离校原因：<td><s:textfield value="%{#nameList.getReason()}" /></td>
		人员工资状态：<td><s:textfield value="%{#nameList.getState()}" /></td>
		停发时间：<td><s:textfield value="%{#nameList.getStopDate()}" /></td>
		备注：<td><s:textfield value="%{#nameList.getNote()}" /></td>
			<br />
		</s:iterator>
	</form>
	</div>
	
	<div>
	<form id="myform6" style="margin:0 auto;text-align:center;width:80%;">
		<s:iterator id="departmentList" value="#session.departmentList">
		姓名：<td><s:textfield value="%{#departmentList.getName()}" /></td>
		性别：<td><s:textfield value="%{#departmentList.getGender()}" /></td>
		职工号：<td><s:textfield value="%{#departmentList.geteId()}" /></td>
		单位：<td><s:textfield value="%{#departmentList.getDepartment()}" /></td>
		离校时间：<td><s:textfield value="%{#departmentList.getLeaveDate()}" /></td>
		离校原因：<td><s:textfield value="%{#departmentList.getReason()}" /></td>
		人员工资状态：<td><s:textfield value="%{#departmentList.getState()}" /></td>
		停发时间：<td><s:textfield value="%{#departmentList.getStopDate()}" /></td>
		备注：<td><s:textfield value="%{#departmentList.getNote()}" /></td>
			<br />
		</s:iterator>
	</form>
	</div>
</body>
</html>
