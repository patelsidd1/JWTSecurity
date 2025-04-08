package com.spring.JWTSecurity.Controller;

import com.spring.JWTSecurity.Model.User;
import com.spring.JWTSecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;



    @GetMapping("/user")
    public List<User> getUser(){

        System.out.println("Getting Users ");

        return userService.getUser();

    }
}
