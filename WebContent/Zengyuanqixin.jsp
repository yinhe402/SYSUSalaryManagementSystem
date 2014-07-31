
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");

	
	function importStaff()
	{
		var myform=document.forms[0];
		myform.action="zengyuanqixin/importStaff_success";
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
</head>
<body onload="checkLogin()">
<form id="myform1" >
	职工号：<input type="text" name="employee.id" /><br />
	姓名：<input type="text" name="employee.name" /><br />
	邮箱：<input type="text" name="employee.email" /><br />
	性别：<input type="radio" name="employee.gender" value="true" checked="checked"/>男<input type="radio" name="employee.gender" value="false"/>女<br />
	出生日期：<input type="text" name="employee.birthday" /><br />
	身份证号：<input type="text" name="employee.uid" /><br />
	单位：<input type="text" name="employee.department" /><br />
	岗位性质：<input type="text" name="employee.jobType" /><br />
	人员身份：<input type="text" name="employee.type" /><br />
	进校来源：<input type="text" name="employee.source" /><br />
	入校报到时间：<input type="text" name="employee.reachSchoolDate" /><br />
	最高学历：<input type="text" name="employee.maxEducation" /><br />
	最高学历获得时间：<input type="text" name="employee.maxEducationDate" /><br />
	最高学位：<input type="text" name="employee.maxDegree" /><br />
	最高学位获得时间：<input type="text" name="employee.maxDegreeDate" /><br />
	聘任职务：<input type="text" name="employee.hireWork" /><br />
	职务级别：<input type="text" name="employee.workLevel" /><br />
	任职时间：<input type="text" name="employee.startWorkDate" /><br />
	聘任职称：<input type="text" name="employee.hireTitle" /><br />
	职称级别：<input type="text" name="employee.titleLevel" /><br />
	聘任时间：<input type="text" name="employee.hireDate" /><br />
	（拟）聘任岗位：<input type="text" name="employee.hireJob" /><br />
	聘岗级别：<input type="text" name="employee.jobLevel" /><br />
	
	<br/><br/><br/><br/>
	
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
	
	<input type="button" name="btnadd" onclick="importStaff()" value="增加" />
 </form>
</body>
</html>