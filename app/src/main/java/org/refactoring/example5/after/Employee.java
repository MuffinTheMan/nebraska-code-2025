package org.refactoring.example5.after;

import lombok.Setter;

@Setter
public abstract class Employee {
    protected String name;
    protected String department;
    protected double weeklyBonusAmount;

    public abstract double calculateWeeklyPay();

    public abstract String getPayDescription();

    public abstract String getEmployeeTypeDescriptor();
}
