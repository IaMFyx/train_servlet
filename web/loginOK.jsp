<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %><%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/7/29
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! Set<String> users=new HashSet<String>();%>
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
    <%
        request.setCharacterEncoding("utf-8");
        out.print("用户信息如下<br/>");

        String username=request.getParameter("username");
        out.print("用户名："+username+"<br/>");

        String realName=request.getParameter("realName");
        out.print("姓名："+realName+"<br/>");

        String userSex=request.getParameter("sex").equals("male")?"男":"女";
        out.print("性别："+userSex+"<br/>");

        String userAge=request.getParameter("age");
        out.print("年龄："+userAge+"<br/>");

        String password=request.getParameter("password");
        out.print("密码："+password+"<br/>");

        String tel=request.getParameter("tel");
        out.print("电话："+tel+"<br/>");

        String email=request.getParameter("email");
        out.print("邮箱："+email+"<br/>");

        out.print("爱好：");
        String[] hobbies=request.getParameterValues("hobbies");
        for (int i=0;i<hobbies.length;i++){
            out.print(hobbies[i]+" ");
        }
        String sign=request.getParameter("sign");
        out.print("<br/>个人签名："+password+"<br/>");
        users.add(username);
        session.setAttribute("users",users);
//        out.print("当前已经注册的用户：");
//        if (!users.isEmpty()){
//            for (String each:users){
//                out.print(each+"<br/>");
//            }
//        }
    %>
<h3>当前已经注册的用户：${users}</h3>
</body>
</html>
