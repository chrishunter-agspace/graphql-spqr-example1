package com.agspace.example.controller;

import com.agspace.example.entity.User;
import com.agspace.example.repository.UserRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.agspace.example.controller.UserController.url;

@RestController
@RequestMapping(value = url)
public class UserController {
    protected final static String url = "user";
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @GraphQLQuery(name = url)
    public User getUser() {
        return userRepository.getUser();
    }
}
