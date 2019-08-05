package com.ucar.training.Servlet;

import com.ucar.training.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private Set<User> users=new HashSet<User>();
    private Set<String> usernameSet=new HashSet<String>();

    public RegisterServlet(){
        usernameSet.add("admin");
        User admin=new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        users.add(admin);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        User user=new User();
        String username=request.getParameter("username");
        String realName=request.getParameter("realName");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String password=request.getParameter("password");
        String tel=request.getParameter("tel");
        String email=request.getParameter("email");
        String[] hobbies=request.getParameterValues("hobbies");
        String sign=request.getParameter("sign");
//        out.print("用户名："+username+"<br/>"
//                +"姓名："+realName+"<br/>"
//                +"性别："+sex+"<br/>"
//                +"年龄："+age+"<br/>"
//                +"密码："+password+"<br/>"
//                +"电话："+tel+"<br/>"
//                +"邮箱："+email+"<br/>"
//                +"爱好：");
//        for (int i = 0; i <hobbies.length ; i++) {
//            out.print(hobbies[i]+"  ");
//        }
//        out.print("<br/>个人签名："+sign+"<br/>");
        user.setUsername(username);
        user.setRealName(realName);
        user.setAge(age);
        user.setSex(sex);
        user.setPassword(password);
        user.setTel(tel);
        user.setEmail(email);
        usernameSet.add(username);
        users.add(user);
        request.getServletContext().setAttribute("users",users);
        request.getServletContext().setAttribute("usernames",usernameSet);
//        if (!users.isEmpty()){
//            for (User user1:users) {
//                out.print(user1.getUsername()+"<br/>");
//            }
//        }
        response.sendRedirect("register.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        if (usernameSet.contains(username)){
            response.getWriter().print(1);//用户名已经存在
        }
        else {
            response.getWriter().print(0);//用户名可以用
        }
    }
}
