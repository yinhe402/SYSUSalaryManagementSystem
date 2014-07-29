<%-- <%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
		<title>中山大学教职工工资系统</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	<div class="container">
		<form class="form-horizontal">
			<fieldset>
				<legend><font size="5" color="blue"><b>用户查询</b></font></legend>
				<div class="control-group">
					<label class="control-label" for="workerid">职工号:</label>
					<div class="controls">
						<input type="text"  id="workerid"/>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="name">姓名:</label>
					<div class="controls">
						<input type="text" id="name"/>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="apartment">部门:</label>
					<div class="controls">
						<input type="text"  id="apartment" />
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="yesorno">业务处理:</label>
					<div class="controls">
					<select id="yesorno"><option selected="selected" value="是">停薪</option><option value="否">取消工资关系</option></select>
					</div>
				</div>
				
				<div class="form-actions">
					<a class="btn btn-primary">查询</a>
				</div>
				</legend>
			</fieldset>
		 </form>
	</div>

	<div class="container">
		<form class="form-horizontal">
		<fieldset>
		    <h2>待减员列表</h2>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>姓名</th>
						<th>性别</th>
						<th>职工号</th>
						<th>单位</th>
						<th>离校时间</th>
						<th>离校原因</th>
						<th>业务处理</th>
					</tr>
					
				</thead>
				
				<tbody>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						 <td>
						 <a href="stopsalary.jsp" target="mainFrame"><font color="blue" size="3">停薪</font></a>/<a href="abolishrelation.jsp" target="mainFrame"><font color="blue" size="3">取消工资关系</font></a>
					 	</td>
					</tr>
					<s:iterator value="" id="" status="">  
					<tr >
					 <td><s:property value=""/></td>
					 <td><s:property value=""/></td>
					 <td><s:property value=""/></td>
					 <td><s:property value=""/></td>
					 <td><s:property value=""/></td>
					 <td><s:property value=""/></td>
					 <td>
						 <a href="stopsalary.jsp" target="mainFrame"><font color="blue" size="3">停薪</font></a href="abolishrelation.jsp" target="mainFrame">/<a><font color="blue" size="3">取消工资关系</font></a>
					 </td>
					</tr>
					</s:iterator>
					 
				</tbody>
			</table>
		<fieldset>
		</form>
	</div>
</body>
</html> --%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<<<<<<< HEAD
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

	</script>
</head>

<body>
	<s:form action="employee/importStopEmployeeInfo_remove" method="post"
		enctype="multipart/form-data" role="form">
		<s:file name="stopEmployeeFile" label="excelFile" />
		<button type="submit" class="btn btn-success">导入</button>
=======
  <head>
    <base href="<%=basePath%>">
    
    <title>减员停薪、取消工资关系</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  </head>
  
  <body>
   <s:form action="employee/importStopEmployeeInfo_remove" method="post" enctype="multipart/form-data" role="form">
     	<s:file class="btn btn-success" name="stopEmployeeFile" label="excelFile"/>
     	 
     	<button type="submit" class="btn btn-success">导入</button>
>>>>>>> 850b2cc20e6c91ac1bba4e9522e0784f7667f509
	</s:form>
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

	<form id="myform2">
		职工号：<input type="text" name="eId" /><br /> 
		离校时间：<input type="text" name="leaveDate" /><br /> 
		离校原因：<input type="text" name="leaveReason" /><br /> 
		工资状态：<input type="text" name="salaryState" /><br /> 
		停发时间：<input type="text" name="stopDate" /><br />
		备注：<input type="text" name="remark" /><br /> 
		业务处理：<input type="radio" name="business" value="停薪" checked="checked" />停薪<input	type="radio" name="business" value="取消工资关系" />取消工资关系<br /> 
		<input type="button" name="btnsubmit" value="确认" onclick="yestoSubmit()" />
	</form>
	
	<form id="myform3">
		职工号：<input type="text" name="queryId" /><br />
		姓名：<input type="text" name="queryName" /><br />
		单位：<input type="text" name="queryDepartment" /><br />
		<input type="button" name="btnsmit" onclick="Query()" value="查询">
	</form>
	
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
	
	<form id="myform6">
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
</body>
</html>
