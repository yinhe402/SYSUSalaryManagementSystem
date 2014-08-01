<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
<title>公式计算公式</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript">
		function initSalaryCompute()
		{
			var myform=document.forms[0];
			myform.action="initSalaryCompute/initSalaryCompute_salaryComputeFormula";
			myform.method="post";
			myform.submit();
			alert("设置成功!");
		}
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
<<<<<<< HEAD
	<div class="container" style="margin-top:20px;font-family:'宋体'">
    <h2>工资计算公式</h2>
    <hr/>
	<!-- <form id="myform" class="form-horizontal">
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 
  		 地区差：<input type="text" name="areaDifference"/><br/><br/>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
  		 岗位津贴： <input type="text" name="positionAllowance"/><br/><br/>
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  		 教护补贴： <input type="text" name="educationAllowance"  /><br/><br/>
  		  特殊津贴(岗位加权)： <input type="text" name="specialPositionParas" /><br/><br/>
  		  特殊津贴(岗位加权)： <input type="text" name="specialLevelParas" /><br/><br/>
  		&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;独生子女： <input type="text" name="onlyChildAllowance"  /><br/><br/>
  		 其它补贴(岗位加权)： <input type="text" name="otherPositionParas"  /><br/><br/>
  		 其它补贴(薪级加权)： <input type="text" name="otherLevelParas"  /><br/><br/>
  	    &nbsp;电话补贴(岗位加权)：<input type="text" name="phonePositionParam"  /><br/><br/>
  		 电话补贴(薪级加权)： <input type="text" name="phoneLevelParam"  /><br/><br/>
  		<input type="button" name="btnOk" onclick="initSalaryCompute()" value="确定" />
  	</form>-->
   <div class="row" >
   <div class="span2.2" >
   
   	<span>地区差：</span><br/>
   	<span>岗位津贴： </span><br/>
   	<span>教护补贴：</span><br/>
   	<span>特殊津贴(岗位加权)：</span><br/>
   	<span>特殊津贴(岗位加权)：</span><br/>
   	<span>其它补贴(岗位加权)：</span><br/>
   	<span>其它补贴(薪级加权)：</span><br/>
   	<span>电话补贴(岗位加权)：</span><br/>
   	<span>电话补贴(薪级加权)：</span><br/>	
   	 			
   </div>
   <div class="span6">
   <input type="text" name="areaDifference" style="height:16px;"/><br/>
   <input type="text" name="positionAllowance" style="height:16px;"/><br/>
   <input type="text" name="educationAllowance" style="height:16px;" /><br/>
   <input type="text" name="specialPositionParas" style="height:16px;"/><br/>
   <input type="text" name="specialLevelParas" style="height:16px;"/><br/>
   <input type="text" name="otherPositionParas" style="height:16px;"/><br/>
   <input type="text" name="otherLevelParas" style="height:16px;"/><br/>
   <input type="text" name="phonePositionParam" style="height:16px;"/><br/>
    <input type="text" name="phoneLevelParam"  style="height:16px;"/><br/>
   </div>
   </div>
   <div style="margin-left:150px;margin-top:30px;">
   <input class="btn btn-success" type="button" name="btnOk" onclick="initSalaryCompute()" value="确定" />
   </div>
  	</div>
=======
	<div class="container"
		style="margin-top:20px;text-align:center;font-family:'宋体'">
    <div style="margin-top:1%; font-size:30px; font-weight:bold; text-align:center;">设置工资计算公式</div>
		<form id="myform" class="form-horizontal" style="margin-top: 5%; margin-left: -5%;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
			地区差：<input type="text" name="areaDifference" /><br />
			<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 岗位津贴： <input
				type="text" name="positionAllowance" /><br />
			<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 教护补贴： <input
				type="text" name="educationAllowance" /><br />
			<br /> 特殊津贴(岗位加权)： <input type="text" name="specialPositionParas" /><br />
			<br /> 特殊津贴(薪级加权)： <input type="text" name="specialLevelParas" /><br />
			<br /> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;独生子女： <input
				type="text" name="onlyChildAllowance" /><br />
			<br /> 其它补贴(岗位加权)： <input type="text" name="otherPositionParas" /><br />
			<br /> 其它补贴(薪级加权)： <input type="text" name="otherLevelParas" /><br />
			<br /> &nbsp;电话补贴(岗位加权)：<input type="text" name="phonePositionParam" /><br />
			<br /> 电话补贴(薪级加权)： <input type="text" name="phoneLevelParam" /><br />
			<br /> <input type="button" name="btnOk" class="btn btn-success"
				onclick="initSalaryCompute()" value="确定" />
		</form>
	</div>
>>>>>>> e4603596d80ab6462c01608c69dee6ee0622c7d4
</body>
</html>