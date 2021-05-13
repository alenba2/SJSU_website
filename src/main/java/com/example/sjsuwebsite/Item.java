package com.example.sjsuwebsite;


/**
 *
 */
public class Item implements Product,Cloneable {
    private String Name;
    private int Quantity;
    private String Description;
    private double Cost;


    /**
     * @param name
     * @param quantity
     * @param description
     * @param cost
     */
    public Item(String name, int quantity, String description, double cost) {
        Name = name;
        Quantity = quantity;
        Description = description;
        Cost = cost;
    }

    /**
     * @return
     */
    public double getCost() {
        return Cost;
    }


    /**
     * @param cost
     */
    public void setCost(double cost) {
        Cost = cost;
    }

    /**
     * @return
     */
    public String getName() {
        return Name;
    }

    /**
     *
     */
    public void printItem(){
        System.out.println("Item class: " + Name);
    }

    /**
     * @param name
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @return
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        return (Item) super.clone();
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
     * @return
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        Description = description;
    }
}
