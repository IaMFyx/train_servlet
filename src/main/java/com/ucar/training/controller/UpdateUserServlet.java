package com.ucar.training.controller;

import com.ucar.training.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=(String)request.getParameter("username");
        String realName=(String)request.getParameter("realName");
        String age=(String)request.getParameter("age");
        String tel=(String)request.getParameter("tel");
        String email=(String)request.getParameter("email");

        UserServiceImp myServiceImp=new UserServiceImp();
        myServiceImp.updateUser(username,realName,age,tel,email);

        getServletContext().setAttribute("users",myServiceImp.getUsers());
        response.getWriter().print("<script language='javascript'>alert('更新成功！');window.location='userInfo.jsp';</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
