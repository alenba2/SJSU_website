package com.example.sjsuwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String MainPage(){
        return "file";
    }


    @RequestMapping("/test")
    public String MainPage2(){
        return "test";
    }

    @RequestMapping("/test2")
    public String MainPage3(){
        return "test2";
    }

}