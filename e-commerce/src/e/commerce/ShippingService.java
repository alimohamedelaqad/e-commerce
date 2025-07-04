/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce;
import java.util.List;
public class ShippingService {
    public void shipItems(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        
        for (Shippable item : items) {
            System.out.printf("%dx %s    %.0fg%n", 
                getItemQuantity(item.getName()), 
                item.getName(), 
                item.getWeight() * 1000);
            totalWeight += item.getWeight();
        }
        
        System.out.printf("Total package weight %.1fkg%n%n", totalWeight);
    }
    
    private long getItemQuantity(String name) {

        return 1;
    }
}
