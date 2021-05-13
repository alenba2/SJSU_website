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

/**
 * Controller
 *
 * Displays .jsp files depending on the type of URL
 *
 * the base URL that is required to start the project: localhost:8008
 *
 * Then it will run any method based on the URL including the base URL
 *
 */
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

    }


    /**
     * This is called when User goes to specified URL
     *
     * @param model
     *
     * Model is needed to add attribute to the URL so the .jsp file can get those data from the Controller
     *
     * @return
     *
     * What it returns is the name of the .jsp file that will be displayed for the URL /MainPage
     */
    @RequestMapping("/MainPage")
    public String MainPage(Model model) {
        model.addAttribute("Username", currentUser);
        model.addAttribute("Cart", CartList);
        model.addAttribute("Item", ItemList);
        model.addAttribute("message", message);
        message = false;

        return "MainPage";
    }


    /**
     * This is called when User goes to specified URL
     *
     * @param ItemNumber
     *
     * The ItemNumber will be grabbed from the URL and it will display the Item based on the ItemNumber.
     *
     * @param model
     *
     * The Item that was received from the ItemNumber will then will be stored to the Model
     *
     * @return
     *
     * What it returns is the name of the .jsp file that will be displayed for the URL /ItemPage
     */
    @RequestMapping("/ItemPage")
    public String ItemPage(@RequestParam(name = "ItemNumber") int ItemNumber, Model model) {

        model.addAttribute("Item", ItemList.get(ItemNumber));
        model.addAttribute("ItemNumber", ItemNumber);
        model.addAttribute("Username", currentUser);


        return "ItemPage";
    }

    /**
     * This is called when User enters/submits data
     *
     * @param Stock
     *
     * The Stock is needed to put the number of stock to the CartList, if the Stock number is 0, It will
     * Post an error to the .jsp file
     *
     * @param ItemNumber
     *
     * The ItemNumber is needed to get which item from the ItemList that it needs to be copied and set the number of
     * Stock
     *
     * @param model
     *
     * The Model is needed to put attributes to the URL
     *
     * @return
     *
     * Then it will redirect to the MainPage
     */

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

    /**
     * This is called when User goes to specified URL
     *
     * @param model
     *
     * Model is needed to set attributes to the URL
     *
     * @return
     *
     * The method returns the page named cart.jsp with the URL /Cart
     *
     */

    //    CartPage on startup
    @RequestMapping("/Cart")
    public String Cart(Model model) {

        model.addAttribute("itemarr", ItemList);
        model.addAttribute("cartArrList", CartList);
        model.addAttribute("Username", currentUser);

        return "cart";
    }

    /**
     * This is called when User enters data
     *
     * @param model
     *
     * Model is used to add attributes to the URL
     *
     * @param quantity
     *
     * The quantity is needed to change the quantity from the
     * CartList. If the quantity is below 0, It will shoot an error
     * to the .jsp file instead
     *
     * @param itemNumber
     *
     * The itemNumber is needed to get which item in the cart that needs
     * modifying
     *
     * @return
     *
     * Both quantity less than equal to -1 and above -1 will return cart.jsp file with the URL /Cart
     *
     */
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

    /**
     *
     * This is called when User enters data
     *
     * @param model
     *
     * Model is needed to add attributes to the URL
     *
     * @param itemNumber
     *
     * ItemNumber is needed to know which part of the ArrayList is needed to be deleted
     *
     * @return
     *
     * returns cart.jsp file and the URL will be /Cart
     *
     */
