package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.service.MyServiceImp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/user/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        ServletContext servletContext=getServletContext();
        MyServiceImp myServiceImp=new MyServiceImp();
        myServiceImp.delUser(username);
        servletContext.setAttribute("users",myServiceImp.getUsers());
        servletContext.setAttribute("usernameSet",myServiceImp.getUsernameSet());
        response.getWriter().print("<script language='javascript'>alert('删除成功！');window.location='userInfo.jsp';</script>");
    }
}
