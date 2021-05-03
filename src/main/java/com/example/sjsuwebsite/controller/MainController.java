package com.example.sjsuwebsite.controller;

import com.example.sjsuwebsite.Bundle;
import com.example.sjsuwebsite.Item;
import com.example.sjsuwebsite.ItemSystem;
import com.example.sjsuwebsite.Product;
import com.example.sjsuwebsite.model.Users;
import com.example.sjsuwebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired
    UserRepository repo;

    //Our ItemList that lists all the items in the store
    ItemSystem ItemList = new ItemSystem();

    //Cart List that lists all the items the user wants to buy
    ItemSystem CartList = new ItemSystem();

    //turns on message on MainPage
    boolean message = false;

    ArrayList<Item> itemarr = new ArrayList<>(10);
    ArrayList<Item> cartArrList = new ArrayList<>(10);

    public MainController() {
        itemarr.add(new Item("Strawberry", 10, "I am a strawberry", 5));
        itemarr.add(new Item("Apple", 11, "Apple description. " +
                "this is a super long description of an item to test the formatting," +
                "alignment, etc of description. " +
                "There are many different types of apples, for example:" +
                "Ambrosia, fuji, honeycrisp, granny smith, pink lady", 8));
        itemarr.add(new Item("Banana", 12, "I am a banana", 10.00));

        cartArrList.add(new Item("Strawberry", 10, "I am a strawberry", 5));
        cartArrList.add(new Item("Banana", 10, "Banana description", 10.00));
        cartArrList.add(new Item("Apple", 7, "Apple description. " +
                "this is a super long description of an item to test the formatting," +
                "alignment, etc of description. " +
                "There are many different types of apples, for example:" +
                "Ambrosia, fuji, honeycrisp, granny smith, pink lady", 8));

        // Composite Design
        Item item1 = new Item("Strawberry", 10, "I am a strawberry", 5);
        Item item2 = new Item("Banana", 10, "I am a Banana", 10.00);
        Item item3 = new Item("Apple", 7, "I am an Apple. " +
                "this is a super long description of an item to test the formatting," +
                "alignment, etc of description. " +
                "There are many different types of apples, for example:" +
                "Ambrosia, fuji, honeycrisp, granny smith, pink lady", 8);
        Item item4 = new Item ("Grape", 6,"Green Grapes that has a sweet taste", 7);
        Item item5 = new Item ("Orange", 5, "Oranges that are good for your Vitamin C", 4);

//        Bundle Class stores multiple items at once in an ArrayList
        Bundle bundle = new Bundle();
        bundle.addItem(item1);
        bundle.addItem(item2);
        bundle.addItem(item3);
        bundle.setQuantity(7);

//        ItemList is able to store Item and Bundle class together
        ItemList.add(bundle);
        ItemList.add(item1);
        ItemList.add(item2);
        ItemList.add(item3);
        ItemList.add(item4);
        ItemList.add(item5);

    }


    public MainController(UserRepository repo) {
        this.repo = repo;
    }

    //    MainPage
    @RequestMapping("/MainPage")
    public String MainPage(Model model) {

        model.addAttribute("Cart", CartList);
        model.addAttribute("Item", ItemList);

        model.addAttribute("message", message);

        message = false;

        return "MainPage";
    }

    //    ItemPage
    @RequestMapping("/ItemPage")
    public String ItemPage(@RequestParam(name = "ItemNumber") int ItemNumber, Model model) {

        model.addAttribute("Item", ItemList.get(ItemNumber));
        model.addAttribute("ItemNumber", ItemNumber);

//        model.addAttribute("num", cart);



        return "ItemPage";
    }

    @PostMapping("/ItemPage")
    public String ItemPage2( @RequestParam(name="Stock") int Stock,@RequestParam(name="ItemNumber") int ItemNumber) {

        Product prod = ItemList.get(ItemNumber);
        prod.setQuantity(Stock);
        //Puts Item Selected to CartList
        CartList.add(prod);

        message = true;

//        REDIRECTS TO MAIN PAGE
        return "redirect:MainPage";
    }

    //    CartPage
    @RequestMapping("/Cart")
    public String Cart(Model model) {
        model.addAttribute("itemarr", itemarr);
        model.addAttribute("cartArrList", cartArrList);
        return "cart";
    }

    @PostMapping(value = "/Cart", params = {"quantity", "itemName"})
    public String updateCart(Model model, @RequestParam int quantity, @RequestParam String itemName) {

        Item currentItemInCart = null;
        Item currentItemInStock =null;

        for (Item item : cartArrList) {
            if (item.getName().equals(itemName))
                currentItemInCart = item;
        }
        for (Item item : itemarr) {
            if (item.getName().equals(itemName))
                currentItemInStock = item;
        }
        if (quantity < 0)
            quantity = 0;
        if(quantity>currentItemInStock.getQuantity())
            quantity=currentItemInStock.getQuantity();

        currentItemInCart.setQuantity(quantity);
        Cart(model);
        return "cart";
    }

    //    AccountSettings
    @RequestMapping("/AccountSettings")
    public String AccountSettings() {
        return "AccountSettings";
    }


    @RequestMapping("/PurchaseHistory")
    public String PurchaseHistory() {
        return "PurchaseHistory";
    }

    @RequestMapping("/SignUp")
    public String SignUp() {
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


        boolean Existdb = repo.existsUsersByUsernameAndPassword(user.getUsername(), user.getPassword());


//        if(Existdb)
//        {
//            System.out.println("main");
//            return "redirect";
//        }
//        } else {
//            System.out.println("no user");
//            model.addAttribute("message", "Error: Username doesn't exist or Password is wrong");
//            return "Login";
//        }

        return "Login";

    }

//    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
//    public String redirect() {
//        return "MainPage";
//    }

    @RequestMapping(value = "/redirect", method = RequestMethod.POST)
    public String redirect() {
        System.out.println("redirect");
        return "MainPage";
    }


    @PostMapping("/SignUp")
    public String getSubmit(@ModelAttribute Users user, Model model) {
        model.addAttribute("users", user);
        System.out.println("3");
        boolean Existdb = repo.existsUsersByUsername(user.getUsername());
        System.out.println("4");
        if (Existdb) {
            System.out.println("exist");
            model.addAttribute("message", "Error: Username exist in the Database");
            return "SignUp";
        } else {
            System.out.println("new user added");
            repo.save(user);
            return "Login";
        }

    }

}