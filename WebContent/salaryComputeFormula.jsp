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
	</script>
</head>
<body>
	<form id="myform">
  		地区差：<input type="text" name="areaDifference"/><br />
  		岗位津贴：<input type="text" name="positionAllowance"/><br />
  		教护补贴：<input type="text" name="educationAllowance"/><br />
  		特殊津贴(岗位加权)：<input type="text" name="specialPositionParas"/>特殊津贴(薪级加权)：<input type="text" name="specialLevelParas"/><br />
  		独生子女：<input type="text" name="onlyChildAllowance"/><br />
  		其它补贴(岗位加权)：<input type="text" name="otherPositionParas"/>其它补贴(薪级加权)：<input type="text" name="otherLevelParas"/><br />
  		电话补贴(岗位加权)：<input type="text" name="phonePositionParam"/>电话补贴(薪级加权)：<input type="text" name="phoneLevelParam"/><br />
  		<input type="button" name="btnOk" onclick="initSalaryCompute()" value="确定" />
  	</form>
</body>
</html>