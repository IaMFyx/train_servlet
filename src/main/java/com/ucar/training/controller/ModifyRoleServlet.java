package com.ucar.training.controller;


import com.ucar.training.entity.TMenu;
import com.ucar.training.entity.TRole;
import com.ucar.training.service.impl.RoleServiceImp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/ModifyRoleServlet")
public class ModifyRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roleID=request.getParameter("roleID");
        RoleServiceImp roleServiceImp=new RoleServiceImp();
        TRole role=roleServiceImp.getRoleByID(Integer.parseInt(roleID));
        request.setAttribute("modifyRole",role);
        List<String> roleMenuName=new ArrayList<>();
        for(TMenu menu:role.getMenusList()){
            roleMenuName.add(menu.getMenuName());
        }
        request.setAttribute("roleMenuName",roleMenuName);
        getServletContext().getRequestDispatcher("/user/modifyRole.jsp").forward(request,response);
    }
}
