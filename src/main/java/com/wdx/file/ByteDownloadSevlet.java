package com.wdx.file;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ByteDownloadSevlet extends HttpServlet{


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("application/x-jpg");
        response.setHeader("Content-Disposition", "attachment;fileName="+"a.jpg");
        File file = new File("D:/1.jpg");
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(file);

            out = response.getOutputStream();
            int len = 0;
            while ((len = in.read()) != -1) {
                out.write(len);
            }
        }catch (Exception e){

        }finally {
            if(in !=null){
                in.close();
            }
            if(out != null){
                out.close();
            }

        }
    }
}
