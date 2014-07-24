<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>职工号&nbsp月薪&nbsp时间</p>
	<s:iterator id="salaryList" value="#session.newSalaryList">
		<s:property value="#salaryList.eid"/> &nbsp <s:property value="#salaryList.totleSalary"/>&nbsp<s:property value="#salaryList.time"/> <br/>
	</s:iterator>
</body>
</html>