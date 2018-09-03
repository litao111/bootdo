package com.bootdo.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

/*
 * 实现基本上传并对文件进行UUID重命名
 */
public class UploadServlet2 extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //1、设置临时上传的路径
        DiskFileItemFactory disk = new DiskFileItemFactory(10240, new File("e:disk"));
        //2、设置文件上传的目标路径
        String servePath = getServletContext().getRealPath("/serviceDisk");
        System.out.println(servePath + "-------------------------");

        //3、申明upload
        ServletFileUpload up = new ServletFileUpload(disk);
        //4、解析request
        try {
            List<FileItem> list = up.parseRequest(request);
            for (FileItem file : list) {
                if (!file.isFormField()) {
                    //获取上传文件的名字
                    String fileName = file.getName();
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                    //获取上传文件的后缀
                    String extName = fileName.substring(fileName.lastIndexOf("."));
                    //申明UUID
                    String uuid = UUID.randomUUID().toString().replace("-", "");
                    //组成新的名称
                    String newName = uuid + extName;
                    //上传文件
                    FileUtils.copyInputStreamToFile(file.getInputStream(),new File(servePath + "/" + newName));
                    //封装
                    request.setAttribute("newName", newName);
                    request.setAttribute("oldName", fileName);
                }
            }
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            new RuntimeException();
        }
    }

}

