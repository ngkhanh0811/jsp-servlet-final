package com.example.jpa_sem4.entity;/*Welcome to my show !

@author: NgKhanh
Date: 6/14/2023
Time: 7:53 PM

ProjectName: jpa_sem4*/

import com.example.jpa_sem4.annotation.Column;
import com.example.jpa_sem4.annotation.Entity;
import com.example.jpa_sem4.annotation.Id;
import com.example.jpa_sem4.constant.SqlDataType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@Entity(tablename = "product")
public class Product {
    @Id(name = "id")
    private int id;
    @Column(name="product_name", dataType = SqlDataType.TEXT)
    private String name;
    @Column(name="impDate", dataType = SqlDataType.TEXT)
    private String impDate;
    @Column(name="quantity", dataType = SqlDataType.INTEGER)
    private int quantity;
    @Column(name="manufacturer_id", dataType = SqlDataType.INTEGER)
    private int manufacturer_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImpDate() {
        return impDate;
    }

    public void setImpDate(String impDate) {
        this.impDate = impDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(int manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }
}
