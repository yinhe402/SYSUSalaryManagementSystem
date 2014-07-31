<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");
	function addCha()
	{
		top.location='addCha.jsp'; 
	}
	function addPay()
	{
		top.location='addPay.jsp'; 
	}
	function addPos()
	{
		top.location='addPos.jsp'; 
	}
	function changeToTest()
	{
		top.location='test.jsp'; 
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
	<input type="button" name="btnaddCha" onclick="addCha()" value="添加套改记录" /><br />
	<input type="button" name="btnaddPay" onclick="addPay()" value="添加薪级对应" /><br />
	<input type="button" name="btnaddPos" onclick="addPos()" value="添加岗位" /><br />
	<input type="button" name="btnCom" onclick="changeToTest()" value="计算工资" /><br />
 </form>
</body>
</html>