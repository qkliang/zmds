<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991454/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<script type="text/javascript">
            function check()
		    {
		        if(document.formAdd.mingcheng.value=="")
		        {
		            alert("请填写图书名称");
		            return false;
		        }
		        document.formAdd.submit();
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
	          <!-- <h1 style="font-size: 45px;">新闻喜讯</h1>
	          <p>
		           This simple, fixed width website template is released under a Creative Commons Attribution 3.0 Licence
		           This means you are free to download and use it for personal and commercial proj
	          </p>
	          <p>1111</p>
	          <p>4545</p> -->
	          <!-- <h1 style="font-size: 45px;">
	                                        会员注册
	          </h1> -->
	          <div>
					 <div style="width:754px;margin-top: 1px;padding-bottom:5px;">
					      <!-- <div style="height:26px;background:url(/cwyxt/images/guangguang.PNG);font-size: 14px;color:#de3237;">
					         <span style="float:left;font-family: 微软雅黑;font-size: 14px;margin-top: 3px;margin-left: 10px;">宠物信息</span>
							 <span style="float:right;font-family: 微软雅黑;font-size: 14px;margin-top: 3px;">&nbsp;</span>
					      </div> -->
					      <div style="border:0px solid #CCCCCC">
								<form action="<%=path %>/bookRes.action" name="formAdd" method="post">
								     <table width="100%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
										<tr bgcolor="#EEF4EA">
									        <td colspan="3" background="<%=path %>/images/wbg.gif" class='title'><span>&nbsp;</span></td>
									    </tr>
										<tr align='center' bgcolor="#FFFFFF" height="45">
										    <td width="10%" bgcolor="#FFFFFF" align="right">
										         书名：
										    </td>
										    <td width="90%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="mingcheng" style="width: 333px;"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" height="45">
										    <td width="10%" bgcolor="#FFFFFF" align="right">
										         作者：
										    </td>
										    <td width="90%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="zuozhe" style="width: 333px;"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" height="45">
										    <td width="10%" bgcolor="#FFFFFF" align="right">
										         出版社：
										    </td>
										    <td width="90%" bgcolor="#FFFFFF" align="left">
										        <input type="text" name="chubanshe" style="width: 333px;"/>
										    </td>
										</tr>
										<tr align='center' bgcolor="#FFFFFF" height="45">
										    <td width="10%" bgcolor="#FFFFFF" align="right">&nbsp;
										    </td>
										    <td width="90%" bgcolor="#FFFFFF" align="left">
										       <input type="button" value="提交" onclick="check()"/>&nbsp; 
										       <input type="reset" value="重置"/>&nbsp;
										    </td>
										</tr>
									 </table>
							</form>
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
