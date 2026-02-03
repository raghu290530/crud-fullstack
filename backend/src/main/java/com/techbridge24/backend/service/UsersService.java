package com.techbridge24.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbridge24.backend.model.Users;
import com.techbridge24.backend.repository.UsersRepo;

@Service
public class UsersService {
    
    @Autowired
    private UsersRepo ur;

    public UsersService(UsersRepo ur) {
        this.ur = ur;
    }

    public String loginUser(String email,String pass){
        List<Users> u = ur.loginUser(email, pass);
        if(u.size()==1){
            return "Login Sucess!!!";
        }
        return "Email or Password is Wrong";
    }
    

}
