package com.sasstack.posadvance.api;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/test")
public class TestController {

    @Value("${server.port}")
    private String portNumber;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping
    public String testData(){
        return applicationName+ " works on "+portNumber ;
    }

    
}
