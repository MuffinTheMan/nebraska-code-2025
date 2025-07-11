package org.refactoring.example3.after;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rent {
    @NonNull
    private Money baseRent;
    @NonNull
    private Money amenityPremium;
    @NonNull
    private Money utilitiesCost;
    @NonNull
    private LeaseTerm term;

    public Rent(@NonNull Double baseRent, @NonNull Double amenityPremium, @NonNull Double utilitiesCost, @NonNull LeaseTerm term) {
        this(new Money(baseRent), new Money(amenityPremium), new Money(utilitiesCost), term);
    }

    public double calculateMonthlyPayment() {
        return calculateTermAdjustedTotalRent().add(utilitiesCost).roundedToNearestCent();
    }

    public Money calculateTermAdjustedTotalRent() {
        double termAdjustment = term.getTermAdjustment();
        return (baseRent.add(amenityPremium)).multiply(termAdjustment);
    }
}
