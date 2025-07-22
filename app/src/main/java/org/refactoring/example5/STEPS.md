1. Ensure passing unit tests exist for existing functionality
2. Create empty `abstract class Employee` and update `ContractEmployee`, `HourlyEmployee`, and `SalariedEmployee` to inherit from it
3. Ensure tests still pass
4. Add `Employee::calculateWeeklyPay` and `Employee::getPayDescription` abstract methods along with `@Override` annotation in children
5. Ensure tests still pass
6. Move `name`, `department`, and `weeklyBonusAmount` fields up to `Employee` (visibility: `protected`, add `@Getter`)
7. Ensure tests still pass
8. Add `Employee::getEmployeeTypeDescriptor` abstract method, implement it in each child and use it in their respective `getPayDescription` implementations
9. Ensure tests still pass
10. Note that `getPayDescription` is identical for `SalariedEmployee` and `ContractEmployee`--move method up to parent
11. Ensure tests still pass