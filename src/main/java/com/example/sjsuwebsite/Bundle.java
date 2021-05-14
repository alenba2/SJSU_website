package com.example.sjsuwebsite;

import java.util.ArrayList;

/**
 * Bundle class that implement Product and Cloneable
 */
public class Bundle implements Product,Cloneable{
    ArrayList<Item> items = new ArrayList<>();
    int Quantity = 0;

    /**
     * @return The total cost of the bundle
     *
     */
    public double getCost() {
        double price = 0.0;

        for(Item item: items)
        {
            price = price + item.getCost();
        }

        price = price - (price*0.1);

        return price;
    }

    /**
     * @return Quantity of bundle
     */
    public int getQuantity()
    {
        return Quantity;
    }

    /**
     * @return True if quantity is > 0
     *          False if not
     */
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


    /**
     * @param item
     * Add an item to the bundle
     */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     * @return
     * The description of the bundle
     */
    public String getDescription() {
        String Description = "Special Bundle that includes: <br/>";

        for (Item item: items)
        {
            Description = Description +"<strong>"+item.getName() +"</strong>"+ ": " + item.getDescription() + " <br/>";
        }

        return Description;
    }

    /**
     *  Print every item in the bundle
     */
    @Override
    public void printItem() {

        System.out.println("Bundle Class:( ");

        for(Item item: items)
        {
            item.printItem();
        }
        System.out.println(" )");
    }

    /**
     * @return "Bundle"
     */
    @Override
    public String getName() {
        return "Bundle";
    }

    /**
     * @param quantity
     * set bundle's quantity
     */
    @Override
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    /**
     * @return  An Bundle Object
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        return (Bundle) super.clone();
    }

}
