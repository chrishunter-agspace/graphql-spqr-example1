package com.agspace.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphQLError;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "graphql")
public class GraphQLController {
    private GraphQL graphql;

    @Autowired
    public GraphQLController(UserController userController) {
        //Schema generated from annotated query classes
        GraphQLSchemaGenerator generator = new GraphQLSchemaGenerator();
        generator.withOperationsFromSingleton(userController)
                .withValueMapperFactory(new JacksonValueMapperFactory())
                .withDefaults();
        graphql = GraphQL.newGraphQL(generator.generate()).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object indexFromAnnotated(@RequestBody Map<String, Object> request) throws Exception {
        String query = request.get("query").toString();
        ExecutionResult executionResult;
        executionResult = graphql.execute(query);

        if (!executionResult.getErrors().isEmpty()){
            return extractErrorResponse(executionResult);
        }

        return executionResult;
    }

    //Just mocking error handling
    private Object extractErrorResponse(ExecutionResult executionResult) {
        ObjectMapper mapper = new ObjectMapper();
        List<String> errorMessages = executionResult.getErrors()
                .stream()
                .map(GraphQLError::getMessage)
                .collect(Collectors.toList());

        try {
            return mapper.writeValueAsString(errorMessages);
        } catch (Exception e) {
            return "Mapper exception";
        }
    }
}
