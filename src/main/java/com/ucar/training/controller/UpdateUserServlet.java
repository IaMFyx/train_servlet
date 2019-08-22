package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String realName=request.getParameter("realName");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String password=request.getParameter("password");
        String tel=request.getParameter("tel");
        String email=request.getParameter("email");
        String[] hobbiesArr=request.getParameterValues("hobbies");
        StringBuffer hobbies=new StringBuffer();
        if (hobbiesArr==null){
            hobbies.append("无");
        }
        else {
            for (int i = 0; i <hobbiesArr.length ; i++) {
                hobbies.append(hobbiesArr[i]+",");
            }
            hobbies.delete(hobbies.length()-1,hobbies.length());
        }

        String sign=request.getParameter("sign");
        String privilege=request.getParameter("role");

        User user=new User();
        user.setUsername(username);
        user.setRealName(realName);
        user.setAge(age);
        user.setSex(sex);
        user.setPassword(password);
        user.setTel(tel);
        user.setEmail(email);
        user.setHobbies(hobbies.toString());
        user.setSign(sign);
        user.setRole(Integer.parseInt(privilege));

        UserServiceImp myServiceImp=new UserServiceImp();
        myServiceImp.updateUser(user);

        request.getSession().setAttribute("users",myServiceImp.getUsers());
        response.getWriter().print("<script language='javascript'>alert('更新成功！');window.location='userInfo.jsp';</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
