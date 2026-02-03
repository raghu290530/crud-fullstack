package com.techbridge24.backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.techbridge24.backend.model.Users;

@Repository
public class UsersRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UsersRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Users> rowMapper = (rs,rowNum) -> 
        new Users(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("role")
        );
    
    public List<Users> loginUser(String email,String pass){
        String query = 
            "Select * from users where email=? and password=?";
        return jdbcTemplate.query(query,rowMapper,email,pass);
    }
    
}
