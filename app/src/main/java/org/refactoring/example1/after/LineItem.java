package org.refactoring.example1.after;

public record LineItem(int quantity, Item item) {
    public double calculateSubTotal() {
        return quantity * item.getPrice();
    }
}
