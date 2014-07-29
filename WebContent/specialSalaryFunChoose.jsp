<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
		<title>特殊情况工资变动</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		
<script type="text/javascript">
	function specialSalaryChange()
	{
	var myform=document.forms[0];
	myform.action="specialSalary/specialSalaryChange_success";
	myform.method="post";
	myform.submit();
}
	
	function specialSalaryRecovery()
	{
		var myform=document.forms[0];
		myform.action="specialSalary/specialSalaryRecovery_success";
		myform.method="post";
		myform.submit();
	}
	
</script>
</head>
<body>
	<br />
	<!-- <a href="specialSalaryChange.jsp">特殊工资变动</a><br /><br />
	<a href="specialSalaryRecovery.jsp">特殊工资恢复</a>-->
	<div class="container">
	<h2>特殊情况工资变动</h2>
	<hr/>
	<form class="form-horizontal">
	    <div class="control-group">
		职工号：<input type="text" name="specialSalaryChange.eId"/>
		</div>
		
		 <div class="control-group">
		姓名：<input type="text" name=""/>
		</div>
		
		 <div class="control-group">
		单位：<input type="text" name=""/>
		</div>
		
		<div class="control-group">
		工资变动幅度<br/>(负数代表减薪)：<input type="text" name="specialSalaryChange.amount"/>
		</div>
		
		<div class="control-group">
		变动原因：<input type="text" name="specialSalaryChange.reason"/>
		</div>
		
		 <div class="control-group">
		修改时间：<input type="text" name=""/>
		</div>
		
		<div class="control-group">
		<a href="specialSalaryChange.jsp" target="mainFrame"><input class="btn btn-primary" style="width:60px;" name="btnchange" onclick="specialSalaryChange()" value="确定" /></a>
		</div>
	</form>
	</div>
	<hr/>

	<div class="container">
	<form class="form-horizontal">
	<h2>特殊情况工资恢复</h2>
	<div class="control-group">
	职工号：<input type="text" name="specialSalaryChange.eId" />
	</div>
	
    <div class="control-group">
	姓名：<input type="text" name=""/>
	</div>
	
	 <div class="control-group">
	单位：<input type="text" name=""/>
	</div>
	<div class="control-group">
	恢复原因：<input type="text" name="specialSalaryRecovery.recoveryReason"/>
	</div>
	
	 <div class="control-group">
	修改时间：<input type="text" name=""/>
	</div>
	
	<div class="control-group">
	<a href="specialSalaryRecovery.jsp" target="mainFrame"><input class="btn btn-primary" style="width:60px;" name="btnRecovery" onclick="specialSalaryRecovery()" value="确定" /></a>
	</div>
	</form>
    </div>
</body>
</html>