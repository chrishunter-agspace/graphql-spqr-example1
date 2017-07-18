package com.agspace.example.query;

import com.agspace.example.entity.User;
import com.agspace.example.repository.UserRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltUserQuery {
    @Autowired
    private UserRepository userRepository;

    @GraphQLQuery(name = "user")
    public User search() throws Exception {
        return userRepository.getUser();
    }

    @GraphQLQuery(name = "user")
    public User searchAll() throws Exception {
        return userRepository.getUser();
    }

}
