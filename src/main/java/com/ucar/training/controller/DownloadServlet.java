package com.ucar.training.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/file/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename=request.getParameter("name");

        System.out.println("文件名："+filename);

        response.setContentType(getServletContext().getMimeType(filename));

        response.setHeader("Content-Disposition", "attachment;filename="+filename);

        ServletContext context=this.getServletContext();

        String fullFileName=context.getRealPath("/upload/"+filename);

        System.out.println(fullFileName);

        InputStream is=new FileInputStream(fullFileName);

        ServletOutputStream os =response.getOutputStream();

        int len=-1;

        byte[] b=new byte[1024];

        while((len=is.read(b))!=-1){
            os.write(b,0,len);
        }

        is.close();

        os.close();
    }
}