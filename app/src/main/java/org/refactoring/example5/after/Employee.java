package org.refactoring.example5.after;

import lombok.Setter;

@Setter
public abstract class Employee {
    protected String name;
    protected String department;
    protected double weeklyBonusAmount;

    public abstract double calculateWeeklyPay();

    public String getPayDescription() {
        return name + " from " + department + " is " + getEmployeeTypeDescriptor() + " and earns $" + calculateWeeklyPay() + " per week" + getBonusDescription() + ".";
    }

    protected abstract String getEmployeeTypeDescriptor();

    protected String getBonusDescription() {
        return weeklyBonusAmount > 0
            ? " (including a $" + weeklyBonusAmount + " weekly bonus)"
            : "";
    }
}
