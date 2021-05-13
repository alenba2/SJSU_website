package com.example.sjsuwebsite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ItemSystem implements Product, Cloneable{
    private List<Product> list = new ArrayList<>();

    /**
     *
     */
    public void printItem()
    {
        for(Product pro: list)
        {
            pro.printItem();
        }
    }

    /**
     * @param prod
     */
    public void add(Product prod)
    {
        int counter = -1;

        for(int i = 0; i < list.size(); i++)
        {
            if(prod.getName().equals(list.get(i).getName()))
            {
                counter = i;
                break;
            }
        }

        if(counter >= 0)
        {
            list.get(counter).setQuantity(prod.getQuantity());
        }
        else{
            list.add(prod);
        }
    }

    /**
     * @return
     */
    public String getName()
    {
        String name = "";

        for(Product prod: list)
        {
            name = name + prod.getName() + " ";
        }

        return name;
    }

    /**
     * @param quantity
     */
    @Override
    public void setQuantity(int quantity) {
    }

    /**
     * @return
     */
    @Override
    public int getQuantity() {
        return -1;
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    /**
     * @param Number
     * @return
     */
    public Product get(int Number)
    {
        return list.get(Number);
    }

    /**
     * @return
     */
    @Override
    public double getCost(){

//        Gets the total number based on the number of quantity

        double price = 0.00;

        for(Product item: list)
        {
            price = price + item.getCost()*item.getQuantity();
        }

        return price;
    }

    /**
     * @return
     */
    public int length()
    {
        return list.size();
    }

    /**
     * @param number
     */
    public void delete(int number)
    {
        list.remove(number);
    }

    /**
     *
     */
    public void clear()
    {
        list.clear();
    }
}
