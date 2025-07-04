/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce;


import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Product {
    private String Name;
    private double price;
    private int quantity;
    
    public Product(String Name, double price, int quantity){
        this.Name = Name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName(){return Name;}
    public double getprice(){return price;}
    public int getquantity(){return quantity;}
    public void setquantity(int quantity){this.quantity=quantity;}
    
        // Abstract method to check if product is expired
    public abstract boolean isExpired();
    
    // Method to check if product requires shipping
    public abstract boolean requiresShipping();
    
}
