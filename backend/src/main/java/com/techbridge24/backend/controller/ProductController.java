package com.techbridge24.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techbridge24.backend.model.Product;
import com.techbridge24.backend.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService service;
    
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.findAll();
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
        return "Delete Sucessflly";
    }

    @PostMapping("/products")
    public int addproduct(@RequestBody Product p){
        return service.addproduct(p);
    }

    @PutMapping("/products/{id}")
    public int updateProduct(@PathVariable int id,@RequestBody Product p){
        return service.updateProduct(id,p);
    }
}
