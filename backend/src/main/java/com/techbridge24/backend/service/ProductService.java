package com.techbridge24.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbridge24.backend.model.Product;
import com.techbridge24.backend.repository.ProductRepo;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepo pr;

    public ProductService(ProductRepo pr) {
        this.pr = pr;
    }

    public List<Product> findAll(){
        return pr.findAll();
    }

    public String deleteProduct(int id){
        pr.deleteProduct(id);
        return "Deleted Sucessfully";
    }

    public int addproduct(Product p){
        return pr.addproduct(p);
    }

    public int updateProduct(int id,Product p){
        return pr.updateProduct(id, p);
    }

}
