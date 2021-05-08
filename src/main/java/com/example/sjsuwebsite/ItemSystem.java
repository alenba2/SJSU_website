package com.example.sjsuwebsite;

import java.util.ArrayList;
import java.util.List;

public class ItemSystem implements Product, Cloneable{
    private List<Product> list = new ArrayList<>();

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

    public String getName()
    {
        String name = "";

        for(Product prod: list)
        {
            name = name + prod.getName() + " ";
        }

        return name;
    }

    @Override
    public void setQuantity(int quantity) {
    }

    @Override
    public int getQuantity() {
        return -1;
    }

    @Override
    public double getCost() {
        return -1;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    public Product get(int Number)
    {
        return list.get(Number);
    }

    public int length()
    {
        return list.size();
    }

    public void delete(int number)
    {
        list.remove(number);
    }


}