//    When User wants to delete one of their items
    @PostMapping(value = "/Cart", params = {"quantity", "itemNumber", "Delete"})
    public String deleteCart(Model model, @RequestParam String itemNumber) {

        CartList.delete(Integer.parseInt(itemNumber));

        model.addAttribute("itemarr", ItemList);
        model.addAttribute("cartArrList", CartList);
        model.addAttribute("Username", currentUser);

        return "cart";
    }

    /**
     *
     * This is called when User enters data
     *
     * @param model
     *
     * Model is needed to add attributes to the URL
     *
     * @return
     *
     * If any of the CartList has a quantity of 0, then it will shoot an error and
     * return cart.jsp with the URL /Cart
     *
     * If not, The CartList will add up all the quantity and the cost and put those data to
     * the History class, along with the date that it was created and currentUsers' name
     *
     * Then it will reduce the amount of stock based on the CartList and subtract the corresponding items on ItemList
     *
     * Then It will clear the cart and redirect to the ConfirmCheckout
     */
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

                    break;
                }
            }
        }

        CartList.clear();

        return "redirect:ConfirmCheckout";
    }

    /**
     *
     * This is called when User goes to the specified URL
     *
     * @param model
     *
     * Model is needed to add attributes to the URL
     *
     * @return
     *
     * It will return ConfirmCheckout.jsp with the URL /ConfirmCheckout
     */
    @RequestMapping("/ConfirmCheckout")
    public String ConfirmCheckout(Model model){

        ArrayList<History> hist =  histrepo.findAllByUsername(currentUser.username);

        History target = hist.get(hist.size()-1);

        model.addAttribute("history", target);
        model.addAttribute("Username", currentUser);

        return "ConfirmCheckout";
    }

    /**
     *
     * This is called when User enters data
     *
     * @param model
     *
     * Model is needed to add attributes to the URL
     *
     * @return
     *
     * Removes data from currentUser by making it as a new User
     *
     * Redirects to Login
     */
    //    User Logs out
    @PostMapping(value = "/ConfirmCheckout", params ="Logout" )
    public String Logout(Model model){

//        Reset Values
        currentUser = new Users();

        return "redirect:Login";
    }

    /**
     *
     * This is called when User enters data
     *
     * @param model
     *
     * Model is needed to add attributes to Model
     *
     * @return
     *
     * Redirects to MainPage
     */
    //    User continues to shop
    @PostMapping(value="/ConfirmCheckout", params = "Continue")
    public String ContinueShopping(Model model){

        return "redirect:MainPage";
    }

    /**
     *
     * This is called when User goes to the specified URL
     *
     * @param model
     *
     * Model is needed to add attributes to Model
     *
     * @return
     *
     * returns AccountSettings.jsp with URL /AccountSettings
     *
     */
    //    AccountSettings
    @RequestMapping("/AccountSettings")
    public String AccountSettings(Model model) {

        model.addAttribute("Username", currentUser);


        return "AccountSettings";
    }

    /**
     *
     * This is called when User goes to the specified URL
     *
     * @return
     *
     * returns ChangePasswordPage.jsp with the URL /ChangePassword
     */
    @RequestMapping("/ChangePassword")
    public String ChangePassword() {
        return "ChangePasswordPage";
    }


    /**
     *
     * This is called when User goes to the specified URL
     *
     * @return
     *
     * returns SignUp.jsp with the URL /SignUp
     *
     */
    @RequestMapping("/SignUp")
    public String SignUp() {
        return "SignUp";
    }


    /**
     *
     * This is called when User goes to the specified URL
     *
     * @param model
     *
     * Model is needed to add attributes to the URL
     *
     * @return
     *
     * return Login.jsp with the URL /Login
     */
    @RequestMapping(value = "/Login")
    public String Login(Model model) {
        model.addAttribute("users", currentUser);

        return "Login";
    }

    /**
     *
     * This is called when User enters data
     *
     * @param user
     *
     * A set of params is grabbed from the URL to form a class User
     *
     * @param model
     *
     * Model is needed to add attributes to the URL
     *
     * @return
     *
     * First it checks if the User exist in the database
     *
     * If the user does exist, It redirects to the MainPage
     *
     * If not the it will send a message to the .jsp and
     * returns Login.jsp and sets the URL /Login
     *
     */
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
            model.addAttribute("message", "Error: Username doesn't exist or Password is wrong");
            return "Login";
        }

    }

    private ObjectMapper mapper = new ObjectMapper();

    /**
     *
     * This is called when User goes to the specified URL
     *
     * @param userHistory
     *
     *
     *
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/PurchaseHistory")
    public String getPurchaseHistory(@ModelAttribute History userHistory, Model model) throws IOException {

        ArrayList<History> userPurchaseHistory = histrepo.findAllByUsername(currentUser.getUsername());
        ArrayList<String> formattedPurchaseHistory = new ArrayList<>();

        model.addAttribute("History", userPurchaseHistory);
        model.addAttribute("Username", currentUser);

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

    /**
     * @param user
     * @param model
     * @return
     */
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

    /**
     *
     * This is called when the User enters data
     *
     * @param user
     *
     * Grabs a set of params from the URL and turns
     * that data to be part of User class
     *
     * @param model
     *
     * Model is needed to add attributes to the URL
     *
     * @return
     *
     * First checks the database if the user exists in the database.
     *
     * If it does exist, then it send a Message to the .jsp file
     * and returns SignUp.jsp with the URL /SignUP
     *
     * If not, adds the the user to the database then
     * redirects to the Login
     *
     */

    @PostMapping("/SignUp")
    public String getSubmit(@ModelAttribute Users user, Model model) {
        model.addAttribute("users", user);

        boolean Existdb = userrepo.existsUsersByUsername(user.getUsername());

        if (Existdb) {
            System.out.println("exist");
            model.addAttribute("message", "Error: Username exist in the Database");
            return "SignUp";
        } else {
            userrepo.save(user);
            return "redirect:Login";
        }

    }

}
