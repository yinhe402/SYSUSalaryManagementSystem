<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>UserMain</title>

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
	
	function importUser()
	{
		var file=document.getElementById("file").value;
		alert(file);
		var path=file.substring(file.lastindexof("\\")+1,file.length);
		alert(path);
		path.action="user/importUser_success";
		path.method="post";
		path.submit();
	}
	
	

</script>
</head>
<body>
<form id="myform1" >
	用户名：<input type="text" name="user.id" /><br />
	密码：<input type="password" name="user.password" /><br />
	类型：<input type="text" name="user.userType" /><br />
	上传文件：<input type="file" name="excelFile" id="file"/><br />
	<input type="button" name="btnadd" onclick="addUser()" value="增加" />
	<input type="button" name="btnmodify" onclick="modifyUser()" value="修改" />
	<input type="button" name="btndel" onclick="deleteUser()" value="删除"  />
	<input type="button" name="btnimport" onclick="importUser()" value="导入" /><br/>
	<a href="EmployeeEntry.jsp">人员录入</a><br />
	<a href="checkEmployeeInfo.jsp">人员查询</a><br />
	<a href="SalaryInfoInput.jsp">工资录入</a><br />
	<a href="SalaryInfoDisplay.jsp">工资导出</a><br />
 </form>
</body>
</html>