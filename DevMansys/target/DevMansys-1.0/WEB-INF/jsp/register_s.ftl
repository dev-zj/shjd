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
   <div class="container_con3">
   <form  name="registerform" id="registerform" method="post" action="/doregister">
       <div class="fa1"><span class="labels"><b class="ftx04">*</b>姓名：</span>
	       <div class="fa_n">
	       		<input type="text" name="name" id="name" class="text1" value="${equipUserInfo.name}" tabindex="1">
	       </div>
		   <div class="fa_n1">
		     
		       <p>
		         <label>
		           <input type="radio" name="thisSchool"  value="yes" />
		           本校</label>
		         <label>
		           <input type="radio" name="thisSchool" value="no" />
		            非本校</label>
	           </p>
	         
	       </div>
		   
	   </div>
	   
	   
       <div class="fa1"><span class="labels"><b class="ftx04">*</b>性别：</span>
	       <p>
		         <label>
		           <input type="radio" name="sex"  value="male" />
		           男</label>
		         <label>
		           <input type="radio" name="sex" value="female" />
		            女</label>
	           </p>

	   </div>
	   
	   
       <div class="fa1"><span class="labels"><b class="ftx04">*</b>登录名：</span>
	       <div class="fa_n">
	       		<input type="text" name="userName" id="userName" class="text1" value="${equipUserInfo.userName}" tabindex="1">
	       </div>
	   </div>
	   
       <div class="fa1"><span class="labels"><b class="ftx04">*</b>密码：</span>
	       <div class="fa_n">
	       		<input type="password" name="password" id="password" class="text1" value="${equipUserInfo.userName}" tabindex="1">
	       </div>
	   </div>
       <div class="fa1"><span class="labels"><b class="ftx04">*</b>重复密码：</span>
	       <div class="fa_n">
	       		<input type="password" name="password1" id="password1" class="text1" value="${equipUserInfo.userName}" tabindex="1">
	       </div>
	   </div>
	   
       <div class="fa1"><span class="labels"><b class="ftx04"></b>一卡通卡号：</span>
	       <div class="fa_n">
	       		<input type="text" name="cardNo" id="cardNo" class="text1" value="${equipUserInfo.cardNo}" tabindex="1">
	       </div>
	   </div>
	   
       <div class="fa1"><span class="labels"><b class="ftx04">*</b>学校/单位名称：</span>
	       <div class="fa_n">
	       		<input type="text" name="group" id="group" class="text1" value="${equipUserInfo.group}" tabindex="1">
	       </div>
	   </div>
	   
       <div class="fa1"><span class="labels"><b class="ftx04">*</b>所属院系/部门：</span>
	       <div class="fa_n">
	       		<input type="text" name="series" id="series" class="text1" value="${equipUserInfo.series}" tabindex="1">
	       </div>
	   </div>	   	   	   

       <div class="fa1"><span class="labels"><b class="ftx04">*</b>联系电话：</span>
	       <div class="fa_n"><input type="text" name="telNo" id="telNo" class="text1" value="${equipUserInfo.telNo}" tabindex="1"></div>
	   </div>	   
	   
       <div class="fa1"><span class="labels"><b class="ftx04">*</b>联系地址：</span>
	       <div class="fa_n"><input type="text" name="address" id="address" class="text1" value="${equipUserInfo.address}" tabindex="1"></div>
	   </div>	   
	   
       <div class="fa1"><span class="labels"><b class="ftx04">*</b>联系邮箱：</span>
	       <div class="fa_n"><input type="text" name="email" id="email" class="text1" value="${equipUserInfo.email}" tabindex="1"></div>
	   </div>	   
	   
	   <div class="fa1">
	       <div class="fa_b"><a href="#" onClick="javascript:doregister();"><img src="../images/qd1.png"></a>
	       								<a href="javascript:logout();"><img src="../images/bt2.png"></a>
	       	</div>
	   </div>
   </form>       
   </div>
</div>

</body>
</html>
