package com.example.sjsuwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    int[] num = {0,0,0,0,0,0,0,0,0};

    @RequestMapping("/")
    public String MainPage(Model model) {

        model.addAttribute("num", num);

        return "MainPage";
    }

    @PostMapping("/")

    public String MainPage2(@RequestParam(name = "buttonName") int change, Model model){

        num[change] = num[change] - 1;

        model.addAttribute("num", num);
        System.out.println("hit");

        return "MainPage";
    }
}
