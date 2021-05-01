package com.example.sjsuwebsite;

import java.util.ArrayList;

public class Bundle implements Product{
    ArrayList<Item> items = new ArrayList<>();

    public double getPrice() {
        double price = 0.0;
        for(Item item: items)
        {
            price = price + item.getCost();
        }

        price = price - (price*0.1);

        return price;
    }

    public void addItem(Item item)
    {
        items.add(item);
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
        return null;
    }
}
