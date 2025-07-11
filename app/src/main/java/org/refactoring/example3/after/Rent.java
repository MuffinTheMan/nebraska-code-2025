package org.refactoring.example3.after;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;

@Getter
@Setter
@AllArgsConstructor
public class Rent {
    @NonNull
    private Double baseRent;
    @NonNull
    private Double amenityPremium;
    @NonNull
    private Double utilitiesCost;
    @NonNull
    private LeaseTerm term;

    public double calculateMonthlyPayment() {
        return Precision.round(calculateTermAdjustedTotalRent() + utilitiesCost, 2);
    }

    public double calculateTermAdjustedTotalRent() {
        double termAdjustment = term.getTermAdjustment();
        return (baseRent + amenityPremium) * termAdjustment;
    }
}
