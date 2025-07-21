1. Ensure passing unit tests exist for existing functionality (`EmailUtils`)
2. Create new `EmailAddress` class with methods from `EmailUtils` (no logic changes but make them instance methods)
3. Update the `EmailUtils` methods to use `EmailAddress` internally
4. Ensure tests still pass
5. Add tests for `EmailAddress` class (match logic from existing tests)
6. Ensure all tests pass
7. Remove `EmailUtils` class
8. Beyond-refactoring improvements:
    1. Update tests to assert constructor throws `IllegalArgumentException` (TDD)
    2. Add validation and trimming at instance creation
    3. Ensure all tests pass
    4. Remove `::trim` methods and `::isValidEmail` (logic in constructor now)
    5. Ensure all tests pass
    6. Remove validation logic from `::getDomain` and `::getLocalPart` methods (redundant)
    7. Ensure all tests pass
    8. Fix edge-case bug in `::isCorporateEmail` (`endsWith` not correct) and add additional test cases
    9. Ensure all tests pass