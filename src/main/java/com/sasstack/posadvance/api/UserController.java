package com.sasstack.posadvance.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    public ResponseEntity<StackOverflowError> createUser(){


    }




}
