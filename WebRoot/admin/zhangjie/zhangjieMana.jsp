<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		
        <script language="javascript">
           function zhangjieAdd()
           {
              var url="<%=path %>/admin/zhangjie/zhangjieAdd.jsp";
              window.location.href=url;
           }
           
           
           function zhangjieDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/zhangjieDel.action?id="+id;
               }
           }

           function zhangjieDetail(id)
           {
                 var url="<%=path %>/zhangjieDetail.action?zhangjieId="+id;
                 var n="";
                 var w="800px";
                 var h="400px";
                 var s="resizable:no;help:no;status:no;scroll:yes";
				 openWin(url,n,w,h,s);
           }
           
           
       </script>
	</head>

	<body leftmargin="12" topmargin="12" background='<%=path %>/img/allbg.gif'>
			<table width="60%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="14" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%">序号</td>
					<td width="20%">章节名称</td>
					<!-- <td width="10%">章节内容</td> -->
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.zhangjieList}" var="zhangjie" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${zhangjie.mingcheng}
					</td>
					<%-- <td bgcolor="#FFFFFF" align="center">
					    ${zhangjie.neirong}
					</td> --%>
					<td bgcolor="#FFFFFF" align="center">
					    <input type="button" value="删除" onclick="zhangjieDel(${zhangjie.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
