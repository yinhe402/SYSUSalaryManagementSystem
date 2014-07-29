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
</head>
<body>
	<div class="container">
      
	 
	 <div class="container">
	 <h2 class="page-header">补发补扣处理 </h2>
		<a class="btn btn-primary">新增</a>
		<a class="btn btn-primary">删除</a>
		<a class="btn btn-primary">保存数据</a>
		<a class="btn btn-primary">取消操作</a>
		<a class="btn btn-primary">导出</a>
		<a class="btn btn-primary">关闭窗口</a>
	  </div>
		 
	<div class="container" style="border:1px solid grey;">
		<form class="form-horizontal">
			<fieldset>
			<div class="control-group">
				<label class="control-label" for="workerid">职工号：</label>
				<div class="controls">
					<input type="text" id="workerid"/>
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="name">姓名：</label>
				<div class="controls">
					<input type="text" id="name"  />
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="apartment">单位：</label>
				<div class="controls">
					<input type="text" id="apartment"  />
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="mend">补发补扣：</label> 
				<div class="controls">
					<select id="mend">
						<option selected="selected" value="工资补发">工资补发</option>
						<option value="工资补扣">工资补扣</option>
					</select>
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="salarylabel">薪级工资：</label>
				<div class="controls">
					<input type="text" id="salarylabel"  />
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="positionsalary">岗位工资：</label>
				<div class="controls">
					<input type="text" id="positionsalary" />
				</div>
			</div>
			
			<div class="control-group">
			<label class="control-label" for="mendmoney">补发款：</label>
			<div class="controls">
				<input type="text" id="mendmoney"  />
			</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="mendreason">补发补扣原因：</label>
				<div class="controls">
				<input type="text" id="mendreason" />
				</div>
			</div>
			</fieldset>
		</form>
	</div>
	 
	 <div class="container">
		<h2>补发补扣列表</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
				<th>职工号</th>
				<th>姓名</th>
				<th>单位</th>
				<th>补发补扣</th>
				<th>补发款</th>
				<th>薪级工资</th>
				<th>岗位工资</th>
				<th>补发补扣原因</th>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="" id="" status="st">
				 <tr>
				 <td><s:property value=""/></td>
				 <td><s:property value=""/></td>
				 <td><s:property value=""/></td>
				 <td><s:property value=""/></td>
				 <td><s:property value=""/></td>
				 <td><s:property value=""/></td>
				 <td><s:property value=""/></td>
				 <td><s:property value=""/></td>
				 </tr>
				</s:iterator>
				 
				  
				 
			</tbody>
		</table>
	 </div>
	 <table>
	 </div>
	</div>

</body>
</html>