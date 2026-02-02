package com.techbridge24.backend.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.techbridge24.backend.model.Product;

@Repository
public class ProductRepo {
    
    private final JdbcTemplate jT;

    public ProductRepo(JdbcTemplate jT) {
        this.jT = jT;
    }

    RowMapper<Product> rowMapper = (rs,rowNum) -> 
        new Product (
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("brand"),
            rs.getDouble("price")
        );

    public List<Product> findAll(){
        String query = "select * from products";
        return jT.query(query, rowMapper);
    }

    public int deleteProduct(int id){
        String query="delete from products where id = ?";
        return jT.update(query,id);
    }

    public int addproduct(Product p){
        String query = "insert into products(name,price,brand) values (?,?,?)";
        return jT.update(query,p.getName(),p.getPrice(),p.getBrand());
    }

    public int updateProduct(int id,Product p){
        String query = "update products set name=?,price=?,brand=? where id =?";
        return jT.update(query,p.getName(),p.getPrice(),p.getBrand(),id);
    }
}
