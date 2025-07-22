package org.refactoring.example5.after;

import lombok.Setter;

@Setter
public abstract class Employee {
    protected String name;
    protected String department;
    protected double weeklyBonusAmount;

    public abstract double calculateWeeklyPay();

    public String getPayDescription() {
        return weeklyBonusAmount > 0
            ? name + " from " + department + " is " + getEmployeeTypeDescriptor() + " and earns $" + calculateWeeklyPay() + " per week (including a $" + weeklyBonusAmount + " weekly bonus)."
            : name + " from " + department + " is " + getEmployeeTypeDescriptor() + " and earns $" + calculateWeeklyPay() + " per week.";
    }

    public abstract String getEmployeeTypeDescriptor();
}
