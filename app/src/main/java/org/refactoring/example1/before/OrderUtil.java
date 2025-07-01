package org.refactoring.example1.before;

public class OrderUtil {
    public static double calculateTotal(Order order) {
        double total = 0;
        for (LineItem lineItem : order.getLineItems()) {
            total += lineItem.quantity() * lineItem.item().getPrice();
        }

        if (total > 1000) {
            total *= 0.9; // 10% discount
        } else if (total > 500) {
            total *= 0.925; // 7.5% discount
        } else if (total > 100) {
            total *= 0.95; // 5% discount
        }

        if (total < 250) {
            total += 20; // $20 shipping
        }

        total *= 1.07; // 7% sales tax

        return total;
    }
}
