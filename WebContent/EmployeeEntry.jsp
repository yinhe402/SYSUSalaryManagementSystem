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
	职工号：<input type="text" name="Employee.id" /><br />
	姓名：<input type="text" name="Employee.name" /><br />
	邮箱：<input type="text" name="Employee.email" /><br />
	性别：<input type="radio" name="Employee.gender" />男<input type="radio" name="Employee.gender" />女<br />
	出生日期：<input type="text" name="Employee.birthday" /><br />
	身份证号：<input type="text" name="Employee.birthday" /><br />
	单位：<input type="text" name="Employee.birthday" /><br />
	岗位性质：<input type="text" name="Employee.birthday" /><br />
	进校来源：<input type="text" name="Employee.birthday" /><br />
	入校报到时间：<input type="text" name="Employee.birthday" /><br />
	最高学历：<input type="text" name="Employee.birthday" /><br />
	最高学历获得时间：<input type="text" name="Employee.birthday" /><br />
	最高学位：<input type="text" name="Employee.birthday" /><br />
	最高学位获得时间：<input type="text" name="Employee.birthday" /><br />
	聘任职务：<input type="text" name="Employee.birthday" /><br />
	职务级别：<input type="text" name="Employee.birthday" /><br />
	任职时间：<input type="text" name="Employee.birthday" /><br />
	聘任职称：<input type="text" name="Employee.birthday" /><br />
	职称级别：<input type="text" name="Employee.birthday" /><br />
	聘任时间：<input type="text" name="Employee.birthday" /><br />
	（拟）聘任岗位：<input type="text" name="Employee.birthday" /><br />
	聘岗级别：<input type="text" name="Employee.birthday" /><br />
	
	<input type="button" name="btnadd" onclick="addUser()" value="增加" />
	<input type="button" name="btnmodify" onclick="modifyUser()" value="修改" />
	<input type="button" name="btndel" onclick="deleteUser()" value="删除"  />
 </form>
</body>
</html>