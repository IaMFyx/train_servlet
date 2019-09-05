<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/9/4
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单管理</title>
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
        <li><a href="goodsInfoRequest"><i class="entypo-gauge"></i>商品列表</a></li>
        <li><a href="cartGoodsInfoRequest"><i class="entypo-doc-text"></i>购物车</a></li>
        <li><a href="login.jsp"><i class="entypo-logout"></i>退出</a></li>
    </ul>
</nav>
<div class="wrapper">
    <header class="site-header">
        <h1>Generico | <span class="site-header--current">Dashboard</span></h1>
        <aside class="account">${sessionScope.userNow.username}<i class="entypo-user"></i></aside>
    </header>
    <section class="workspace">
        <h2>订单信息</h2>
        <table border="1">
            <tr align="center">
                <th>商品id</th>
                <th>商品名</th>
                <th>商品描述</th>
                <th>商品价格</th>
                <th>购买数量</th>
                <th>小计</th>
            </tr>
            <c:forEach items="${requestScope.cartGoods}" var="each">
                <tr align="center">
                    <td>${each.goodID}</td>
                    <td>${each.good.goodName}</td>
                    <td>${each.good.goodDesc}</td>
                    <td>${each.good.goodPrice}</td>
                    <td>${each.goodNum}</td>
                    <td>${each.goodNum*each.good.goodPrice}</td>
                </tr>
            </c:forEach>
            <tr align="center">
                <td>
                    总价：<span class="total_price">${requestScope.totalPrice}</span>
                </td>
            </tr>
        </table>
    </section>
</div>

<script src='../js/jquery.js'></script>

<script src="../js/index.js"></script>

</body>
</html>
