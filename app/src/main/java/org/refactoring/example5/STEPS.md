1. Ensure passing unit tests exist for existing functionality
2. Create empty `abstract class Employee` and update `ContractEmployee`, `HourlyEmployee`, and `SalariedEmployee` to inherit from it
3. Ensure tests still pass
4. Add `Employee::calculateWeeklyPay` and `Employee::getPayDescription` abstract methods along with `@Override` annotation in children
5. Ensure tests still pass
6. Move `name`, `department`, and `weeklyBonusAmount` fields up to `Employee` (visibility: `protected`, add `@Getter`)
7. Ensure tests still pass