package com.ucar.training.Servlet;

import com.ucar.training.User;
import com.ucar.training.UserMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/AddMessageServlet")
public class AddMessageServlet extends HttpServlet {
    private static ArrayList<UserMessage> userMessages=new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //servlet
        User user=(User)request.getSession().getAttribute("userNow");
        String messageTitle=request.getParameter("messageTitle");
        String messageContent=request.getParameter("messageContent");
        Calendar c=Calendar.getInstance();
        String messageTime=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE);
        //service
        UserMessage userMessage=new UserMessage();
        userMessage.setUsername(user.getUsername());
        userMessage.setMessageTime(messageTime);
        userMessage.setMessageTitle(messageTitle);
        userMessage.setMessageContent(messageContent);

        //dao
        userMessages.add(userMessage);
        request.getServletContext().setAttribute("userMessages",userMessages);
        response.sendRedirect("/training_servlet/messageBord.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
