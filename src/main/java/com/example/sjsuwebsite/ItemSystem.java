package com.example.sjsuwebsite;

import java.util.ArrayList;
import java.util.List;

public class ItemSystem implements Product{
    private List<Product> list = new ArrayList<>();

    public void printItem()
    {
        for(Product pro: list)
        {
            pro.printItem();
        }
    }

    public String getName()
    {
        String name = "";

        for(Product prod: list)
        {
            name = name + prod.getName() + " ";
        }

        return name;
    }

    public void add(Product prod)
    {
        list.add(prod);
    }

    public Product get(int Number)
    {
        return list.get(Number);
    }
}
