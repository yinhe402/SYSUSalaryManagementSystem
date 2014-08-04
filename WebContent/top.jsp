<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>中山大学教职工工资系统</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		<script type="text/javascript">
		function logout() {
		alert("确认注销?");
		top.location.href="logout";
		}
		
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>";
		
		if (nid == "null" || nid == "") {			
			window.location.href="login.jsp";
			$(".alert").alert("请先登录！");
		}
	}
</script>
	</head>
	<body>

		<div class="top">
			<div class="span4">
				<img src="img/logo.gif" alt="" width="381" height="130">
			</div>
			<div class="span6">
				<span class="title">
					<h2>中山大学教职工工资系统</h2>
				</span>
			</div>
			<div class="span4 offset1" style="margin-left:180px;">
				<div class="pull-right user">
					<span class="label label-success">当前用户</span>	
					<span class="label label-info"><s:property value="#session.employeeLogin.name"/>(<s:property value="#session.employeeLogin.id"/>)</span>
					<br/>
					<div class="btn-group user-btn">
					  <a class="btn btn-primary" data-toggle="modal" data-target="#logoutModel"><i class="icon-user icon-white"></i> 注销</a>
					  <ul class="dropdown-menu">
					    <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
					    <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
					    <li><a href="#"><i class="icon-ban-circle"></i> Ban</a></li>
					    <li class="divider"></li>
					    <li><a href="#"><i class="i"></i> Make admin</a></li>
					  </ul>
					</div>
				</div>
			</div>

			<div style="height:100%;clear:both;"></div>

		</div>
	
	<div class="modal fade" id="logoutModel" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">确认注销?</h4>
				</div>
				<div class="modal-body">
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"  onclick="logout()">确定</button>
					<button type="button" class="btn btn-default" onclick="" data-dismiss="modal">取消</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
		

		
	</body>
</html>
















































