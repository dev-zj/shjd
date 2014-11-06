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
   <div class="container_con">
       <div class="banner_pic"><img src="../images/ad1.png"  /></div>
	   <div class="login" >
			<form id="loginForm" method="POST" name="loginForm" action="/login" target="_parent">
			<div class="form1">
			  <span>用户名</span>
			  <div class="item-ifo">
                        <input type="text" id="loginname" name="userName" class="text" value="${UserLoginInfo.userName}" tabindex="1" >

                        <div class="i-name ico"></div>
                        <label id="loginname_succeed" class="blank invisible"></label>
                        <label id="loginname_error" class="hide"><b></b></label>
                    </div>
			</div>
			
			<div class="form2">
			  <span>密码</span>
			  <div class="item-ifo">
                        <input type="password" id="loginname" name="password" class="text" value="" tabindex="1" >

                        <div class="i-name ico"></div>
                        <label id="loginname_succeed" class="blank invisible"></label>
                        <label id="loginname_error" class="hide"><b></b></label>
                    </div>
			</div>
			<div class="login_txt">
			   <a href="#">忘记密码?</a>
			   <span><a href="javascript:register();">注册</a></span>			</div>
			<div class="login_bt"><a href="#" onClick="javascript:login();"><img src="../images/bt.png" /></a></div>
			</form>
	   </div>
	   <div class="tuijian">
	      <div class="newstitle">重点设备推荐</div>
	       <ul>
	         <li><a href="#"><img src="../images/pro.png"  />产品名称</a></li>	  
			 <li><a href="#"><img src="../images/pro.png"  />产品名称</a></li>	
		     <li><a href="#"><img src="../images/pro.png"  />产品名称</a></li>	  
			 <li><a href="#"><img src="../images/pro.png"  />产品名称</a></li>	 
			 <li><a href="#"><img src="../images/pro.png"  />产品名称</a></li>	  
	       </ul>
	       <a class="arrow back">&lt;&lt;</a>
		   <a class="arrow forward">&gt;&gt;</a>	   </div>
	   
	   <div class="news">
          <div class="newstitle">新闻公告</div>
	       <ul>
	         <#if (result?size>0)>
	         	<#list result?sort_by("created_date")?reverse as announcement>
	         		<#if (announcement_index>3)>
	         			<#break>
	         		</#if>
	         		<li><a href="#" onClick="top.document.location.href='/announcementList'">${announcement.announce_title}</a> <span>${announcement.created_date}</span></li>		
	         	</#list>
	         </#if>
	       </ul>
       </div>
	   
	   <div class="news1">
          <div class="news1title">文件下载</div>
	       <ul>
	       		<#if fileList??>
	       			<#list fileList?sort_by("cdate")?reverse as file>
	       				<#if (file_index>3)>
	       					<#break>
	       				</#if>
	       				
			         <li><a href="#" onClick="top.document.location.href='/downloadList'">${file.name}</a> <span>${file.cdate}</span></li>	  
	       			</#list>
	       		</#if>
	       
	       </ul>
       </div>
   </div>
</div>

</body>
</html>
