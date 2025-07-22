package org.refactoring.example5.before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class SalariedEmployeeUnitTest {
    @Test
    void calculateWeeklyPayAndGetDescription() {
        assertAll(
            () -> {
                var employee = new SalariedEmployee();
                employee.setName("Billy Joel");
                employee.setDepartment("Department 1");
                employee.setSalary(88_000);
                assertAll(
                    () -> assertThat(employee.calculateWeeklyPay()).isEqualTo(1_692.31),
                    () -> assertThat(employee.getPayDescription()).isEqualTo("Billy Joel from Department 1 is salaried and earns $1692.31 per week.")
                );
            },
            () -> {
                var employee = new SalariedEmployee();
                employee.setName("Jimmy Dean");
                employee.setDepartment("Department 2");
                employee.setSalary(75_000);
                employee.setWeeklyBonusAmount(20.5);
                assertAll(
                    () -> assertThat(employee.calculateWeeklyPay()).isEqualTo(1_462.81),
                    () -> assertThat(employee.getPayDescription()).isEqualTo("Jimmy Dean from Department 2 is salaried and earns $1462.81 per week (including a $20.5 weekly bonus).")
                );
            },
            () -> {
                var employee = new SalariedEmployee();
                employee.setName("Sara Lee");
                employee.setDepartment("Department 3");
                employee.setSalary(85_000);
                assertAll(
                    () -> assertThat(employee.calculateWeeklyPay()).isEqualTo(1_634.62),
                    () -> assertThat(employee.getPayDescription()).isEqualTo("Sara Lee from Department 3 is salaried and earns $1634.62 per week.")
                );
            },
            () -> {
                var employee = new SalariedEmployee();
                employee.setName("Julius Caesar");
                employee.setDepartment("Department 4");
                employee.setSalary(1_050_000);
                employee.setWeeklyBonusAmount(21.05);
                assertAll(
                    () -> assertThat(employee.calculateWeeklyPay()).isEqualTo(20_213.36),
                    () -> assertThat(employee.getPayDescription()).isEqualTo("Julius Caesar from Department 4 is salaried and earns $20213.36 per week (including a $21.05 weekly bonus).")
                );
            }
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
    })
    void ptoBalance(int ptoBalance) {
        var employee = new SalariedEmployee();
        employee.setPtoBalance(ptoBalance);
        assertThat(employee.getPtoBalance()).isEqualTo(ptoBalance);
    }
}