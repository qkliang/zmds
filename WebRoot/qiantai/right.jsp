<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false" %> 
<%
  String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
      <div id="sidebar_container" style="margin-top: 13px;">
          <div class="sidebar">
	          <h4 style="margin-top: 10px;">
	             <jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"></jsp:include>
	          </h4>
          </div>
          <div class="sidebar">
	          <s:action name="orgSuoyou" executeResult="true" flush="true" namespace="/"></s:action> 
          </div>
          
          <div class="sidebar">
	          <h4 style="margin-top: 10px;">
	             <jsp:include flush="true" page="/qiantai/rili/rili.jsp"></jsp:include>
	          </h4>
          </div>
	  </div>
  </body>
</html>
