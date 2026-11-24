# Abstract Factory · Workshop desk

Abstract Factory provides a way to create a family of related products using
one factory. Each factory in this exercise supplies both parts of a workshop
kit for the same setting.

Start with `WorkshopDesk` and the product roles in `KitModels.java`. A campus
kit pairs a classroom schedule with campus supplies. An online kit pairs a
video-call schedule with online supplies. `prepareKit` should still accept
the same workshop choice and return both parts of the kit.

The checks use the `IWorkshopKitFactory` interface and the factories
`CampusKitFactory` and `OnlineKitFactory` in this package. They request the products through
`Schedule makeSchedule()` and `SupplyList makeSupplyList()`. Decide where
the choice of family belongs in the desk's workflow.

Use `./gradlew test --tests '*WorkshopKitFactoryTest'` to check this exercise.
For a refresher, see [Refactoring.Guru · Abstract Factory](https://refactoring.guru/design-patterns/abstract-factory).
