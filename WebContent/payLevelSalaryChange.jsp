<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" >
	<title>中山大学教职工工资系统</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/index.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript"> 
		function modifyLevSalaryStandard() {
			var mainDocument=window.top.document.getElementById("mainFrame").contentWindow.document;
			var myform=mainDocument.getElementById("myform");
			myform.action="salaryStandard/modifyLevSalaryStandard_showSalaryStandard";
			myform.method="post";
			myform.submit();
		}
	</script>
</head>

<body>
	<s:form id="myform">	 
		<s:textfield style="display:none" name="tableName" value="%{#session.tableName}"/><br />
		<s:textfield style="display:none" name="type" value="%{#session.type}"/><br />	
		薪级：<s:textfield name="payLevel" value="%{#session.payLevel}"/><br />
		工资标准：<s:textfield name="payLevelSalaryStandard" value="%{#session.payLevelSalaryStandard}"/><br />
		<button type="button" class="btn btn-success" onclick="modifyLevSalaryStandard()">修改</button>
	</s:form>
</body>
</html>