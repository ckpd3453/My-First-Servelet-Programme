package com.bridgeLabz.myFirstServletProject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Hello")
public class FirstServelet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");//setting content to text or html
        PrintWriter out = response.getWriter();
        //printing on web server
        out.println("<h3>Hello World ChandraKant Prasad  My First Servlet</h3>");
        out.close();
    }
}
