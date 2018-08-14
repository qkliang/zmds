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
        <script language="javascript">
           function bookDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/bookDel.action?id="+id;
               }
           }
           
           function bookAdd()
           {
                 var url="<%=path %>/admin/book/bookAdd.jsp";
				 window.location.href=url;
           }
           
           
           function zhangjieAdd(bookId)
           {
                   var url="<%=path %>/admin/zhangjie/zhangjieAdd.jsp?bookId="+bookId;
                   window.location.href=url;
           }
           
           function zhangjieMana(bookId)
           {
                   var url="<%=path %>/zhangjieMana.action?bookId="+bookId;
                   window.location.href=url;
           }
           
           function over(picPath)
	       {
			  if (picPath=="")picPath="/img/zanwu.jpg";
			  x = event.clientX;
			  y = event.clientY;      
			  document.all.tip.style.display = "block";
			  document.all.tip.style.top = y;
			  document.all.tip.style.left = x+10;
			  document.all.photo.src = ".."+picPath; 
		   }
		   function out()
	       {
			  document.all.tip.style.display = "none";
		   }	
		   
		   
		   function pinglunMana(bookId)
           {
                   var url="<%=path %>/pinglunMana.action?bookId="+bookId;
                   window.location.href=url;
           }
           
           function down1(fujianPath,fujianYuashiMing)
           {
               var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
		       url=encodeURI(url); 
               url=encodeURI(url); 
               window.open(url,"_self");
           }	
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="11" background="<%=path %>/images/tbg.gif">&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td width="4%">序号</td>
				    <td width="10%">类别</td>
					<td width="10%">名称</td>
					<td width="10%">作者</td>
					
					<td width="10%">出版社</td>
					<!-- <td width="10%">介绍</td> -->
					<td width="10%">封面</td>
					<td width="10%">附件</td>
					
					<td width="10%">发布时间</td>
					<td width="4%">点击量</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.bookList}" var="book" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${book.org.mingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${book.mingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${book.zuozhe}
					</td>
					
					
					<td bgcolor="#FFFFFF" align="center">
						${book.chubanshe}
					</td>
					<%-- <td bgcolor="#FFFFFF" align="center">
						${book.jieshao}
					</td> --%>
					<td bgcolor="#FFFFFF" align="center">
					   <div onmouseover = "over('<%=path %>/${book.tupian}')" onmouseout = "out()" style="cursor:hand;">
							图片
					   </div>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					     ${book.fujian}&nbsp;
					     <a href="#" onclick="down1('${book.fujian}','${book.fujian}')" style="color: red">下载</a>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					     ${book.fabushi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					     ${book.dianji}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="bookDel(${book.id})"/>
						<input type="button" value="评论管理" onclick="pinglunMana(${book.id})"/>
						<input type="button" value="章节管理" onclick="zhangjieMana(${book.id})"/>
						<input type="button" value="添加章节" onclick="zhangjieAdd(${book.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 11px;">
			  <tr>
			    <td>
			        <input type="button" value="添加图书" style="width: 120px;" onclick="bookAdd()" />
			    </td>
			  </tr>
		    </table>
		    <div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
				<TABLE id="tipTable" border="0" bgcolor="#ffffee">
					<TR align="center">
						<TD><img id="photo" src="" height="123" width="99"></TD>
					</TR>
				</TABLE>
			</div>
	</body>
</html>
