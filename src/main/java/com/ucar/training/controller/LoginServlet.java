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
import java.util.Set;

@WebServlet("/user/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        MyServiceImp myServiceImp=new MyServiceImp();
        int val=myServiceImp.login(username,password);
        if (val==0){
            //密码正确
            request.getSession().setAttribute("userNow",myServiceImp.getUserNow());
            response.getWriter().print(0);
        }
        else if(val==1)
        {
            //密码不正确
            out.print(1);
        }
        else {
            //用户名不存在
            out.print(2);
        }
    }
}
