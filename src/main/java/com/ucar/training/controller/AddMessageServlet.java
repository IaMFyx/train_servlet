package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.entity.UserMessage;
import com.ucar.training.service.impl.MessageServiceImp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/messagebord/AddMessageServlet")
public class AddMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //servlet
        User user=(User)request.getSession().getAttribute("userNow");
        String messageTitle=request.getParameter("messageTitle");
        String messageContent=request.getParameter("messageContent");
        UserMessage userMessage=new UserMessage();
        userMessage.setUsername(user.getUsername());
        userMessage.setMessageTitle(messageTitle);
        userMessage.setMessageContent(messageContent);


        MessageServiceImp messageServiceImp=new MessageServiceImp();
        messageServiceImp.addMessage(userMessage);

        request.getSession().setAttribute("userMessages",messageServiceImp.getUserMessages());
        response.sendRedirect("/training_servlet/messagebord/messageBord.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
