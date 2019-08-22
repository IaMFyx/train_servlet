package com.ucar.training.controller;

import com.ucar.training.service.impl.RoleServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/DelRoleServlet")
public class DelRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roleID=request.getParameter("roleID");
        RoleServiceImp roleServiceImp=new RoleServiceImp();
        roleServiceImp.delRole(Integer.parseInt(roleID));
        request.getSession().setAttribute("roles",roleServiceImp.getAllRole());
        response.getWriter().print("<script language='javascript'>alert('删除成功！');window.location='role.jsp';</script>");
    }
}
