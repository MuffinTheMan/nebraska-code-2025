package org.refactoring.example5.before;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ContractEmployeeUnitTest {
    @Test
    void calculateWeeklyPayAndGetDescription() {
        assertAll(
            () -> {
                var employee = new ContractEmployee();
                employee.setName("Billy Joel");
                employee.setDepartment("Department 1");
                employee.setWeeklyContractAmount(493.04);
                assertAll(
                    () -> assertThat(employee.calculateWeeklyPay()).isEqualTo(493.04),
                    () -> assertThat(employee.getPayDescription()).isEqualTo("Billy Joel from Department 1 is a contractor and earns $493.04 per week.")
                );
            },
            () -> {
                var employee = new ContractEmployee();
                employee.setName("Jimmy Dean");
                employee.setDepartment("Department 2");
                employee.setWeeklyContractAmount(1012.3);
                employee.setWeeklyBonusAmount(20.5);
                assertAll(
                    () -> assertThat(employee.calculateWeeklyPay()).isEqualTo(1032.8),
                    () -> assertThat(employee.getPayDescription()).isEqualTo("Jimmy Dean from Department 2 is a contractor and earns $1032.8 per week (including a $20.5 weekly bonus).")
                );
            },
            () -> {
                var employee = new ContractEmployee();
                employee.setName("Sara Lee");
                employee.setDepartment("Department 3");
                employee.setWeeklyContractAmount(2150.25);
                assertAll(
                    () -> assertThat(employee.calculateWeeklyPay()).isEqualTo(2150.25),
                    () -> assertThat(employee.getPayDescription()).isEqualTo("Sara Lee from Department 3 is a contractor and earns $2150.25 per week.")
                );
            },
            () -> {
                var employee = new ContractEmployee();
                employee.setName("Julius Caesar");
                employee.setDepartment("Department 4");
                employee.setWeeklyContractAmount(8750);
                employee.setWeeklyBonusAmount(225.25);
                assertAll(
                    () -> assertThat(employee.calculateWeeklyPay()).isEqualTo(8975.25),
                    () -> assertThat(employee.getPayDescription()).isEqualTo("Julius Caesar from Department 4 is a contractor and earns $8975.25 per week (including a $225.25 weekly bonus).")
                );
            }
        );
    }
}