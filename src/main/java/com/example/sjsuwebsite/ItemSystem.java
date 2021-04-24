package com.example.sjsuwebsite;

import java.util.ArrayList;
import java.util.List;

public class ItemSystem implements Product{
    private List<Product> list = new ArrayList<Product>();

    public void printItem()
    {
        for(Product pro: list)
        {
            pro.printItem();
        }
    }

    public void add(Product prod)
    {
        list.add(prod);
    }
}
