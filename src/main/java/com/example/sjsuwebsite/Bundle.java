package com.example.sjsuwebsite;

import java.util.ArrayList;

/**
 *
 * Leaf Component
 *
 * Bundle class that implement Product and Cloneable
 */
public class Bundle implements Product,Cloneable{
    ArrayList<Item> items = new ArrayList<>();
    int Quantity = 0;

    /**
     *
     * return the total cost of the bundle
     *
     * @return
     *
     * For every item in the array list of items
     * add all the costs up and return the total amount for the bundle
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
     *
     * Return quantity of bundle
     *
     * @return
     *
     * Will get quantity of certain bundle and return it as an integer
     */
    public int getQuantity()
    {
        return Quantity;
    }

    /**
     *
     * Return True if quantity is > 0, False if not
     *
     * @return
     *
     * Used getQuantity to check if the quantity is more than 0 or not
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
     *
     * Add an item to the bundle
     *
     * @param item
     *
     * Take the item parameter and add it to the array list of items
     */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     *
     * Return the description of the bundle
     *
     * @return
     *
     * For every item in the array list of items, we add the item's name and
     * description to the bundle's description and return it as a String
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
     *
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
     *
     * Return "Bundle" as a String
     *
     * @return
     *
     * Return the name of the bundle, in this case it is just call "Bundle"
     */
    @Override
    public String getName() {
        return "Bundle";
    }

    /**
     * Set bundle's quantity
     *
     * @param quantity
     *
     * Function take the quantity parameter and set it to the bundle's quantity
     */
    @Override
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    /**
     * Return an Bundle Object
     *
     * @return
     *
     * Using the clone method to clone an item, cast it as a Bundle and return it.
     *
     * @throws CloneNotSupportedException
     *
     * Throw a CloneNotSupportedException exception
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        return (Bundle) super.clone();
    }

}
