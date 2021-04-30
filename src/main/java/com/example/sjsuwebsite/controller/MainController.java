package com.example.sjsuwebsite.controller;

import com.example.sjsuwebsite.Bundle;
import com.example.sjsuwebsite.Item;
import com.example.sjsuwebsite.ItemSystem;
import com.example.sjsuwebsite.model.Users;
import com.example.sjsuwebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired
    UserRepository repo;

    ItemSystem ItemList = new ItemSystem();


    int[] cart = {0,0,0,0,0,0,0,0,0};
    ArrayList<Item> itemarr = new ArrayList<>(10);
    ArrayList<Item> cartArrList = new ArrayList<>(10);

    public MainController(){

        itemarr.add(new Item("Banana",10,"I am a banana", 10.00));

        cartArrList.add(new Item("Banana",10,"Banana description", 10.00));
        cartArrList.add(new Item("Apple",7,"Apple description. " +
                "this is a super long description of an item to test the formatting," +
                "alignment, etc of description. " +
                "There are many different types of apples, for example:" +
                "Ambrosia, fuji, honeycrisp, granny smith, pink lady", 8));

        // Composite Design
        Item item1 = new Item("Apple",1,"good Apple",10);
        Item item2 = new Item("Bad Apple", 1, "Bad Apple", 11);

//        Bundle Class stores multiple items at once in an ArrayList
        Bundle bundle = new Bundle();
        bundle.addItem(item1);
        bundle.addItem(item2);

//        ItemList is able to store Item and Bundle class together
        ItemList.add(new Item("Banana",10,"Banana description", 10.00));
        ItemList.add(bundle);

//        Prints Items
        ItemList.printItem();

    }


    public MainController(UserRepository repo)
    {
        this.repo = repo;
        System.out.println("hit2");
    }

//    MainPage
    @RequestMapping("/MainPage")
    public String MainPage(Model model) {

        model.addAttribute("num", cart);
        model.addAttribute("Item",itemarr);
        return "MainPage";
    }

    @PostMapping("/MainPage")
    public String MainPage2(@RequestParam(name = "buttonName") int change, Model model){


        model.addAttribute("num", cart);
        System.out.println("hit");

        return "MainPage";
    }

//    ItemPage
    @RequestMapping("/ItemPage")
    public String ItemPage(@RequestParam(name= "ItemNumber") int ItemNumber,Model model) {
        model.addAttribute("Item", itemarr.get(ItemNumber));
        model.addAttribute("num", cart);

        return "ItemPage";
    }

//    CartPage
    @RequestMapping("/Cart")
    public String Cart(Model model)
    {
        model.addAttribute("cartArrList", cartArrList);
        return "cart";
    }
    @PostMapping(value="/Cart", params = {"quantity", "itemName"})
    public String updateCart(Model model, @RequestParam int quantity, @RequestParam String itemName)
    {
        Item currentItem=null;
        for(Item item:cartArrList)
        {
            if (item.getName().equals(itemName))
                currentItem = item;
        }
        currentItem.setQuantity(quantity);
        Cart(model);
        return "cart";
    }

//    AccountSettings
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


    @RequestMapping(value = "/Login")
    public String Login(Model model) {
        model.addAttribute("users", new Users());

        return "Login";
    }

    @PostMapping("/Login")
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