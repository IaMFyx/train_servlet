package com.ucar.training.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "MessageFilter",urlPatterns = "/AddMessageServlet")
public class MessageFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String messageContent=req.getParameter("messageContent");
        if (messageContent.contains("sb")){
            resp.getWriter().print("<script language='javascript'>alert('输入的内容不友好，请重新输入');window.location='addMessage.jsp';</script>");
        }
        else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
