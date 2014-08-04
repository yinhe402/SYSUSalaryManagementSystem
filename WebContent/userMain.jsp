<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>中山大学职工工资管理系统</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" href="bootstrap/css/datepicker.css"/>
<link rel="stylesheet" href="css/index.css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/employee.js"></script>
<script type="text/javascript">
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>";
		
		if (nid == "null" || nid == "") {	
			alert("请先登录！");		
			window.location.href="login.jsp";	
		}
	}
	checkLogin();
</script>
</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
      <div class="container-fluid"  id="top">
            <%@ include file="top.jsp" %> 
      </div>
    </div>
 </div>
 <div class="container-fluid" >
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav" id="left">
			<%@ include file="left.jsp" %> 
          </div><!--/.well -->
        </div><!--/span-->

        <div class="span9">
          <div class="leaderboard" id="main">
                 <%@ include file="main.jsp" %> 
            </div>
        </div><!--/span-->
      </div><!--/row-->
          <hr>
    </div><!--/.fluid-container-->


<!-- <frameset rows="110,*" cols="*"  border="1" framespacing="0" onload="checkLogin()">
  <frame src="top.jsp" name="topFrame"  scrolling="no" noresize="noresize" id="topFrame" title="topFrame" marginheight="250"> </frame>
    <frameset  cols="300,*" border="3" >
    <frame src="left.jsp" name="leftFrame"  noresize="noresize" id="leftFrame" title="leftFrame" > </frame>  
       <frame  name="mainFrame"  noresize="noresize" id="mainFrame" title="mainFrame" > </frame>
  </frameset>
</frameset>
<noframes>
<div class="modal fade" id="logoutModel" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">确认注销?</h4>
				</div>
				<div class="modal-body">
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"  onclick="logout()">确定</button>
					<button type="button" class="btn btn-default" onclick="" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
</noframes> -->
</body>
</html>
