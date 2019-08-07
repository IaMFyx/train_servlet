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

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取文件名
        String filename=request.getParameter("name");
        //防止读取name名乱码
        //filename=new String(filename.getBytes("iso-8859-1"),"utf-8");
        //在控制台打印文件名
        System.out.println("文件名："+filename);

        //设置文件MIME类型（让文件可下载）
        response.setContentType(getServletContext().getMimeType(filename));
        //设置Content-Disposition（直接浏览器打开，还是下载）
        response.setHeader("Content-Disposition", "attachment;filename="+filename);

        //获取要下载的文件绝对路径，我的文件都放到WebRoot/download目录下
        ServletContext context=this.getServletContext();
        String fullFileName=context.getRealPath("/upload/"+filename);
        System.out.println(fullFileName);
        //输入流为项目文件，输出流指向浏览器
        InputStream is=new FileInputStream(fullFileName);
        ServletOutputStream os =response.getOutputStream();

        /**
         * 设置缓冲区
         * is.read(b)当文件读完时返回-1
         */
        int len=-1;
        byte[] b=new byte[1024];
        while((len=is.read(b))!=-1){
            os.write(b,0,len);
        }
        //关闭流
        is.close();
        os.close();
    }
}