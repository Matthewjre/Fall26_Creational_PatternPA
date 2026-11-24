# Builder · Event planning

Builder lets a caller configure a product in stages and obtain the finished
object in one final operation.

An event plan starts with a title. Its room defaults to `TBD`, capacity
defaults to 20 seats, and the projector and refreshments are off by default.
A caller can pick any combination of options and chain their choices before
building the plan.

Use the TODOs in `EventPlanBuilder` and read the supplied `EventPlan` model.
Once the builder works, use it for the welcome session in `EventDeskDemo`
and compare the output with the project README.

Use `./gradlew test --tests '*EventPlanBuilderTest'` to check this exercise.
For a refresher, see [Refactoring.Guru · Builder](https://refactoring.guru/design-patterns/builder).
