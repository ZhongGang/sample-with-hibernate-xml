<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13-6-14
  Time: 下午10:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<form action="search" method="get">
    <input type="text" name="keyword"/><input type="submit" value="全文搜索"/>
</form>

<p>
    <a href="/shop/form">添加商铺</a>
</p>

<h1>${size}</h1>
</body>
</html>