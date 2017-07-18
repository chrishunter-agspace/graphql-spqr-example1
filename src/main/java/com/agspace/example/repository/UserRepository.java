package com.agspace.example.repository;

import com.agspace.example.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserRepository {
    public User getUser() {
        User user = new User();
        user.setName("Bob");
        return user;

    }
}
