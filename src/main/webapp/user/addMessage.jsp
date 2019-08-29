<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/7
  Time: 9:30
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
    <a href="login.jsp">退出</a>
    <br><br>
    <a href="messageBord.jsp">留言板</a>
</div>
<h1>填写留言信息</h1>
<form action="${pageContext.request.contextPath}/user/addMessageRequest" method="post" onsubmit="return confirm('确认提交？')">
    <input hidden type="hidden" name="nowUsername" value="${sessionScope.userNow.username}"/>
    <table border="1" align="center">
        <tr>
            <td>留言标题：</td>
            <td><input type="text" name="messageTitle"></td>
        </tr>
        <tr>
            <td>留言内容：</td>
            <td><textarea name="messageContent"></textarea></td>
        </tr>
    </table>
    <br><br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>
