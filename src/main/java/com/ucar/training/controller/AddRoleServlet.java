package com.ucar.training.controller;

import com.ucar.training.entity.TRole;
import com.ucar.training.service.impl.MenuServiceImp;
import com.ucar.training.service.impl.RoleServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/AddRoleServlet")
public class AddRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roleName=request.getParameter("roleName");
        String[] menu=request.getParameterValues("menu");

        RoleServiceImp roleServiceImp=new RoleServiceImp();
        roleServiceImp.addRole(roleName);

        int roleID=roleServiceImp.getRoleIDByName(roleName);
        for (int i = 0; i < menu.length; i++) {
            roleServiceImp.addRoleMenu(roleID,Integer.parseInt(menu[i]));
        }
        request.getSession().setAttribute("roles",roleServiceImp.getAllRole());
        response.getWriter().print("<script language='javascript'>alert('添加成功！');window.location='role.jsp';</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
