package com.preet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/emp")
public class InfoEmployeeController {

    @GetMapping
    String getEmployeeInfo(){

        return "hello";
    }
}
