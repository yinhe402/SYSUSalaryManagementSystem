<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>减员停薪、取消工资关系</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>

<body>
	<s:form style="text-align:center;"
		action="bonus/importTestResult_success" method="post"
		enctype="multipart/form-data" role="form">
		<div>
			<s:file name="excelFile" label="excelFile 1" />

			<button type="submit" class="btn btn-success">导入</button>
		</div>
		
		
        <div style="margin-top:5%;">
		<select  id="type"
			onchange="show(this.selectedIndex)">

			<option value="1">不发</option>
			<option value="2">双薪</option>
			<option value="3">部分双薪</option>

		</select>
		
		<button type="button" style="margin-bottom:10px;"
			 
			class="btn btn-success" onclick="">提交
		</button>
		</div>



        

	</s:form>

</body>
</html>
