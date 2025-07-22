package org.refactoring.example5.before;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class HourlyEmployeeUnitTest {
    @Test
    void calculateWeeklyPayAndGetDescription() {
        assertAll(
            () -> {
                var employee = new HourlyEmployee();
                employee.setName("Billy Joel");
                employee.setDepartment("Department 1");
                employee.setHourlyRate(25.25);
                employee.setHoursWorked(39.5);
                assertAll(
                    () -> assertThat(employee.calculateWeeklyPay()).isEqualTo(997.38),
                    () -> assertThat(employee.getPayDescription()).isEqualTo("Billy Joel from Department 1 is hourly and earns $997.38 for 39.5 hours.")
                );
            },
            () -> {
                var employee = new HourlyEmployee();
                employee.setName("Jimmy Dean");
                employee.setDepartment("Department 2");
                employee.setHourlyRate(17.11);
                employee.setHoursWorked(40.1);
                employee.setWeeklyBonusAmount(20.5);
                assertAll(
                    () -> assertThat(employee.calculateWeeklyPay()).isEqualTo(706.61),
                    () -> assertThat(employee.getPayDescription()).isEqualTo("Jimmy Dean from Department 2 is hourly and earns $706.61 for 40.1 hours (including a $20.5 weekly bonus).")
                );
            },
            () -> {
                var employee = new HourlyEmployee();
                employee.setName("Sara Lee");
                employee.setDepartment("Department 3");
                employee.setHourlyRate(25.25);
                assertAll(
                    () -> assertThat(employee.calculateWeeklyPay()).isEqualTo(0),
                    () -> assertThat(employee.getPayDescription()).isEqualTo("Sara Lee from Department 3 is hourly and earns $0.0 for 0.0 hours.")
                );
            },
            () -> {
                var employee = new HourlyEmployee();
                employee.setName("Julius Caesar");
                employee.setDepartment("Department 4");
                employee.setHourlyRate(25.25);
                employee.setWeeklyBonusAmount(21.05);
                assertAll(
                    () -> assertThat(employee.calculateWeeklyPay()).isEqualTo(21.05),
                    () -> assertThat(employee.getPayDescription()).isEqualTo("Julius Caesar from Department 4 is hourly and earns $21.05 for 0.0 hours (including a $21.05 weekly bonus).")
                );
            }
        );
    }
}