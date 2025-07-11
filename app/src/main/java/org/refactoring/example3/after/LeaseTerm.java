package org.refactoring.example3.after;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LeaseTerm {
    MONTH_TO_MONTH(1.55),
    TWO_MONTH(1.5),
    THREE_MONTH(1.45),
    FOUR_MONTH(1.40),
    FIVE_MONTH(1.35),
    SIX_MONTH(1.30),
    SEVEN_MONTH(1.25),
    EIGHT_MONTH(1.20),
    NINE_MONTH(1.15),
    TEN_MONTH(1.1),
    ELEVEN_MONTH(1.05),
    TWELVE_MONTH(1.0),
    THIRTEEN_MONTH(0.99),
    FOURTEEN_MONTH(0.98),
    FIFTEEN_MONTH(0.97),
    SIXTEEN_MONTH(0.96),
    SEVENTEEN_MONTH(0.95),
    EIGHTEEN_MONTH(0.94),
    NINETEEN_MONTH(0.93),
    TWENTY_MONTH(0.92),
    TWENTY_ONE_MONTH(0.91),
    TWENTY_TWO_MONTH(0.90),
    TWENTY_THREE_MONTH(0.89),
    TWENTY_FOUR_MONTH(0.88),
    ;

    private final double termAdjustment;
}
