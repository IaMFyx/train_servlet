package com.ucar.training.Servlet;

import com.ucar.training.User;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        ServletContext servletContext=request.getServletContext();
        Set<User> users=(Set)servletContext.getAttribute("users");
        Set<String> usernameSet=(Set)request.getServletContext().getAttribute("usernames");

        for (User user:users){
            if (user.getUsername().equals(username)){
                users.remove(user);
                usernameSet.remove(username);
                break;
            }
        }
        servletContext.setAttribute("users",users);
        //response.sendRedirect("userInfo.jsp");
        response.getWriter().print("<script language='javascript'>alert('删除成功！');window.location='userInfo.jsp';</script>");
    }
}
