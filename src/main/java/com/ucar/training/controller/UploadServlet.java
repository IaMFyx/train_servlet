package com.ucar.training.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/file/UploadServlet")
public class UploadServlet extends HttpServlet {
    private Set<String> fileNames=new HashSet<>();
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "upload";
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {

            PrintWriter writer = response.getWriter();

            writer.println("Error: 表单必须包含 enctype=multipart/form-data");

            writer.flush();

            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();

        factory.setSizeThreshold(MEMORY_THRESHOLD);

        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setFileSizeMax(MAX_FILE_SIZE);

        upload.setSizeMax(MAX_REQUEST_SIZE);

        upload.setHeaderEncoding("UTF-8");

        String uploadPath = getServletContext().getRealPath("/") + UPLOAD_DIRECTORY;

        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {

            uploadDir.mkdir();
        }
        try {
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {

                        String fileName = new File(item.getName()).getName();

                        String filePath = uploadPath + File.separator + fileName;

                        File storeFile = new File(filePath);

                        System.out.println(filePath);

                        item.write(storeFile);

                        fileNames.add(fileName);

                        getServletContext().setAttribute("fileNames",fileNames);

                        request.setAttribute("message", "文件上传成功!");
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message", "错误信息: " + ex.getMessage());
        }

        response.getWriter().print("<script language='javascript'>alert(' 上传成功！');window.location='download.jsp';</script>");
    }
}
