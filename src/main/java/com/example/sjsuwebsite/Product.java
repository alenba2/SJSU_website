package com.example.sjsuwebsite;

/**
 *
 * the product interface handles the way we implement our items in the application
 *
 */
public interface Product{
    /**
     *
     * the printItem() method prints the name of the product that it is called on
     *
     */
    void printItem();

    /**
     * @return calls getName() to get the name of our product
     */
    String getName();

    /**
     *
     *
     * the setQuantity() method sets the amount of stock there is for a certain item we have in our shop
     *
     * @param quantity
     */
    void setQuantity(int quantity);

    /**
     * @return gets the stock/quantity of the item this method is called on
     */
    int getQuantity();

    /**
     * @return this method returns the cost of the item it is called on
     */
    double getCost();

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    Object clone() throws CloneNotSupportedException;
}
