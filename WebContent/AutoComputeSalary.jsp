<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自动生成工资</title>
<script type="text/javascript">
			function checkLogin() {
				var nid = "<%=session.getAttribute("user.id")%>";

				if (nid == "null" || nid == "") {
				window.location.href = "login.jsp";
				$(".alert").alert("请先登录！");
				}
			}
</script>
</head>
<body onload="checkLogin()">
  		<a href="autoSalary">自动生成工资</a>
</body>
</html>