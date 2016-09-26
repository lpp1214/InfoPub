<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s2" uri="/struts-tags" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>后台-审核信息</title>
  <base href="<%=basePath%>">
  <script type="text/javascript" src="<s2:url value='js/DeleteCheck.js'/>"></script>
</head>
<body>
    <center>
        <br>
        <table border="0" width="645" cellpadding="10" cellspacing="0" style="word-break:break-all">            
            <tr height="30">
                <td style="text-indent:5"><b>审核信息 [ID值：<s2:property value="infoSingle.id"/>]</b></td>
                <td colspan="2" align="right"><s2:fielderror/></td>
            </tr>
            <tr height="30" bgcolor="#F9F9F9"><td colspan="3" align="center" style="text-indent:5">信息详细内容</td></tr>
            <tr height="30">
                <td width="25%" style="text-indent:10">信息类别：</td>
                <td>【<s2:property value="#session.typeMap[infoSingle.infoType]"/>】</td>
                <td>付费状态：&nbsp;&nbsp;<s2:if test="infoSingle.infoPayfor==1">★ 已付费</s2:if><s2:else>● 未付费</s2:else></td>
            </tr>
            <tr height="30">
                <td style="text-indent:10">发布时间：</td>
                <td><s2:property value="infoSingle.infoDate"/></td>
                <td>审核状态：&nbsp;&nbsp;<s2:if test="infoSingle.infoState==1">★ 已审核</s2:if><s2:else>● 未审核</s2:else></td>
            </tr>
            <tr height="30">
                <td style="text-indent:10">信息标题：</td>
                <td colspan="2"><s2:property value="infoSingle.infoTitle"/></td>
            </tr>
            <tr height="40" bgcolor="#F9F9F9">
                <td style="text-indent:10">信息内容：</td>
                <td align="center">
                	<s2:form action="admin_Check.action?" theme="simple">
                		<input type="hidden" name="checkID" value="<s2:property value="infoSingle.id"/>">
	                    <s2:if test="infoSingle.infoState==1"><s2:set name="forbid" value="true"/></s2:if>
	                    <s2:else><s2:set name="forbid" value="false"/></s2:else>
	                    <s2:submit value="√通过审核" disabled="%{forbid}"/>
	                </s2:form>
                </td>
                <td align="center">
               		 <s2:form action="admin_Delete.action?" theme="simple">
               		 	<input type="hidden" name="deleteID" value="<s2:property value="infoSingle.id"/>">
                		<s2:submit methos="Delete" value="×删除信息" onclick="return really()"/>
                	</s2:form>
                </td>
            </tr>
            <tr height="5"><td></td></tr>
            <tr>
                <td colspan="3" style="border:1 solid">
                    <table border="0" width="630" cellspacing="0" cellpadding="10" style="word-break:break-all">
                        <tr height="130"><td colspan="3" valign="top"><s2:property value="infoSingle.infoContent" escape="false"/></td></tr>
                        <tr height="30" align="center">
                            <td>联系电话：<s2:property value="infoSingle.infoPhone"/></td>
                            <td>联系人：<s2:property value="infoSingle.infoLinkman"/></td>
                            <td>E-mial：<s2:property value="infoSingle.infoEmail"/></td>
                        </tr>
                   </table>  
                </td>
            </tr>
            <tr><td align="center" colspan="3"><a href="javascript:window.history.back(-1)">返回</a></td></tr>
         </table>
    </center>
</body>
</html>