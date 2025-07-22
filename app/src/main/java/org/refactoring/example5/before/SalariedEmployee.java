package org.refactoring.example5.before;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;

@Getter
@Setter
public class SalariedEmployee {
    private String name;
    private String department;
    private double salary;
    private double weeklyBonusAmount;
    private int ptoBalance;

    public double calculateWeeklyPay() {
        return Precision.round((salary / 52) + weeklyBonusAmount, 2);
    }

    public String getPayDescription() {
        return weeklyBonusAmount > 0
            ? name + " from " + department + " is salaried and earns $" + calculateWeeklyPay() + " per week (including a $" + weeklyBonusAmount + " weekly bonus)."
            : name + " from " + department + " is salaried and earns $" + calculateWeeklyPay() + " per week.";
    }
}
