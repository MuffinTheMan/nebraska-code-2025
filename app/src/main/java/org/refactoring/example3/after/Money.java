package org.refactoring.example3.after;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Money {
    private final BigDecimal fixedPrecisionAmount;

    public Money(@NonNull Double amount) {
        this.fixedPrecisionAmount = BigDecimal.valueOf(amount);
    }

    public double roundedToNearestCent() {
        return fixedPrecisionAmount.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public Money add(@NonNull Money other) {
        return new Money(fixedPrecisionAmount.add(other.fixedPrecisionAmount));
    }

    public Money subtract(@NonNull Money other) {
        return new Money(fixedPrecisionAmount.subtract(other.fixedPrecisionAmount));
    }

    public Money multiply(@NonNull Double multiplier) {
        return new Money(fixedPrecisionAmount.multiply(BigDecimal.valueOf(multiplier)));
    }

    public Money divide(@NonNull Money divisor) {
        return new Money(fixedPrecisionAmount.divide(divisor.fixedPrecisionAmount, 2, RoundingMode.HALF_UP));
    }
}
