<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %><%--
  Created by IntelliJ IDEA.
  User: 86751
  Date: 2019/7/29
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    class User{
        String username;
        String realName;
        String userSex;
        String userAge;
        String password;
        String tel;
        String email;
        public User(String username, String realName, String userSex, String userAge, String password, String tel, String email){
            this.username=username;
            this.realName=realName;
            this.userSex=userSex;
            this.userAge=userAge;
            this.password=password;
            this.tel=tel;
            this.email=email;
        }
    }
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
        request.setCharacterEncoding("utf-8");
        //out.print("用户信息如下<br/>");

        String username=request.getParameter("username");
        //out.print("用户名："+username+"<br/>");

        String realName=request.getParameter("realName");
        //out.print("姓名："+realName+"<br/>");

        String userSex=request.getParameter("sex").equals("male")?"男":"女";
        //out.print("性别："+userSex+"<br/>");

        String userAge=request.getParameter("age");
        //out.print("年龄："+userAge+"<br/>");

        String password=request.getParameter("password");
        //out.print("密码："+password+"<br/>");

        String tel=request.getParameter("tel");
        //out.print("电话："+tel+"<br/>");

        String email=request.getParameter("email");
        //out.print("邮箱："+email+"<br/>");

//        //out.print("爱好：");
//        String[] hobbies=request.getParameterValues("hobbies");
//        for (int i=0;i<hobbies.length;i++){
//            out.print(hobbies[i]+" ");
//        }
//        String sign=request.getParameter("sign");
//        out.print("<br/>个人签名："+password+"<br/>");

        User user=new User(username, realName, userSex, userAge, password, tel, email);
        users.add(user);
        //session.setAttribute("users",users);
        out.print("<tr align=\"center\"><th>用户名</th><th>姓名</th><th>性别</th><th>年龄</th><th>密码</th><th>电话</th><th>邮箱</th><th/>");
        if (!users.isEmpty()){
            for (User each:users){
                out.print("<tr align=\"center\"><td>"+each.username+"</td><td>"+each.realName+"</td><td>"+each.userSex+"</td><td>"+each.userAge+"</td><td>"+each.password+"</td><td>"+each.tel+"</td><td>"+each.email+"</td><tr/>");
            }
        }
    %>
<%--    <tr align="center"><th>用户名</th><th>姓名</th><th>性别</th><th>年龄</th><th>密码</th><th>电话</th><th>邮箱</th><th/>--%>
<%--    <c:forEach var="user" items="${users}">--%>
<%--        <tr align="center"><td>${user.username}</td><td>${user.realName}</td><td>${user.userSex}</td><td>${user.userAge}</td><td>${user.password}</td><td>${user.tel}</td><td>${user.email}</td><tr/>--%>
<%--    </c:forEach>--%>
</table>
</body>
</html>
