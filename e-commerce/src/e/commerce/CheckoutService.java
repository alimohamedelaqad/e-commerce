/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CheckoutService {

    private static final double SHIPPING_FEE_PER_KG = 30.0;
    private ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, ShoppingCart cart) {
        // Validate cart
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cannot checkout with empty cart");
        }

        // Validate products
        for (Cartitem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product.getquantity() < item.getQuantity()) {
                throw new IllegalStateException(
                        "Product " + product.getName() + " is out of stock");
            }

            if (product.isExpired()) {
                throw new IllegalStateException(
                        "Product " + product.getName() + " is expired");
            }
        }

        // Validate customer balance
        double subtotal = cart.calculateSubtotal();
        double shippingFee = calculateShippingFee(cart);
        double totalAmount = subtotal + shippingFee;

        if (customer.getBalance() < totalAmount) {
            throw new IllegalStateException("Insufficient balance");
        }

        // Process shipping
        List<Shippable> shippableItems = getShippableItems(cart);
        if (!shippableItems.isEmpty()) {
            shippingService.shipItems(shippableItems);
        }

        // Process payment
        customer.deductBalance(totalAmount);

        for (Cartitem item : cart.getItems()) {
            Product product = item.getProduct();
            product.setquantity(product.getquantity() - item.getQuantity());
        }

        // Print receipt
        printReceipt(cart, subtotal, shippingFee, totalAmount, customer);
    }

    private double calculateShippingFee(ShoppingCart cart) {
        double totalWeight = cart.getItems().stream()
                .filter(item -> item.getProduct().requiresShipping())
                .mapToDouble(item -> ((Shippable) item.getProduct()).getWeight() * item.getQuantity())
                .sum();

        return totalWeight * SHIPPING_FEE_PER_KG;
    }

    private List<Shippable> getShippableItems(ShoppingCart cart) {
        return cart.getItems().stream()
                .filter(item -> item.getProduct().requiresShipping())
                .flatMap(item -> Collections.nCopies(item.getQuantity(), (Shippable) item.getProduct()).stream())
                .collect(Collectors.toList());
    }

    private void printReceipt(ShoppingCart cart, double subtotal, double shippingFee,
            double totalAmount, Customer customer) {
        System.out.println("** Checkout receipt **");

        for (Cartitem item : cart.getItems()) {
            System.out.printf("%dx %s    %.0f%n",
                    item.getQuantity(),
                    item.getProduct().getName(),
                    item.getTotalPrice());
        }

        System.out.println("---");
        System.out.printf("Subtotal    %.0f%n", subtotal);
        System.out.printf("Shipping    %.0f%n", shippingFee);
        System.out.printf("Amount    %.0f%n", totalAmount);
        System.out.printf("Remaining balance: %.0f%n", customer.getBalance());
        System.out.println("END.");
    }
}
