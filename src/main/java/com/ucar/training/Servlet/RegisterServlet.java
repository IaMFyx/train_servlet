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
        admin.setPrivilege("admin");
        users.add(admin);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        User user=new User();
        String username=request.getParameter("username");
        String realName=request.getParameter("realName");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String password=request.getParameter("password");
        String tel=request.getParameter("tel");
        String email=request.getParameter("email");
        String privilege=request.getParameter("privilege");

        user.setUsername(username);
        user.setRealName(realName);
        user.setAge(age);
        user.setSex(sex);
        user.setPassword(password);
        user.setTel(tel);
        user.setEmail(email);
        user.setPrivilege(privilege);
        //将用户信息加入集合，模拟数据库
        usernameSet.add(username);
        users.add(user);
        request.getServletContext().setAttribute("users",users);
        request.getServletContext().setAttribute("usernames",usernameSet);
        //在register.jsp中提示注册成功
        response.getWriter().print("<script language='javascript'>alert('注册成功！');window.location='register.jsp';</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        if (usernameSet.contains(username)){
            //用户名已经存在
            response.getWriter().print(1);
        }
        else {
            //用户名可以用
            response.getWriter().print(0);
        }
    }
}
