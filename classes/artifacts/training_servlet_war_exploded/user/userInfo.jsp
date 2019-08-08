<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/2
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.ucar.training.entity.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息</title>
    <style>
        body{
            background-image: url("../image/bg4.jpg");
            background-size: cover;
            text-align: center;
            margin: auto;
        }
    </style>
</head>
<body>
<h2>${sessionScope.userNow.username},你好！</h2>
<h3>用户信息表</h3>
<table align="center" border="1">
    <tr align="center">
        <th>用户名</th>
        <th>密码</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>电话</th>
        <th>邮箱</th>
    </tr>
    <c:if test="${sessionScope.userNow.privilege==\"admin\"}">
    <c:forEach items="${users}" var="user">
        <c:if test="${user.privilege==\"user\"}">
        <tr align="center">
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.realName}</td>
            <td>${user.sex}</td>
            <td>${user.age}</td>
            <td>${user.tel}</td>
            <td>${user.email}</td>
            <td><a href="ModifyUserServlet?username=${user.username}">修改</a>
                <a href="DeleteUserServlet?username=${user.username}" onclick="return confirm('是否删除？')">删除</a></td>
        </tr>
        </c:if>
    </c:forEach>
        <a href="register.jsp">增加用户</a>
    </c:if>
    <c:if test="${sessionScope.userNow.privilege==\"user\"}">
        <tr align="center">
        </tr>
        <td>${sessionScope.userNow.username}</td>
        <td>${sessionScope.userNow.password}</td>
        <td>${sessionScope.userNow.realName}</td>
        <td>${sessionScope.userNow.sex}</td>
        <td>${sessionScope.userNow.age}</td>
        <td>${sessionScope.userNow.tel}</td>
        <td>${sessionScope.userNow.email}</td>
    </c:if>
</table>
<a href="../messagebord/messageBord.jsp">留言板</a>
<br>
<a href="login.jsp">退出</a>
</body>
</html>
