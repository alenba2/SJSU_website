package com.example.sjsuwebsite;

/**
 *
 * Interface for Child: Bundle and Item
 *
 * For Composite Design Pattern
 *
 */
public interface Product{
    /**
     * prints the name of the product that this method is called on
     *
     * the printItem() method prints the name of the product that it is called on
     *
     */
    void printItem();

    /**
     * gets the name of the item that this method is called on
     *
     * @return calls getName() to get the name of our product
     */
    String getName();

    /**
     *sets the quantity of the item that this method is called on
     *
     * the setQuantity() method sets the amount of stock there is for a certain item we have in our shop
     *
     * @param quantity
     *
     * Grabs an int value and sets it as its quantity
     */
    void setQuantity(int quantity);

    /**
     *
     * gets the stock/quantity of the item this method is called on
     *
     * @return gets the stock/quantity of the item this method is called on
     */
    int getQuantity();

    /**
     * gets the cost of the item that we call this method on
     *
     * @return this method returns the cost of the item it is called on
     */
    double getCost();

    /**
     *
     * clone object that we use to duplicate our product without referring to the same address of the original product
     *
     * @return
     *
     * returns an cloned Object
     *
     * @throws CloneNotSupportedException
     *
     * Error case when Object is not cloneable
     *
     */
    Object clone() throws CloneNotSupportedException;
}
