<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/6
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <style>
        body{
            text-align: center;
        }
    </style>
</head>
<body>
<form method="post" action="UploadServlet" enctype="multipart/form-data" onsubmit="return confirm('确认上传？')">
    选择需要上传的文件:<br/><br/>
    <input type="file" name="uploadFile"/>
    <br/><br/>
    <input type="submit" value="上传"/>
</form>
<a href="../user/login.jsp">返回登录</a>
</body>
</html>
