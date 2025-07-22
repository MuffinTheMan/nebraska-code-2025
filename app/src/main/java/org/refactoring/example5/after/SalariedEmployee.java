package org.refactoring.example5.after;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;

@Getter
@Setter
public class SalariedEmployee extends Employee {
    private double salary;
    private int ptoBalance;

    @Override
    public double calculateWeeklyPay() {
        return Precision.round((salary / 52) + weeklyBonusAmount, 2);
    }

    @Override
    public String getPayDescription() {
        return weeklyBonusAmount > 0
            ? name + " from " + department + " is salaried and earns $" + calculateWeeklyPay() + " per week (including a $" + weeklyBonusAmount + " weekly bonus)."
            : name + " from " + department + " is salaried and earns $" + calculateWeeklyPay() + " per week.";
    }
}
