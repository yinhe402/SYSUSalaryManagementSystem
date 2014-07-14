<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>中山大学职工基本工资信息管理系统</title>
<link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>

</head>

<body>


<div class="header">
  <h1 class="headerLogo"><a title="" target="_blank" href="http://www.baidu.com/"><img alt="logo" src="images/logo.jpg"></a></h1>
	
</div>

<div class="banner">

<div class="login-aside">
  <div id="o-box-up"></div>
  <div id="o-box-down"  style="table-layout:fixed;">
   <div class="error-box"></div>
   
   <form class="registerform"action="demo/ajax_post.jsp">
   <div class="fm-item">
	   <label for="logonId" class="form-label">账号</label>
	   <input type="text"  maxlength="100" id="username" class="i-text"   datatype="s6-18" >    
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label">密码</label>
	   <input type="password"  maxlength="100" id="password" class="i-text" datatype="*6-16"  >    
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="fm-item pos-r">
	   <label for="logonId" class="form-label">验证码</label>
	   <input type="text" value="输入验证码" maxlength="100" id="yzm" class="i-text yzm" >    
       <div class="ui-form-explain"><img src="images/yzm.jpg" class="yzm-img" /></div>
  </div>
  

  
  <div class="fm-item">
	   <div class="span12">
			 <button class="btn btn-info btn-block btn-large" type="button">登陆</button>
	   </div>
  </div>
 
  
  </form>
  
  </div>

</div>

	<div class="bd">
		
	</div>

	</div>



<div class="banner-shadow"></div>

<div class="footer">
   <p>版权所有：中山大学财务处<a target="_blank" href="http://www.baidu.com"></a></p>
</div>

</body>
</html>
