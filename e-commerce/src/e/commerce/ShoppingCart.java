/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce;
import java.util.ArrayList;
import java.util.List;
public class ShoppingCart {
    private List<Cartitem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        // Check if product already in cart
        for (Cartitem item : items) {
            if (item.getProduct().equals(product)) {
                item = new Cartitem(product, item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new Cartitem(product, quantity));
    }

    public List<Cartitem> getItems() {
        return items;
    }
    
    public double calculateSubtotal() {
        return items.stream()
            .mapToDouble(Cartitem::getTotalPrice)
            .sum();
    }
        public boolean isEmpty() {
        return items.isEmpty();
    }
}
