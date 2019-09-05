<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/9/3
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="../css/normalize.css">

    <link rel="stylesheet" href="../css/style.css" media="screen" type="text/css" />

    <script src="../js/modernizr.js"></script>

    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

    <script>

        $(document).ready(function () {
            accumTotalPrice();

            $('.up').click(function () {

               var n=$(this).prev().html();
               var num=parseInt(n)+1;
               var goodInventory=$(this).parent().siblings().children('.goodInventory').html();
               if (num>parseInt(goodInventory)){
                   alert("购买数量不能超过库存");
                   return;
               }
               $(this).prev().html(num);
               var goodID=$(this).parent().siblings().children('.goodID').html();
               //alert(goodID);
                useAjax(parseInt(goodID),num);

               var c=$(this).parent().siblings().children('.price').html();
               parseInt(c);
               var subPrice=num*c;
               var subPrice=subPrice.toFixed(2);
               $(this).parent().siblings().children('.part_price').html(subPrice);

               accumTotalPrice();
            });

            $('.down').click(function () {
                var n=$(this).next().html();
                var num=parseInt(n)-1;
                if (num==0){
                    alert("购买数量不能为0，无需购买请删除");
                    return;
                }
                $(this).next().html(num);
                var goodID=$(this).parent().siblings().children('.goodID').html();
                //alert(goodID);
                useAjax(parseInt(goodID),num);

                var c=$(this).parent().siblings().children('.price').html();
                parseInt(c);
                var subPrice=num*c;
                var subPrice=subPrice.toFixed(2);
                $(this).parent().siblings().children('.part_price').html(subPrice);

                accumTotalPrice();
            });

            function accumTotalPrice() {
                var total=0;
                $('.part_price').each(function () {
                    var price=parseFloat($(this).html());
                    total+=price;
                    var  total_price=total.toFixed(2);
                    $('.total_price').html(total_price);
                });
            }

            function useAjax(goodID,goodNum) {
                var username=$('.username').html();
                $.ajax({
                    async:false,
                    type:"POST",
                    url:"goodsAjaxJudgeRequest",
                    data:{"goodID":goodID,
                          "goodNum":goodNum,
                          "username":username},
                    success:function (data) {
                        if (data.result=='SUCCESS'){
                            alert("修改成功")
                        } else {
                            alert("修改失败，原因："+data);
                        }
                    }
                });
            }
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
        <li><a href="goodsInfoRequest"><i class="entypo-doc-text"></i>商品列表</a></li>
        <li><a href="login.jsp"><i class="entypo-logout"></i>退出</a></li>
    </ul>
</nav>

<div class="wrapper">
    <header class="site-header">
        <h1>Generico | <span class="site-header--current">Dashboard</span></h1>
        <aside class="account"><span class="username">${sessionScope.userNow.username}</span><i class="entypo-user"></i></aside>
    </header>
    <section class="workspace">
        <h2>购物车商品信息</h2>
        <table border="1">
            <tr align="center">
                <th>商品id</th>
                <th>商品名</th>
                <th>商品描述</th>
                <th>商品库存</th>
                <th>商品价格</th>
                <th>购买数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.cartGoods}" var="each">
                <tr align="center">
                    <td><span class="goodID">${each.goodID}</span></td>
                    <td>${each.good.goodName}</td>
                    <td>${each.good.goodDesc}</td>
                    <td><span class="goodInventory">${each.good.goodInventory}</span></td>
                    <td><span class="price">${each.good.goodPrice}</span></td>
                    <td>
                        <button class="down">-</button>
                        <span class="goodNum">${each.goodNum}</span>
                        <button class="up">+</button>
                    </td>
                    <td><span class="part_price">${each.goodNum*each.good.goodPrice}</span></td>
                    <td>
                    <a href="${pageContext.request.contextPath}/user/delCartGoodsRequest?goodID=${each.goodID}&username=${sessionScope.userNow.username}" onclick="return confirm('是否删除？')">
                        <button style="color: gray;">删除</button></a>
                    </td>
                </tr>
            </c:forEach>
            <tr align="center">
                <td>
                    总价：<span class="total_price"></span>
                </td>
            </tr>
        </table>
        <br/>
        <a href="delAllCartGoodsRequest?username=${sessionScope.userNow.username}"><button style="color: red;">清空购物车</button></a>
        <a href="buyAllCartGoodsRequest?username=${sessionScope.userNow.username}"><button style="color: #1f08ff;">结算</button></a>
    </section>
</div>
<script src='../js/jquery.js'></script>

<script src="../js/index.js"></script>
</body>
</html>
