package com.example.sjsuwebsite;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String name = request.getParameter("Name");
        String username = request.getParameter("UserName");
        String password = request.getParameter("PassWord");


        if(name.isEmpty() ||  username.isEmpty() || password.isEmpty() )
        {
            RequestDispatcher req = request.getRequestDispatcher("SignUp.jsp");
            req.include(request, response);
        }
        else
        {
//            System.out.println(name);
//            System.out.println(username);
//            System.out.println(password);
            RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
            req.forward(request, response);
        }
    }

}