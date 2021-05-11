package com.example.sjsuwebsite;

import java.util.ArrayList;

public class Bundle implements Product,Cloneable{
    ArrayList<Item> items = new ArrayList<>();
    int Quantity = 0;

    public double getCost() {
        double price = 0.0;

        for(Item item: items)
        {
            price = price + item.getCost();
        }

        price = price - (price*0.1);

        return price;
    }

    public int getQuantity()
    {
        return Quantity;
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


    public void addItem(Item item)
    {
        items.add(item);
    }

    public String getDescription() {
        String Description = "Special Bundle that includes: <br/>";

        for (Item item: items)
        {
            Description = Description +"<strong>"+item.getName() +"</strong>"+ ": " + item.getDescription() + " <br/>";
        }

        return Description;
    }

    @Override
    public void printItem() {

        System.out.println("Bundle Class:( ");

        for(Item item: items)
        {
            item.printItem();
        }
        System.out.println(" )");
    }

    @Override
    public String getName() {
        return "Bundle";
    }

    @Override
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return (Bundle) super.clone();
    }

}
