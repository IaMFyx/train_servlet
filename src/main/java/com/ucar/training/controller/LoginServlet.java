package com.ucar.training.controller;

import com.ucar.training.service.impl.MenuServiceImp;
import com.ucar.training.service.impl.MessageServiceImp;
import com.ucar.training.service.impl.RoleServiceImp;
import com.ucar.training.service.impl.UserServiceImp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        UserServiceImp myServiceImp=new UserServiceImp();
        int val=myServiceImp.login(username,password);
        if (val==0){
            //密码正确
            request.getSession().setAttribute("userNow",myServiceImp.getUserNow());
            request.getSession().setAttribute("users",myServiceImp.getUsers());
            request.getSession().setAttribute("userMenu",myServiceImp.getUserMenu());

            MessageServiceImp messageServiceImp=new MessageServiceImp();
            request.getSession().setAttribute("userMessages",messageServiceImp.getUserMessages());

            MenuServiceImp menuServiceImp=new MenuServiceImp();
            request.getSession().setAttribute("menus",menuServiceImp.getMenus());

            RoleServiceImp roleServiceImp=new RoleServiceImp();
            request.getSession().setAttribute("roles",roleServiceImp.getAllRole());
            out.print(0);
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
