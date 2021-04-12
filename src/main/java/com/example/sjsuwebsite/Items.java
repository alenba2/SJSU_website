package com.example.sjsuwebsite;

public class Items {
    private String Name;
    private int Stock;
    private String Description;

    public Items(String name, int stock, String description) {
        Name = name;
        Stock = stock;
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
