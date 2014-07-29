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

	function addSalaryInfo() {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var myform = topWin.document.getElementById("myform1");

	
		myform.action = "newEmployee/importStaff_newWorkerSalary_yiqixin";
		myform.method = "post";
		myform.submit();
	}

	function modifySalaryInfo() {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var myform = topWin.document.getElementById("myform1");

		myform.action = "newEmployee/modifySalaryInfo_success";
		myform.method = "post";
		myform.submit();
	}

	function addManExperience() {

		label0 = document.createElement("label");
		label0.setAttribute("id", "label" + i);
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("manExperience");

		var span1 = document.createElement("span");
		span1.innerHTML = '<span style="font-weight:bold;">年份&nbsp</span>';
		label0.appendChild(span1);

		var a = document.createElement("input");
		a.setAttribute("type", "text");
		a.setAttribute("name", "manWorkDate" + i);
		a.setAttribute("id", "Title" + i);
		label0.appendChild(a);

		var span2 = document.createElement("span");
		span2.innerHTML = '<span style="font-weight:bold;">&nbsp&nbsp担任职位&nbsp</span>';
		label0.appendChild(span2);

		var b = document.createElement("input");
		b.setAttribute("type", "text");
		b.setAttribute("name", "manExperience" + i);
		b.setAttribute("id", "Title" + i);
		label0.appendChild(b);

		var textField2 = document.createElement("input");
		textField2.setAttribute("type", "button");
		textField2.setAttribute("name", "button");
		textField2.setAttribute("style", "margin-top:-8px; margin-left:10px;");
		textField2.setAttribute("class", "btn btn-warning");
		textField2.setAttribute("value", "删除");

		textField2.onclick = function() {
			delManExperience(this);
		};
		label0.appendChild(textField2);

		var div = document.createElement("div");
		div.innerHTML = '';
		label0.appendChild(div);

		experienceDiv.appendChild(label0);
		i++;
		topWin.document.getElementById("i").value = i;
	}

	function delManExperience(o) {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
		mainDocument.getElementById("manExperience").removeChild(o.parentNode);

	}

	function addProExperience() {
		label0 = document.createElement("label");
		label0.setAttribute("id", "label" + j);
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("proExperience");

		var span1 = document.createElement("span");
		span1.innerHTML = '<span style="font-weight:bold;">年份&nbsp</span>';
		label0.appendChild(span1);

		var a = document.createElement("input");
		a.setAttribute("type", "text");
		a.setAttribute("name", "proWorkDate" + j);
		a.setAttribute("id", "Title" + j);
		label0.appendChild(a);

		var span2 = document.createElement("span");
		span2.innerHTML = '<span style="font-weight:bold;">&nbsp&nbsp担任职称&nbsp</span>';
		label0.appendChild(span2);

		var b = document.createElement("input");
		b.setAttribute("type", "text");
		b.setAttribute("name", "proExperience" + j);
		b.setAttribute("id", "Title" + j);
		label0.appendChild(b);

		var textField2 = document.createElement("input");
		textField2.setAttribute("type", "button");
		textField2.setAttribute("name", "button");
		textField2.setAttribute("style", "margin-top:-8px; margin-left:10px;");
		textField2.setAttribute("class", "btn btn-warning");
		textField2.setAttribute("value", "删除");

		textField2.onclick = function() {
			delProExperience(this);
		};
		label0.appendChild(textField2);

		var div = document.createElement("div");
		div.innerHTML = '';
		label0.appendChild(div);

		experienceDiv.appendChild(label0);
		j++;
		topWin.document.getElementById("j").value = j;
		
	}

	function delProExperience(o) {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
		mainDocument.getElementById("proExperience").removeChild(o.parentNode);
	}

	function addWorkerExperience() {
		label0 = document.createElement("label");
		label0.setAttribute("id", "label" + m);
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("workerExperience");

		var span1 = document.createElement("span");
		span1.innerHTML = '<span style="font-weight:bold;">年份&nbsp</span>';
		label0.appendChild(span1);

		var a = document.createElement("input");
		a.setAttribute("type", "text");
		a.setAttribute("name", "workerWorkDate" + m);
		a.setAttribute("id", "Title" + m);
		label0.appendChild(a);

		var span2 = document.createElement("span");
		span2.innerHTML = '<span style="font-weight:bold;">&nbsp&nbsp担任职称&nbsp</span>';
		label0.appendChild(span2);

		var b = document.createElement("input");
		b.setAttribute("type", "text");
		b.setAttribute("name", "workerExperience" + m);
		b.setAttribute("id", "Title" + m);
		label0.appendChild(b);

		var textField2 = document.createElement("input");
		textField2.setAttribute("type", "button");
		textField2.setAttribute("name", "button");
		textField2.setAttribute("style", "margin-top:-8px; margin-left:10px;");
		textField2.setAttribute("class", "btn btn-warning");
		textField2.setAttribute("value", "删除");

		textField2.onclick = function() {
			delWorkerExperience(this);
		};
		label0.appendChild(textField2);

		var div = document.createElement("div");
		div.innerHTML = '';
		label0.appendChild(div);

		experienceDiv.appendChild(label0);
		m++;
		topWin.document.getElementById("m").value = m;
		
	}

	function delWorkerExperience(o) {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
		mainDocument.getElementById("workerExperience").removeChild(
				o.parentNode);
	}

	function addEduExperience() {
		label0 = document.createElement("label");
		label0.setAttribute("id", "label" + k);
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("eduExperience");

		var span1 = document.createElement("span");
		span1.innerHTML = '<span style="font-weight:bold;">年份&nbsp</span>';
		label0.appendChild(span1);

		var a = document.createElement("input");
		a.setAttribute("type", "text");
		a.setAttribute("name", "eduWorkDate" + k);
		a.setAttribute("id", "Title" + k);
		label0.appendChild(a);

		var span2 = document.createElement("span");
		span2.innerHTML = '<span style="font-weight:bold;">&nbsp&nbsp获得学位&nbsp</span>';
		label0.appendChild(span2);

		var b = document.createElement("input");
		b.setAttribute("type", "text");
		b.setAttribute("name", "eduExperience" + k);
		b.setAttribute("id", "Title" + k);
		label0.appendChild(b);

		var textField2 = document.createElement("input");
		textField2.setAttribute("type", "button");
		textField2.setAttribute("name", "button");
		textField2.setAttribute("style", "margin-top:-8px; margin-left:10px;");
		textField2.setAttribute("class", "btn btn-warning");
		textField2.setAttribute("value", "删除");

		textField2.onclick = function() {
			delEduExperience(this);
		};
		label0.appendChild(textField2);

		var div = document.createElement("div");
		div.innerHTML = '';
		label0.appendChild(div);

		experienceDiv.appendChild(label0);
		k++;
		topWin.document.getElementById("k").value = k;
		
	}

	function delEduExperience(o) {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
		mainDocument.getElementById("eduExperience").removeChild(o.parentNode);
	}

	function addBreakExperience() {
		label0 = document.createElement("label");
		label0.setAttribute("id", "label" + l);
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("breakExperience");

		var span1 = document.createElement("span");
		span1.innerHTML = '<span style="font-weight:bold;">起始时间&nbsp</span>';
		label0.appendChild(span1);

		var a = document.createElement("input");
		a.setAttribute("type", "text");
		a.setAttribute("name", "breakWorkDate" + l);
		a.setAttribute("id", "Title" + l);
		label0.appendChild(a);

		var span2 = document.createElement("span");
		span2.innerHTML = '<span style="font-weight:bold;">&nbsp&nbsp结束时间&nbsp</span>';
		label0.appendChild(span2);

		var b = document.createElement("input");
		b.setAttribute("type", "text");
		b.setAttribute("name", "breakExperience" + l);
		b.setAttribute("id", "Title" + l);
		label0.appendChild(b);

		var textField2 = document.createElement("input");
		textField2.setAttribute("type", "button");
		textField2.setAttribute("name", "button");
		textField2.setAttribute("style", "margin-top:-8px; margin-left:10px;");
		textField2.setAttribute("class", "btn btn-warning");
		textField2.setAttribute("value", "删除");

		textField2.onclick = function() {
			delBreakExperience(this);
		};
		label0.appendChild(textField2);

		var div = document.createElement("div");
		div.innerHTML = '';
		label0.appendChild(div);

		experienceDiv.appendChild(label0);
		l++;
		topWin.document.getElementById("l").value = l;
		
	}

	function delBreakExperience(o) {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
		mainDocument.getElementById("breakExperience")
				.removeChild(o.parentNode);
	}
