package com.example.jpa_sem4.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/14/2023
Time: 10:39 PM

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
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@WebServlet(name="productservlet", value = "/product/*")
public class ProductController extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        String id = req.getParameter("id");
        if (id == null){
            RequestDispatcher view = req.getRequestDispatcher("/pages/home.jsp");

            ProductRepositoryImpl productRepo = new ProductRepositoryImpl();
            List<Product> productList = productRepo.findall();
            req.setAttribute("product", productList);
            view.forward(req, res);
        } else{
            ProductRepositoryImpl productRepo = new ProductRepositoryImpl();
            Product productById = productRepo.getById(id);

            req.setAttribute("productByIdName", productById.getName());
            RequestDispatcher view2 = req.getRequestDispatcher("/pages/details.jsp");

            view2.forward(req, res);
        }

    }
}
