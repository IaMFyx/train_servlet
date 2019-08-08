<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/7
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板</title>
    <style>
        body{
            text-align: center;
            margin: auto;
        }
    </style>
</head>
<body>
<h1>填写留言信息</h1>
<form action="AddMessageServlet" method="post" onsubmit="return confirm('确认提交？')">
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
<a href="messageBord.jsp">返回留言板</a>
</body>
</html>
