package org.refactoring.example3.before;

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
        double termAdjustment = switch (term) {
            case MONTH_TO_MONTH -> 1.55;
            case TWO_MONTH -> 1.5;
            case THREE_MONTH -> 1.45;
            case FOUR_MONTH -> 1.40;
            case FIVE_MONTH -> 1.35;
            case SIX_MONTH -> 1.30;
            case SEVEN_MONTH -> 1.25;
            case EIGHT_MONTH -> 1.20;
            case NINE_MONTH -> 1.15;
            case TEN_MONTH -> 1.1;
            case ELEVEN_MONTH -> 1.05;
            case TWELVE_MONTH -> 1.0;
            case THIRTEEN_MONTH -> 0.99;
            case FOURTEEN_MONTH -> 0.98;
            case FIFTEEN_MONTH -> 0.97;
            case SIXTEEN_MONTH -> 0.96;
            case SEVENTEEN_MONTH -> 0.95;
            case EIGHTEEN_MONTH -> 0.94;
            case NINETEEN_MONTH -> 0.93;
            case TWENTY_MONTH -> 0.92;
            case TWENTY_ONE_MONTH -> 0.91;
            case TWENTY_TWO_MONTH -> 0.90;
            case TWENTY_THREE_MONTH -> 0.89;
            case TWENTY_FOUR_MONTH -> 0.88;
        };

        return Precision.round(((baseRent + amenityPremium) * termAdjustment) + utilitiesCost, 2);
    }
}
