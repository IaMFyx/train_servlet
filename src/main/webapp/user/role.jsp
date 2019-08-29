<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/20
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
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
            margin-left: -700px;
            margin-top: -300px;

        }
    </style>
</head>
<body>
<div class="menu">
    <c:forEach items="${sessionScope.userMenu}" var="each">
        <a href="${each.url}">${each.menuName}</a><br><br>
    </c:forEach>
    <a href="chooseMenuRequest">增加角色</a><br><br>
    <a href="login.jsp">退出</a>
</div>
<h2 align="center">角色信息</h2>
<table class="roleTable" border="1" align="center">
    <tr>
        <th>角色ID</th>
        <th>角色名</th>
        <th>权限</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.roles}" var="each">
        <tr>
            <td>${each.rid}</td>
            <td>${each.roleName}</td>
            <td>
                <c:forEach items="${each.menusList}" var="eachMenu">
                    ${eachMenu.menuName}&ensp;&ensp;
                </c:forEach>
            </td>
            <td><a href="modifyRoleRequest?roleID=${each.rid}">修改</a>
                <a href="delRoleRequest?roleID=${each.rid}" onclick="return confirm('是否删除？')">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
