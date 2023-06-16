package com.example.jpa_sem4.impl;/*Welcome to my show !

@author: NgKhanh
Date: 6/14/2023
Time: 7:55 PM

ProjectName: jpa_sem4*/

import com.example.jpa_sem4.entity.Product;

import java.util.List;

public class ProductRepositoryImpl extends JpaExecutorImpl<Product>{
    public ProductRepositoryImpl() {
        super(Product.class);
    }

    public Object getAll() {
        return findall();
    }

    @Override
    public Product getById(String id){
        return super.getById(id); // có nguy cơ gây ra đệ quy
    }

    public static void main(String[] args) {
        ProductRepositoryImpl obj = new ProductRepositoryImpl();
        List<Product> productList = obj.findall();
        System.err.println(productList);

        obj.getById("1");
        System.err.println(obj);
    }
}
