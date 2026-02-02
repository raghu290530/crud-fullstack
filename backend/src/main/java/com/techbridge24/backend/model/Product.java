package com.techbridge24.backend.model;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private int id;
    private String name;
    private double price;
    private String brand;

    public Product(int id, String name,  String brand, double price) {
        this.brand = brand;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String brand, String name, double price) {
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
}
