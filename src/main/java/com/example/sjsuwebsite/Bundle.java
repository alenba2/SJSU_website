package com.example.sjsuwebsite;

import java.util.ArrayList;

public class Bundle implements Product{
    ArrayList<Item> items = new ArrayList<>();

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

        int min = items.get(0).getQuantity();

        for(int i = 1;  i < items.size() ; i++)
        {
            if(min < items.get(i).getQuantity())
            {
                min = items.get(i).getQuantity();
            }
        }

        return min;
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
}
