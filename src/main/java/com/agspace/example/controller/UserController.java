package com.agspace.example.controller;

import com.agspace.example.entity.User;
import com.agspace.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public User getUser() {
        return userRepository.getUser();
    }
}
