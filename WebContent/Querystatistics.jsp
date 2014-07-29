<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
		<title>查询统计</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
 
	  
</head>
<body>
	<form class="form-horizontal">
	<div class="container" style="text-align:center; margin:0 auto;">
		<h3><font color="blue">请输入查询条件</font></h3>
		 <div class="row" style="text-align:center; margin:0 auto;">
			<div class="span6">
			职工号：<input type="text"/>
			</div>
		
			<div class="span5">
			姓名：<input type="text"/>
			</div>
		</div> 
		
		 <div class="row" style="text-align:center; margin:0 auto;">
			<div class="span6">
			查询起始年月：<input type="text"/>
			</div>
			
			<div class="span5">
			查询结束年月：<input type="text" />
			</div>
		  </div>
		  
		 <div class="span12">
		 <a class="btn btn-primary">查询</a>
		 </div>
		
	</div>
	<hr/>
	
	<div class="container" style="text-align:center;margin:0 auto;">
	<div class="span12">
	<table class="table table-bordered">
	<thead>
		<tr>
			<th class="span2"></th>
			<th class="span2">岗位工资</th>
			<th class="span2">薪级工资</th>
			<th class="span2">本月工资总额</th>
		</tr>
	</thead>
	 
	<tbody>
	<s:iterator value="" id=""> 
		<tr>
		<td><s:property value=""/></td>
		<td><s:property value=""/></td>
		<td><s:property value=""/></td>
		<td><s:property value=""/></td>
		</tr>
		</s:iterator>
		<tr>
			<td>总额</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		
		<tr>
			<td>平均额</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	 
	</tbody>
	</table>
	</div>
	</div>
	</form>
</body>
</html>