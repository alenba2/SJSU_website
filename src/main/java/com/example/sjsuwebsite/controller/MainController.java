package com.example.sjsuwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    int[] num = {0,0,0,0,0,0,0,0,0};

    @RequestMapping("/MainPage")
    public String MainPage(Model model) {

        model.addAttribute("num", num);

        return "MainPage";
    }

    @PostMapping("/MainPage")

    public String MainPage2(@RequestParam(name = "buttonName") int change, Model model){

        num[change] = num[change] - 1;

        model.addAttribute("num", num);
        System.out.println("hit");

        return "MainPage";
    }
    @RequestMapping("/Cart")
    public String Cart()
    {
        return "cart";
    }
    @RequestMapping("/AccountSettings")
    public String AccountSettings()
    {
        return "AccountSettings";
    }
    @RequestMapping("/PurchaseHistory")
    public String PurchaseHistory()
    {
        return "PurchaseHistory";
    }
    @RequestMapping("/login")
    public String Login()
    {
        return "Login";
    }
    @RequestMapping("/SignUp")
    public String SignUp()
    {
        return "SignUp";
    }

}