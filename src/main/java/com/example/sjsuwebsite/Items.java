package com.example.sjsuwebsite;

public class Items {
    private String Name;
    private int Stock;
    private String Description;
    private double Cost;

    public Items(String name, int stock, String description,double cost) {
        Name = name;
        Stock = stock;
        Description = description;
        Cost = cost;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
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
