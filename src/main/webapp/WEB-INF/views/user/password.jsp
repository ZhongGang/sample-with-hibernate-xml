<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13-7-26
  Time: 下午2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Step 2: Password</title>
</head>
<body>
<h1>Step 2: Password</h1>
<table border="1px solid blue" style="margin-bottom: 10px">
    <c:forEach items="${shops}" var="shop">
        <tr>
            <td>${shop.name}</td>
            <td>${shop.description}</td>
        </tr>
    </c:forEach>
</table>
<input type="text" name="password"/>
<a href="${flowExecutionUrl}&_eventId=previous">上一步</a>
<a href="${flowExecutionUrl}&_eventId=next">下一步</a>
<a href="${flowExecutionUrl}&_eventId=cancel">取消</a>
</body>
</html>