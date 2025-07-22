package org.refactoring.example5.after;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.util.Precision;

@Getter
@Setter
public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    @Override
    public double calculateWeeklyPay() {
        return Precision.round((hourlyRate * hoursWorked) + weeklyBonusAmount, 2);
    }

    @Override
    public String getPayDescription() {
        return weeklyBonusAmount > 0
            ? name + " from " + department + " is " + getEmployeeTypeDescriptor() + " and earns $" + calculateWeeklyPay() + " for " + hoursWorked + " hours (including a $" + weeklyBonusAmount + " weekly bonus)."
            : name + " from " + department + " is " + getEmployeeTypeDescriptor() + " and earns $" + calculateWeeklyPay() + " for " + hoursWorked + " hours.";
    }

    @Override
    public String getEmployeeTypeDescriptor() {
        return "hourly";
    }
}
