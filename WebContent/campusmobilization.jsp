<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
		<title>中山大学教职工工资系统</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	<div class="container">
		<form class="form-horizontal">
		<h2>校内工资变动</h2>
			<table class="table table-bordered">
				<thead>
				<tr>
				<th> 职工号</th> 
				<th> 姓名</th> 
				<th> 新单位名称</th> 
				<th> 原单位名称</th> 
				<th> 变更依据</th> 
				<th> 备注</th> 
				</tr>
				</thead>
				
				<tbody>
				 
				
				<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><input name="mob1" type="text" value="填写变更依据" class="input1"/></td>
				<td><input name="mob2" type="text" value="填写备注" class="input1"/></td>
			    <tr>
				
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>