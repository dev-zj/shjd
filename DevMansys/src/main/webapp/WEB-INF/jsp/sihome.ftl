<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上海交通大学化学化工学院实验室</title>
<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script src="/js/default.js"></script>
</head>
<body >
<div class="container">
   <div class="container_con2">
      <div class="leftpart1">
	       <div class="lp_titile1">
		       <div class="h_name14">用户：<span>super_admin</span></div>
		       
		       <div class="h_name">类型：<span>超级管理员</span></div>
			   
			   <div class="login_out"><a href="#" onClick="javascript:logout();"><img src="../images/back.png"  /> 退出</a></div>
		   </div>
		   
		   <div class="lp_nav">
			  
			  <div class="nav1">
			    <div class="nav1_t">权限管理</div>
			         <ul>
		               <li <#if menuflag??><#if menuflag == 'usercheck'>class="leftnav1"</#if></#if>><a href="/login_s">用户审核</a></li>
		               	<li <#if menuflag??><#if menuflag == 'auditMana'>class="leftnav1"</#if></#if>><a href="/permiss_mana">权限管理</a></li>
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
			           <li <#if menuflag??><#if menuflag == 'equipAdd'>class="leftnav1"</#if></#if>><a href="/equipAddDetail">仪器添加</a></li>
		             </ul>	  
		      </div>
			  
		   </div>
		   
	  </div>


      <div class="rightpart">
	        <div class="rightpart_top">
	        	<form name="userInfoForm" id="userInfoForm" action="/login_s" method="POST">
			    <div class="fl1">用户姓名：<input type="text" name="name" id="name" class="text1" value="${searchDto.name}" tabindex="1"></div>
				<div class="fl1">联系电话：<input type="text" name="telNo" id="telNo" class="text1" value="${searchDto.telNo}" tabindex="1"></div>
				<div class="fl1">一卡通号：<input type="text" name="cardNo" id="cardNo" class="text1" value="${searchDto.cardNo}" tabindex="1"></div>
				<input type="hidden" name="currentPage"  id="currentPage" value="${searchDto.currentPage}"/>
				<input type="hidden" name="begin" id="begin" value="${searchDto.begin}"/>
				<input type="hidden" name="sum" id="sum" value="${searchDto.sum}"/>
				<input type="hidden" name="pageNum" id="pageNum" value="${searchDto.pageNum}"/>
				<input type="hidden" name="toCheckStatus" id="toCheckStatus" value="${searchDto.toCheckStatus}"/>
				<input type="hidden" name="id" id="id" value="${searchDto.id}"/>
				</form>
				<div class="fl2"><a href="#" onClick="javascript:document.getElementById('userInfoForm').submit();"><img src="../images/bt.jpg"  /></a></div>
				
			</div>
			
			<div class="rightpart_bottom">
			  
					<div class="fl2s">
						<div><strong>用户列表：</strong></div>
													  
						<div class="clear"></div>
						<div class="table1">
							       <table width="100%" border="0" cellspacing="0" cellpadding="0">
										  <tr>
										    <td width="5%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">姓名</td>
										    <td width="3%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">性别</td>
										    <td width="3%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">本校</td>
										    <td width="6%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">电话</td>
										    <td width="6%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">一卡通号</td>
										    <td width="6%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">邮箱</td>
										    <td width="6%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">状态</td>
										    <td width="6%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">申请日期</td>
										    <td width="6%" height="40" align="center" valign="middle" bgcolor="#f7f7f7">操作</td>
										  </tr>
										<#if equipUserInfoList??>
											<#if equipUserInfoList?size &gt;0>
												<#list equipUserInfoList as  userInfo>
										  		<tr>
										    		<td height="40" align="center" valign="middle">${userInfo.name}</td>
										    		<td height="40" align="center" valign="middle">
										    			<#if userInfo.sex == 'male'>男</#if>
										    			<#if userInfo.sex == 'female'>女</#if>
										    		</td>
										    		<td height="40" align="center" valign="middle">
										    			<#if userInfo.thisSchool == 'yes'>是</#if>
										    			<#if userInfo.thisSchool == 'no'>否</#if>
										    		</td>
										    		<td height="40" align="center" valign="middle">
														${userInfo.telNo}
										    		</td>    		
										    		<td height="40" align="center" valign="middle">
														${userInfo.cardNo}
										    		</td>    		
										    		<td height="40" align="center" valign="middle">
														${userInfo.email}
										    		</td>    		

										    		<td height="40" align="center" valign="middle">
														<#if userInfo.auditStatus == 'todo'>待审核</#if>
														<#if userInfo.auditStatus == 'doing'>审核通过待注册</#if>
														<#if userInfo.auditStatus == 'done'>注册完成</#if>
										    		</td>    		
										    		<td height="40" align="center" valign="middle">
														${userInfo.registerDate}
										    		</td>    		
										    		<td height="40" align="center" valign="middle">
														<#if userInfo.auditStatus == 'todo'><a href="/userinfoById?id=${userInfo.id}">审核</a></#if>
														<#if userInfo.auditStatus == 'doing'><a href="/userinfoById?id=${userInfo.id}">注册</a></#if>
														<#if userInfo.auditStatus == 'done'><a href="/userinfoById?id=${userInfo.id}">查看</a></#if>
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
										  			<a href="#" onClick="javascript:pageChageUserInfoAudit(1);" class="page-end"><span>首页</span></a>
										  		</#if>
										  </#if>
										  <#list 1..searchDto.pageNum as page>
										  		<#if searchDto.currentPage == page>
										  			<span class="page-cur">${page}</span>
										  		<#else>
										  			<a href="#" onClick="javascript:pageChageUserInfoAudit(${page});">${page}</a>
										  		</#if>
										  </#list>
										  <#if searchDto.pageNum &gt;1>
										  		<#if searchDto.currentPage == searchDto.pageNum>
										  			<span class="page-cur">末页</span>
										  		<#else>
										  			<a href="#" onClick="javascript:pageChageUserInfoAudit(${searchDto.pageNum});" class="page-end"><span>末页</span></a>
										  		</#if>
										  </#if>
              						</div>		 
			
						</div>
	  
	  </div>

   </div>
</div>

</body>
</html>
