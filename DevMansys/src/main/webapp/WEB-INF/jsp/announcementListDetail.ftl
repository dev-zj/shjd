<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上海交通大学化学化工学院实验室</title>
<link href="/css/global.css" rel="stylesheet" type="text/css" />
</head>
<body >
<div class="container">
   <div class="container_con1">
      <div class="downcon">
	       <ul>
	       <#if (result?size>0)>
	         	<#list result?sort_by("created_date")?reverse as announcement>
	         		<li><a href="/announcementDetail?announceId=${announcement.id}">${announcement.announce_title}<span>${announcement.created_date}</span></a> </li>		
	         	</#list>
	         </#if>
	       </ul>
		   <#--<div class="pagination">
	          <span class="page-start"></span>
			  <span class="page-cur">1</span>
			  <a href="#">2</a>
			  <a href="#">3</a>
			  <a href="#">4</a>
			  <a href="#">5</a>
			  <a href="#" class="page-next"><span>下一页</span></a>
			  <a href="#" class="page-end"><span>末页</span></a>
           </div>--#>
  
       </div>
	 
  
   </div>
</div>

</body>
</html>
