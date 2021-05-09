package com.example.sjsuwebsite.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public String toString(){
        return "History for " + username;
    }
}
