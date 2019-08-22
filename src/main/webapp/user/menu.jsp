<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/20
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
    <style>
        body{
            background-image: url("../image/bg2.jpg");
            background-size: cover;
        }
        .menu{
            padding: 13px;
            position: absolute;
            left: 50%;
            top: 50%;
            margin-left: -700px;
            margin-top: -300px;

        }
        .aaa{
            width: 400px;
            height: 400px;
            padding: 13px;
            position: absolute;
            left: 50%;
            top: 50%;

            margin-left: -160px;

            margin-top: -200px;
            background-color: rgba(240, 255, 255, 0.5);
            border-radius: 10px;
            text-align: center;

        }
    </style>
</head>
<body>
    <div class="menu">
        <c:forEach items="${sessionScope.userMenu}" var="each">
            <a href="${each.url}">${each.menuName}</a><br><br>
        </c:forEach>
        <a href="login.jsp">退出</a>
    </div>
    <div class="aaa">
    <h2>菜单信息</h2>
    <table class="menuTable" border="1">
        <tr>
            <th>菜单名</th>
            <th>url</th>
        </tr>
        <c:forEach items="${sessionScope.menus}" var="each">
            <tr>
                <td>${each.menuName}</td>
                <td>${each.url}</td>
                <td><a href="ModifyMenuServlet?menuID=${each.mid}">修改</a>
                    <a href="DelMenuServlet?menuID=${each.mid}" onclick="return confirm('是否删除？')">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </div>
</body>
</html>
