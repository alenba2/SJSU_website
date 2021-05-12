package com.example.sjsuwebsite.controller;

import com.example.sjsuwebsite.Bundle;
import com.example.sjsuwebsite.Item;
import com.example.sjsuwebsite.ItemSystem;
import com.example.sjsuwebsite.Product;
import com.example.sjsuwebsite.model.History;
import com.example.sjsuwebsite.model.Users;
import com.example.sjsuwebsite.repository.HistoryRepository;
import com.example.sjsuwebsite.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class MainController {
    @Autowired
    UserRepository userrepo;
    @Autowired
    HistoryRepository histrepo;

    Users currentUser;

    //Our ItemList that lists all the items in the store
    ItemSystem ItemList = new ItemSystem();

    //Cart List that lists all the items the user wants to buy
    ItemSystem CartList = new ItemSystem();

    //turns on message on MainPage
    boolean message = false;

    public MainController() {
        currentUser = new Users();

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

        for(int i = 0; i < ItemList.length();i++)
        {
            System.out.println("Item number: "+ i +" "+ItemList.get(i).getQuantity());
        }

    }

    public MainController(UserRepository userrepo) {
        this.userrepo = userrepo;
    }

    //    MainPage
    @RequestMapping("/MainPage")
    public String MainPage(Model model) {
        model.addAttribute("Username", currentUser);
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
        model.addAttribute("Username", currentUser);


        return "ItemPage";
    }

    @PostMapping("/ItemPage")
    public String ItemPage2( @RequestParam(name="Stock") int Stock,@RequestParam(name="ItemNumber") int ItemNumber, Model model) {

//        Error case where user puts 0 as there quantity
        if(Stock == 0)
        {
            model.addAttribute("message", true);
            model.addAttribute("Username", currentUser);
            model.addAttribute("Item", ItemList.get(ItemNumber));
            model.addAttribute("ItemNumber", ItemNumber);

            return "ItemPage";
        }

    try
    {


//        CLONES CLASS
        Product prod = (Product) ItemList.get(ItemNumber).clone();

        prod.setQuantity(Stock);
        //Puts Item Selected to CartList
        CartList.add(prod);

        message = true;
    }
    catch(CloneNotSupportedException e)
    {
        System.out.println("Something went wrong with the cloning");
    }

//        REDIRECTS TO MAIN PAGE
        return "redirect:MainPage";
    }

    //    CartPage on startup
    @RequestMapping("/Cart")
    public String Cart(Model model) {

        model.addAttribute("itemarr", ItemList);
        model.addAttribute("cartArrList", CartList);
        model.addAttribute("Username", currentUser);

        return "cart";
    }

//    When User wants to edit one of their items
    @PostMapping(value = "/Cart", params = {"quantity", "itemNumber", "Submit"})
    public String updateCart(Model model, @RequestParam int quantity, @RequestParam int itemNumber) {

//        Error case where User enters a negative number
        if(quantity <= -1)
        {
            model.addAttribute("message", true);
            model.addAttribute("messageString", "You cannot set negative numbers as your quantity");
            model.addAttribute("Username", currentUser);
            model.addAttribute("itemarr", ItemList);
            model.addAttribute("cartArrList", CartList);

            return "cart";
        }


        CartList.get(itemNumber).setQuantity(quantity);

        model.addAttribute("itemarr", ItemList);
        model.addAttribute("cartArrList", CartList);
        model.addAttribute("Username", currentUser);

        return "cart";
    }

//    When User wants to delete one of their items
    @PostMapping(value = "/Cart", params = {"quantity", "itemNumber", "Delete"})
    public String deleteCart(Model model, @RequestParam int quantity, @RequestParam String itemNumber) {

        CartList.delete(Integer.parseInt(itemNumber));

        model.addAttribute("itemarr", ItemList);
        model.addAttribute("cartArrList", CartList);
        model.addAttribute("Username", currentUser);

        return "cart";
    }

//    When User wants to Purchase Items
    @PostMapping(value = "/Cart", params = {"Checkout"})
    public String checkoutCart(Model model) {

//        Error case where Item quantity is 0
        for(int i = 0; i < CartList.length(); i++)
        {
            if(CartList.get(i).getQuantity() == 0)
            {

                model.addAttribute("message", true);
                model.addAttribute("messageString", "Item '"+CartList.get(i).getName() +"' quantity is set to 0");
                model.addAttribute("Username", currentUser);
                model.addAttribute("itemarr", ItemList);
                model.addAttribute("cartArrList", CartList);

                return "cart";
            }
        }

        int NumberofItems = 0;
        double TotalCost = 0.0;

        for(int i = 0;i < CartList.length();i++)
        {
            NumberofItems = NumberofItems + CartList.get(i).getQuantity();
        }

        TotalCost = CartList.getCost();

        double tax = TotalCost - TotalCost*.9;

        TotalCost = TotalCost + tax;

        Date date = new Date();

//        Add to History
        History hist = new History(currentUser.username,TotalCost,NumberofItems,date);

        histrepo.save(hist);

//        Reduce amount of Stock in ItemList based on CartList

        for(int i = 0; i < CartList.length(); i++)
        {
            for(int j = 0; j < ItemList.length(); j++)
            {
                if(CartList.get(i).getName().equals(ItemList.get(j).getName()))
                {
                    ItemList.get(j).setQuantity(ItemList.get(j).getQuantity()-CartList.get(i).getQuantity());
                    System.out.println("found target");
                    break;
                }
            }
        }

        CartList.clear();

        return "redirect:ConfirmCheckout";
    }

    @RequestMapping("/ConfirmCheckout")
    public String ConfirmCheckout(Model model){

        ArrayList<History> hist =  histrepo.findAllByUsername(currentUser.username);

        History target = hist.get(hist.size()-1);

        model.addAttribute("history", target);
        model.addAttribute("Username", currentUser);

        return "ConfirmCheckout";
    }

    //    User Logs out
    @PostMapping(value = "/ConfirmCheckout", params ="Logout" )
    public String Logout(Model model){

//        Reset Values
        currentUser = new Users();

        return "redirect:Login";
    }

    //    User continues to shop
    @PostMapping(value="/ConfirmCheckout", params = "Continue")
    public String ContinueShopping(Model model){

        return "redirect:MainPage";
    }

    //    AccountSettings
    @RequestMapping("/AccountSettings")
    public String AccountSettings(Model model) {
        System.out.println(currentUser);
        model.addAttribute("Username", currentUser);


        return "AccountSettings";
    }

    @RequestMapping("/ChangePassword")
    public String ChangePassword() {
        return "ChangePasswordPage";
    }

//    @RequestMapping("/PurchaseHistory")
//    public String PurchaseHistory() {
//        return "PurchaseHistory";
//    }

    @RequestMapping("/SignUp")
    public String SignUp() {
        return "SignUp";
    }


    @RequestMapping(value = "/Login")
    public String Login(Model model) {
        model.addAttribute("users", currentUser);

        return "Login";
    }

    @PostMapping("/Login")
    public String getLog(@ModelAttribute Users user, Model model) {

        model.addAttribute("users", user);

        boolean Existdb = userrepo.existsUsersByUsernameAndPassword(user.getUsername(), user.getPassword());

        this.currentUser = user;

        if(Existdb)
        {
            return "redirect:MainPage";
        }
        else {
            System.out.println("no user");
            model.addAttribute("message", "Error: Username doesn't exist or Password is wrong");
            return "Login";
        }


    }

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/PurchaseHistory")
    public String getPurchaseHistory(@ModelAttribute History userHistory, Model model) throws IOException {

        ArrayList<History> userPurchaseHistory = histrepo.findAllByUsername(currentUser.getUsername());
        ArrayList<String> formattedPurchaseHistory = new ArrayList<>();

        model.addAttribute("History", userPurchaseHistory);
        model.addAttribute("Username", currentUser);

//        FOUND ERROR HERE
//        double purchasePrice = userPurchaseHistory.get(0).getTotal();
//        System.out.println("Purchase price: " + purchasePrice);
//
        for (int i = 0; i < userPurchaseHistory.size(); i++) {
            String formattedPurchase = mapper.writeValueAsString(userPurchaseHistory.get(i));
            formattedPurchaseHistory.add(formattedPurchase);
        }

        for (int i = 0; i < formattedPurchaseHistory.size(); i++) {
            System.out.println(formattedPurchaseHistory.get(i));
            Object currentItem = formattedPurchaseHistory.get(i);
            for (int j = 0; j < 4; j++) {

            }
        }

//        System.out.println(formattedPurchaseHistory);
        System.out.println("Size of purchase history: " + userPurchaseHistory.size());

        return "PurchaseHistory";
    }

    @PostMapping("/ChangePassword")
    public String changePassword(@ModelAttribute Users user, Model model) {

        model.addAttribute("users", user);
        System.out.println(user.newPassword);
        System.out.println("hello");
        System.out.println(user.password);
//        System.out.println("Current user: " + currentUser.username);
        boolean Existdb = userrepo.existsUsersByUsernameAndPassword(currentUser.getUsername(), currentUser.getPassword());

        System.out.println(user);
        System.out.println(" ");
        System.out.println(currentUser);

        if(Existdb && (user.password.equals(currentUser.password)))
        {
            currentUser.setPassword(user.newPassword);
            userrepo.save(currentUser);
            System.out.println("Successfully changed password");
//            repo.changePassword(user.getUsername(), user.setPassword());
            return "Login";
        }
        else {
            System.out.println("no user");
            model.addAttribute("message", "Error: Username doesn't exist or Password is wrong");
            return "AccountSettings";
        }
    }
    @PostMapping("/SignUp")
    public String getSubmit(@ModelAttribute Users user, Model model) {
        model.addAttribute("users", user);
        System.out.println("3");
        boolean Existdb = userrepo.existsUsersByUsername(user.getUsername());
        System.out.println("4");
        if (Existdb) {
            System.out.println("exist");
            model.addAttribute("message", "Error: Username exist in the Database");
            return "SignUp";
        } else {
            System.out.println("new user added");
            userrepo.save(user);
            return "Login";
        }

    }

}
