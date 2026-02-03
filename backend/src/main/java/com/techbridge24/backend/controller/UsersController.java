package com.techbridge24.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techbridge24.backend.service.UsersService;

@RestController
@CrossOrigin("*")
public class UsersController {

    @Autowired
    private UsersService us;

    public UsersController(UsersService us) {
        this.us = us;
    }
    
    @GetMapping("/users")
    public String loginUser(@RequestParam String email,@RequestParam String pass){
        return us.loginUser(email, pass);
        // /users?email=user1@gmail.com&pass=user123
    }
}
