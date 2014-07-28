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
		<div class="rows">
		<div class="span2">
			<h2><font color="blue">停薪管理</font></h2>
		</div>
		
		<div class="span3" style="margin-top:15px;">
			<form class="form-horizontal">
				<a class="btn btn-primary"><i class="icon-print"></i> 打印公司介绍信</a>
			</form>
		</div>
	</div>
	</div>
	<hr />
	 
	 
	<div class="container">
	<form class="form-horizontal">
		<fieldset>
			<table class="table table-bordered span8">
				<thead>
					<tr>
						<th>工资停发表</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>姓名</td>
						<td></td>
						<td>职工号</td>
						<td></td>
					</tr>
					
					<tr>
						<td>离校时间</td>
						<td></td>
						<td>人员工资状态</td>
						<td></td>
					</tr>
					
					<tr>
						<td>离校原因</td>
						<td  colspan="3"></td>
					</tr>
					
					<tr>
						<td>姓名</td>
						<td></td>
						<td>职工号</td>
						<td></td>
					</tr>
					
					<tr>
						<td>工资停发时间</td>
						<td><input type="text" /></td>
						<td>业务处理时间</td>
						<td><input type="text" /></td>
					</tr>
					
					<tr>
						<td>备注</td> 
						<td colspan="3"><input type="text" class="input1" /></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>
	
	<div class="container">
		<form class="horizontal">
			<input type="submit" value="提交" />
		</form>
	</div>
  </div>

</body>
</html>