package com.ucar.training.Servlet;

import com.ucar.training.User;

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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=(String)request.getParameter("username");
        String realName=(String)request.getParameter("realName");
        String age=(String)request.getParameter("age");
        String tel=(String)request.getParameter("tel");
        String email=(String)request.getParameter("email");
        ServletContext servletContext=request.getServletContext();
        Set<User> users=(Set)servletContext.getAttribute("users");

        for (User user:users){
            if (user.getUsername().equals(username)){
                user.setEmail(email);
                user.setTel(tel);
                user.setRealName(realName);
                user.setAge(age);
                break;
            }
        }
        servletContext.setAttribute("users",users);
        response.sendRedirect("message.jsp");
        //response.getWriter().print("<script language='javascript'>alert('修改成功！');window.location='message.jsp';</script>");
    }
}
