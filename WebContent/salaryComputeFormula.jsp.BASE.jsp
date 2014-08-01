<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公式计算公式</title>
	<script type="text/javascript">
		function initSalaryCompute()
		{
			var myform=document.forms[0];
			myform.action="initSalaryCompute/initSalaryCompute";
			myform.method="post";
			myform.submit();
		}
		function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>";
		
		if (nid == "null" || nid == "") {			
			window.location.href="login.jsp";
			$(".alert").alert("请先登录！");
		}
	}

	</script>
	<!--[if IE]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
 
 
<body onload="checkLogin()">
	<div class="container" style="margin-top:20px;text-align:center;font-family:'宋体'">
 
	<form id="myform" class="form-horizontal">
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 
  		 地区差：<input type="text" name="areaDifference"/><br/><br/>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
  		 岗位津贴： <input type="text" name="positionAllowance"/><br/><br/>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		 教护补贴： <input type="text" name="educationAllowance"  /><br/><br/>
  		  特殊津贴(岗位加权)： <input type="text" name="specialPositionParas" /><br/><br/>
  		  特殊津贴(薪级加权)： <input type="text" name="specialLevelParas" /><br/><br/>
  		&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;独生子女： <input type="text" name="onlyChildAllowance"  /><br/><br/>
  		 其它补贴(岗位加权)： <input type="text" name="otherPositionParas"  /><br/><br/>
  		 其它补贴(薪级加权)： <input type="text" name="otherLevelParas"  /><br/><br/>
  	    &nbsp;电话补贴(岗位加权)：<input type="text" name="phonePositionParam"  /><br/><br/>
  		 电话补贴(薪级加权)： <input type="text" name="phoneLevelParam"  /><br/><br/>
  		<input type="button" name="btnOk" onclick="initSalaryCompute()" value="确定" />
  	</form>
  	</div>
</body>
</html>