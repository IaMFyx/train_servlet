package com.ucar.training.controller;

import com.ucar.training.entity.TMenu;
import com.ucar.training.service.impl.MenuServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/UpdateMenuServlet")
public class UpdateMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid=request.getParameter("mid");
        String menuName=request.getParameter("menuName");
        String url=request.getParameter("url");
        TMenu menu=new TMenu();
        menu.setMid(Integer.parseInt(mid));
        menu.setMenuName(menuName);
        menu.setUrl(url);
        MenuServiceImp menuServiceImp=new MenuServiceImp();
        menuServiceImp.modifyMenu(menu);
        request.getSession().setAttribute("menus",menuServiceImp.getMenus());
        response.getWriter().print("<script language='javascript'>alert('更新成功！');window.location='menu.jsp';</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
