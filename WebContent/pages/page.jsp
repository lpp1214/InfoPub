<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>页面信息</title></head>
<body>
    <table border="0" width="100%" cellspacing="0">
        <tr>
        	<td width="20%">当前页<s2:property escape="false" value="#request.createpage.CurrentP"/></td>
            <td width="20%">总页数<s2:property escape="false" value="#request.createpage.AllP"/></td>
        </tr>
    </table>
</body>
</html>