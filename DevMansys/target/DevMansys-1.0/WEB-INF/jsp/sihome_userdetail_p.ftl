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
	        <div class="rightpart_top1s">
	        	<form name="userInfoForm" id="userInfoFormPermission" action="/process_permission" method="POST">
			    <div class="fl2s">
	       			<span class="label1s"><b class="ftx04">*</b>用户姓名：</span>
	       				<input type="text" name="name" class="text1" value="${userInfo.name}" tabindex="1" readOnly>
	   			</div>
			    <input type="hidden" name="sex" id="sex" class="text1" value="${userInfo.sex}" tabindex="1">
			    <div class="fl2s">
	       			<span class="label1s"><b class="ftx04">*</b>性别：</span>
	       				
	       				<#if userInfo.sex == 'male'><input type="text" name="sex1" class="text1" value="男" tabindex="1" readOnly></#if>
	       				<#if userInfo.sex == 'female'><input type="text" name="sex1" class="text1" value="女" tabindex="1" readOnly></#if>
	   			</div>
	   			<div class="fl2s">
	       			<span class="label1s"><b class="ftx04">*</b>是否本校：</span>
	       				<p>
				         <label>
				           <input type="radio" name="thisSchool" <#if userInfo.thisSchool == 'yes'>checked</#if>   value="yes" />
				           本校</label>
				         <label>
				           <input type="radio" name="thisSchool" <#if userInfo.thisSchool == 'no'>checked</#if>  value="no" />
				            非本校</label>
			           </p>
	   			</div>
	   			<div class="fl2s">
	       			<span class="label1s"><b class="ftx04">*</b>用户属性：</span>
	       				<p>
				         <label>
				           <input type="radio" name="userProperty" <#if userInfo.userProperty == 'long'>checked</#if>   value="long" />
				           长期用户</label>
				         <label>
				           <input type="radio" name="userProperty" <#if userInfo.userProperty == 'book'>checked</#if>  value="book" />
				            预约用户</label>
				         <label>
				           <input type="radio" name="userProperty" <#if userInfo.userProperty == 'staff'>checked</#if>  value="staff" />
				            内部员工</label>
			           </p>
	   			</div>
			    <div class="fl2s">
	       			<span class="label1s"><b class="ftx04">*</b>登录名：</span>
	       				<input type="text" name="userName" class="text1" value="${userInfo.userName}" tabindex="1" readOnly>
	   			</div>
			     <div class="fl2s">
	       			<span class="label1s"><b class="ftx04">*</b>一卡通号：</span>
	       				<input type="text" name="cardNo" class="text1" value="${userInfo.cardNo}" tabindex="1" readOnly>
	   			</div>
				<div class="fl2s">
	       			<span class="label1s"><b class="ftx04">*</b>学校/单位名称：</span>
	       				<input type="text" name="group1" class="text1" value="${userInfo.group}" tabindex="1" readOnly>
	   			</div>
				<div class="fl2s">
	       			<span class="label1s"><b class="ftx04">*</b>院系/部门：</span>
	       				<input type="text" name="series1" class="text1" value="${userInfo.series}" tabindex="1" readOnly>
	   			</div>
				<div class="fl2s">
	       			<span class="label1s"><b class="ftx04">*</b>联系电话：</span>
	       				<input type="text" name="telNo" class="text1" value="${userInfo.telNo}" tabindex="1" readOnly>
	   			</div>
				<div class="fl2s">
	       			<span class="label1s"><b class="ftx04">*</b>联系地址：</span>
	       				<input type="text" name="address" class="text1" value="${userInfo.address}" tabindex="1" readOnly>
	   			</div>
				<div class="fl2s">
	       			<span class="label1s"><b class="ftx04">*</b>联系地址：</span>
	       				<input type="text" name="email" class="text1" value="${userInfo.email}" tabindex="1" readOnly>
	       				<div class="clear"></div>
	   			</div>
				<div class="fl2s">
	       			<span class="label1s"><b class="ftx04">*</b>用户角色：</span>
	       				<p>
				         <label>
				           <input type="radio" name="adminProperty" <#if userInfo.adminProperty == 'normal'>checked</#if>   value="normal" />
				           管理员</label>
				         <label>
				           <input type="radio" name="adminProperty" <#if userInfo.adminProperty == 'user'>checked</#if>  value="user" />
				            普通用户</label>
			           </p>
	   			</div>
	   			<div class="fl2s"><span class="label1s"><b class="ftx04">*</b>仪器分类：</span>
					   		<select name="equipOwns" class="text2" style="width:200px;font-size:12px"  multiple="multiple" size="4">
																<#list categoryList as equipmentCategory>
																	<option value="${equipmentCategory.id}" <#if equipment.cateId == equipmentCategory.id>selected</#if>>${equipmentCategory.cateName}</option>
				  												</#list>
															</select>
				</div>
	   			
				<input type="hidden" name="id" id="id" value="${userInfo.id}"/>
				<div class="fl2s2">
						<span class="label1s">&nbsp;</span><a href="javascript:document.getElementById('userInfoFormPermission').submit();"><img src="../images/bt1.png"  /></a>
						<span class="label1s">&nbsp;</span><a href="/permiss_mana"><img src="../images/bt2.png"  /></a>
			    		<div class="clear"></div>
			    </div>
				</form>

			</div>
			<div class="clear"></div>
	</div>
</div>

</body>
</html>
