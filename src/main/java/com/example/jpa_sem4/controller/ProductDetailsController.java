package com.example.jpa_sem4.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/16/2023
Time: 7:18 PM

ProjectName: jsp-servlet-final*/

import com.example.jpa_sem4.entity.Product;
import com.example.jpa_sem4.impl.ProductRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name="productdetails", value = "/product/*")
//public class ProductDetailsController extends HttpServlet {
//    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//        RequestDispatcher view = req.getRequestDispatcher("/pages/details.jsp");
//        ProductRepositoryImpl productRepo = new ProductRepositoryImpl();
//
//        String id = req.getParameter("id");
//        Product productById = productRepo.getById(id);
//
//        req.setAttribute("productByIdName", productById.getName());
//
//        view.forward(req, res);
//    }
//}
