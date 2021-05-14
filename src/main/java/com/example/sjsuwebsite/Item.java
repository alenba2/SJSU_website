package com.example.sjsuwebsite;


/**
 *  Item class that implements Product and Cloneable
 */
public class Item implements Product,Cloneable {
    private String Name;
    private int Quantity;
    private String Description;
    private double Cost;


    /**
     * Constructor for an Item class
     * @param name
     * Set item's name
     * @param quantity
     * Set item's quantity
     * @param description
     * Set item's description
     * @param cost
     * Set item's cost
     */
    public Item(String name, int quantity, String description, double cost) {
        Name = name;
        Quantity = quantity;
        Description = description;
        Cost = cost;
    }

    /**
     * Get the item's cost
     * @return
     * Return the cost of an item as a double
     */
    public double getCost() {
        return Cost;
    }


    /**
     * Set the item's cost
     * @param cost
     * Make the cost parameter the item's cost
     */
    public void setCost(double cost) {
        Cost = cost;
    }

    /**
     *
     * Get the name of the item
     * @return
     * Return name of item as a String
     *
     */
    public String getName() {
        return Name;
    }

    /**
     * Print the item
     */
    public void printItem(){
        System.out.println("Item class: " + Name);
    }

    /**
     * Set the item's name
     * @param name
     * Take the name parameter and make it the item's name
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Quantity of item
     * @return
     * Return the quantity of a certain item
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * Set the item's quantity
     * @param quantity
     * Take the parameter quantity and set it to the item's quantity
     */
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    /**
     * Return an Item Object
     *
     * @return
     * Call the clone method of the Object class, clone the item and return it as an Item
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        return (Item) super.clone();
    }

    /**
     * Return True if quantity is > 0
     * False if not
     *
     * @return
     *
     * Check to see if the item's quantity is more than 0, return true if it is
     * false if it not
     *
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
     * Return the description of item
     * @return
     * Get the description of item and return it as a String
     */
    public String getDescription() {
        return Description;
    }

    /**
     * Set the description for item
     * @param description
     * Set the description parameter to the item's description
     */
    public void setDescription(String description) {
        Description = description;
    }
}
