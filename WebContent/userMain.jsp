<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");

	
	function addUser()
	{
		var myform=document.forms[0];
		myform.action="user/addUser_success";
		myform.method="post";
		myform.submit();
	}
	
	function modifyUser()
	{
		var myform=document.forms[0];
		myform.action="user/modifyUser_success";
		myform.method="post";
		myform.submit();
	}
	
	function deleteUser()
	{
		var myform=document.forms[0];
		myform.action="user/deleteUser_success";
		myform.method="post";
		myform.submit();
	}
	
	

</script>
</head>
<body>
<form id="myform1" >
	用户名：<input type="text" name="user.id" /><br />
	密码：<input type="password" name="user.password" /><br />
	类型：<input type="text" name="user.userType" /><br />
	<input type="button" name="btnadd" onclick="addUser()" value="增加" />
	<input type="button" name="btnmodify" onclick="modifyUser()" value="修改" />
	<input type="button" name="btndel" onclick="deleteUser()" value="删除"  /><br />
	<a href="EmployeeEntry.jsp">人员录入</a>
 </form>
</body>
</html>