<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/9/3
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品管理</title>
    <link rel="stylesheet" href="../css/normalize.css">

    <link rel="stylesheet" href="../css/style.css" media="screen" type="text/css" />

    <script src="../js/modernizr.js"></script>

    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>

        $(document).ready(function () {

            $('.button1').click(function () {
                var username=$('.username').html();
                var goodID=$(this).parent().siblings('.goodID').html();
                $.ajax({
                    async:false,
                    type:"POST",
                    url:"addToCartGoodsRequest",
                    data:{"goodID":goodID,
                    "username":username},
                    success:function (data) {
                        if (data.result=='SUCCESS'){
                            alert("修改成功")
                        } else {
                            alert("修改失败，原因："+data);
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<nav id="site-nav" class="site-nav" role='navigation'>
    <button href="#" id="site-nav--toggle"  class="site-nav--toggle"><i class="entypo-menu"></i>Menu</button></button>
    <ul class="site-nav--list">
        <c:forEach items="${sessionScope.userMenu}" var="each">
            <li><a href="${each.url}"><i class="entypo-lifebuoy"></i>${each.menuName}</a></li>
        </c:forEach>
        <li><a href="cartGoodsInfoRequest?username=${sessionScope.userNow.username}"><i class="entypo-doc-text"></i>购物车</a></li>
        <li><a href="login.jsp"><i class="entypo-logout"></i>退出</a></li>
    </ul>
</nav>
<div class="wrapper">
    <header class="site-header">
        <h1>Generico | <span class="site-header--current">Dashboard</span></h1>
        <aside class="account"><span class="username">${sessionScope.userNow.username}</span><i class="entypo-user"></i></aside>
    </header>
    <section class="workspace">
        <form action="searchGoodsRequest" method="get">
            <input type="text" name="keyName" placeholder="请输入关键词" />
            <input type="submit" value="搜索"/>
        </form>
        <h2>商品信息</h2>
        <table border="1">
            <tr>
                <th>商品ID</th>
                <th>商品名</th>
                <th>商品描述</th>
                <th>商品价格</th>
                <th>商品库存</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.goods}" var="each">
                <tr>
                    <td class="goodID">${each.id}</td>
                    <td>${each.goodName}</td>
                    <td>${each.goodDesc}</td>
                    <td>${each.goodPrice}</td>
                    <td>${each.goodInventory}</td>
                    <td>
                        <button class="button1" style="color: gray;">加入购入车</button>
                    </td>
<%--                    <td><a href="${pageContext.request.contextPath}/user/modifyGoodRequest?goodID=${each.id}">修改</a>--%>
<%--                        <a href="${pageContext.request.contextPath}/user/delGoodRequest?goodID=${each.id}" onclick="return confirm('是否删除？')">删除</a>--%>
<%--                    </td>--%>
                </tr>
            </c:forEach>
        </table>
    </section>
</div>

<script src='../js/jquery.js'></script>

<script src="../js/index.js"></script>

</body>
</html>
