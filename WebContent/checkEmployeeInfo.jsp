s<%@page import="javax.print.DocFlavor.INPUT_STREAM"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");

	
	function checkEmployee()
	{
		var myform=document.forms[0];
		myform.action="employee/getEmployeeInfo_DisplayEmployeeInfo";
		myform.method="post";
		myform.submit();
	}	
	
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>";
		
		if (nid == "null" || nid == "") {			
			window.location.href="login.jsp";
			$(".alert").alert("请先登录！");
		}
	}
	

</script>
</head>
<body onload="checkLogin()">
<form id="myform1" >
	用户名：<input type="text" name="employee.id" /><br />		
	<input type="button" name="btncheck" onclick="checkEmployee()" value="查询" /><br />
 </form>
</body>
</html>