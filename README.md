# Nebraska.Code 2025 | [Object-Oriented Refactoring Strategies and Tactics](https://whova.com/embedded/session/DH7YrgaYmGpojoxWklzPs06mXsIUgcdAQDibzg9Dw4M%3D/4489150/?widget=primary)

## Project Structure

Each example has its own package (eg `org.refactoring.example4`). Within each example's package lives at least two packages: `before` and `after`. The `before` package contains the pre-refactored code, while the `after` package contains an example of the refactored code (of course there are many different ways to refactor, so you may arrive at your own "after"). Additional packages include `intermediate` (for code changes necessary to make the `before` code testable prior to the final refactor) and `beyond` (for post-refactor code improvements--these are not technically "refactors," since they do change the logic in some way).

## Resources

* Slides (link TBD)
* [Refactoring Catalog](https://refactoring.com/catalog/)
* [Anemic Domain Model article](https://martinfowler.com/bliki/AnemicDomainModel.html)