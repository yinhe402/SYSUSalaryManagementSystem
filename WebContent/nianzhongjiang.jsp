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
<link rel="stylesheet" href="css/nianzhongjiang.css">



</head>

<body>
	<s:form style="text-align:center;"
		action="bonus/importTestResult_success" method="post"
		enctype="multipart/form-data" role="form">
		<br/>
		<br/>
			<input type="file" title="选择"  data-filename-placement="outside" class="file-input-wrapper btn btn-default btn-primary">
            

		
		
		<br/>
		<br/>
		


		<div class="top">
			<select id="type" name=" ">

				<option value="1">不发</option>
				<option value="2">双薪</option>
				<option value="3">部分双薪</option>

			</select>

			<button type="button" style="margin-bottom:10px;"
				class="btn btn-success" onclick="">提交</button>
		</div>

		<s:form name="professionalPositionForm">
			<table width="85%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="40">
						<table width="100%" border="0" cellpadding="4" cellspacing="1"
							bgcolor="#000000" class="newfont03">
							<tr class="CTitle" bgcolor="#CAE1FF">
								<td height="22" colspan="7" align="center"
									style="font-size:16px; "></td>
							</tr>
							<tr bgcolor="#EEEEEE">
								<td width="10%">职工号</td>
								<td width="10%">姓名</td>
								<td width="10%">双薪类型</td>
								<td width="10%">部分双薪原因</td>
								<td width="10%">双薪月数</td>
								<td width="10%">时间</td>
							</tr>



						</table></td>
				</tr>
			</table>

		</s:form>



	</s:form>

</body>


<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.file-input.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script>
            $('input[type=file]').bootstrapFileInput();
            $('.file-inputs').bootstrapFileInput();
</script>
</html>
