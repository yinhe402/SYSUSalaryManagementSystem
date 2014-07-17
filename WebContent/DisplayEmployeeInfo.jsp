<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");
</script>
</head>
<body>
	<form id="myform1">
		<table>
			<%-- <s:iterator value="eInfo" id="li">
				<tr>
					<td><s:property value="#li.id" /></td>
					<td><s:property value="#li.name" /></td>
					<td>
				</tr>
			</s:iterator> --%>
			<%-- <s:textfield name="employee.id" value="%{employee.id}"/> --%>
			<s:iterator value="#session.eInfo" id="li">
				<td><s:textfield name="li.id" value="%{#li.id}" /></td>
				<td><s:textfield name="li.name" value="%{#li.name}" /></td>
			</s:iterator>			
		</table>
	</form>
</body>
=======
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DisplayEmployeeInfo</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");
</script>
</head>
<body>
	<form id="myform1">
		<table>
			<%-- <s:iterator value="eInfo" id="li">
				<tr>
					<td><s:property value="#li.id" /></td>
					<td><s:property value="#li.name" /></td>
					<td>
				</tr>
			</s:iterator> --%>
			<%-- <s:textfield name="employee.id" value="%{employee.id}"/> --%>
			<s:iterator value="#session.eInfo" id="li">
				<td><s:textfield name="li.id" value="%{#li.id}" /></td>
				<td><s:textfield name="li.name" value="%{#li.name}" /></td>
			</s:iterator>			
		</table>
	</form>
</body>
>>>>>>> e9fbb8eeae8b7f08ccade04560041c279df191c3
</html>