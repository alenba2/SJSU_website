package com.example.sjsuwebsite;

/**
 *
 */
public interface Product{
    /**
     *
     */
    void printItem();

    /**
     * @return
     */
    String getName();

    /**
     * @param quantity
     */
    void setQuantity(int quantity);

    /**
     * @return
     */
    int getQuantity();

    /**
     * @return
     */
    double getCost();

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    Object clone() throws CloneNotSupportedException;
}
