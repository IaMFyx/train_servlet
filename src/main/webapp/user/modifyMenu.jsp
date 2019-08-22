<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/20
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改菜单</title>
</head>
<body>
    <form action="UpdateMenuServlet" method="post" onsubmit="return confirm('确认提交')">
        ID:<input type="text" name="mid" value="${requestScope.modifyMenu.mid}" readonly><br/><br/>
        菜单名:<input type="text" name="menuName" value="${requestScope.modifyMenu.menuName}"><br/><br/>
        URL:<input type="text" name="url" value="${requestScope.modifyMenu.url}"><br/><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
