<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<script type="text/javascript">
	       function pinglunAdd(bookId)
           {
                <c:if test="${sessionScope.userType!=1}">
	                  alert("请先登录");
	                  return false;
	            </c:if>
	            
                var url="<%=path %>/qiantai/pinglun/pinglunAdd.jsp?bookId="+bookId;
                var ret = window.showModalDialog(url,"","dialogWidth:800px; dialogHeight:400px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
                window.location.reload();
           }
           
           function shoucangAdd(bookId)
           {
                <c:if test="${sessionScope.userType!=1}">
	                  alert("请先登录");
	            </c:if>
	            <c:if test="${sessionScope.userType==1}">
	                  var url="<%=path %>/shoucangAdd.action?bookId="+bookId;
	                  window.location.href=url; 
	            </c:if>
           }
           
           function down1(fujianPath,fujianYuashiMing)
           {
                <c:if test="${sessionScope.userType!=1}">
	                  alert("请先登录");
	                  return false;
	            </c:if>
               var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
		       url=encodeURI(url); 
               url=encodeURI(url); 
               window.open(url,"_self");
           }
	</script>
	
	<style type="text/css">
		.c1-bline{border-bottom:#999 1px dashed;border-top:1px;}
		.f-right{float:right}
		.f-left{float:left}
		.clear{clear:both}
	</style>
  </head>
   
  <body>
  <div id="main">
      <jsp:include flush="true" page="/qiantai/top.jsp"></jsp:include>
      
      
      
      
      <div id="site_content">
	      <jsp:include flush="true" page="/qiantai/right.jsp"></jsp:include>
	      <div class="content">
	          <!-- <h1 style="font-size: 22px;">新闻喜讯</h1>
	          <p>
		           This simple, fixed width website template is released under a Creative Commons Attribution 3.0 Licence
		           This means you are free to download and use it for personal and commercial proj
	          </p>
	          <p>1111</p>
	          <p>2222</p> -->
	          <!-- <h1 style="font-size: 22px;">
	                                        会员注册
	          </h1> -->
	          <div style="border:1px solid  #CCCCCC;width: 745px;margin-left: 10px">
		             <p>图书名称：${requestScope.book.mingcheng }</p>
                     <p><img src="<%=path %>/${requestScope.book.tupian }" alt="" width="300" height="350"/></p>
                     <p>作者：${requestScope.book.zuozhe }</p>
                     <p>出版社：${requestScope.book.chubanshe }</p>
                     
			         <p>图书介绍：<c:out value="${requestScope.book.jieshao }" escapeXml="false"></c:out></p>
			         <p>点击量：<c:out value="${requestScope.book.dianji }" escapeXml="false"></c:out></p>
			         <p>
			                          附件：<c:out value="${requestScope.book.fujian }" escapeXml="false"></c:out>&nbsp;&nbsp;
			             <a href="#" onclick="down1('${book.fujian}','${book.fujian}')" style="color: red">下载</a>
			         </p>
			         <p>发布时间：${requestScope.book.fabushi }</p>
			         
	                 <p>
	                     <fieldset style="width:700px; margin-left:20px;"><legend class="fieldtitle">章节</legend>
							<table class="bill" width="100%">
							<c:forEach items="${requestScope.zhangjieList}" var="zhangjie" varStatus="ss">
							<tr><td><a href="<%=path %>/zhangjieDetailQian.action?id=${zhangjie.id }" style="color: green">${zhangjie.mingcheng }</a></td></tr>
							</c:forEach>
							</table>
					     </fieldset>
	                 </p>
	                 <p>
						<fieldset style="width:700px; margin-left:20px;"><legend class="fieldtitle">评论</legend>
							<c:forEach items="${requestScope.pinglunList}" var="pinglun" varStatus="s">
											    <div class="c1-bline" style="padding:7px 0px;">
											        <div class="f-left" style="margin-left: 10px;">
												        <img src="<%=path %>/img/head-mark4.gif" align="middle" class="img-vm" border="0"/>${pinglun.neirong}
											        </div>
											        <div class="f-right" style="margin-right: 10px;">${pinglun.shijian}</div><div class="clear"></div>
												</div>
										   </c:forEach>
										   <br/>
					     </fieldset>
	                 </p>
	                 
	                 <p>
	                     <input type="button" value="评论" onclick="pinglunAdd(${requestScope.book.id })" style="width: 100px;margin-left: 21px;"/>
	                     <input type="button" value="加入书架" onclick="shoucangAdd(${requestScope.book.id })" style="width: 80px;"/>			
	                 </p>
	          </div>
	      </div>
      </div>
      
      
      
      
      
      <footer>
          <a href="<%=path %>/login.jsp">系统后台</a>
      </footer>
  </div>
</body>
</html>
