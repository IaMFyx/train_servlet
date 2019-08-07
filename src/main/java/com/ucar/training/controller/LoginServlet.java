package com.ucar.training.controller;

import com.ucar.training.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Set<User> users=(Set)request.getServletContext().getAttribute("users");
        Set<String> usernameSet=(Set)request.getServletContext().getAttribute("usernames");

        if (users!=null&&usernameSet!=null){
            if (usernameSet.contains(username)){
                for (User user:users){
                    if (user.getUsername().equals(username)){
                        if (user.getPassword().equals(password)) {
                            request.getSession().setAttribute("userNow",user);
                            response.getWriter().print(0);
                        }
                        else {
                            //密码不正确
                            out.print(1);
                        }
                        break;
                    }
                }
            }
            else {
                //用户名不存在
                out.print(2);
            }
        }
        else {
            //用户名不存在
            out.print(2);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
