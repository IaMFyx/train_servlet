package com.ucar.training.controller;

import com.ucar.training.service.impl.MenuServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/DelMenuServlet")
public class DelMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menuID=request.getParameter("menuID");
        MenuServiceImp menuServiceImp=new MenuServiceImp();
        menuServiceImp.delMenu(Integer.parseInt(menuID));
        request.getSession().setAttribute("menus",menuServiceImp.getMenus());
        response.getWriter().print("<script language='javascript'>alert('删除成功！');window.location='menu.jsp';</script>");
    }
}
