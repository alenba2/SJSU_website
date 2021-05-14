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
     * this method prints an item so we can check we are grabbing the correct item
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
     *
     * this add method adds an item to the list
     *
     * @param prod
     *
     * grabs product class and adds it to the List
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
     *
     * this method returns the name of a certain item in the list
     *
     * @return the name of the product in the list
     *
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
     *
     * Does nothing
     *
     * @param quantity
     *
     * grabs quantity, but does nothing
     */
    @Override
    public void setQuantity(int quantity) {
    }

    /**
     *
     * Does nothing
     *
     * @return
     *
     * Returns -1
     */
    @Override
    public int getQuantity() {
        return -1;
    }

    /**
     *
     * Does nothing
     *
     * @return
     *
     * does nothing
     *
     * @throws CloneNotSupportedException
     *
     * does nothing
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    /**
     * gets the specific product that this method is called on
     *
     * @param Number
     *
     * Gets number for the List
     *
     * @return
     *
     * puts out a Product based on the number
     */
    public Product get(int Number)
    {
        return list.get(Number);
    }

    /**
     *
     * the getCost() method is a function we use to display the cost of an item in our jsp pages
     *
     * @return the cost of an item
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
     * this method returns the size of the list that it is called on
     *
     * @return the size of our list
     */
    public int length()
    {
        return list.size();
    }

    /**
     *
     * this method deletes a product from the list
     *
     * @param number
     *
     * removes a product from the list based on the number
     */
    public void delete(int number)
    {
        list.remove(number);
    }

    /**
     *
     * Method clears the list
     *
     */
    public void clear()
    {
        list.clear();
    }
}
