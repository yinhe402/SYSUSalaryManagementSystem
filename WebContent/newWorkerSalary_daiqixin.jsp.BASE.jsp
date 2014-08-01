<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="textml; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/datepicker.css">


<script type="text/javascript">
	//ar myfrom=document.getElementById("myform1");
	i = 0;
	j = 0;
	k = 0;
	l = 0;
	m = 0;
	
	function addSalaryInfo()
	{	var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var myform = topWin.document.getElementById("myform1");
		myform.action="newEmployee/importStaff_newWorkerSalary_yiqixin";
		myform.method="post";
		myform.submit();
	}
	
	function addManExperience() {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("manExperience");
		experienceDiv.innerHTML+='<div id="manExperience_'+i+'">年份:<s:textfield name="manWorkDate'+i+'"/> 担任职位<s:textfield name="manExperience'+i+'"/> <button type="button" class="btn btn-warning" onclick="delManExperience('+i+')">删除</button> <div>';
		i=i+1;
		topWin.document.getElementById("i").value=i;
		
		alert("i="+i);
	}

	function delManExperience(o){
		i=i-1;
		alert("i="+i);
		
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
	    mainDocument.getElementById("manExperience").removeChild(mainDocument.getElementById("manExperience_"+o));
		topWin.document.getElementById("i").value=i;
		
	}
	
	function addProExperience() {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("proExperience");
		experienceDiv.innerHTML+='<div id="proExperience_'+j+'">年份:<s:textfield name="proWorkDate'+j+'"/> 担任职称<s:textfield name="proExperience'+j+'"/> <button type="button" class="btn btn-warning" onclick="delProExperience('+j+')">删除</button> <div>';
		j=j+1;
		topWin.document.getElementById("j").value=j;
		
		alert("j="+j);
	}

	function delProExperience(o){
		j=j-1;
	    alert("j="+j);
	    
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
	    mainDocument.getElementById("proExperience").removeChild(mainDocument.getElementById("proExperience_"+o));
		topWin.document.getElementById("j").value=j;
	}

	function addEduExperience() {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("eduExperience");
		experienceDiv.innerHTML+='<div id="eduExperience_'+k+'">年份:<s:textfield name="eduWorkDate'+k+'"/> 获得学位<s:textfield name="eduExperience'+k+'"/> <button type="button" class="btn btn-warning" onclick="delEduExperience('+k+')">删除</button> <div>';
		k=k+1;
		topWin.document.getElementById("k").value=k;
		
		alert("k="+k);
	}

	function delEduExperience(o){
		k=k-1;
		alert("k="+k);
		
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
	    mainDocument.getElementById("eduExperience").removeChild(mainDocument.getElementById("eduExperience_"+o));
	    topWin.document.getElementById("k").value=k;   	    
	}
	
	function addBreakExperience() {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("breakExperience");
		experienceDiv.innerHTML+='<div id="breakExperience_'+l+'">起始时间：<s:textfield name="breakStartDate'+l+'"/> 结束时间：<s:textfield name="breakEndDate'+l+'"/> <button type="button" class="btn btn-warning" onclick="delBreakExperience('+l+')">删除</button> <div>';
		l=l+1;
		topWin.document.getElementById("l").value=l;
		
		alert("l="+l);
	}

	function delBreakExperience(o) {
		l=l-1;
		alert("l="+l);
		
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
	    mainDocument.getElementById("breakExperience").removeChild(mainDocument.getElementById("breakExperience_"+o));
	    topWin.document.getElementById("l").value=l;
 }
	
	function addWorkerExperience() {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("workerExperience");
		experienceDiv.innerHTML+='<div id="workerExperience_'+m+'">年份:<s:textfield name="workerWorkDate'+m+'"/> 获得学位<s:textfield name="workerExperience'+m+'"/> <button type="button" class="btn btn-warning" onclick="delWorkerExperience('+m+')">删除</button> <div>';
		m=m+1;
		topWin.document.getElementById("m").value=m;
		
		alert("m="+m);
	}

	function delWorkerExperience(o){
		m=m-1;
		alert("m="+m);
		
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
	    mainDocument.getElementById("workerExperience").removeChild(mainDocument.getElementById("workerExperience_"+o));
	    topWin.document.getElementById("m").value=m; 	    
	}
	
</script>
</head>
<body>

<s:form id="myform" style="display:none">
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

<s:form id="myform1" style="margin-left:100px;">	
	职工号	: <s:textfield  name="startSalaryInfo.eid" value="%{#session.addedEmployee.id}"/> <br />	
	起薪时间(XXXX-XX-XX):<input type="text" name="startSalaryInfo.startSalaryDate" /><br />
	基本工资是否上调10%：<input type="radio" name="startSalaryInfo.isRaised" value="true" checked="checked"/>是<input type="radio" name="startSalaryInfo.isRaised" value="false"/>否<br />
	起始工作时间：<input type="text" name="startWorkYear" /><br />
	考核不合格次数：<input type="text" name="failYearTime" /><br />	
	工资系列：<input type="text" name="startSalaryInfo.salarySeries" /><br />
	工资岗位级别：<input type="text" name="startSalaryInfo.positionLevel" /><br />
	备注：<input type="text" name="startSalaryInfo.remarks" value="无" onfocus="if (value =='无'){value =''}" onblur="if (value ==''){value='无'}"/><br />
	<div id="manExperience">
		<h3>管理系列经历:</h3><br />
	</div>
	<s:textarea name="i" id="i" style="display:none"></s:textarea>
	<button type="button" class="btn btn-success" onclick="addManExperience()"> 增加</button>
	
	<div id="proExperience">
		<h3>专技系列经历:</h3><br />
	</div>
	<s:textarea name="j" id="j" style="display:none"></s:textarea>
	<button type="button" class="btn btn-success" onclick="addProExperience()"> 增加</button>
	
	<div id="workerExperience">
		<h3> 工人系列经历:</h3><br />
	</div>
	<s:textarea name="m" id="m" style="display:none"></s:textarea>
	<button type="button" class="btn btn-success" onclick="addWorkerExperience()"> 增加</button>
	
	<div id="eduExperience">
		<h3>教育经历:</h3><br />
	</div>
	<s:textarea name="k" id="k" style="display:none"></s:textarea>
	<button type="button" class="btn btn-success" onclick="addEduExperience()"> 增加</button>
	
	<div id="breakExperience">
		<h3>中断工作经历:</h3><br />
	</div>
	<s:textarea name="l" id="l" style="display:none"></s:textarea>
	<button type="button" class="btn btn-success" onclick="addBreakExperience()"> 增加</button>	
	
	<button type="button" class="btn btn-success" onclick="addSalaryInfo()"> 提交</button>
	
</s:form>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/liveValidation.js"></script>

</body>

</html>
