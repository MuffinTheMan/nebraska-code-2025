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

    public double calculateMonthlyRent() {
        double termAdjustment = term.getTermAdjustment();

        return Precision.round(((baseRent + amenityPremium) * termAdjustment) + utilitiesCost, 2);
    }
}
