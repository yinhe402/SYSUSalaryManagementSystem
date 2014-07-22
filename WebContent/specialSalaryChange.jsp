<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>特殊工资变动</title>
<script type="text/javascript">
	function specialSalaryChange()
	{
		var myform=document.forms[0];
		myform.action="specialSalary/specialSalaryChange_success";
		myform.method="post";
		myform.submit();
	}
</script>
</head>
<body>
	<form id="myform">
  		职工号：<input type="text" name="specialSalaryChange.eId"/><br />
  		工资变动幅度(负数代表减薪)：<input type="text" name="specialSalaryChange.amount"/><br />
  		变动原因：<input type="text" name="specialSalaryChange.reason"/><br />
  		<input type="button" name="btnchange" onclick="specialSalaryChange()" value="确定" />
  	</form>
</body>
</html>