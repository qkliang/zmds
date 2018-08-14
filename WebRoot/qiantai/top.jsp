<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
   String path = request.getContextPath();
%>

<!DOCTYPE html>
<head>
     <link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" />
     <script type="text/javascript" src="<%=path %>/js/modernizr-1.5.min.js"></script>
</head>
  
<body>
  <!-- <header style="background: #444 url(/zhiyuan/images/logo.jpg) repeat-x;"> -->
  <header style="background: #444 url()  repeat-x;height: 150px;">
      <div id="logo" style="height: 10px;">
        <div id="logo_text" style="width: 600px;">
          <h1 style="margin-top: 48px;margin-left: 100px;color: white;font-size: 26px;">基于Java的周末读书郎系统</h1>
        </div>
      </div>
      <div id="menu_container" style="margin-top: 85px;">
          <ul class="sf-menu" id="nav" style="margin-top: 0px;">
	          <li><a href="<%=path %>/qiantai/default.jsp" style="font-family: 微软雅黑;font-size: 16px;">系统首页</a></li>
	          <li><a href="<%=path %>/bookDianjilv.action" style="font-family: 微软雅黑;font-size: 16px;">阅读排行榜</a></li>
	          <li><a href="<%=path %>/xinwenAll.action" style="font-family: 微软雅黑;font-size: 16px;">新闻资讯</a></li>
	          <li><a href="<%=path %>/qiantai/userreg/userreg.jsp" style="font-family: 微软雅黑;font-size: 16px;">用户注册</a></li>
	          <li><a href="<%=path %>/qiantai/book/bookSea.jsp" style="font-family: 微软雅黑;font-size: 16px;">图书查询</a></li>
	          <%-- <li><a href="<%=path %>/gonggaoAll.action" style="font-family: 微软雅黑;font-size: 16px;">111</a></li>
	          <li><a href="<%=path %>/gonggaoAll.action" style="font-family: 微软雅黑;font-size: 16px;">111</a></li>
	          <li><a href="<%=path %>/gonggaoAll.action" style="font-family: 微软雅黑;font-size: 16px;">111</a></li> --%>
	          <%-- <li><a href="<%=path %>/qiantai/userreg/userreg.jsp" style="font-family: 微软雅黑;font-size: 16px;">1111</a></li>
	              <ul>
	                <li><a href="#">222</a></li>
	                <li><a href="#">333</a></li>
	              </ul>
		      </li> --%>
	      </ul>
      </div>
</header>
</body>
</html>
