<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>都市信息网-后台管理</title>
  <base href="<%=basePath%>">
  <link type="text/css" rel="stylesheet" href="<s2:url value='css/style.css'/>">
</head>
<body>
    <center>
        <table border="0" width="920" cellspacing="0" bgcolor="white">
            <tr><td colspan="2"><%@ include file="top.jsp"%></td></tr>
            <tr height="10" bgcolor="lightgrey"><td colspan="2"></td></tr>
            <tr>
                <td width="700" align="center" valign="top"><jsp:include page="main.jsp"/></td>
                <td width="200" align="center" valign="top"><jsp:include page="right.jsp"/></td>
            </tr>
            <tr height="7" bgcolor="lightgrey"><td colspan="2"></td></tr>
        </table>        
    </center>
</body>
</html>