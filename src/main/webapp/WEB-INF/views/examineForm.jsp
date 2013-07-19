<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Examine Form</title>
</head>
<body>
<h1>Examine Form</h1>

<form:form commandName="examine">
    <table>
        <tr>
            <td>开始日期：</td>
            <td>
                <form:input path="startDate"/>
            </td>
        </tr>
        <tr>
            <td>结束日期：</td>
            <td>
                <form:input path="endDate"/>
            </td>
        </tr>
        <tr>
            <td>部门：</td>
            <td>
                <form:input path="department"/>
            </td>
        </tr>
        <tr>
            <td>人员：</td>
            <td>
                <form:input path="member"/>
            </td>
        </tr>
        <tr>
            <td>成绩：</td>
            <td>
                <form:input path="score"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="保存"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>