<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>年终一次性奖金</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");
	
</script>
</head>
<body>
<s:form action="bonus/importTestResult_success" method="post" enctype="multipart/form-data">
    <s:file name="excelFile" label="excelFile 1"/>
    <s:submit value="submit"/>
</s:form>
</body>
</html>