</script>
</head>
<body>
<s:form id="myform" style="display:none; ">

	职工号：<s:property value="#session.addedEmployee.id" />
		<br />
	姓名:<s:property value="#session.addedEmployee.name" />
		<br />
	邮箱:<s:property value="#session.addedEmployee.email" />
		<br />
	性别：	<s:if test="#session.addedEmployee.gender"> 男</s:if>

		<s:else>女</s:else>
		<br />
	出生日期：<s:property value="#session.addedEmployee.birthday" />
		<br />
	身份证号：<s:property value="#session.addedEmployee.uid" />
		<br />
	单位：<s:property value="#session.addedEmployee.department" />
		<br />
	岗位性质：<s:property value="#session.addedEmployee.jobType" />
		<br />
	人员身份：<s:property value="#session.addedEmployee.type" />
		<br />
	进校来源：<s:property value="#session.addedEmployee.source" />
		<br />
	入校报到时间：<s:property value="#session.addedEmployee.reachSchoolDate" />
		<br />
	最高学历：<s:property value="#session.addedEmployee.maxEducation" />
		<br />
	最高学历获得时间：<s:property value="#session.addedEmployee.maxEducationDate" />
		<br />
	最高学位：<s:property value="#session.addedEmployee.maxDegree" />
		<br />
	最高学位获得时间：<s:property value="#session.addedEmployee.maxDegreeDate" />
		<br />
	聘任职务：<s:property value="#session.addedEmployee.hireWork" />
		<br />
	职务级别：<s:property value="#session.addedEmployee.workLevel" />
		<br />
	任职时间：<s:property value="#session.addedEmployee.startWorkDate" />
		<br />
	聘任职称：<s:property value="#session.addedEmployee.hireTitle" />
		<br />
	职称级别：<s:property value="#session.addedEmployee.titleLevel" />
		<br />
	聘任时间：<s:property value="#session.addedEmployee.hireDate" />
		<br />
	（拟）聘任岗位：<s:property value="#session.addedEmployee.hireJob" />
		<br />
	聘岗级别：<s:property value="#session.addedEmployee.jobLevel" />
		<br />
	职工号	: <s:textfield name="startSalaryInfo.eid"
			value="%{#session.addedEmployee.id}" />
		<br />
	</s:form>

	<s:form id="myform1">
		<div class="addEmployeeSalary">增员起薪</div>
		<div class="container">
			<div class="row">
				<div class="span6" style="margin-left:65px;">
					<dl class="dl-horizontal">
						<dt>
							职工号<span style="color:red">*</span>
						</dt>
						<dd>
							<s:textfield id="f1" name="startSalaryInfo.eid"
								value="%{#session.addedEmployee.id}" maxlength="6" />

						</dd>
					</dl>


					<dl class="dl-horizontal" style="margin-bottom:20px; ">
						<dt style="margin-left:-35px; overflow:visible;">
							基本工资是否上调10%<span style="color:red ;">*</span>
						</dt>
						<dd>
							<input style="margin-top:-3px;" type="radio"
								name="startSalaryInfo.isRaised" value="true" checked="checked" />是&nbsp;&nbsp;&nbsp;<input
								style="margin-top:-3px;" type="radio"
								name="startSalaryInfo.isRaised" value="false" />否

						</dd>
					</dl>

					<dl class="dl-horizontal">
						<dt>考核不合格次数</dt>
						<dd>

							<input type="text" name="failTime" size=20>
						</dd>
					</dl>

					<dl class="dl-horizontal">
						<dt>
							工资岗位级别<span style="color:red">*</span>
						</dt>
						<dd>
							<input id="f2" type="text" name="startSalaryInfo.positionLevel"
								size=20>
						</dd>
					</dl>
				</div>

				<div class="span6" style="margin-left:-40px;">
					<dl class="dl-horizontal">
						<dt>
							起薪时间<span style="color:red">*</span>
						</dt>
						<dd>
							<input type="text" id="f3" class="datepicker"
								name="startSalaryInfo.startSalaryDate">

						</dd>
					</dl>


					<dl class="dl-horizontal">
						<dt>
							起始工作时间<span style="color:red">*</span>
						</dt>
						<dd>
							<input type="text" id="f4" class="datepicker"
								name="startWorkYear">
						</dd>
					</dl>

					<dl class="dl-horizontal">
						<dt>
							工资系列<span style="color:red">*</span>
						</dt>
						<dd>

							<input id="f5" type="text" name="startSalaryInfo.salarySeries">
						</dd>
					</dl>

					<dl class="dl-horizontal">
						<dt>备注</dt>
						<dd>
							<input type="text" name="startSalaryInfo.remarks" value="无"
								onfocus="if (value =='无'){value =''}"
								onblur="if (value ==''){value='无'}">
						</dd>
					</dl>
				</div>
			</div>
		</div>

		<div id="manExperience" style="text-align:center; margin-top:50px;">
			<span style="font-size:25px; font-weight:bold;">管理系列经历</span>
			<button type="button" style="margin-top:-5px; margin-left:5px;"
				class="btn btn-success" onclick="addManExperience()">增加</button>
			<br />
		</div>
		<s:textarea name="i" id="i" style="display:none;"></s:textarea>


		<div id="proExperience" style="text-align:center; margin-top:50px;">
			<span style="font-size:25px; font-weight:bold;">专技系列经历</span>
			<button type="button" style="margin-top:-5px; margin-left:5px;"
				class="btn btn-success" onclick="addProExperience()">增加</button>
		</div>
		<s:textarea name="j" id="j" style="display:none;"></s:textarea>



		<div id="workerExperience" style="text-align:center; margin-top:50px;">
			<span style="font-size:25px; font-weight:bold;">工人系列经历</span>
			<button type="button" style="margin-top:-5px; margin-left:5px;"
				class="btn btn-success" onclick="addWorkerExperience()">增加</button>
		</div>
		<s:textarea name="m" id="m" style="display:none;"></s:textarea>

		<div id="eduExperience" style="text-align:center; margin-top:50px;">
			<span style="font-size:25px; font-weight:bold;">教育经历</span>
			<button type="button" style="margin-top:-5px; margin-left:5px;"
				class="btn btn-success" onclick="addEduExperience()">增加</button>
		</div>
		<s:textarea name="k" id="k" style="display:none;"></s:textarea>

		<div id="breakExperience" style="text-align:center; margin-top:50px;">
			<span style="font-size:25px; font-weight:bold;">中断工作经历</span>
			<button type="button" style="margin-top:-5px; margin-left:5px;"
				class="btn btn-success" onclick="addBreakExperience()">增加</button>
		</div>
		<s:textarea name="l" id="l" style="display:none;"></s:textarea>



		<button type="button" style="margin-left: 45%; margin-top:50px;"
			class="btn btn-success" onclick="addSalaryInfo()">提交</button>

	</s:form>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/liveValidation.js"></script>
	<script type="text/javascript">
		$(".datepicker").datepicker({
			format : 'yyyy-mm-dd',
		});

		for ( var y = 1; y < 6; y++) {
			var em = new LiveValidation("f" + y, {
				validMessage : " ",
				wait : 500
			}, {
				onlyOnSubmit : true
			});
			em.add(Validate.Presence, {
				failureMessage : "必填"
			});
		}

		
		
	</script>


</body>

</html>
