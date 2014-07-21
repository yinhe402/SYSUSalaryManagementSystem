<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="textml; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">
	//ar myfrom=document.getElementById("myform1");

	
	function addSalaryInfo()
	{	var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var myform = topWin.document.getElementById("myform1");
		myform.action="newEmployee/importStaff_success";
		myform.method="post";
		myform.submit();
	}
	
	function modifySalaryInfo()
	{	
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var myform = topWin.document.getElementById("myform1");
		myform.action="newEmployee/modifySalaryInfo_success";
		myform.method="post";
		myform.submit();
	}
	

</script>
</head>
<body>
<s:form id="myform">
	职工号：<s:property value="#session.addedEmployee.id"/><br />
	姓名:<s:property  value="#session.addedEmployee.name"/> <br />
	邮箱:<s:property  value="#session.addedEmployee.email"/><br />
	性别：	<s:if test="#session.addedEmployee.gender"> 男</s:if>
		<s:else>女</s:else> 
		<br/>
	出生日期：<s:property  value="#session.addedEmployee.birthday" /><br />
	身份证号：<s:property  value="#session.addedEmployee.uid" /><br />
	单位：<s:property  value="#session.addedEmployee.department" /><br />
	岗位性质：<s:property  value="#session.addedEmployee.jobType" /><br />
	人员身份：<s:property  value="#session.addedEmployee.type" /><br />
	进校来源：<s:property  value="#session.addedEmployee.source" /><br />
	入校报到时间：<s:property  value="#session.addedEmployee.reachSchoolDate" /><br />
	最高学历：<s:property  value="#session.addedEmployee.maxEducation" /><br />
	最高学历获得时间：<s:property  value="#session.addedEmployee.maxEducationDate" /><br />
	最高学位：<s:property  value="#session.addedEmployee.maxDegree" /><br />
	最高学位获得时间：<s:property  value="#session.addedEmployee.maxDegreeDate" /><br />
	聘任职务：<s:property  value="#session.addedEmployee.hireWork" /><br />
	职务级别：<s:property  value="#session.addedEmployee.workLevel" /><br />
	任职时间：<s:property  value="#session.addedEmployee.startWorkDate" /><br />
	聘任职称：<s:property  value="#session.addedEmployee.hireTitle" /><br />
	职称级别：<s:property  value="#session.addedEmployee.titleLevel" /><br />
	聘任时间：<s:property  value="#session.addedEmployee.hireDate" /><br />
	（拟）聘任岗位：<s:property  value="#session.addedEmployee.hireJob" /><br />
	聘岗级别：<s:property  value="#session.addedEmployee.jobLevel" /><br />
	职工号	: <s:textfield  name="startSalaryInfo.eid" value="%{#session.addedEmployee.id}"/> <br />	
</s:form>

<s:form id="myform1">
	职工号	: <s:textfield  name="startSalaryInfo.eid" value="%{#session.addedEmployee.id}"/> <br />	
	起薪时间(XXXX-XX-XX):<input type="text" name="startSalaryInfo.startSalaryDate" /><br />
	基本工资是否上调10%：<input type="radio" name="startSalaryInfo.isRaised" value="true" checked="checked"/>是<input type="radio" name="startSalaryInfo.isRaised" value="false"/>否<br />
	套改年限（自动套用）：<input type="text" name="startSalaryInfo.changeYears" /><br />
	中断工龄：<input type="text" name="startSalaryInfo.breakOffSeniority" /><br />
	截至2006年6月30日实际工作年限：<input type="text" name="startSalaryInfo.workYears" /><br />
	工作前工龄（自动套用）：<input type="text" name="startSalaryInfo.seniorityBeforeWork" /><br />
	大专以上不计工龄年限：<input type="text" name="startSalaryInfo.learnSeniority" /><br />
	任职年限（自动套用）：<input type="text" name="startSalaryInfo.hireYears" /><br />
	工资系列：<input type="text" name="startSalaryInfo.salarySeries" /><br />
	工资岗位级别：<input type="text" name="startSalaryInfo.positionLevel" /><br />
	薪级（自动套用）：<input type="text" name="startSalaryInfo.salaryLevel" /><br />
	岗位工资（自动套用）：<input type="text" name="startSalaryInfo.positionSalary" /><br />
	薪级工资（自动套用）：<input type="text" name="startSalaryInfo.levelSalary" /><br />
	备注：<input type="text" name="startSalaryInfo.remarks" value="无" onfocus="if (value =='无'){value =''}" onblur="if (value ==''){value='无'}"/><br />
</s:form>
</body>

</html>
