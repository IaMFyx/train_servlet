<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/2
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <style>
        body{
            background-image: url("../image/bg2.jpg");
            background-size: cover;
            text-align: center;
            margin: auto;
        }
    </style>
</head>
<body>
<h1>用户登录</h1>
    <form action="${pageContext.request.contextPath}/user/loginRequest" method="post">
        用户名：<input type="text" name="username" id="username" ><br/><br>
        密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password"><br><br>
        <font color="red" id="note"></font>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="登录">
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="重置">
    </form>
&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp">没有用户名？点击注册</a><br><br>
&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<a href="../file/upload.jsp">文件上传</a><br><br>
&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<a href="../file/download.jsp">文件下载</a>
</body>
</html>
