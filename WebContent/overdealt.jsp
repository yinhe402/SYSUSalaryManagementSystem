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
		<script type="text/javascript">
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
<form name="promotiontablet" method="post" action="">
	<table border="1" width="500" cellspacing="0" cellpadding="2" align="center">
	<caption>晋升职务表</caption>
	<tr>
	<td >姓名</td>
	<td><input name="in1" type="text" class="input1" /></td>
	</tr>
	<tr>
	<td>员工号</td>
	<td><input name="in1" type="text" class="input1" /></td>
	</tr>
	<tr>
	<td>性别</td>
	<td><input name="in3" type="text" class="input1" /></td>
	</tr>
	<tr>
	<td>出生日期</td>
	<td><input name="in4" type="text" class="input1" /></td>
	</tr>
	<tr>
	<td>身份证号</td>
	<td><input name="in5" type="text" class="input1" /></td>
	</tr>
	<tr>
	<td>原聘任职务</td>
	<td><input name="in6" type="text" class="input1" /></td>
	</tr>
	<tr>
	<td>原职务级别</td>
	<td><input name="in7" type="text" class="input1" ></td>
	</tr>
	<tr>
	<td>原聘任时间</td>
	<td><input name="in8" type="text" class="input1" /></td>
	</tr>
	<tr>
	<td>现聘任职务</td>
	<td><input name="in9" type="text" class="input1" /></td>
	</tr>
	<tr>
	<td>现职务级别</td>
	<td><input name="in10" type="text" class="input1" /></td>
	</tr>
	<tr>
	<td>职务变动时间</td>
	<td><input name="in11" type="text" class="input1" /></td>
	</tr>
	<table>
	<table align="center" border="0">
	<tr>
	<td><input type="button" name="typelist1" onclick="" value="打印" /></td>
	</tr>
	</table>
	</form>
	
	<br /><br /><br />
	<form name="salarychangetable" method="post" action="">
	<table border="1" width="500" cellspacing="0" cellpadding="2" align="center">
	<caption>工资变动的审批表</caption>
	<tr>
	<td width="25%">姓名</td>
	<td width="25%"><input name="inp1" type="text" class="input1" /></td>
	<td width="25%">员工号</td>
	<td width="25%"><input name="inp2" type="text" class="input1" /></td>
	</tr>
	 
	<tr>
	<td>性别</td>
	<td><input name="inp3" type="text" class="input1" /></td>
	<td>出生日期</td>
	<td></td>
	</tr>
	
	<tr>
	<td>身份证号</td>
	<td colspan="3"><input name="inp4" type="text" class="input1" /></td>
	</tr>
	
	<tr>
	<td>单位</td>
	<td><input name="inp5" type="text" class="input1" /></td>
	<td>人员身份</td>
	<td><input name="inp6" type="text" class="input1" /></td>
	</tr>
	
	<tr>
	<td>原岗位工资</td>
	<td><input name="inp7" type="text" class="input1" /></td>
	<td>原薪级工资</td>
	<td><input name="inp8" type="text" class="input1" /></td>
	</tr>
	
	<tr>
	<td>现岗位工资</td>
	<td><input name="inp9" type="text" class="input1" /></td>
	<td>现薪级工资</td>
	<td><input name="inp10" type="text" class="input1" /></td>
	</tr>
	<tr>
	<td>工资变动依据</td>
	<td colspan="3" heignt="50"><input name="inp11" type="text" class="input1" /></td>
	<tr>
	<tr>
	<td>审批状态</td>
	<td colspan="3"><input name="inp12" type="text" class="input1" /></td>
	</tr>
	</table>
	<table align="center" border="0">
	<tr>
	<td><input type="button" name="typelist2" onclick="" value="打印" /></td>
	</tr>
	</table>
	</form>
</body>
</html>