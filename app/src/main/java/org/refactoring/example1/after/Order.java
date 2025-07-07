package org.refactoring.example1.after;

import java.util.SequencedCollection;

public class Order {
    private static final double TAX_RATE = 0.07;
    private long orderNumber;
    private SequencedCollection<LineItem> lineItems;

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public SequencedCollection<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(SequencedCollection<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    private double calculateLineItemSubTotal() {
        double subTotal = 0;
        for (LineItem lineItem : lineItems) {
            subTotal += lineItem.calculateSubTotal();
        }
        return subTotal;
    }

    private double calculateDiscount() {
        double subTotal = calculateLineItemSubTotal();
        if (subTotal > 1000) {
            return 0.1; // 10% discount
        } else if (subTotal > 500) {
            return 0.075; // 7.5% discount
        } else if (subTotal > 100) {
            return 0.05; // 5% discount
        }
        return 0; // No discount
    }

    private double calculateDiscountedSubTotal() {
        return calculateLineItemSubTotal() * (1 - calculateDiscount());
    }

    private int calculateShipping() {
        return calculateDiscountedSubTotal() < 250 ? 20 : 0;
    }

    private double calculateUntaxedTotal() {
        return calculateDiscountedSubTotal() + calculateShipping();
    }

    public double calculateTotal() {
        return calculateUntaxedTotal() * (1 + TAX_RATE);
    }
}
