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
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
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
		
		function ok2()
		{
			var b=document.getElementById("div2");
			if(b.style.display=="none")
				b.style.display="block";
			else
				b.style.display="none";
		}
	</script>
</head>

<body>
	<div style="margin-top:20px;margin-left:20px;"> 
	<s:form action="employee/importStopEmployeeInfo_remove" method="post"
		enctype="multipart/form-data" role="form">

		<s:file name="stopEmployeeFile" label="上传文件" />
		<!--<button type="submit" class="btn btn-success" onclick="ok1()">导入</button>-->
		<input type="submit" class="btn btn-success" onclick="ok1()" value="导入" />
	</s:form>
	</div>
	
	<form id="myform1">
	<table class="table table-bordered">
		<thead>
		<tr>
	 		<th>姓名</th>
	 		<th>性别</th>
	 		<th>职工号</th>
	 		<th>单位</th>
	 		<th>离校时间</th>
	 		<th>离校原因</th>
	 		<th>人员工资状态</th>
	 		<th>停发时间</th>
	 		<th>备注</th>
	 	</tr>
		</thead>
		<tbody>
		<s:iterator id="lList" value="#session.lList">
		 <tr>
			<td><s:property value="%{#lList.getName()}" /></td>
			<td><s:property value="%{#lList.getGender()}" /></td>
			<td><s:property value="%{#lList.geteId()}" /></td>
			<td><s:property value="%{#lList.getDepartment()}" /></td>
			<td><s:property value="%{#lList.getLeaveDate()}" /></td>
			<td><s:property value="%{#lList.getReason()}" /></td>
			<td><s:property value="%{#lList.getState()}" /></td>
			<td><s:property value="%{#lList.getStopDate()}" /></td>
			<td><s:property value="%{#lList.getNote()}" /></td>
		</tr>
	  </s:iterator>
		</tbody>
	</table>
	  <input type="button" name="btnSubmit" value="确认"onclick="yesToSubmit()" />
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
	
	<div id="div2" style="margin-top:20px;text-align:center;width:80%;display:none;">
	<form id="myform4">
	<table class="table table-bordered">
	<thead>
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>职工号</th>
			<th>单位</th>
			<th>离校时间</th>
			<th>离校原因</th>
			<th>人员工资状态</th>
			<th>停发时间</th>
			<th>备注</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator id="idList" value="#session.idList">
		<tr>
			<td><s:textfield value="%{#idList.getName()}" /></td>
			<td><s:textfield value="%{#idList.getGender()}" /></td>
			<td><s:textfield value="%{#idList.geteId()}" /></td>
			<td><s:textfield value="%{#idList.getDepartment()}" /></td>
			<td><s:textfield value="%{#idList.getLeaveDate()}" /></td>
			<td><s:textfield value="%{#idList.getReason()}" /></td>
			<td><s:textfield value="%{#idList.getState()}" /></td>
			<td><s:textfield value="%{#idList.getStopDate()}" /></td>
			<td><s:textfield value="%{#idList.getNote()}" /></td>
		</tr>
		</s:iterator>
		</tbody>
		</table>
	</form>
	</div>
	
	<div id="div2" style="margin-top:20px;text-align:center;width:80%;display:none;">
	<form id="myform5">
		<table class="table tabel-bordered">
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>职工号</th>
				<th>单位</th>
				<th>离校时间</th>
				<th>离校原因</th>
				<th>人员工资状态</th>
				<th>停发时间</th>
				<th>备注</th> 
			</tr>
		</thead>
		<tbody>
		<s:iterator id="nameList" value="#session.nameList">
		<tr>
		<td><s:textfield value="%{#nameList.getName()}" /></td>
	    <td><s:textfield value="%{#nameList.getGender()}" /></td>
		<td><s:textfield value="%{#nameList.geteId()}" /></td>
		<td><s:textfield value="%{#nameList.getDepartment()}" /></td>
		<td><s:textfield value="%{#nameList.getLeaveDate()}" /></td>
		<td><s:textfield value="%{#nameList.getReason()}" /></td>
		<td><s:textfield value="%{#nameList.getState()}" /></td>
		<td><s:textfield value="%{#nameList.getStopDate()}" /></td>
		<td><s:textfield value="%{#nameList.getNote()}" /></td>
		</tr>
		</s:iterator>
		</tbody>
		</table>
	</form>
	</div>
	
	<div id="div2" style="margin-top:20px;text-align:center;width:80%;display:none;">
	<form id="myform6" style="margin:0 auto;text-align:center;width:80%;display:none;">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>职工号</th>
				<th>单位</th>
				<th>离校时间</th>
				<th>离校原因</th>
				<th>人员工资状态</th>
				<th>停发时间</th>
				<th>备注</th> 
			</tr>
		</thead>
		<tbody>
		<s:iterator id="departmentList" value="#session.departmentList">
		<tr>
			<td><s:textfield value="%{#departmentList.getName()}" /></td>
			<td><s:textfield value="%{#departmentList.getGender()}" /></td>
			<td><s:textfield value="%{#departmentList.geteId()}" /></td>
			<td><s:textfield value="%{#departmentList.getDepartment()}" /></td>
			<td><s:textfield value="%{#departmentList.getLeaveDate()}" /></td>
			<td><s:textfield value="%{#departmentList.getReason()}" /></td>
			<td><s:textfield value="%{#departmentList.getState()}" /></td>
			<td><s:textfield value="%{#departmentList.getStopDate()}" /></td>
			<td><s:textfield value="%{#departmentList.getNote()}" /></td>
		</tr>
		</s:iterator>
		</tbody>
		</table>
	</form>
	</div>
</body>
</html>
