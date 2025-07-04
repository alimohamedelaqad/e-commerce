/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package e.commerce;

/**
 *
 * @author ali mohamed
 */
import java.time.LocalDate;

public class ECommerce {
        public static void main(String[] args) {

        Product cheese = new PerishableProduct("Cheese", 100, 10, 0.4, LocalDate.now().plusDays(7));
Product biscuits = new PerishableProduct("Biscuits", 150, 5, 0.7, LocalDate.now().plusDays(14));
Product tv = new StandardProduct("TV", 1000, 2, 5.5);

Customer customer = new Customer("Alice", 2000);

ShoppingCart cart = new ShoppingCart();
cart.addItem(cheese, 2);
cart.addItem(biscuits, 1);

CheckoutService checkoutService = new CheckoutService(new ShippingService());
checkoutService.checkout(customer, cart);
        // Create services
        ShippingService shippingService = new ShippingService();
        
        // Process checkout
        try {
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
  
    }

}