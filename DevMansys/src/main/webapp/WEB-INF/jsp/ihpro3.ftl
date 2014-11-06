<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上海交通大学化学化工学院实验室</title>
<link href="/css/global.css" rel="stylesheet" type="text/css" />
<script src="/js/default.js"></script>

	<link type="text/css" href="/css/jquery-ui-1.8.17.custom.css" rel="stylesheet" />
     <link type="text/css" href="/css/jquery-ui-timepicker-addon.css" rel="stylesheet" />
    <script type="text/javascript" src="/js/calendar/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="/js/calendar/jquery-ui-1.8.17.custom.min.js"></script>
	<script type="text/javascript" src="/js/calendar/jquery-ui-timepicker-addon.js"></script>
    <script type="text/javascript" src="/js/calendar/jquery-ui-timepicker-zh-CN.js"></script>
    <script type="text/javascript">
    $(function () {
        $(".ui_timepicker").datetimepicker({
            //showOn: "button",
            //buttonImage: "./css/images/icon_calendar.gif",
            //buttonImageOnly: true,
            showSecond: true,
            timeFormat: 'hh:mm:ss',
            stepHour: 1,
            stepMinute: 1,
            stepSecond: 1
        })
    })
    </script>


</head>
<body >
<div class="container">
   <div class="container_con2">
            <div class="leftpart1">
	       <div class="lp_titile1">
		       <div class="h_name14">用户：<span>${user.userName}</span></div>
		       <#if user.userName != 'super_admin'><div class="h_name">小组：<span>${user.teamName}</span></div></#if>
		       <div class="h_name">类型：<span><#if user.userName == 'super_admin'>超级管理员<#else>普通用户</#if></span></div>
			   
			   <div class="login_out"><a href="#" onClick="javascript:logout();"><img src="../images/back.png"> 退出</a></div>
		   </div>
		   
		   <div class="lp_nav">
		   <#if user.userName == 'super_admin'>
		     <div class="nav1">
			    <div class="nav1_t">权限管理</div>
			         <ul>
		               <li <#if pageFlag??><#if pageFlag == 'usercheck'>class="leftnav1"</#if></#if>><a href="/login_s">用户审核</a></li>
			           <li><a href="#">权限管理</a></li>
		             </ul>	  
		      </div>
		      </#if>
			  
			  <div class="nav1">
			    <div class="nav1_t">预约管理</div>
			         <ul>
			           <li <#if pageFlag??><#if pageFlag == 'myAudit'>class="leftnav1"</#if></#if>><a href="/myAudit?userName=super_admin">预约审核</a></li>
		             </ul>	  
		      </div>
		      
		      <#if user.userName == 'super_admin'>
		      	<div class="nav1">
			    <div class="nav1_t">仪器管理</div>
			         <ul>
			           <li <#if menuflag??><#if menuflag == 'equipModify'>class="leftnav1"</#if></#if>><a href="/equipMana">仪器修改</a></li>
			           <li><a href="/myAudit?userName=super_admin">仪器添加</a></li>
		             </ul>	  
		      </div>
		      </#if>
		   </div>
		   
	  </div>

		
      <div class="rightpart">
	        <div class="rightpart_top1">

<form name="searchMyFormBook" id="searchMyFormBook" action="/myAuditChange" method="POST">
				<input type="hidden" name="currentPage"  id="currentPage" value="${searchDto.currentPage}"/>
				<input type="hidden" name="begin" id="begin" value="${searchDto.begin}"/>
				<input type="hidden" name="sum" id="sum" value="${searchDto.sum}"/>
				<input type="hidden" name="pageNum" id="pageNum" value="${searchDto.pageNum}"/>
				<input type="hidden" name="userName" id="userName" value="${user.userName}"/>
				<input type="hidden" name="name" id="name" value="${user.name}"/>
				<input type="hidden" name="id" id="id" value="${searchDto.id}"/>
				<div class="fl1">仪器名称：<input type="text" name="equipName" class="text1" value="${(searchDto.equipName)!''}" tabindex="1"></div>
				<div class="fl2"><a href="#" onClick="javascript:pageChangeMyBook(1);"><img src="/images/bt.jpg"  /></a></div>
</form>
				<div class="clear"></div>
			</div>
			
			<div class="rightpart_bt1">
			      <div class="fl2s">
			    <div><strong>预约说明：</strong></div>
				<div class="kx"><img  src="/images/sm1.png" />审核通过</div>
				<div class="zy"><img  src="/images/sm2.png" />预约驳回</div>
			    <div class="dsp"><img  src="/images/sm3.png" />待审核</div>
			  
				<div class="clear"></div>
				  <div class="table1">
				       <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="10%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">仪器名称</td>
    <td width="10%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">预约者</td>
    <td width="10%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">开始时间</td>
    <td width="10%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">结束时间</td>
    <td width="6%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">状态</td>
    <td width="6%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">操作</td>
  </tr>
<#if bookList??>
	<#if bookList?size &gt;0>
		<#list bookList as  equipBook>
  		<tr>
    		<td height="40" align="center" valign="middle">${equipBook.equipName}</td>
    		<td height="40" align="center" valign="middle">${equipBook.userName}</td>
    		<td height="40" align="center" valign="middle">${equipBook.beginTime}</td>
    		<td height="40" align="center" valign="middle">${equipBook.endTime}</td>
    		<td height="40" align="center" valign="middle" <#if equipBook.orderStatus=='tocheck'>class="dsp1"</#if><#if equipBook.orderStatus == 'checked'>class="kx1"</#if><#if equipBook.orderStatus == 'unchecked'>class="zy1"</#if>>
    			<#if equipBook.orderStatus == 'cancle'>已取消<#else>&nbsp;</#if>
    		</td>
    		<td height="40" align="center" valign="middle">
    				<#if equipBook.orderStatus=='tocheck'>
    					<a href="/detailOrder?orderId=${equipBook.id}" >查看</a>
    				</#if>
    				<#if equipBook.orderStatus=='checked'>
    					<a href="/detailOrder?orderId=${equipBook.id}" >查看</a>
    				</#if>
    				
    		</td>    		
  		</tr>
		</#list>
	</#if>
</#if>
</table>

			<div class="pagination">
				  <#if searchDto.pageNum &gt;1>
				  		<#if searchDto.currentPage == 1>
				  			<span class="page-cur">首页</span>
				  		<#else>
				  			<a href="#" onClick="javascript:pageChangeMyBook(1);" class="page-end"><span>首页</span></a>
				  		</#if>
				  </#if>
				  <#list 1..searchDto.pageNum as page>
				  		<#if searchDto.currentPage == page>
				  			<span class="page-cur">${page}</span>
				  		<#else>
				  			<a href="#" onClick="javascript:pageChangeMyBook(${page});">${page}</a>
				  		</#if>
				  </#list>
				  <#if searchDto.pageNum &gt;1>
				  		<#if searchDto.currentPage == searchDto.pageNum>
				  			<span class="page-cur">末页</span>
				  		<#else>
				  			<a href="#" onClick="javascript:pageChangeMyBook(${searchDto.pageNum});" class="page-end"><span>末页</span></a>
				  		</#if>
				  </#if>
              </div>
				  
				  
				  </div>
				  
			  </div>
			     
			
			
			</div>
			
	  
	  </div>

   </div>
</div>

</body>
</html>
