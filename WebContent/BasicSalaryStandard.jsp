<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<base href="<%=basePath%>">

<title>BSS</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript">
	
		function checkSalaryStandard()
		{
			var myform=document.forms[0];
			myform.action="salaryStandard/checkSalaryStandard_BasicSalaryStandard";
			myform.method="post";
			myform.submit();
		}
		
		function modifyPosSalaryStandard()
		{
			var myform=document.getElementById("myform2");
			myform.action="salaryStandard/modifyPosSalaryStandard_BasicSalaryStandard";
			myform.method="post";2
			myform.submit();
		}
		
		function modifyLevSalaryStandard()
		{
			var myform=document.getElementById("myform3")
			myform.action="salaryStandard/modifyLevSalaryStandard_BasicSalaryStandard";
			myform.method="post";
			myform.submit();
		}
		
		function checkLogin() {
			var nid = "<%=session.getAttribute("user.id")%>";

			if (nid == "null" || nid == "") {
				window.location.href = "login.jsp";
				$(".alert").alert("请先登录！");
			}
		}
		
	</script>
</head>

<body onload="checkLogin()">
	<form id="myform1">
		<table>
			<s:iterator value="#session.managepositionsalary" id="li">
				<s:form>
  					岗位工资：<br />
					<td>序号：<s:textfield name="lid" value="%{#li.id}" /></td>
					<td>岗位：<s:textfield name="position" value="%{#li.position}" /></td>
					<td>级数：<s:textfield name="level" value="%{#li.level}" /></td>
					<td>工资标准：<s:textfield name="salaryStandard"
							value="%{#li.salaryStandard}" /></td>
					<td>起点薪级：<s:textfield name="startPayLevel"
							value="%{#li.startPayLevel}" /></td>
				</s:form>
			</s:iterator>
			<s:iterator value="#session.managepaylevelsalary" id="li">
				<s:form>  		
  					薪级工资：<br />
					<td>薪级：<s:textfield name="payLevel" value="%{#li.payLevel}" /></td>
					<td>工资标准：<s:textfield name="salaryStandard"
							value="%{#li.salaryStandard}" /></td>
				</s:form>
			</s:iterator>
		</table>
		<input type="button" name="btncheck" onclick="checkSalaryStandard()"
			value="Check" />
	</form>

	<form id="myform2">
		岗位工资：<br /> 岗位：
		<s:textfield name="position" />
		<br /> 级数：
		<s:textfield name="level" />
		<br /> 工资标准：
		<s:textfield name="salaryStandard" />
		<br /> 起点薪级：
		<s:textfield name="startPayLevel" />
		<br /> <input type="button" name="btnmodifyPosSalary"
			onclick="modifyPosSalaryStandard()" value="Submit" />
	</form>

	<form id="myform3">
		薪级工资：<br /> 工资标准：
		<s:textfield name="payLevel" />
		<br /> 起点薪级：
		<s:textfield name="payLevelSalaryStandard" />
		<br /> <input type="button" name="btnmodifyLevSalary"
			onclick="modifyLevSalaryStandard()" value="Submit" />
	</form>
</body>
</html>
