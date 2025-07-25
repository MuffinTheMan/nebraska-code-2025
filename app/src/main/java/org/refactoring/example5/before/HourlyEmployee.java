package org.refactoring.example5.before;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;

@Getter
@Setter
public class HourlyEmployee {
    private String name;
    private String department;
    private double hourlyRate;
    private double hoursWorked;
    private double weeklyBonusAmount;

    public double calculateWeeklyPay() {
        return Precision.round((hourlyRate * hoursWorked) + weeklyBonusAmount, 2);
    }

    public String getPayDescription() {
        return weeklyBonusAmount > 0
            ? name + " from " + department + " is hourly and earns $" + calculateWeeklyPay() + " for " + hoursWorked + " hours (including a $" + weeklyBonusAmount + " weekly bonus)."
            : name + " from " + department + " is hourly and earns $" + calculateWeeklyPay() + " for " + hoursWorked + " hours.";
    }
}
