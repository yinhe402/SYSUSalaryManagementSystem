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
<link rel="stylesheet" href="css/index.css">

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
	
	function modifySalaryInfo()
	{	
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var myform = topWin.document.getElementById("myform1");
		myform.action="newEmployee/modifySalaryInfo_success";
		myform.method="post";
		myform.submit();
	}
	var j = 0;
	function addManExperience() {
	    j++;
	    label0 = document.createElement("label");
  		label0.setAttribute("id","label"+j);
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("manExperience");
		
		var span1 = document.createElement("span");
  		span1.innerHTML = '<span style="font-weight:bold;">年份&nbsp</span>';
  		label0.appendChild(span1);
		
		var a = document.createElement("input");
		a.setAttribute("type","text");
        a.setAttribute("name","'manWorkDate'+j");
        a.setAttribute("id","Title"+j);
        label0.appendChild(a);
        
        var span2 = document.createElement("span");
  		span2.innerHTML = '<span style="font-weight:bold;">&nbsp&nbsp担任职位&nbsp</span>';
  		label0.appendChild(span2);
		
		var b = document.createElement("input");
		b.setAttribute("type","text");
        b.setAttribute("name","'manExperience'+j");
        b.setAttribute("id","Title"+j);
        label0.appendChild(b);
                
  		var textField2 = document.createElement("input");
 		textField2.setAttribute("type","button");
  		textField2.setAttribute("name","button");
  		textField2.setAttribute("style","margin-top:-8px; margin-left:10px;");
  		textField2.setAttribute("class","btn btn-warning");
  		textField2.setAttribute("value","删除");
  
  		textField2.onclick=function(){delManExperience(this)}
  		label0.appendChild(textField2);
  		
  		
        
        var div = document.createElement("div");
  		div.innerHTML = '';
  		label0.appendChild(div);
  		
  		experienceDiv.appendChild(label0);
	    topWin.document.getElementById("j").value=j;
	}

	function delManExperience(o){ 
	    var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
	    mainDocument.getElementById("manExperience").removeChild(o.parentNode);
		
	}
	
	function addProExperience() {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("proExperience");
		experienceDiv.innerHTML+='<div style="font-weight:bold;" id="proExperience_'+j+'">年份&nbsp<s:textfield name="proWorkDate'+j+'"/> &nbsp&nbsp担任职称&nbsp<s:textfield name="proExperience'+j+'"/> <button type="button" style="margin-top:-5px;" class="btn btn-warning" onclick="delProExperience('+j+')">删除</button> <div>';
		j=j+1;
		topWin.document.getElementById("j").value=j;
	}

	function delProExperience(o){
	    var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
	    mainDocument.getElementById("proExperience").removeChild(mainDocument.getElementById("proExperience_"+o));
		j=j-1;
		topWin.document.getElementById("j").value=j;
	}
	
	function addWorkerExperience() {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("workerExperience");
		experienceDiv.innerHTML+='<div style="font-weight:bold;" id="workerExperience_'+m+'">年份&nbsp<s:textfield name="workerWorkDate'+m+'"/> &nbsp&nbsp获得学位&nbsp<s:textfield name="workerExperience'+m+'"/> <button type="button" style="margin-top:-5px;"class="btn btn-warning" onclick="delWorkerExperience('+m+')">删除</button> <div>';
		m=m+1;
		topWin.document.getElementById("m").value=m;
	}

	function delWorkerExperience(o){
	    var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
	    mainDocument.getElementById("workerExperience").removeChild(mainDocument.getElementById("workerExperience_"+o));
	    m=m-1;
	    topWin.document.getElementById("m").value=m;
	}

	function addEduExperience() {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("eduExperience");
		experienceDiv.innerHTML+='<div id="eduExperience_'+k+'">年份:<s:textfield name="eduWorkDate'+k+'"/> 获得学位<s:textfield name="eduExperience'+k+'"/> <button type="button" class="btn btn-warning" onclick="delEduExperience('+k+')">删除</button> <div>';
		k=k+1;
		topWin.document.getElementById("k").value=k;
	}

	function delEduExperience(o){
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
	    mainDocument.getElementById("eduExperience").removeChild(mainDocument.getElementById("eduExperience_"+o));
	    k=k-1;
	    topWin.document.getElementById("k").value=k;
	}
	
	function addBreakExperience() {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("breakExperience");
		experienceDiv.innerHTML+='<div id="breakExperience_'+i+'">起始时间：<s:textfield name="breakStartDate'+i+'"/> 结束时间：<s:textfield name="breakEndDate'+i+'"/> <button type="button" class="btn btn-warning" onclick="delBreakExperience('+i+')">删除</button> <div>';
		l=l+1;
		topWin.document.getElementById("l").value=l;
	}

	function delBreakExperience(o) {
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
	    mainDocument.getElementById("breakExperience").removeChild(mainDocument.getElementById("breakExperience_"+o));
	    l=l-1;
	    topWin.document.getElementById("l").value=l;
	}
	
	
	
