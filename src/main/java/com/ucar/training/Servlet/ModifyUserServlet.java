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

@WebServlet("/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=(String)request.getParameter("username");
        ServletContext servletContext=request.getServletContext();
        Set<User> users=(Set)servletContext.getAttribute("users");
        for (User user:users){
            if (user.getUsername().equals(username)){
                request.setAttribute("modifiedUser",user);
                break;
            }
        }
    servletContext.getRequestDispatcher("/modifyUser.jsp").forward(request,response);
    }
}
