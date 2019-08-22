<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/21
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改角色</title>
    <style>
        body{
            background-image: url("../image/bg1.jpg");
            background-size: cover;
            margin: auto;
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
            width: 270px;
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
<form action="UpdateRoleServlet" method="post" onsubmit="return confirm('确认提交')">
    角色名：<input type="text" name="roleName" value="${requestScope.modifyRole.roleName}"/><br/><br/>
    角色ID：<input type="text" name="roleID" value="${requestScope.modifyRole.rid}" readonly/><br/><br/>
    选择权限：<br/><br/>
    <c:forEach items="${sessionScope.menus}" var="each">
        ${each.menuName}<input type="checkbox" name="menu" value="${each.mid}" ${requestScope.roleMenuName.contains(each.menuName) eq true ? 'checked':''}/><br/><br/>
    </c:forEach>
    <input type="submit" value="提交">
</form>
</div>
</body>
</html>
