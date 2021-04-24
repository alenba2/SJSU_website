package com.example.sjsuwebsite;

import java.util.ArrayList;

public class Bundle implements Product{
    ArrayList<Item> items = new ArrayList<>();

    public double getPrice() {
        return 0;
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
}
