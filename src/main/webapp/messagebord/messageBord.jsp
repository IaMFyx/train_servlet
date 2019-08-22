<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/7
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>留言板</title>
    <style>
        body{
            background-image: url("../image/bg4.jpg");
            background-size: cover;
            margin: auto;
            text-align: center;
        }
        .menu{
            padding: 13px;
            position: absolute;
            left: 50%;
            top: 50%;
            margin-left: -500px;
            margin-top: -300px;
        }
    </style>
</head>
<body>
<div class="menu">
    <a href="addMessage.jsp">添加留言</a>
    <br><br>
    <a href="../user/userInfo.jsp">个人信息</a>
    <br><br>
    <a href="../user/login.jsp">退出</a>
</div>
<h2>留言板</h2>
<table border="1" align="center">
    <tr>
        <th>用户</th>
        <th>留言时间</th>
        <th>留言标题</th>
        <th>留言内容</th>
    </tr>
    <c:forEach items="${sessionScope.userMessages}" var="userMessage">
        <tr>
            <td>${userMessage.username}</td>
            <td>${userMessage.messageTime}</td>
            <td>${userMessage.messageTitle}</td>
            <td>${userMessage.messageContent}</td>
            <c:if test="${sessionScope.userNow.role==1}">
                <td><a href="DelMsgServlet?messageID=${userMessage.messageID}" onclick="return confirm('是否删除？')">删除</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<br>
</body>
</html>
