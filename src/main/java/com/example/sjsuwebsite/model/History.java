package com.example.sjsuwebsite.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Date;

/**
 * Model
 *
 * This class is supposed to hold data that the user has purchased through the Checkout Page
 */
@Document(collection = "history")
public class History {

    @Id
    public String id;
    public String username;
    public Double total;
    public int quantity;
    public Date date;

    /**
     * @param username
     *
     * Username related to the User class
     *
     * @param total
     *
     * The total cost of the purchased item
     *
     * @param quantity
     *
     * The total amount of items inside the cart
     *
     * @param date
     *
     * The date when the item has been purchased
     */
    public History(String username, Double total, int quantity,Date date) {
        this.username = username;
        this.total = total;
        this.quantity = quantity;
        this.date = date;
    }

    /**
     * @return total
     *
     * returns the total from the History class
     */
    public Double getTotal() {
        return total;
    }


    /**
     * @return
     *
     * returns the date from the History class
     */
    public Date getDate() {
        return date;
    }
}
