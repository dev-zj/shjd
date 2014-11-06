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
    });
	$(document).ready(function(){
		//alert('test');
		top.document.getElementById('ename').innerText	 = ''+'${equipment.equipName}';
		top.document.getElementById('introduce').innerText	 = '仪器介绍：'+'${equipment.equipIntroduce}';
		top.document.getElementById('property').innerText	 = '规格说明：'+'${equipment.equipStandardIntroduce}';
		//alert(top.document.getElementById('ename').innerText);
	});
    </script>
	

</head>
<body >
<div class="container">
   <div class="container_con2">
            <div class="leftpart1">
	       <div class="lp_titile1">
		       <div class="h_name14">用户：<span>${user.name}</span></div>
		       <div class="h_name">小组：<span>${user.teamName}</span></div>
		       <div class="h_name">类型：<span>普通用户</span></div>
			   
			   <div class="login_out"><a href="#" onClick="javascript:logout();"><img src="../images/back.png"> 退出</a></div>
		   </div>
		   
		   <div class="lp_nav">
		     <div class="nav1">
			    <div class="nav1_t">预约操作</div>
			         <ul>
		               <li <#if pageFlag??><#if pageFlag=='bookchange'>class="leftnav1"</#if></#if>><a href="/login_u?user=${user.userName}">仪器查询</a></li>
			           <li <#if pageFlag??><#if pageFlag=='mybook'>class="leftnav1"</#if></#if>><a href="/myBook?userName=${user.userName}"   target="user_content">我的预约</a></li>
		             </ul>	  
		      </div>
			  
			  <div class="nav1">
			    <div class="nav1_t">信息管理</div>
			         <ul>
		               <li><a href="#">权限审核</a></li>
			           <li><a href="#">权限分配</a></li>
		             </ul>	  
		      </div>
		      
		   </div>
		   
	  </div>

		
      <div class="rightpart">
	        <div class="rightpart_top1">

<form name="bookForm" id="bookForm" action="/bookItem" method="POST">
			<input type="hidden" name="equipName"  id="equipName" value="${equipment.equipName}"/>
			<input type="hidden" name="equipId" id="equipId" value="${equipment.id}"/>
			<input type="hidden" name="userId" id="userId" value="${user.id}"/>
			<input type="hidden" name="userName" id="userName" value="${user.userName}"/>
			<input type="hidden" name="auditUser" id="auditUser" value="${equipment.equipOwnerId}"/>
		
		      <div class="fl1s">仪器名称：${equipment.equipName}</div>
			  <div class="fl1s">仪器型号：${equipment.equipModel}</div>
			  <div class="fl1s"><a href="#" onclick="ShowDiv('MyDiv','fade')">详情</a></div>
	          <div class="fl2s">预约开始时间：
					<input type="text" name="beginTime" id="beginTime" class="ui_timepicker" value="${searchDto.planBeginTime}"/>
			  </div>
			  <div class="fl2s">预约结束时间：
					<input type="text" name="endTime" id="endTime" class="ui_timepicker" value="${searchDto.planEndTIme}"/>
			  </div>
	          <div class="fl3s"><a href="#" onClick="javascript:bookItem();"><img src="../images/bt1.png"></a></div>
	          <div class="fl3s"><#if genResu??><#if genResu == true>预约成功，请等待审批！</#if><#if genResu == false>预约失败！</#if></#if></div>
							
	</form>  
				<div class="clear"></div>
			</div>
			
			<div class="rightpart_bt1">
			      <div class="fl2s">
			    <div><strong>预约说明：</strong></div>
				<div class="zy"><img  src="../images/sm2.png" />占用</div>
			    <div class="dsp"><img  src="../images/sm3.png" />待审批</div>
			  
				<div class="clear"></div>
				  <div class="table1">
				       <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="10%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">开始时间</td>
    <td width="10%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">结束时间</td>
    <td width="6%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">状态</td>
  </tr>
<#if bookList??>
	<#if bookList?size &gt;0>
		<#list bookList as  equipBook>
  		<tr>
    		<td height="40" align="center" valign="middle">${equipBook.beginTime}</td>
    		<td height="40" align="center" valign="middle">${equipBook.endTime}</td>
    		<td height="40" align="center" valign="middle" <#if equipBook.orderStatus=='tocheck'>class="dsp1"</#if><#if equipBook.orderStatus == 'checked'>class="zy1"</#if>>&nbsp;</td>
  		</tr>
		</#list>
	</#if>
</#if>
</table>
<form name="searchFormBook" id="searchFormBook" action="/bookChange" method="POST">
				<input type="hidden" name="currentPage"  id="currentPage" value="${searchDto.currentPage}"/>
				<input type="hidden" name="begin" id="begin" value="${searchDto.begin}"/>
				<input type="hidden" name="sum" id="sum" value="${searchDto.sum}"/>
				<input type="hidden" name="pageNum" id="pageNum" value="${searchDto.pageNum}"/>
				<input type="hidden" name="userName" id="userName" value="${user.userName}"/>
				<input type="hidden" name="equipId" id="equipId" value="${equipment.id}"/>
				<input type="hidden" name="planBeginTime" id="planBeginTime" value="${searchDto.planBeginTime}"/>
				<input type="hidden" name="planEndTime" id="planEndTime" value="${searchDto.planEndTime}"/>

</form>
			<div class="pagination">
				  <#if searchDto.pageNum &gt;1>
				  		<#if searchDto.currentPage == 1>
				  			<span class="page-cur">首页</span>
				  		<#else>
				  			<a href="#" onClick="javascript:pageChangeBook(1);" class="page-end"><span>首页</span></a>
				  		</#if>
				  </#if>
				  <#list 1..searchDto.pageNum as page>
				  		<#if searchDto.currentPage == page>
				  			<span class="page-cur">${page}</span>
				  		<#else>
				  			<a href="#" onClick="javascript:pageChangeBook(${page});">${page}</a>
				  		</#if>
				  </#list>
				  <#if searchDto.pageNum &gt;1>
				  		<#if searchDto.currentPage == searchDto.pageNum>
				  			<span class="page-cur">末页</span>
				  		<#else>
				  			<a href="#" onClick="javascript:pageChangeBook(${searchDto.pageNum});" class="page-end"><span>末页</span></a>
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
