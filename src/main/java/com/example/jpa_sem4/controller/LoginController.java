package com.example.jpa_sem4.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/14/2023
Time: 10:39 PM

ProjectName: jsp-servlet-final*/


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="authentication", value = "/signin")
public class LoginController extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        RequestDispatcher view = req.getRequestDispatcher("/pages/signin.jsp");

        String username = req.getParameter("email");
        String password = req.getParameter("password");
        view.forward(req, res);
    }
}