package com.example.sjsuwebsite.controller;

import com.example.sjsuwebsite.model.Users;
import com.example.sjsuwebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    UserRepository repo;

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
    @RequestMapping("/SignUp")
    public String SignUp()
    {
        return "SignUp";
    }

    @RequestMapping(value = "/login")
    public String Login(Model model) {
        model.addAttribute("users", new Users());

        return "Login";
    }

    @PostMapping("/login")
    public String getLog(@ModelAttribute Users user, Model model) {

        model.addAttribute("users", user);


        boolean Existdb = repo.existsUsersByUsernameAndPassword(user.getUsername(),user.getPassword());

        if(Existdb)
        {
            System.out.println("main");
            return "MainPage";
        }
        else {
            System.out.println("no user");
            model.addAttribute("message", "Error: Username doesn't exist or Password is wrong");
            return "Login";
        }

    }


    @PostMapping("/SignUp")
    public String getSubmit(@ModelAttribute Users user, Model model) {
        model.addAttribute("users", user);
        System.out.println("3");
        boolean Existdb = repo.existsUsersByUsername(user.getUsername());
        System.out.println("4");
        if(Existdb)
        {
            System.out.println("exist");
            model.addAttribute("message", "Error: Username exist in the Database");
            return "SignUp";
        }
        else{
            System.out.println("new user added");
            repo.save(user);
            return "Login";
        }
    }

}