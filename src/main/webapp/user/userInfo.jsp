<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/2
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息</title>
    <style>
        body{
            background-image: url("../image/bg2.jpg");
            background-size: cover;
            margin: auto;
            text-align: center;
        }
        .menu{
            padding: 13px;
            position: absolute;
            left: 50%;
            top: 50%;
            margin-left: -700px;
            margin-top: -300px;
        }
    </style>
</head>
<body>
<div class="menu">
    <c:forEach items="${sessionScope.userMenu}" var="each">
        <a href="${each.url}">${each.menuName}</a>
        <br><br>
    </c:forEach>
    <a href="login.jsp">退出</a>
</div>
<div class="table">
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
        <th>爱好</th>
        <th>个人签名</th>
    </tr>
    <c:if test="${sessionScope.userNow.role==1}">
    <c:forEach items="${requestScope.users}" var="user">
        <c:if test="${user.role==2}">
        <tr align="center">
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.realName}</td>
            <td>${user.sex}</td>
            <td>${user.age}</td>
            <td>${user.tel}</td>
            <td>${user.email}</td>
            <td>${user.hobbies}</td>
            <td>${user.sign}</td>
            <td><a href="${pageContext.request.contextPath}/user/modifyUserRequest?username=${user.username}">修改</a>
                <a href="${pageContext.request.contextPath}/user/delUserRequest?username=${user.username}" onclick="return confirm('是否删除？')">删除</a></td>
        </tr>
        </c:if>
    </c:forEach>
    </c:if>
    <c:if test="${sessionScope.userNow.role==2}">
        <tr align="center">
            <td>${sessionScope.userNow.username}</td>
            <td>${sessionScope.userNow.password}</td>
            <td>${sessionScope.userNow.realName}</td>
            <td>${sessionScope.userNow.sex}</td>
            <td>${sessionScope.userNow.age}</td>
            <td>${sessionScope.userNow.tel}</td>
            <td>${sessionScope.userNow.email}</td>
            <td>${sessionScope.userNow.hobbies}</td>
            <td>${sessionScope.userNow.sign}</td>
        </tr>
    </c:if>
</table>
</div>
</body>
</html>
