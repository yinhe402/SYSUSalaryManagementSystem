<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="textml; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	//ar myfrom=document.getElementById("myform1");

	
	function addSalaryInfo()
	{	var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var myform = topWin.document.getElementById("myform1");
		myform.action="salary/addSalary_success";
		myform.method="post";
		myform.submit();
	}
	
	function modifySalaryInfo()
	{	
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var myform = topWin.document.getElementById("myform1");
		myform.action="salary/modifySalary_success";
		myform.method="post";
		myform.submit();
	}
	

</script>
</head>
<body>
<form id="myform1">
	职工号	: <input type="text" name="startSalaryInfo.eid" /><br />	
	起薪时间(XXXX-XX-XX): <input type="text" name="startSalaryInfo.startSalaryDate" /><br />
	基本工资是否上调10%：<input type="radio" name="startSalaryInfo.isRaised" value="true" checked="checked"/>是<input type="radio" name="startSalaryInfo.isRaised" value="false"/>否<br />
	套改年限：<input type="text" name="startSalaryInfo.changeYears" /><br />
	中断工龄：<input type="text" name="startSalaryInfo.breakOffSeniority" /><br />
	截至2006年6月30日实际工作年限：<input type="text" name="startSalaryInfo.workYears" /><br />
	工作前工龄：<input type="text" name="startSalaryInfo.seniorityBeforeWork" /><br />
	大专以上不计工龄年限：<input type="text" name="startSalaryInfo.learnSeniority" /><br />
	任职年限：<input type="text" name="startSalaryInfo.hireYears" /><br />
	工资系列：<input type="text" name="startSalaryInfo.salarySeries" /><br />
	工资岗位级别：<input type="text" name="startSalaryInfo.positionLevel" /><br />
	薪级：<input type="text" name="startSalaryInfo.salaryLevel" /><br />
	岗位工资：<input type="text" name="startSalaryInfo.positionSalary" /><br />
	薪级工资：<input type="text" name="startSalaryInfo.levelSalary" /><br />
	备注：<input type="text" name="startSalaryInfo.remarks" /><br />
	<button type="button" class="btn btn-success" onclick="addSalaryInfo()">增加</button>
    <button type="button" class="btn btn-success" onclick="modifySalaryInfo()">修改</button>
    </form>
</body>
</html>
