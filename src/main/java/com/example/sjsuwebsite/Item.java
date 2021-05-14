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
     * Constructor for an Item that
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
     * getCost
     * @return Cost of item
     */
    public double getCost() {
        return Cost;
    }


    /**
     * setCost
     * @param cost
     * Set cost to Cost
     */
    public void setCost(double cost) {
        Cost = cost;
    }

    /**
     * getName
     * @return Name of item
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
     * @param name
     * Set name of item
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @return Quantity of item
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * @param quantity
     * Set quantity for item
     */
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    /**
     * @return A clone of the Object that call it
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        return (Item) super.clone();
    }

    /**
     * @return  True if quantity is > 0
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
     * @return Description of item
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     * Set the description for item
     */
    public void setDescription(String description) {
        Description = description;
    }
}
