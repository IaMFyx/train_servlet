<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/7/29
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.ucar.training.User" %>
<%!
    Set<User> users=new HashSet<User>();
%>
<html>
<head>
    <title>成功注册！</title>
    <style>
        body{
            background-image: url("preview.jpg");
            background-size: cover;
        }
    </style>
</head>
<body>
<h2>用户信息表</h2>
<table width="100%" border="1" align="center">
    <%
        User user1=new User();
        request.setCharacterEncoding("utf-8");

        String username=request.getParameter("username");
        user1.setUsername(username);

        String realName=request.getParameter("realName");
        user1.setRealName(realName);

        String userSex=request.getParameter("sex").equals("male")?"男":"女";
        user1.setUserSex(userSex);

        String userAge=request.getParameter("age");
        user1.setUserAge(userAge);

        String password=request.getParameter("password");
        user1.setPassword(password);

        String tel=request.getParameter("tel");
        user1.setTel(tel);

        String email=request.getParameter("email");
        user1.setEmail(email);
        users.add(user1);
        session.setAttribute("users",users);

//        //out.print("爱好：");
//        String[] hobbies=request.getParameterValues("hobbies");
//        for (int i=0;i<hobbies.length;i++){
//            out.print(hobbies[i]+" ");
//        }
//        String sign=request.getParameter("sign");
//        out.print("<br/>个人签名："+password+"<br/>");


        //session.setAttribute("user",user);

//        out.print("<tr align=\"center\"><th>用户名</th><th>姓名</th><th>性别</th><th>年龄</th><th>密码</th><th>电话</th><th>邮箱</th><th/>");
//        if (!users.isEmpty()){
//            for (User each:users){
//                out.print("<tr align=\"center\"><td>"+each.username+"</td><td>"+each.realName+"</td><td>"+each.userSex+"</td><td>"+each.userAge+"</td><td>"+each.password+"</td><td>"+each.tel+"</td><td>"+each.email+"</td><tr/>");
//            }
//        }
    %>
    <tr align="center"><th>用户名</th><th>姓名</th><th>性别</th><th>年龄</th><th>密码</th><th>电话</th><th>邮箱</th></tr>
    <c:forEach var="user" items="${users}">
        <tr align="center">
            <td>${user.username}</td>
            <td>${user.realName}</td>
            <td>${user.userSex}</td>
            <td>${user.userAge}</td>
            <td>${user.password}</td>
            <td>${user.tel}</td>
            <td>${user.email}</td></tr>
    </c:forEach>
</table>
</body>
</html>
