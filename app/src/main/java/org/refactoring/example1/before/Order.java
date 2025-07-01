package org.refactoring.example1.before;

import java.util.SequencedCollection;

public class Order {
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
}
