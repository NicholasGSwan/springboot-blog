package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {


    @ResponseBody
    @GetMapping("/add/{num1}/and/{num2}")
    public Integer add(@PathVariable Integer num1,@PathVariable Integer num2){
        return num1 + num2;
    }
    @ResponseBody
    @GetMapping("/subtract/{b}/from/{a}")
    public Integer subtract(@PathVariable Integer a,@PathVariable Integer b){
        return a-b;
    }
    @ResponseBody
    @GetMapping("/multiply/{a}/and/{b}")
    public Integer multiply(@PathVariable Integer a,@PathVariable Integer b){
    return a*b;
        }

    @ResponseBody
    @GetMapping("/divide/{a}/by/{b}")
    public Double divide(@PathVariable Double a,@PathVariable Double b){
        return a / b;
    }
}
