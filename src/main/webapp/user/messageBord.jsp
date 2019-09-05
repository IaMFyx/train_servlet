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
        <li><a href="addMessage.jsp"><i class="entypo-chart-bar"></i>添加留言</a></li>
        <li><a href="login.jsp"><i class="entypo-logout"></i>退出</a></li>

    </ul>
</nav>
<div class="wrapper">
    <header class="site-header">
        <h1>Generico | <span class="site-header--current">Dashboard</span></h1>
        <aside class="account">${sessionScope.userNow.username} <i class="entypo-user"></i></aside>
    </header>
    <section class="workspace">
        <h2>留言板</h2>
        <table border="1" align="center">
            <tr>
                <th>用户</th>
                <th>留言时间</th>
                <th>留言标题</th>
                <th>留言内容</th>
            </tr>
            <c:forEach items="${requestScope.userMessages}" var="userMessage">
                <tr>
                    <td>${userMessage.username}</td>
                    <td>${userMessage.messageTime}</td>
                    <td>${userMessage.messageTitle}</td>
                    <td>${userMessage.messageContent}</td>
                    <c:if test="${sessionScope.userNow.role==1}">
                        <td><a href="${pageContext.request.contextPath}/user/delMessageRequest?messageID=${userMessage.messageID}" onclick="return confirm('是否删除？')">删除</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
        <br>
    </section>
</div>

<script src='../js/jquery.js'></script>

<script src="../js/index.js"></script>

</body>
</html>
