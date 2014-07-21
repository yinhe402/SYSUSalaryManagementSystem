<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>中山大学职工工资管理系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

BK
    .tabfont01 {
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}

.font051 {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}

.font201 {
	font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
-->
</style>
<script type="text/JavaScript">

</script>
</head>

<body>
	<s:form name="professionalPositionForm">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size:16px bgcolor = #FFFFFF">专业技术人员岗位工资表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="10%">岗位</td>
													<td width="10%">级数</td>
													<td width="10%">工资标准</td>
													<td width="10%">起点薪级</td>
													<td width="10%">操作</td>
												</tr>
												<s:iterator id="proList" value="#session.proList">
													<tr bgcolor="#FFFFFF">
														<td><s:property value="#proList.position" /></td>
														<td><s:property value="#proList.level" /></td>
														<td><s:property value="#proList.salaryStandard" /></td>
														<td><s:property value="#proList.startPayLevel" /></td>
														<td ><a href="BasicSalaryStandard.jsp">修改</a></td>
													</tr>
												</s:iterator>
											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
	<br />


	<s:form name="fom" id="fom" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size:16px bgcolor = #FFFFFF">专业技术人员薪级工资表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="20%">薪级</td>

													<td width="20%">工资标准</td>
													<td width="10%">操作</td>
												</tr>
												
												<s:iterator id="proPayLevelList"
													value="#session.proPayLevelList">
													<tr bgcolor="#FFFFFF">
														<td><s:property value="#proPayLevelList.payLevel" /></td>
														<td><s:property
																value="#proPayLevelList.salaryStandard" /></td>
																<td ><a href="BasicSalaryStandard.jsp">修改</a></td>
																</tr>
												</s:iterator>
								


											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
	<br />

	<s:form name="fom" id="fom" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size:16px bgcolor = #FFFFFF">管理人员岗位工资表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="10%">岗位</td>
													<td width="10%">级数</td>
													<td width="10%">工资标准</td>
													<td width="10%">起点薪级</td>
													<td width="10%">操作</td>
												</tr>
												<s:iterator id="manList" value="#session.manList">
													<tr bgcolor="#FFFFFF">
														<td><s:property value="#manList.position" /></td>
														<td><s:property value="#manList.level" /></td>
														<td><s:property value="#manList.salaryStandard" /></td>
														<td><s:property value="#manList.startPayLevel" /></td>
														<td ><a href="BasicSalaryStandard.jsp">修改</a></td>
													</tr>
												</s:iterator>


											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
	<br />


	<s:form name="fom" id="fom" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size:16px bgcolor = #FFFFFF">管理人员薪级工资表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="20%">薪级</td>
													<td width="20%">工资标准</td>
													<td width="10%">操作</td>
												</tr>

												<s:iterator id="manPayLevelList"
													value="#session.manPayLevelList">
													<tr bgcolor="#FFFFFF">
														<td><s:property value="#manPayLevelList.payLevel" /></td>
														<td><s:property
																value="#manPayLevelList.salaryStandard" /></td>
																<td ><a href="BasicSalaryStandard.jsp">修改</a></td>
													</tr>
												</s:iterator>
											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
	<br />

	<s:form name="fom" id="fom" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">


			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size:16px bgcolor = #FFFFFF">工人岗位工资表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="10%">岗位</td>
													<td width="10%">级数</td>
													<td width="10%">工资标准</td>
													<td width="10%">起点薪级</td>
													<td width="10%">操作</td>
												</tr>

												<s:iterator id="workerList" value="#session.workerList">
													<tr bgcolor="#FFFFFF">
														<td><s:property value="#workerList.position" /></td>
														<td><s:property value="#workerList.level" /></td>
														<td><s:property value="#manList.salaryStandard" /></td>
														<td><s:property value="#manList.startPayLevel" /></td>
														<td ><a href="BasicSalaryStandard.jsp">修改</a></td>
													</tr>
												</s:iterator>


											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
	<br />

	<s:form name="fom" id="fom" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">


			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size:16px bgcolor = #FFFFFF">工人薪级工资表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="20%">薪级</td>

													<td width="20%">工资标准</td>
													<td width="10%">操作</td>
												</tr>

												<s:iterator id="workerPayLevelList"
													value="#session.workerPayLevelList">
													<tr bgcolor="#FFFFFF">
														<td><s:property value="#workerPayLevelList.payLevel" /></td>
														<td><s:property
																value="#workerPayLevelList.salaryStandard" /></td>
														<td ><s:a href="BasicSalaryStandard.jsp">修改</s:a></td>
													</tr>
												</s:iterator>



											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
