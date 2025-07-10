1. Update `LincolnFireworksLauncher` to be unit-testable (introduce dependency injection) and add passing tests
2. Extract Variable `currentTime`
3. Ensure unit tests still pass
4. Create and set instance variables for open/close times on July 3rd and 4th (and use them)
5. Ensure unit tests still pass
6. Create `LocalDateTimeRange` class (ideally, add unit tests for this--skipping for now)
7. Update `LincolnFireworksLauncher` to add instance variables for July 3rd and July 4th open hours with `LocalDateTimeRange` and use them
8. Ensure unit tests still pass
9. Remove open/close time instance fields (Inline Variable)
10. Ensure unit tests still pass
11. Make `LincolnFireworksLauncher::launch` thread-safe?