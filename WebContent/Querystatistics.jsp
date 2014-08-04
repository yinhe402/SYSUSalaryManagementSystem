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
		<link rel="stylesheet" href="bootstrap/css/datepicker.css">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap-datepicker.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		
		<script type="text/javascript">
		$(function(){ 
		    $("#date_1").datepicker({
	    		format: 'yyyy-mm-dd',
	    	}); 
		}); 
		
		$(function(){ 
		    $("#date_2").datepicker({
	    		format: 'yyyy-mm-dd',
	    	}); 
		}); 
		
		function checkLogin() {
			var nid = "<%=session.getAttribute("user.id")%>";
			
			if (nid == "null" || nid == "") {			
				window.location.href="login.jsp";
				$(".alert").alert("请先登录！");
			}
	}
		
</script>
</head>
<body onload="checkLogin()">
	<form class="form-horizontal">
	<div class="container" style="text-align:center; margin:0 auto;">
		<h3><font color="blue">请输入查询条件</font></h3>
		 <div class="row" style="text-align:center; margin:0 auto;">
			<div class="span6">
			<span>职工号：</span><input type="text"/>
			</div>
			<div class="span5">
			<span>姓名：</span><input type="text"/>
			</div>
		</div>
		 <div class="row" style="text-align:center; margin:0 auto;">
			<div class="span6">
			<span>查询起始年月：</span><input type="text" id="date_1"/>
			</div>
			
			<div class="span5">
			<span>查询结束年月：</span><input type="text" id="date_2"/>
			</div>
		  </div>
		  
		 <div class="span12">
		 <a class="btn btn-primary">查询</a>
		 </div>
		
	</div>
	<hr/>
	
	<div class="container" style="text-align:center;">
	<table class="table table-bordered" width="40%">
	<thead>
		<tr>
			<th></th>
			<th>岗位工资</th>
			<th>薪级工资</th>
			<th>本月工资总额</th>
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
</form>
</body>
</html>