# Factory Method · Pass desk

Factory Method gives callers a shared way to create a product, with the
concrete factory deciding which kind of product to make.

Start in `PassDesk`. A day pass lasts one day, and a weekend pass lasts two.
Both should carry the attendee's name. Read the two supplied products and
their common `Pass` type in `PassModels.java`.

Choose an interface named `IFactory` or an abstract class named `AbsFactory`.
Give it one abstract operation, `Pass makePass(String attendee)`. Keep
`DayPassFactory` and `WeekendPassFactory` in this package so the tests can
find them. Rework `PassDesk` to use the common factory type while keeping its
`issuePass` entry point.

Use `./gradlew test --tests '*PassFactoryTest'` to check this exercise.
For a refresher, see [Refactoring.Guru · Factory Method](https://refactoring.guru/design-patterns/factory-method).
