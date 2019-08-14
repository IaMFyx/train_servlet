package com.ucar.training.controller;

import com.ucar.training.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=(String)request.getParameter("username");

        UserServiceImp myServiceImp=new UserServiceImp();

        request.setAttribute("modifiedUser",myServiceImp.findUser(username));
        getServletContext().getRequestDispatcher("/user/modifyUser.jsp").forward(request,response);
    }
}
