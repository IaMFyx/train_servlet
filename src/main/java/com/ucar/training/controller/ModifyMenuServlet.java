package com.ucar.training.controller;

import com.ucar.training.entity.TMenu;
import com.ucar.training.service.impl.MenuServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/ModifyMenuServlet")
public class ModifyMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menuID=request.getParameter("menuID");
        MenuServiceImp menuServiceImp=new MenuServiceImp();
        request.setAttribute("modifyMenu",menuServiceImp.getMenuByID(Integer.parseInt(menuID)));
        getServletContext().getRequestDispatcher("/user/modifyMenu.jsp").forward(request,response);
    }
}
