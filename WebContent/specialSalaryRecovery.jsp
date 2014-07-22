<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>特殊工资恢复</title>
<script type="text/javascript">
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
	<form id="myform">
  		职工号：<input type="text" name="specialSalaryRecovery.eId"/><br />
  		恢复原因：<input type="text" name="specialSalaryRecovery.recoveryReason"/><br />
  		<input type="button" name="btnRecovery" onclick="specialSalaryRecovery()" value="确定" />
  	</form>
</body>
</html>