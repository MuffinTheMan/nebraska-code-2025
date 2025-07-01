package org.refactoring.example1.after;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.api.Assertions.assertAll;

class OrderUtilUnitTest {

    @Test
    void calculateTotal() {
        // Test multiple scenarios using assertAll
        assertAll(
            // Small order (<$100): No discount, $20 shipping, 7% tax
            () -> {
                Order smallOrder = createOrder(50.0, 1);
                double total = OrderUtil.calculateTotal(smallOrder);

                // For small orders, verify that the total is approximately what we expect
                assertThat(total).as("Small order total")
                    .isCloseTo(75.0, within(1.0)); // Approximately $75 (with some tolerance)
            },

            // Medium order ($100-$500): 5% discount, $20 shipping, 7% tax
            () -> {
                Order mediumOrder = createOrder(75.0, 2); // $150 total
                double total = OrderUtil.calculateTotal(mediumOrder);

                // For medium orders, verify that the total is approximately what we expect
                assertThat(total).as("Medium order total")
                    .isCloseTo(173.875, within(1.0)); // Approximately $173.875 (with some tolerance)
            },

            // Large order ($500-$1000): 7.5% discount, no shipping, 7% tax
            () -> {
                Order largeOrder = createOrder(100.0, 6); // $600 total
                double total = OrderUtil.calculateTotal(largeOrder);

                // For large orders, verify that the total is approximately what we expect
                assertThat(total).as("Large order total")
                    .isCloseTo(593.85, within(1.0)); // Approximately $593.85 (with some tolerance)
            },

            // Very large order (>$1000): 10% discount, no shipping, 7% tax
            () -> {
                Order veryLargeOrder = createOrder(200.0, 6); // $1200 total
                double total = OrderUtil.calculateTotal(veryLargeOrder);

                // For very large orders, verify that the total is approximately what we expect
                assertThat(total).as("Very large order total")
                    .isCloseTo(1155.60, within(1.0)); // Approximately $1155.60 (with some tolerance)
            },

            // Edge case: exactly $100 (no discount, $20 shipping, 7% tax)
            () -> {
                Order edgeOrder1 = createOrder(100.0, 1);
                double total = OrderUtil.calculateTotal(edgeOrder1);

                // For $100 orders, verify that the total is approximately what we expect
                assertThat(total).as("$100 order total")
                    .isCloseTo(128.0, within(1.0)); // Approximately $128 (with some tolerance)
            },

            // Edge case: exactly $500 (5% discount, no shipping, 7% tax)
            () -> {
                Order edgeOrder2 = createOrder(100.0, 5); // $500 total
                double total = OrderUtil.calculateTotal(edgeOrder2);

                // For $500 orders, verify that the total is approximately what we expect
                assertThat(total).as("$500 order total")
                    .isCloseTo(508.25, within(1.0)); // Approximately $508.25 (with some tolerance)
            },

            // Edge case: exactly $1000 (7.5% discount, no shipping, 7% tax)
            () -> {
                Order edgeOrder3 = createOrder(200.0, 5); // $1000 total
                double total = OrderUtil.calculateTotal(edgeOrder3);

                // For $1000 orders, verify that the total is approximately what we expect
                assertThat(total).as("$1000 order total")
                    .isCloseTo(989.75, within(1.0)); // Approximately $989.75 (with some tolerance)
            },

            // Multiple items: Small order with multiple items (<$100)
            () -> {
                double[] prices = {20.0, 30.0};
                int[] quantities = {1, 1};
                Order multiItemSmallOrder = createOrderWithMultipleItems(prices, quantities);
                double total = OrderUtil.calculateTotal(multiItemSmallOrder);

                // For small orders with multiple items, verify that the total is approximately what we expect
                assertThat(total).as("Small order with multiple items total")
                    .isCloseTo(75.0, within(1.0)); // Approximately $75 (with some tolerance)
            },

            // Multiple items: Medium order with multiple items ($100-$500)
            () -> {
                double[] prices = {40.0, 60.0, 80.0};
                int[] quantities = {1, 1, 1};
                Order multiItemMediumOrder = createOrderWithMultipleItems(prices, quantities);
                double total = OrderUtil.calculateTotal(multiItemMediumOrder);

                // For medium orders with multiple items, verify that the total is approximately what we expect
                assertThat(total).as("Medium order with multiple items total")
                    .isCloseTo(204.37, within(1.0)); // Approximately $204.37 (with some tolerance)
            },

            // Multiple items: Large order with multiple items ($500-$1000)
            () -> {
                double[] prices = {100.0, 200.0, 300.0};
                int[] quantities = {1, 1, 1};
                Order multiItemLargeOrder = createOrderWithMultipleItems(prices, quantities);
                double total = OrderUtil.calculateTotal(multiItemLargeOrder);

                // For large orders with multiple items, verify that the total is approximately what we expect
                assertThat(total).as("Large order with multiple items total")
                    .isCloseTo(593.85, within(1.0)); // Approximately $593.85 (with some tolerance)
            },

            // Multiple items: Very large order with multiple items (>$1000)
            () -> {
                double[] prices = {200.0, 300.0, 400.0, 500.0};
                int[] quantities = {1, 1, 1, 1};
                Order multiItemVeryLargeOrder = createOrderWithMultipleItems(prices, quantities);
                double total = OrderUtil.calculateTotal(multiItemVeryLargeOrder);

                // For very large orders with multiple items, verify that the total is approximately what we expect
                assertThat(total).as("Very large order with multiple items total")
                    .isCloseTo(1348.2, within(1.0)); // Approximately $1348.2 (with some tolerance)
            },

            // Multiple items: Order with varying quantities
            () -> {
                double[] prices = {50.0, 75.0, 100.0};
                int[] quantities = {2, 3, 1};
                // Total before discounts and taxes: (50*2) + (75*3) + (100*1) = 100 + 225 + 100 = 425
                Order multiItemVaryingQuantities = createOrderWithMultipleItems(prices, quantities);
                double total = OrderUtil.calculateTotal(multiItemVaryingQuantities);

                // For orders with varying quantities, verify that the total is approximately what we expect
                assertThat(total).as("Order with varying quantities total")
                    .isCloseTo(431.44, within(1.0)); // Approximately $431.44 (with some tolerance)
            }
        );
    }

    /**
     * Helper method to create an order with items of a specific price and quantity
     */
    private Order createOrder(double itemPrice, int quantity) {
        Item item = new Item();
        item.setSku(1L);
        item.setTitle("Test Item");
        item.setPrice(itemPrice);

        LineItem lineItem = new LineItem(quantity, item);
        List<LineItem> lineItems = new ArrayList<>();
        lineItems.add(lineItem);

        Order order = new Order();
        order.setOrderNumber(1L);
        order.setLineItems(lineItems);

        return order;
    }

    /**
     * Helper method to create an order with multiple line items
     */
    private Order createOrderWithMultipleItems(double[] prices, int[] quantities) {
        if (prices.length != quantities.length) {
            throw new IllegalArgumentException("Prices and quantities arrays must have the same length");
        }

        List<LineItem> lineItems = new ArrayList<>();

        for (int i = 0; i < prices.length; i++) {
            Item item = new Item();
            item.setSku((long) (i + 1));
            item.setTitle("Test Item " + (i + 1));
            item.setPrice(prices[i]);

            LineItem lineItem = new LineItem(quantities[i], item);
            lineItems.add(lineItem);
        }

        Order order = new Order();
        order.setOrderNumber(1L);
        order.setLineItems(lineItems);

        return order;
    }
}
