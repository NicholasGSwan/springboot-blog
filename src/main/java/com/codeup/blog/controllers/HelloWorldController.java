package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String helloName(@PathVariable String name){
        return "Hello, "+name+"!!";
    }
    @ResponseBody
    @GetMapping("/square/{number}")
    public Integer square(@PathVariable Integer number){
        return number*number;
    }
}
