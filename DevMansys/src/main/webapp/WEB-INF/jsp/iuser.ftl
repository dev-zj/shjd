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
		       <div class="h_name14">用户：<span>${user.name}</span></div>
		       <div class="h_name">小组：<span>${user.teamName}</span></div>
		       <div class="h_name">类型：<span>普通用户</span></div>
			   
			   <div class="login_out"><a href="#" onClick="javascript:logout();"><img src="../images/back.png"> 退出</a></div>
		   </div>
		   
		   <div class="lp_nav">
		     <div class="nav1">
			    <div class="nav1_t">预约操作</div>
			         <ul>
		               <li class="leftnav1"><a href="/login_u?user=${user.userName}">仪器查询</a></li>
			           <li><a href="/myBook?userName=${user.userName}"   target="user_content">我的预约</a></li>
		             </ul>	  
		      </div>
			  	<#if user.isAdministrator == 'yes'>
			  		<div class="nav1">
			    		<div class="nav1_t">预约管理</div>
			         		<ul>
			           			<li><a href="/myAudit?userName=${user.userName}">预约审核</a></li>
		             		</ul>	  
		      		</div>
			  	</#if>			
		      
		   </div>
		   
	  </div>


      <div class="rightpart">
	        <div class="rightpart_top">
	        <form id="searchForm" action="/loginUserView" method="POST">
	        	<input type="hidden" id="h_userName" name="userName" value="${user.userName}"/>
			    <div class="fl1">仪器名称：<input type="text" name="equipName" class="text1" value="${(searchDto.equipName)!''}" tabindex="1"></div>
				<div class="fl1">仪器型号：<input type="text" name="equipModel" class="text1" value="${(searchDto.equipModel)!''}" tabindex="1"></div>
				<div class="fl1">制造厂商：<input type="text" name="equipMerchant" class="text1" value="${(searchDto.equipMearchant)!''}" tabindex="1"></div>
				<div class="fl1">仪器分类：<select name="cateId" class="text2">
				  													<option value="0">请选择分类</option>
																<#list categoryList as equipmentCategory>
																	<option value="${equipmentCategory.id}" <#if searchDto.cateId == equipmentCategory.id>selected</#if>>${equipmentCategory.cateName}</option>
				  												</#list>
															</select>
				</div>
				
				<div class="fl2"><a href="#" onClick="document.getElementById('searchForm').submit();"><img src="/images/bt.jpg"  /></a></div>

				
				<input type="hidden" name="currentPage"  id="currentPage" value="${searchDto.currentPage}"/>
				<input type="hidden" name="begin" id="begin" value="${searchDto.begin}"/>
				<input type="hidden" name="sum" id="sum" value="${searchDto.sum}"/>
				<input type="hidden" name="pageNum" id="pageNum" value="${searchDto.pageNum}"/>
				
			</form>
			</div>
			
			<div class="rightpart_bottom">
			<#if equipmentList??>
				<#if equipmentList?size &gt;0>
					<#list equipmentList as equipment>
						<div class="prolist">
				      		<div class="pro_p"><img src="/images/pro_pic.png"  /></div>
					  		<div class="pro_n">${equipment.equipName}</div>
					  		<div class="pro_l">${equipment.equipModel}</div>
					  		<div class="pro_order"><a href="/userBook?userName=${user.userName}&id=${equipment.id}"  target="user_content">预约</a></div>
			  			</div>		
					</#list>
				</#if>
			</#if>
			  
			  <div class="pagination">
				  <#if searchDto.pageNum &gt;1>
				  		<#if searchDto.currentPage == 1>
				  			<span class="page-cur">首页</span>
				  		<#else>
				  			<a href="#" onClick="javascript:pageChange(1);" class="page-end"><span>首页</span></a>
				  		</#if>
				  </#if>
				  <#list 1..searchDto.pageNum as page>
				  		<#if searchDto.currentPage == page>
				  			<span class="page-cur">${page}</span>
				  		<#else>
				  			<a href="#" onClick="javascript:pageChange(${page});">${page}</a>
				  		</#if>
				  </#list>
				  <#if searchDto.pageNum &gt;1>
				  		<#if searchDto.currentPage == searchDto.pageNum>
				  			<span class="page-cur">末页</span>
				  		<#else>
				  			<a href="#" onClick="javascript:pageChange(${searchDto.pageNum});" class="page-end"><span>末页</span></a>
				  		</#if>
				  </#if>
              </div>
			
			 <#--		
			  <div class="pagination">
	          <span class="page-start"></span>
			  <span class="page-cur">1</span>
			  <a href="#">2</a>
			  <a href="#">3</a>
			  <a href="#">4</a>
			  <a href="#">5</a>
			  <a href="#" class="page-next"><span>下一页</span></a>
			  <a href="#" class="page-end"><span>末页</span></a>
              </div>
			  --#>
			</div>
			
	  
	  </div>

   </div>
</div>

</body>
</html>
