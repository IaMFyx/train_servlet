package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.service.UserServiceImp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
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
        String privilege=request.getParameter("privilege");

        User user=new User();
        user.setUsername(username);
        user.setRealName(realName);
        user.setAge(age);
        user.setSex(sex);
        user.setPassword(password);
        user.setTel(tel);
        user.setEmail(email);
        user.setHobbies(hobbies.toString());
        user.setHobbyList();
        user.setSign(sign);
        user.setPrivilege(privilege);

        //将用户信息加入集合，模拟数据库
        UserServiceImp myServiceImp=new UserServiceImp();
        myServiceImp.register(user);

        //request.getSession().setAttribute("users",myServiceImp.getUsers());

        //在register.jsp中提示注册成功
        response.getWriter().print("<script language='javascript'>alert('注册成功！');window.location='user/register.jsp';</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        UserServiceImp myServiceImp=new UserServiceImp();
        if (myServiceImp.inUsers(username)){
            //用户名已经存在
            response.getWriter().print(1);
        }
        else {
            //用户名可以用
            response.getWriter().print(0);
        }
    }
}
