<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/8/6
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>下载文件</title>
    <style>
        body{
            background-image: url("bg4.jpg");
            background-size: cover;
            text-align: center;
            margin: auto;
        }
    </style>
</head>
<body>
<h2>文件列表</h2>
<table border="1" align="center">
    <tr>
        <th>文件名</th>
        <th>操作</th>
    </tr>
<c:forEach items="${requestScope.fileNames}" var="fileName">
    <tr>
        <th>${fileName}</th>
        <th><a href="DownloadServlet?name=${fileName}" rel="nofollow">下载</a></th>
    </tr>
</c:forEach>
</table>
</body>
</html>
