package com.ucar.training.controller;

import com.ucar.training.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=(String)request.getParameter("username");
        String realName=(String)request.getParameter("realName");
        String age=(String)request.getParameter("age");
        String tel=(String)request.getParameter("tel");
        String email=(String)request.getParameter("email");
        ServletContext servletContext=request.getServletContext();
        Set<User> users=(Set)servletContext.getAttribute("users");

        for (User user:users){
            if (user.getUsername().equals(username)){
                users.remove(user);
                user.setEmail(email);
                user.setTel(tel);
                user.setRealName(realName);
                user.setAge(age);
                users.add(user);
                break;
            }
        }

        servletContext.setAttribute("users",users);
        response.sendRedirect("/training_servlet/userInfo.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
