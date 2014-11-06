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
			           <li <#if menuflag??><#if menuflag == 'equipAdd'>class="leftnav1"</#if></#if>><a href="/equipAddDetail">仪器添加</a></li>
		             </ul>	  
		      </div>
		      
		   </div>
		   
	  </div>



      <div class="rightpart">
	        <div class="rightpart_top1s">
	        			<form name="equipModifyForm" id="equipModifyForm" action="/equipModifyProcess" method="POST">
	        			<input type="hidden" name="id" id="id" value="${equipment.id}"/>
					    <div class="fl2s">
					    	<span class="label1s"><b class="ftx04">*</b>仪器名称：</span><input type="text" name="equipName" class="text1" value="${equipment.equipName}" tabindex="1">
					    </div>
					   <div class="fl2s"><span class="label1s"><b class="ftx04">*</b>仪器分类：</span>
					   		<select name="cateId" class="text2">
																<#list categoryList as equipmentCategory>
																	<option value="${equipmentCategory.id}" <#if equipment.cateId == equipmentCategory.id>selected</#if>>${equipmentCategory.cateName}</option>
				  												</#list>
															</select>
						</div>
						<div class="fl2s">
							<span class="label1s"><b class="ftx04">*</b>仪器型号：</span><input type="text" name="equipModel" class="text1" value="${equipment.equipModel}" tabindex="1">
						</div>
						<div class="fl2s">
							<span class="label1s"><b class="ftx04">*</b>制造厂商：</span><input type="text" name="equipMerchant" class="text1" value="${equipment.equipMerchant}" tabindex="1">
						</div>
						<div class="fl2s">
							<span class="label1s"><b class="ftx04">*</b>仪器价格：</span><input type="text" name="equipValue" class="text1" value="${equipment.equipValue}" tabindex="1">
						</div>
						<div class="fl2s2">
            				<span class="label1s">规格：</span><textarea name="equipStandard_txt" id="equipStandard_txt"  cols="" rows="" class="text1s">${equipment.equipStandard}</textarea>
            				<input type="hidden" name="equipStandard" id="equipStandard" value="${equipment.equipStandard}"/>
            				<div class="clear"></div>
            			</div>
						<div class="fl2s">
							<span class="label1s"><b class="ftx04">*</b>使用年限：</span><input type="text" name="equipAge" class="text1" value="${equipment.equipAge}" tabindex="1">
						</div>
						<div class="fl2s2">
            				<span class="label1s">使用介绍：</span><textarea name="equipIntroduce_txt" id="equipIntroduce_txt"  cols="" rows="" class="text1s">${equipment.equipIntroduce}</textarea>
            				<input type="hidden" name="equipIntroduce" id="equipIntroduce" value="${equipment.equipIntroduce}"/>
            				<div class="clear"></div>
            			</div>
						<div class="fl2s2">
            				<span class="label1s">规格说明：</span><textarea name="equipStandardIntroduce_txt" id="equipStandardIntroduce_txt"  cols="" rows="" class="text1s">${equipment.equipStandardIntroduce}</textarea>
            				<input type="hidden" name="equipStandardIntroduce" id="equipStandardIntroduce" value="${equipment.equipStandardIntroduce}"/>
            				<div class="clear"></div>
            			</div>
						<div class="fl2s2">
            				<span class="label1s">操作流程：</span><textarea name="equipOprProcess_txt" id="equipOprProcess_txt"  cols="" rows="" class="text1s">${equipment.equipOprProcess}</textarea>
            				<input type="hidden" name="equipOprProcess" id="equipOprProcess" value="${equipment.equipOprProcess}"/>
            				<div class="clear"></div>
            			</div>
						<!--<div class="fl2s">
							<span class="label1s">图片地址：</span><input type="text" name="loginname" class="text1sa" value="" tabindex="1">
                  			<input type="submit" name="button" id="button" class="schuan" value="上传" />
            			</div>
			            <div class="fl2s1">
			            	<span class="label1s"><b class="ftx04">*</b>使用介绍：</span>
			                  <input type="submit" name="button" id="button" class="schuan" value="上传" />
			            </div>
			            <div class="fl2s1">
			            	<span class="label1s"><b class="ftx04">*</b>规格说明：</span>
			                  <input type="submit" name="button" id="button" class="schuan" value="上传" />
			            </div>-->
			            
            <div class="fl2s"><span class="label1s">预约开关：</span>
            	<div class="fa_n1s">
		             <p>
		              <label>
		               <input type="radio" name="canBook"  <#if equipment.canBook=='yes'>checked</#if> value="yes">
		              	可预约</label>
		              <label>
		              <input type="radio" name="canBook"<#if equipment.canBook=='no'>checked</#if> value="no">
		              不可预约</label>
	                 </p>
	            </div>
	          </div>

	          <div class="fl2s"><span class="label1s">预约属性：</span>
	          	<div class="fa_n1s">
		             <p>
		              <label>
		               <input type="radio" name="equipBookProperty" <#if equipment.equipBookProperty == 'un-sch'>checked</#if> value="un-sch">
		               校外</label>
		              <label>
		              <input type="radio" name="equipBookProperty" <#if equipment.equipBookProperty == 'sch-dep'>checked</#if> value="sch-dep">
		              校内本院</label>
		              <input type="radio" name="equipBookProperty" <#if equipment.equipBookProperty == 'sch-undep'>checked</#if> value="sch-undep">
		              校内非本院</label>
	                 </p>
	            </div>
	          </div>
			    	<div class="fl2s2">
			    		<span class="label1s">&nbsp;</span><a href="javascript:equipmentManager();"><img src="../images/qd2.png"  /></a>
			    		<span class="label1s">&nbsp;</span><a href="/equipMana"><img src="../images/bt2.png" /></a>
			    		
			    		<div class="clear"></div>
			    	</div>

						<div class="clear"></div>
					</div>
					</form>	
		
			   

	  
	 		</div>
      <div class="clear"></div>
   </div>
</div>

</body>
</html>
