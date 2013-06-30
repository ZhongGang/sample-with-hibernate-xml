<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shops Overview</title>
</head>
<body>
<h1>Shops Overview</h1>
<a href="/shop/form">添加商铺</a>
<table>
    <c:forEach items="${shops}" var="shop">
        <tr>
            <td>${shop.name}</td>
            <td>${shop.description}</td>
            <td><a href="javascript:void(0)">添加产品</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>