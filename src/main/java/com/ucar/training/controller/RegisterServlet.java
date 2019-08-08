package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.service.MyServiceImp;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String realName=request.getParameter("realName");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String password=request.getParameter("password");
        String tel=request.getParameter("tel");
        String email=request.getParameter("email");
        String privilege=request.getParameter("privilege");
        User user=new User();

        user.setUsername(username);
        user.setRealName(realName);
        user.setAge(age);
        user.setSex(sex);
        user.setPassword(password);
        user.setTel(tel);
        user.setEmail(email);
        user.setPrivilege(privilege);

        //将用户信息加入集合，模拟数据库
        MyServiceImp myServiceImp=new MyServiceImp();
        myServiceImp.register(user);

        getServletContext().setAttribute("users",myServiceImp.getUsers());
        getServletContext().setAttribute("usernames",myServiceImp.getUsernameSet());
        //在register.jsp中提示注册成功
        response.getWriter().print("<script language='javascript'>alert('注册成功！');window.location='user/register.jsp';</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        MyServiceImp myServiceImp=new MyServiceImp();
        if (myServiceImp.inUsers(username)){
            //用户名已经存在
            response.getWriter().print(1);
        }
        else {
            //用户名可以用
            response.getWriter().print(0);
        }
    }
}