</script>
</head>
<body>
<s:form id="myform" style="display:none; ">
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

<s:form id="myform1" >	
<div class="addEmployeeSalary">增员起薪</div>
<div class="container">
   <div class="row" >
    <div class="span6" style="margin-left:65px;" >
			<dl class="dl-horizontal">
				<dt>
					职工号<span style="color:red">*</span>
				</dt>
				<dd>
					<s:textfield  id="f1" name="startSalaryInfo.eid" value="%{#session.addedEmployee.id}" maxlength="6"/>
								
				</dd>
			</dl>


			<dl class="dl-horizontal" style="margin-bottom:20px; ">
				<dt style="margin-left:-35px; overflow:visible;">
					基本工资是否上调10%<span style="color:red ;">*</span>
				</dt>
				<dd>
					<input style="margin-top:-3px;" type="radio" name="startSalaryInfo.isRaised" value="true" checked="checked"/>是&nbsp;&nbsp;&nbsp;<input style="margin-top:-3px;" type="radio" name="startSalaryInfo.isRaised" value="false"/>否
								
				</dd>
			</dl>

			<dl class="dl-horizontal">
				<dt>
					考核不合格次数<span style="color:red">*</span>
				</dt>
				<dd>
							    
					<input id="f2" type="text" name="failYearTime" size=20>
				</dd>
			</dl>

			<dl class="dl-horizontal">
				<dt>
					工资岗位级别<span style="color:red">*</span>
				</dt>
				<dd>
					<input id="f3" type="text" name="startSalaryInfo.positionLevel" size=20>
				</dd>
			</dl>
    </div>
    
    <div class="span6" style="margin-left:-40px;">
			<dl class="dl-horizontal">
				<dt>
					起薪时间<span style="color:red">*</span>
				</dt>
				<dd>
					<input  type="text" id="f4" name="startSalaryInfo.startSalaryDate">
								
				</dd>
			</dl>


			<dl class="dl-horizontal">
				<dt>
					起始工作时间<span style="color:red">*</span>
				</dt>
				<dd>
					<input  type="text" id="f5" name="startWorkYear" >
				</dd>
			</dl>

			<dl class="dl-horizontal">
				<dt>
					工资系列<span style="color:red">*</span>
				</dt>
				<dd>
							    
					<input id="f6" type="text" name="startSalaryInfo.salarySeries" >
				</dd>
			</dl>

			<dl class="dl-horizontal">
				<dt>
					备注
				</dt>
				<dd>
					<input  type="text" name="startSalaryInfo.remarks" value="无" onfocus="if (value =='无'){value =''}" onblur="if (value ==''){value='无'}">
				</dd>
			</dl>
    </div>
   </div>
</div>
	
	<div id="manExperience" style="text-align:center; margin-top:50px;">
		<span style="font-size:25px; font-weight:bold;">管理系列经历</span>
		<button type="button" style="margin-top:-5px; margin-left:5px;" class="btn btn-success" onclick="addManExperience()"> 增加</button>
		<br/>
	</div>
	<s:textarea name="i" id="i" style="display:none;"></s:textarea>
	
	
	<div id="proExperience" style="text-align:center; margin-top:50px;">
		<span style="font-size:25px; font-weight:bold;">专技系列经历</span>
		<button type="button" style="margin-top:-5px; margin-left:5px;" class="btn btn-success" onclick="addProExperience()"> 增加</button>
	</div>
	<s:textarea name="j" id="j" style="display:none;"></s:textarea>
	
	<div id="workerExperience" style="text-align:center; margin-top:50px;">
		<span style="font-size:25px; font-weight:bold;">工人系列经历</span>
		<button type="button" style="margin-top:-5px; margin-left:5px;" class="btn btn-success" onclick="addWorkerExperience()"> 增加</button>
	</div>
	<s:textarea name="m" id="m" style="display:none;"></s:textarea>
	
	
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
