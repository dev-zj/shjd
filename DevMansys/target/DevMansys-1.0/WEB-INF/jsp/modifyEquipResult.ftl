<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上海交通大学化学化工学院实验室</title>
<link href="/css/global.css" rel="stylesheet" type="text/css" />
<script src="/js/default.js"></script>
</head>
<body >
<div class="container">
   <div class="container_con2">
      <div class="leftpart1">
	       <div class="lp_titile1">
		       <div class="h_name14">用户：<span>super_admin</span></div>
		       
		       <div class="h_name">类型：<span>超级管理员</span></div>
			   
			   <div class="login_out"><a href="#" onClick="javascript:logout();"><img src="../images/back.png"> 退出</a></div>
		   </div>
		   
		   <div class="lp_nav">
		     <div class="nav1">
			    <div class="nav1_t">权限管理</div>
			         <ul>
		               <li <#if menuflag??><#if menuflag == 'usercheck'>class="leftnav1"</#if></#if>><a href="/login_s">用户审核</a></li>
			           <li><a href="#">权限管理</a></li>
		             </ul>	  
		      </div>
			  <div class="nav1">
			    <div class="nav1_t">预约管理</div>
			         <ul>
			           <li><a href="/myAudit?userName=super_admin">预约审核</a></li>
		             </ul>	  
		      </div>
			  <div class="nav1">
			    <div class="nav1_t">仪器管理</div>
			         <ul>
			           <li <#if menuflag??><#if menuflag == 'equipModify'>class="leftnav1"</#if></#if>><a href="/equipMana">仪器修改</a></li>
			           <li><a href="/myAudit?userName=super_admin">仪器添加</a></li>
		             </ul>	  
		      </div>
		      
		   </div>
		   
	  </div>



      <div class="rightpart">
	        
			   <div class="fl2s2">
			    		<span class="label1s">&nbsp;</span>修改成功。<a href="/equipMana">点此返回</a>
			    		<div class="clear"></div>
			    	</div>

	  
	 		
      <div class="clear"></div>
   </div>
</div>

</body>
</html>
