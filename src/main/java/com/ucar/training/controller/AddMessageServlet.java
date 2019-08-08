package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.entity.UserMessage;
import com.ucar.training.service.MyServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
@WebServlet("/messagebord/AddMessageServlet")
public class AddMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //servlet
        User user=(User)request.getSession().getAttribute("userNow");
        String messageTitle=request.getParameter("messageTitle");
        String messageContent=request.getParameter("messageContent");
        Calendar c=Calendar.getInstance();
        String messageTime=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE);
        UserMessage userMessage=new UserMessage();
        userMessage.setUsername(user.getUsername());
        userMessage.setMessageTime(messageTime);
        userMessage.setMessageTitle(messageTitle);
        userMessage.setMessageContent(messageContent);
        userMessage.setMessageID(messageContent.hashCode());

        MyServiceImp myServiceImp=new MyServiceImp();
        myServiceImp.addMessage(userMessage);

        getServletContext().setAttribute("userMessages",myServiceImp.getUserMessages());
        response.sendRedirect("/training_servlet/messagebord/messageBord.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
