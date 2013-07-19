<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Examines Overview</title>
</head>
<body>
<h1>Examines Overview</h1>
<a href="/examine/form">添加考核信息</a>
<table>
    <c:forEach items="${examines}" var="examine">
        <tr>
            <td>${examine.department}</td>
            <td>${examine.member}</td>
            <td>${examine.score}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>