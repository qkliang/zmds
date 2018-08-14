<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<script type="text/javascript">

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
	          <div>
					 <div style="width:754px;margin-top: 1px;padding-bottom:5px;">
					      <!-- <div style="height:26px;background:url(/cwyxt/images/guangguang.PNG);font-size: 14px;color:#de3237;">
					         <span style="float:left;font-family: 微软雅黑;font-size: 14px;margin-top: 3px;margin-left: 10px;">宠物信息</span>
							 <span style="float:right;font-family: 微软雅黑;font-size: 14px;margin-top: 3px;">&nbsp;</span>
					      </div> -->
					      <div style="border:1px solid #CCCCCC">
								   <TABLE class=main border=0 cellSpacing=9 cellPadding=9 height=115>
						              <TR>
						                  <c:forEach items="${requestScope.bookList}" var="book" varStatus="sta">
						                    <c:if test="${sta.index%4==0}">
						                       </tr><tr>
						                    </c:if>
							                <TD>
							                  <TABLE onmouseover="this.style.backgroundColor='#FF6600'" onmouseout="this.style.backgroundColor=''" border=0 cellSpacing=1 cellPadding=2 bgColor=#e1e1e1>
							                    <TR>
							                      <TD bgColor=#ffffff  align="center">
							                           <center>
							                              <A href="<%=path %>/bookDetailQian.action?id=${book.id}">
							                              <IMG border=0 src="<%=path %>/${book.tupian}" width=172 height=200></A>
							                           </center>
							                           <center>
							                              <A href="<%=path %>/bookDetailQian.action?id=${book.id}">
							                              <FONT color=#ff0000><c:out value="${fn:substring(book.mingcheng, 0, 12)}" escapeXml="false"></c:out>..</FONT></A><br>
							                                                             点击率：${book.dianji}
							                              <BR>
							                           <center>
							                      </TD>
							                    </TR>
							                  </TABLE>
							                </TD>
						                </c:forEach>
						              </TR>
					                 </TABLE>
							       <br/>
					      </div>
					 </div>
	          </div>
	      </div>
      </div>
      
      
      
      
      
      <footer>
          <a href="<%=path %>/login.jsp">系统后台</a>
      </footer>
  </div>
</body>
</html>
