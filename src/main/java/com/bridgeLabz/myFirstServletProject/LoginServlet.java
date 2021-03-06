package com.bridgeLabz.myFirstServletProject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "ChandraKant"),
                @WebInitParam(name = "password", value = "ckpd@123")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get request for userID and Password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        //get servlet config init params
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        /**
         * Defining the pattern of UserID and Password validating the format.
         */
        Pattern userpattern = Pattern.compile("^([A-Z][a-zA-Z]{2,}[ ]?)+$");
        Matcher userMatcher = userpattern.matcher(user);
        Pattern pwdPattern = Pattern.compile("^([a-zA-Z0-9]{4,}[!@#$%&*]{1}[a-zA-Z0-9]{1,})$");
        Matcher pwdMatcher = pwdPattern.matcher(pwd);
        //For UserId
        if(!userMatcher.matches()) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color = red> Incorrect UserId. Please try again!!<font>");
            rd.include(request, response);
            return;
        }
        //For Password
        if(!pwdMatcher.matches()) {
            PrintWriter out = response.getWriter();
            out.println("<font color = orange> Incorrect Password. Please try again!!<font>");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            rd.include(request, response);
            return;
        }

        /**
         * Validating the users Credentials and allowing user to login to the page.
         */
        if (userID.equals(user) && password.equals(pwd)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red> Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}