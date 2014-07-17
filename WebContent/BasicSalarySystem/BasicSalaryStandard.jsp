<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基本工资标准</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
		function checkSalaryStandard()
		{
			var myform=document.forms[0];
			myform.action="salaryStandard/checkSalaryStandard_success";
			myform.method="post";
			myform.submit();
		}
	
		function modifySalaryStandard()
		{
			var myform=document.forms[0];
			myform.action="salaryStandard/modifySalaryStandard_success";
			myform.method="post";
			myform.submit();
		}
		
	</script>
  </head>
  
  <body>
  	<form id="myform1">
  		<table>
  			<s:iterator value="#session.managepositionsalary" id="li">
  				<s:form>
  					<td><s:textfield name="position" value="%{#li.position}"/></td>
  					<td><s:textfield name="level" value="%{#li.level}"/></td>
  					<td><s:textfield name="salaryStandard" value="%{#li.salaryStandard}"/></td>
  				</s:form>
  			</s:iterator>
  			<s:iterator value="#session.managepaylevelsalary" id="li">
  				<s:form>  				
  					<td><s:textfield name="payLevel" value="%{#li.payLevel}"/></td>
  					<td><s:textfield name="salaryStandard" value="%{#li.salaryStandard}"/></td>
  				</s:form>
  			</s:iterator>
  		</table>
  		<input type="button" name="btncheck" onclick="checkSalaryStandard()" value="查看" />
  		<input type="button" name="btnmodify" onclick="modifySalaryStandard()" value="提交" />
  	</form>
  </body>
</html>
