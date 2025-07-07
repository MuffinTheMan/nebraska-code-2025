package org.refactoring.example1.after;

public class OrderUtil {
    /**
     * Calculates the total cost for the specified order, including tax, discounts, and shipping.
     *
     * @param order the order for which the total cost is calculated
     * @return the total cost of the order as a double value
     * @deprecated This method is deprecated. Use {@link Order#calculateTotal()} directly.
     */
    @Deprecated
    public static double calculateTotal(Order order) {
        return order.calculateTotal();
    }
}
