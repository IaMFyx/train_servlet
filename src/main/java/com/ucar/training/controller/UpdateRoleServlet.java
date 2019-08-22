package com.ucar.training.controller;

import com.ucar.training.service.impl.RoleServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/UpdateRoleServlet")
public class UpdateRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roleID=request.getParameter("roleID");
        String roleName=request.getParameter("roleName");
        String[] menu=request.getParameterValues("menu");

        RoleServiceImp roleServiceImp=new RoleServiceImp();
        roleServiceImp.delRole(Integer.parseInt(roleID));
        roleServiceImp.addRole(roleName);
        int roleID1=roleServiceImp.getRoleIDByName(roleName);
        for (int i = 0; i < menu.length; i++) {
            roleServiceImp.addRoleMenu(roleID1,Integer.parseInt(menu[i]));
        }
        request.getSession().setAttribute("roles",roleServiceImp.getAllRole());
        response.getWriter().print("<script language='javascript'>alert('更新成功！');window.location='role.jsp';</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
