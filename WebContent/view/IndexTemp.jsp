<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>
<%
	//项目根目录
	String path = request.getContextPath();
	//协议+服务器名+服务器端口+路径
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String mainPage=(String)request.getAttribute("mainPage");
	if(mainPage==null||mainPage.equals(""))
		mainPage="default.jsp";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>都市信息网</title>
		<base href="<%=basePath%>">
		<link type="text/css" rel="stylesheet" href="css/style.css">
	</head>
	<body background="images/back.gif">
		<center>
			<table border="0" width="920" cellspacing="0" cellpadding="0" bgcolor="white">
				<!-- 引入页眉 -->
				<tr><td colspan="2"><jsp:include page="top.jsp"/></td></tr>
				<tr>
					<!-- include指令引入侧栏 -->
					<td width="230" valign="top" align="center"><jsp:include page="left.jsp"/></td>
					<!-- include指令引入首页 -->
					<td width="690" height="400" align="center" valign="top" bgcolor="#FFFFFF"><jsp:include page="<%=mainPage%>"/></td>
				</tr>
			</table>        
		</center>
	</body>
</html>