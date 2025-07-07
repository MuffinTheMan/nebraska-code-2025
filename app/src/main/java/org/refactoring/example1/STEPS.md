1. Ensure passing unit tests exist for existing functionality (`OrderUtil::calculateTotal`)
2. Copy logic from `OrderUtil::calculateTotal` to new instance method in `Order` class
3. Update `OrderUtil::calculateTotal` to simply return the value of the new `Order::calculateTotal` instance method
4. Ensure unit tests still pass
5. Create and use Magic Constant for `TAX_RATE`
6. Ensure unit tests still pass
7. Move `lineItem.quantity() * lineItem.item().getPrice()` into new `LineItem::calculateSubTotal` instance method
8. Ensure unit tests still pass
9. Move logic into new methods (ensuring unit tests still pass as you go)
    1. `Order::calculateLineItemSubTotal`
    2. `Order::calculateDiscount`
    3. `Order::calculateDiscountedSubTotal`
    4. `Order::calculateShipping`
    5. `Order::calculateUntaxedTotal`