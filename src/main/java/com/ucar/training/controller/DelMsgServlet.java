package com.ucar.training.controller;


import com.ucar.training.service.impl.MessageServiceImp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/messagebord/DelMsgServlet")
public class DelMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String messageID=request.getParameter("messageID");

        MessageServiceImp messageServiceImp=new MessageServiceImp();
        messageServiceImp.delMessage(Integer.parseInt(messageID));

        request.getSession().setAttribute("userMessages",messageServiceImp.getUserMessages());
        response.getWriter().print("<script language='javascript'>alert('删除成功！');window.location='messageBord.jsp';</script>");
    }
}
