package com.ucar.training.Servlet;

import com.ucar.training.User;

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
//        response.setContentType("text/html;charset=utf-8");
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
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
                            request.getSession().setAttribute("userNow",username);
                            response.getWriter().print(0);
                            //response.sendRedirect("message.jsp");
                        }
                        else {
                            out.print(1);//密码不正确
                        }
                        break;
                    }
                }
            }
            else {
                out.print(2);//用户名不存在
            }
        }
        else {
            out.print(2);//用户名不存在
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
