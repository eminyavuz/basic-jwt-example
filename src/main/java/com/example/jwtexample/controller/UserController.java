package com.example.jwtexample.controller;

import com.example.jwtexample.model.User;
import com.example.jwtexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAll")
    public List<User> getAll()
    {
        return userService.getAll();
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public  String login( @RequestBody User user ){
        return userService.verify(user);
    }
}
