package com.example.sjsuwebsite;


public class Item implements Product {
    private String Name;
    private int Quantity;
    private String Description;
    private double Cost;
    private String imageLocation;

    public Item(String name, int quantity, String description, double cost) {
        Name = name;
        Quantity = quantity;
        Description = description;
        Cost = cost;

        imageLocation = "/images/items/"+name+".png";
    }

    public double getPrice() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public String getName() {
        return Name;
    }

    public void printItem(){
        System.out.println("Item class: " + Name);
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImageLocation(){
        return imageLocation;
    }
}
