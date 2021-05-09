package com.example.sjsuwebsite;

public interface Product{
    void printItem();
    String getName();
    void setQuantity(int quantity);
    int getQuantity();
    double getCost();
    Object clone() throws CloneNotSupportedException;
}
