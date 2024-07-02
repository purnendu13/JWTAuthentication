package com.example.JWTAuth.controllers;

import com.example.JWTAuth.Services.UserService;
import com.example.JWTAuth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserService userService;
    @GetMapping("/test")
    public List<User> Test(){
        return userService.getUser();
    }
    @GetMapping("/Current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
