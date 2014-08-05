<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>中山大学教职工工资系统</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">
			function checkLogin() {
				var nid = "<%=session.getAttribute("user.id")%>";

				if (nid == "null" || nid == "") {
				window.location.href = "login.jsp";
					alert("请先登录！");
				}
			}
			

			function academictitlechange() {
				var myform=document.getElementById("form1");
				myform.action="";
				myform.method="post";
			}
			function search(){			
			    var myform = document.getElementById("changeInfo");
				myform.action = "";
				myform.method = "post";
				myform.submit();
			}
			
			function check(){			
			    var myform = document.getElementById("changeInfo");
				myform.action = "";
				myform.method = "post";
				myform.submit();
				var x = document.getElementById("positionsalary");
				x.readOnly = "false";
				var y = document.getElementById("salary");
				y.readOnly = "false";
			}
			
			function modify(){			
			    var myform = document.getElementById("changeInfo");
				myform.action = "";
				myform.method = "post";
				myform.submit();
			}
</script>
</head>
<body onload="checkLogin()">
	<div class="container">

		<form class="form-horizontal" id="form1">
			<div class="container">
				<h2 style="text-align:center;">职称变动人员名单</h2>
			</div>
			<hr />

			<div class="container" style="margin-left:23%;">

				<form class="form-horizontal" id="changeInfo">
					<fieldset>
						<div class="control-group">
							<label class="control-label" for="workerid">职工号：</label>
							<div class="controls">
								<input id="workerid" type="text" name="employee.id" /> <input
									type="button" class="btn btn-success" value="查询"
									onclick="search()" />
							</div>


						</div>

						<div class="control-group">
							<label class="control-label" for="name">姓名：</label>
							<div class="controls">
								<input id="name" type="text" readonly="readonly"
									name="employee.name" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="mail">邮箱：</label>
							<div class="controls">
								<input id="mail" type="text" readonly="readonly"
									name="employee.email" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="sex">性别：</label>
							<div class="controls">
								<input id="sex" type="radio" value="true" checked="checked"
									readonly="readonly" name="employee.gender" />男&nbsp&nbsp<input
									id="sex" type="radio" name="employee.gender" value="false"
									readonly="readonly" name="employee.gender" />女
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="birthday">出生日期：</label>
							<div class="controls">
								<input id="birthday" type="text" readonly="readonly"
									name="employee.birthday" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="identity">身份证号：</label>
							<div class="controls">
								<input id="identity" type="text" readonly="readonly"
									name="employee.uid" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="apartment">单位：</label>
							<div class="controls">
								<input id="apartment" type="text" readonly="readonly"
									name="employee.department" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="popro">岗位性质：</label>
							<div class="controls">
								<input id="propo" type="text" readonly="readonly"
									name="employee.jobType" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="capacity">人员身份：</label>
							<div class="controls">
								<input id="capacity" type="text" readonly="readonly"
									name="employee.type" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="camefrom">进校来源：</label>
							<div class="controls">
								<input id="camefrom" type="text" readonly="readonly"
									name="employee.source" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="entrytime">入校报到时间：</label>
							<div class="controls">
								<input id="entrytime" type="text" readonly="readonly"
									name="employee.reachSchoolDate" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="hteduexp">最高学历：</label>
							<div class="controls">
								<input id="hteduexp" type="text" readonly="readonly"
									name="employee.maxEducation" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="gaintime">最高学历获得时间：</label>
							<div class="controls">
								<input id="gaintime" type="text" readonly="readonly"
									name="employee.maxEducationDate" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="htedupos">最高学位：</label>
							<div class="controls">
								<input id="htedupos" type="text" readonly="readonly"
									name="employee.maxDegree">
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="gaintime2">最高学位获得时间：</label>
							<div class="controls">
								<input id="gaintime2" type="text" readonly="readonly"
									name="employee.maxDegreeDate" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="position">聘任职务：</label>
							<div class="controls">
								<input id="position" type="text" readonly="readonly"
									name="employee.hireWork" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="poslabel">职务级别：</label>
							<div class="controls">
								<input id="poslabel" type="text" readonly="readonly"
									name="employee.workLevel" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="assumetime">任职时间：</label>
							<div class="controls">
								<input id="assumetime" type="text" readonly="readonly"
									name="employee.startWorkDate" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="originaltitle">原聘任职称：</label>
							<div class="controls">
								<input id="originaltitle" type="text" readonly="readonly"
									name="employee.hireTitle" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="originallabel">原职称级别：</label>
							<div class="controls">
								<input id="originallabel" type="text" readonly="readonly"
									name="employee.titleLevel" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="originaltime">原聘任时间：</label>
							<div class="controls">
								<input id="originaltime" type="text" readonly="readonly"
									name="employee.hireDate" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="currenttitle">现聘任职称：</label>
							<div class="controls">
								<input id="currenttitle" type="text" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="currentlabel">现职称级别：</label>
							<div class="controls">
								<input id="currentlabel" type="text" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="titlechangetime">职称变动时间：</label>
							<div class="controls">
								<input id="titlechangetime" type="text" readonly="readonly" />
							</div>
						</div>


						<div class="control-group">
							<label class="control-label" for="chansaltime">变动起薪时间：</label>
							<div class="controls">
								<input id="chansaltime" type="text" class="datepicker" />
							</div>
						</div>


						<div class="control-group">
							<label class="control-label" for="according">变更依据：</label>
							<div class="controls">
								<input type="text" />
							</div>
						</div>


						<div class="control-group">
							<label class="control-label" for="positionsalary">岗位工资：</label>
							<div class="controls">
								<input id="positionsalary" type="text" readonly="readonly" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="salary">薪级工资：</label>
							<div class="controls">
								<input id="salary" type="text" readonly="readonly" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="remark">备注：</label>
							<div class="controls">
								<input id="remark" type="text" />
							</div>
						</div>

						<div class="form-actions">
							<input type="button" class="btn btn-success" value="提交"
								onclick="check()" /> <input class="btn btn-success"
								type="button" value="更改" onclick="modify()" />
						</div>
					</fieldset>
				</form>
			</div>
			<script type="text/javascript"
				src="bootstrap/js/bootstrap-datepicker.js"></script>
				
			<script type="text/javascript">
				$(".datepicker").datepicker({
					 ViewMode: 'years',
					format : 'yyyy-mm-dd',
	
					})
	
</script>
</body>
</html>