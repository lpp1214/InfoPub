<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.TreeMap" %>
<%@ taglib prefix="s2" uri="/struts-tags" %>
<%
TreeMap<String,String> searchType=new TreeMap<String,String>();
searchType.put("like","模糊搜索");
searchType.put("all","全字匹配");
request.setAttribute("searchType",searchType);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>侧栏</title>
	</head>
	<body>
		<center>
			<table border="0" width="225" height="100%" cellspacing="0" cellpadding="0">
				<tr height="30"><td style="text-indent:5" valign="bottom"><font color="#004790"><b>■日历</b></font></td></tr>
				<tr height="1"><td></td></tr>
				<tr height="215">
					<td valign="top" background="images/leftD.jpg"><jsp:include page="/pages/calendar.jsp"/></td>
				</tr>
				<tr height="1"><td></td></tr>
				<tr height="30"><td style="text-indent:5" valign="bottom"><font color="#004790"><b>■信息快速搜索</b></font></td></tr>
				<tr height="1"><td></td></tr>
				<tr height="103">
					<td align="center" valign="top" background="images/leftS.jpg">
					<table border="0" width="99%" height="100%" cellspacing="0">
						<s2:form action="info_SearchShow.action" theme="simple">
						<tr height="10"><td colspan="3"></td></tr>
						<tr>
							<td align="right" width="70">关键字：</td>
							<td colspan="2" width="200"><s2:textfield name="searchInfo.sqlvalue" value="%{searchInfo.sqlvalue}" size="21"/></td>
						</tr>
						<tr>
							<td align="right">条&nbsp;&nbsp;件：</td>
							<td>
								<s2:select
								emptyOption="true"
								list="#session.searchMap"
								listKey="value"
								listValue="key" 
								name="searchInfo.subsql"/>
							</td>
						<td align="center" width="30"><s2:submit value="搜索"/></td>
						</tr>
					<tr>
					<td align="right">搜索类型：</td>
					<td colspan="2">
						<s2:radio 
						list="#request.searchType"
						value="%{'like'}"
						name="searchInfo.type"/>
						</td>
					</tr>
					<tr height="10"><td colspan="3"></td></tr>
					</s2:form>
					</table>
				</td>
			</tr>
			<tr><td></td></tr>
			</table>
		</center>
	</body>
</html>