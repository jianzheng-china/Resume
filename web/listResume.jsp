<%--
  Created by IntelliJ IDEA.
  User: jianz
  Date: 2021/1/5
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加简历</title>
    <script type="application/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/statics/ckeditor/ckeditor.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/statics/ckeditor/config.js"></script>
    <style>

    </style>
</head>

<body>
<div style="text-align: center">
    <table>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>期望岗位</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
        <c:forEach var="user" items="${requestScope.users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.job}</td>
                <td>${user.cellphone}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/servlet/UserServlet.do?action=query&id=${user.id}">查看</a>
                    <a href="${pageContext.request.contextPath}/servlet/UserServlet.do?action=modify&id=${user.id}">修改</a>
                    <a href="${pageContext.request.contextPath}/servlet/UserServlet.do?action=remove&id=${user.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>