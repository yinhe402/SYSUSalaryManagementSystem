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

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">
	//ar myfrom=document.getElementById("myform1");
	
	function SubmitSalaryInfo()
	{	
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var myform = topWin.document.getElementById("myform1");
		myform.action="newEmployee/addSalaryInfo_success";
		myform.method="post";
		myform.submit();
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

<s:form id="myform1">	
<div class="addEmployeeSalary">增员起薪</div>
<div class="container" style="font-size:18px;">
			<div class="row" style="margin-left:180px;">
				<div class="span6" style="margin-left:65px;">
					<dl class="dl-horizontal">
						<dt>
							职工号<span style="color:red">*</span>
						</dt>
						<dd>
							<s:textfield  readonly="true" id="f1" name="startSalaryInfo.eid"
								value="%{#session.ssInfo.eid}" maxlength="6" />

						</dd>
					</dl>
					
			        <dl class="dl-horizontal">
						<dt>
							起薪时间<span style="color:red">*</span>
						</dt>
						<dd>
							<s:textfield readonly="true" id="f1" name="startSalaryInfo.startSalaryDate"
								value="%{#session.ssInfo.startSalaryDate}" />

						</dd>
					</dl>


					<dl class="dl-horizontal" style="margin-bottom:25px; ">
						<dt style="margin-left:-35px; overflow:visible;">
							基本工资是否上调10%<span style="color:red ;">*</span>
						</dt>
						<dd>
							<s:if test="%{#session.ssInfo.isRaised}">
								<input disabled="disabled" type="radio" style="margin-top:-3px;"name="startSalaryInfo.isRaised" value="true" checked="checked"/>是&nbsp;&nbsp;&nbsp;<input disabled="disabled" type="radio" style="margin-top:-3px;" name="startSalaryInfo.isRaised" value="false"/>否<br />
							</s:if> 
							<s:else> 
								<input disabled="disabled" type="radio" style="margin-top:-3px;" name="startSalaryInfo.isRaised" value="true"/>是&nbsp;&nbsp;&nbsp;<input disabled="disabled" style="margin-top:-3px;" type="radio" name="startSalaryInfo.isRaised" value="false" checked="checked"/>否<br />
							</s:else>
							
							

						</dd>
						
					</dl>
					
					<dl class="dl-horizontal">
						<dt>
							起始工作时间<span style="color:red">*</span>
						</dt>
						<dd>
                            
							<s:textfield readonly="true" id="f1" name="startSalaryInfo.startWorkYear"
								value="%{#session.sYear}" />
							
						</dd>
					</dl>
					
					<dl class="dl-horizontal">
						<dt>
							考核不合格次数<span style="color:red">*</span>
						</dt>
						<dd>
						<s:textfield readonly="true" id="f1" name="failYearTime"
								value="%{#session.fTime}" />
							
							
						</dd>
					</dl>
					
					<dl class="dl-horizontal">
						<dt>
							工资系列<span style="color:red">*</span>
						</dt>
						<dd>
 						<s:textfield readonly="true" id="f1" name="startSalaryInfo.salarySeries"
								value="%{#session.ssInfo.salarySeries}"/>
							
						</dd>
					</dl>
					

					<dl class="dl-horizontal">
						<dt>
							工资岗位级别<span style="color:red">*</span>
						</dt>
						<dd>
						<s:textfield readonly="true" id="f1" name="startSalaryInfo.positionLevel"
								value="%{#session.ssInfo.positionLevel}"/>
							
						</dd>
					</dl>
					
					
					<dl class="dl-horizontal">
						<dt >
							套改年限
						</dt>
						<dd>
						<s:textfield id="f1" name="startSalaryInfo.changeYears"
								value="%{#session.ssInfo.changeYears}"/>
							
						</dd>
					</dl>
					
					<dl class="dl-horizontal">
						<dt>
							中断工龄
						</dt>
						<dd>
						<s:textfield id="f1" name="startSalaryInfo.breakOffSeniority"
								value="%{#session.ssInfo.breakOffSeniority}"/>
							
						</dd>
					</dl>
					
					<dl class="dl-horizontal">
						<dt style="margin-left:-117px; overflow:visible;">
							截至2006年6月30日实际工作年限
						</dt>
						<dd>
						<s:textfield id="f1" name="startSalaryInfo.workYears" 
								value="%{#session.ssInfo.workYears}"/>
							
						</dd>
					</dl>
					
					
					<dl class="dl-horizontal">
						<dt >
							工作前工龄
						</dt>
						<dd>
						<s:textfield id="f1" name="startSalaryInfo.seniorityBeforeWork"
								value="%{#session.ssInfo.seniorityBeforeWork}"/>
							
						</dd>
					</dl>
					
					<dl class="dl-horizontal">
						<dt style="margin-left:-31px; overflow:visible;">
							大专以上不计工龄年限
						</dt>
						<dd>
						<s:textfield id="f1" name="startSalaryInfo.learnSeniority"
								value="%{#session.ssInfo.learnSeniority}"/>
							
						</dd>
					</dl>
					
					<dl class="dl-horizontal">
						<dt >
							任职年限
						</dt>
						<dd>
						<s:textfield id="f1" name="startSalaryInfo.hireYears"
								value="%{#session.ssInfo.hireYears}"/>
							
						</dd>
					</dl>
					
					<dl class="dl-horizontal">
						<dt>
							薪级
						</dt>
						<dd>
						<s:textfield id="f1" name="startSalaryInfo.salaryLevel" 
								value="%{#session.ssInfo.salaryLevel}"/>
							
						</dd>
					</dl>
					
					<dl class="dl-horizontal">
						<dt >
							岗位工资
						</dt>
						<dd>
						<s:textfield id="f1" name="startSalaryInfo.positionSalary" 
								value="%{#session.ssInfo.positionSalary}"/>
							
						</dd>
					</dl>
					
					<dl class="dl-horizontal">
						<dt >
							薪级工资
						</dt>
						<dd>
						<s:textfield id="f1" name="startSalaryInfo.levelSalary" 
								value="%{#session.ssInfo.levelSalary}"/>
							
						</dd>
					</dl>
					
					<dl class="dl-horizontal">
						<dt >
							备注
						</dt>
						<dd>
						<s:textfield id="f1" name="startSalaryInfo.remarks" 
								value="%{#session.ssInfo.remarks}"/>
							
						</dd>
					</dl>
					
				</div>
             </div>
</div>
  
	
	<br/>
	
	
	
	<div id="manExperience" style="text-align:center; margin-top:50px;">
		<span style="font-size:25px; font-weight:bold; margin-bottom:20px;">管理系列经历</span><br />
		<s:iterator id="mList" value="#session.mList">
			<td><s:textfield readonly="true" value="%{#mList.getTime()}"/></td>
			<td><s:textfield readonly="true" value="%{#mList.getGanhuo()}"/></td><br />
		</s:iterator>
	</div>
	
	<div id="workExperience" style="text-align:center; margin-top:50px;">
		<span style="font-size:25px; font-weight:bold; margin-bottom:20px;">专技系列经历</span><br />
		<s:iterator id="tList" value="#session.tList">
			<td><s:textfield readonly="true" value="%{#tList.getTime()}"/></td>
			<td><s:textfield readonly="true" value="%{#tList.getGanhuo()}"/></td><br />
		</s:iterator>
	</div>
	
	<div id="workerExperience" style="text-align:center; margin-top:50px;">
		<span style="font-size:25px; font-weight:bold; margin-bottom:20px;">工人系列经历</span><br />
		<s:iterator id="wList" value="#session.wList">
			<td><s:textfield readonly="true" value="%{#wList.getTime()}"/></td>
			<td><s:textfield readonly="true" value="%{#wList.getGanhuo()}"/></td><br />
		</s:iterator>
	</div>
	
	<div id="eduExperience" style="text-align:center; margin-top:50px;">
		<span style="font-size:25px; font-weight:bold; margin-bottom:20px;">教育经历</span><br />
		<s:iterator id="eList" value="#session.eList">
			<td><s:textfield readonly="true" value="%{#eList.getTime()}"/></td>
			<td><s:textfield readonly="true" value="%{#eList.getGanhuo()}"/></td><br />
		</s:iterator>
	</div>
	
	<button style="margin-left:47%; margin-top:5%;" type="button" class="btn btn-success" onclick="SubmitSalaryInfo()"> 提交</button>
	
</s:form>
</body>

</html>
