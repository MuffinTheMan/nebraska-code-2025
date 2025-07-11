1. Move `termAdjustment` logic into `LeaseTerm` enum
2. Ensure unit tests still pass
3. Rename method 'calculateMonthlyRent' to 'calculateMonthlyPayment' for clarity.
4. Ensure unit tests still pass
5. Move calculation of the term-adjusted total rent a separate method named 'calculateTermAdjustedTotalRent'. This makes the 'calculateMonthlyPayment' method more readable and easier to understand and allows for getting a more detailed breakdown if printing more itemized billing details is desired.