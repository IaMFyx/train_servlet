package com.ucar.training.controller;

import com.ucar.training.entity.UserMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DelMsgServlet")
public class DelMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //servlet
        String messageID=request.getParameter("messageID");
        ArrayList<UserMessage> userMessages=(ArrayList<UserMessage>)request.getServletContext().getAttribute("userMessages");
        //service dao
        for (UserMessage userMessage:userMessages){
            if (userMessage.getMessageID()==(Integer.parseInt(messageID))){
                userMessages.remove(userMessage);
                break;
            }
        }
        //servlet
        getServletContext().setAttribute("userMessages",userMessages);
        response.getWriter().print("<script language='javascript'>alert('删除成功！');window.location='messageBord.jsp';</script>");
    }
}
