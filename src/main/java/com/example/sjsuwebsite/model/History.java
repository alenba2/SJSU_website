package com.example.sjsuwebsite.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Date;

@Document(collection = "history")
public class History {

    @Id
    public String id;
    public String username;
    public Double total;
    public int quantity;
    public Date date;

    public History(String username, Double total, int quantity,Date date) {
        this.username = username;
        this.total = total;
        this.quantity = quantity;
        this.date = date;
    }

    public History() {

    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    @Override
//    public String toString(){
//        String[] history;
////        return "History = { " +
////                "Username: " + username + "\t" +
////                "| Price: " + total + "\t" +
////                "| Quantity: " + quantity + "\t" +
////                "| Date: " + date + " }";
////        return "Customer [name: " + username + ", price: " + total + "]";
//
//    }
}
