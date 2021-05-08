package com.example.sjsuwebsite;


public class Item implements Product,Cloneable {
    private String Name;
    private int Quantity;
    private String Description;
    private double Cost;


    public Item(String name, int quantity, String description, double cost) {
        Name = name;
        Quantity = quantity;
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

    @Override
    public Object clone() throws CloneNotSupportedException{
        return (Item) super.clone();
    }

    public Boolean getStock()
    {
        if(getQuantity()>0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
