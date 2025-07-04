/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce;

/**
 *
 * @author ali mohamed
 */
public class nonshippleproduct extends Product {

    public nonshippleproduct(String name, double price, int quantity) {
        super(name, price, quantity);

    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean requiresShipping() {
        return false;
    }

}
