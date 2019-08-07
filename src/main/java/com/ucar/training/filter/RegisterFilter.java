package com.ucar.training.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter(filterName = "RegisterFilter",urlPatterns = "/RegisterServlet")
public class RegisterFilter implements Filter {
    private Set<String> blacklist=new HashSet<>();
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        blacklist.add("张三");
        blacklist.add("李四");
        blacklist.add("王五");
        blacklist.add("穆天翔");
        String username=req.getParameter("realName");
        if (blacklist.contains(username)){
            resp.getWriter().print("<script language='javascript'>alert('该用户在黑名单中,无法注册');window.location='register.jsp';</script>");
        }
        else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
