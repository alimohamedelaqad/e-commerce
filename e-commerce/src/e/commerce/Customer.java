/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce;

public class Customer {

    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    
    // Getters and setters
    public String getName() { return name; }
    public double getBalance() { return balance; }
    
    public void deductBalance(double amount) {
        balance -= amount;
    }
    
    }
