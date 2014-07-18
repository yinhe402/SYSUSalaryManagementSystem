<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>中山大学职工工资管理系统</title>
</head>

<frameset rows="110,*" cols="*"  border="1" framespacing="0">
  <frame src="top.jsp" name="topFrame"  scrolling="no" noresize="noresize" id="topFrame" title="topFrame">
    <frameset  cols="300,*" border="3" >
    <frame src="left.jsp" name="leftFrame"  noresize="noresize" id="leftFrame" title="leftFrame" />  
       <frame  name="mainFrame"  noresize="noresize" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
<noframes>
</noframes>
<body>
<form id="myform2">
	<a href="BasicSalarySystem.jsp">基本工资体系</a><br />
	<a href="Zengyuanqixin.jsp">增员起薪</a><br />
</form>
</body>
</html>
