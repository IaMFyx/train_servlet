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
    <link rel="stylesheet" href="../css/normalize.css">

    <link rel="stylesheet" href="../css/style.css" media="screen" type="text/css" />

    <script src="../js/modernizr.js"></script>

</head>
<body>
<nav id="site-nav" class="site-nav" role='navigation'>
    <button href="#" id="site-nav--toggle"  class="site-nav--toggle"><i class="entypo-menu"></i>Menu</button></button>
    <ul class="site-nav--list">
        <c:forEach items="${sessionScope.userMenu}" var="each">
            <li><a href="${each.url}"><i class="entypo-lifebuoy"></i>${each.menuName}</a></li>
        </c:forEach>
        <li><a href="chooseMenuRequest"><i class="entypo-chart-bar"></i>增加角色</a></li>
        <li><a href="login.jsp"><i class="entypo-logout"></i>退出</a></li>

    </ul>
</nav>
<div class="wrapper">
    <header class="site-header">
        <h1>Generico | <span class="site-header--current">Dashboard</span></h1>
        <aside class="account">${sessionScope.userNow.username}<i class="entypo-user"></i></aside>
    </header>
    <section class="workspace">

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
    </section>
</div>

<script src='../js/jquery.js'></script>

<script src="../js/index.js"></script>

</body>
</html>
