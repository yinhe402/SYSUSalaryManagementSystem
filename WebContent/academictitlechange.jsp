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
				$(".alert").alert("请先登录！");
				}
			}
</script>
</head>
<body onload="checkLogin()">
	<div class="container">
		<h2>职称变动人员名单</h2>
		<table class="table table-bordered">
			<thead>
				<tr bgcolor="#EEEEEE">
					<th class="span3">职工号</th>
					<th class="span3">姓名</th>
					<th class="span3">操作</th>
				</tr>
			</thead>

			<tbody>
				<s:iterator value="resultList" id="" status="st">
					<tr>
						<td><s:property value="" /></td>
						<td><s:property value="" /></td>
						<td><a href="#edit1">编辑</a></td>
					</tr>
				</s:iterator>

			</tbody>
		</table>
	</div>

	<a name="edit1" id="value">&nbsp</a>
	<div class="container">

		<form class="form-horizontal">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="workerid">职工号：</label>
					<div class="controls">
						<input id="workerid" type="text" readonly="readonly"
							name="employee.id" />
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
							readonly="readonly" name="employee.gender" />男<input id="sex"
							type="radio" name="employee.gender" value="false"
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
							<input id="currenttitle" type="text" readonly="readonly" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="currentlabel">现职称级别：</label>
						<div class="controls">
							<input id="currentlabel" type="text" readonly="readonly" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="titlechangetime">职称变动时间：</label>
						<div class="controls">
							<input id="titlechangetime" type="text" readonly="readonly" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="originalposition">原聘任岗位：</label>
						<div class="controls">
							<input id="originalposition" type="text" readonly="readonly" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="originallabel">原聘岗级别：</label>
						<div class="controls">
							<input id="originallabel" type="text" readonly="readonly" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="poschangetime">岗位变动时间：</label>
						<div class="controls">
							<input id="poschangetime" type="text" readonly="readonly" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="currentpos">现聘任岗位：</label>
						<div class="controls">
							<input id="currentpos" type="text" readonly="readonly" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="currentlabel">现聘岗级别：</label>
						<div class="controls">
							<input id="currentlabel" type="text" readonly="readonly" />
						</div>
					</div>

					<br />
					<br />
					<div class="control-group">
						<label class="control-label" for="chansaltime">变动起薪时间：</label>
						<div class="controls">
							<input id="chansaltime" type="text" value="可手动输入" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="dealwithtime">业务处理时间：</label>
						<div class="controls">
							<input id="dealwithtime" type="text" value="自动获取" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="positionsalary">岗位工资：</label>
						<div class="controls">
							<input id="positionsalary" type="text" value="自动读取" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="salary">薪级工资：</label>
						<div class="controls">
							<input id="salary" type="text" value="自动读取" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="according">变更依据：</label>
						<div class="controls">
							<input type="text" value="可手动输入" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="remark">备注：</label>
						<div class="controls">
							<input id="remark" type="text" value="可手动输入" />
						</div>
					</div>

					<div class="form-actions">
						<input type="button" name="btnmodify" onclick="modifyEmployee()"
							value="修改" /> <a href="overdeal.html" target="mainFrame"><input
							type="button" name="btncomp" value="完成" /></a>
					</div>
			</fieldset>
		</form>
	</div>
</body>
</html>