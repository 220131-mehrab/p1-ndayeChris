package com.revature;

import java.io.IOException;
import java.io.InputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DefServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getPathInfo();
        String resourceDir = "static";
        if (filename == null || filename.equals("/") || filename.equals("")) filename = "/index.html";
        InputStream file = getClass().getClassLoader().getResourceAsStream(resourceDir + filename);
        if (file == null) {
            file = getClass().getClassLoader().getResourceAsStream(resourceDir + "/index.html");
        }
        String mimeType = getServletContext().getMimeType(filename);
        resp.setContentType(mimeType);
        IOUtils.copy(file, resp.getOutputStream());
        
    }
}
