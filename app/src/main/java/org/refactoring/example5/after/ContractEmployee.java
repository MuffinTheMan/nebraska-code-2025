package org.refactoring.example5.after;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;

@Getter
@Setter
public class ContractEmployee extends Employee {
    private String name;
    private String department;
    private double weeklyContractAmount;
    private double weeklyBonusAmount;

    @Override
    public double calculateWeeklyPay() {
        return Precision.round(weeklyContractAmount + weeklyBonusAmount, 2);
    }

    @Override
    public String getPayDescription() {
        return weeklyBonusAmount > 0
            ? name + " from " + department + " is a contractor paid $" + calculateWeeklyPay() + " per week (including a $" + weeklyBonusAmount + " weekly bonus)."
            : name + " from " + department + " is a contractor paid $" + calculateWeeklyPay() + " per week.";
    }
}
