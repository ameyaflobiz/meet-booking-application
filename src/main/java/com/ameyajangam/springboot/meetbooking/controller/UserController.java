package com.ameyajangam.springboot.meetbooking.controller;

import com.ameyajangam.springboot.meetbooking.model.User;
import com.ameyajangam.springboot.meetbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/users/create")
    public User createUser(@RequestBody User requestedUser){
        User user = userService.createUser(requestedUser.getName(), requestedUser.getPhoneNumber(), requestedUser.getEmail());

        return user;
    }

}
