package com.example.sjsuwebsite;

import java.util.ArrayList;

/**
 *
 */
public class Bundle implements Product,Cloneable{
    ArrayList<Item> items = new ArrayList<>();
    int Quantity = 0;

    /**
     * @return
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
     * @return
     */
    public int getQuantity()
    {
        return Quantity;
    }

    /**
     * @return
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
     */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     * @return
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
     * @return
     */
    @Override
    public String getName() {
        return "Bundle";
    }

    /**
     * @param quantity
     */
    @Override
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        return (Bundle) super.clone();
    }

}
