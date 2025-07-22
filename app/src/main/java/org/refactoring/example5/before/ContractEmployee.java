package org.refactoring.example5.before;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;

@Getter
@Setter
public class ContractEmployee {
    private String name;
    private String department;
    private double weeklyContractAmount;
    private double weeklyBonusAmount;

    public double calculateWeeklyPay() {
        return Precision.round(weeklyContractAmount + weeklyBonusAmount, 2);
    }

    public String getPayDescription() {
        return weeklyBonusAmount > 0
            ? name + " from " + department + " is a contractor and earns $" + calculateWeeklyPay() + " per week (including a $" + weeklyBonusAmount + " weekly bonus)."
            : name + " from " + department + " is a contractor and earns $" + calculateWeeklyPay() + " per week.";
    }
}
